import csv
import json
import os
import re

import requests
from selenium import webdriver as wd
from bs4 import BeautifulSoup as bs
from selenium.webdriver.common.keys import Keys
import time
from webdriver_manager.chrome import ChromeDriverManager





def run():
    crawling_list = ['한식', '중식', '일식', '양식']
    for key in crawling_list:
        driver = wd.Chrome(ChromeDriverManager().install())
        options = wd.ChromeOptions()
        options.add_experimental_option('excludeSwitches', ['enable-logging'])

        recipe_csv = []
        main_url = 'https://www.10000recipe.com/index.html'

        keyword = key

        #크롤링 자료 저장 리스트


        driver.get(main_url)

        search_area = driver.find_element_by_xpath('//*[@id="srhRecipeText"]') #검색창
        search_area.send_keys(keyword)
        driver.find_element_by_xpath('//*[@id="srhRecipeText"]').send_keys(Keys.ENTER) #검색실행
        time.sleep(2)
        driver.find_element_by_xpath('// *[ @ id = "contents_area_full"] / ul / div / ul / li[1] / a').send_keys(Keys.ENTER)  #정확순 클릭
        time.sleep(0.2)

        filename = keyword

        #store_info() start###################################################

        def store_info():
            time.sleep(0.2)

            html = driver.page_source
            soup = bs(html, 'html.parser')

            recipe_list = soup.select('.common_sp_list_ul> .common_sp_list_li')
            for recipe in recipe_list:

                recipe_name = recipe.select('.common_sp_caption > .common_sp_caption_tit')[0].text

                link = 'https://www.10000recipe.com/'+recipe.select('.common_sp_thumb> .common_sp_link')[0]['href']

                driver.get(link)
                time.sleep(1)
                soup = bs(driver.page_source, 'html.parser')









                try:

                    # serving(몇인분)
                    serving = soup.select('.view2_summary_info > .view2_summary_info1')[0].text

                    #소요시간(cook_time)
                    cook_time = soup.select('.view2_summary_info > .view2_summary_info2')[0].text

                    #난이도(difficulty)
                    difficulty = soup.select('.view2_summary_info > .view2_summary_info3')[0].text

                    #재료(ingredients)
                    ingre_div = soup.find("div", "cont_ingre2")
                    ingre = ingre_div.select('li')
                    ingredients = '';



                    for ig in ingre:
                        a = ig.get_text().replace(" ", "")
                        a = a.replace("\n", "")
                        ingredients += a + ','

                    ingredients = ingredients[:-1]

                    # 조리법(recipe)
                    recipe_div = soup.findAll("div", "view_step_cont")
                    recipe = '';

                    for r in recipe_div:
                        info = r.get_text().replace("  ", "")
                        info = info.replace("\n", "")
                        recipe += info + ','

                    recipe = recipe[:-1]


                    #유튜브링크
                    try:
                        ylink_div = soup.find("div", "movie_area")
                        youtube_link = ylink_div.find("iframe").get("src")

                    except Exception as e:
                        youtube_link = 'none'
                    temp = []
                    temp.append(recipe_name)
                    temp.append(link)
                    temp.append(serving)
                    temp.append(cook_time)
                    temp.append(difficulty)
                    temp.append(ingredients)
                    temp.append(recipe)
                    temp.append(youtube_link)

                    category = keyword
                    temp.append(category)

                    recipe_csv.append(temp)

                    #경로, 파일이름 수정해야함 (hansik으로 고정시켜놓음)
                    BASE_PATH = os.path.dirname(os.path.abspath(__file__))
                    data_path = os.path.dirname(BASE_PATH)
                    data_path = data_path +'/metanet_crawling'+ '/data'
                    f = open(data_path + '/' + 'hansik' + '.csv', "w", encoding="utf-8-sig", newline="")
                    writercsv = csv.writer(f)
                    header = ['recipe_name', 'link', 'serving', 'cook_time', 'difficulty', 'ingredients', 'recipe', 'youtube_link', 'category']
                    writercsv.writerow(header)

                    for i in recipe_csv:
                        writercsv.writerow(i)











                except Exception as e:
                    print('aa', e)
                    continue





                recipe_lists = [recipe_name, link, serving, cook_time, difficulty, ingredients, recipe, youtube_link, category]
                print(recipe_lists)









        #store_info() end###########################################

        page = 1 #실제페이지
        page2 = 0 # 5페이지 이후 다음을 누르면 0으로 초기화 되는 용도

        for i in range(0, 7):

            try:

                page2 += 1

                print(page, "page 이동")

                driver.find_element_by_xpath(f'//*[@id="contents_area_full"]/ul/nav/ul/li[{page2}]/a').send_keys(Keys.ENTER) # 페이지 클릭 page2가 바뀌면서(.format과 같은기능) 실행됨

                store_info() # store_info()함수 실행시켜서 크롤링

                search_area = driver.find_element_by_xpath('//*[@id="srhRecipeText"]')  # 검색창
                search_area.send_keys(keyword)
                driver.find_element_by_xpath('//*[@id="srhRecipeText"]').send_keys(Keys.ENTER)  # 검색실행
                time.sleep(2)
                driver.find_element_by_xpath(
                    '// *[ @ id = "contents_area_full"] / ul / div / ul / li[1] / a').send_keys(Keys.ENTER)  # 정확순 클릭
                time.sleep(0.2)



                page += 1

            except Exception as e:
                print(e)
                break

    driver.close()  # 크롬 브라우저 닫기
    driver.quit()  # 드라이버 종료
    import sys
    sys.exit()







if __name__ == "__main__":
    run()




