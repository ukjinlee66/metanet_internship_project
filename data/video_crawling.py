import csv
import json
import os
import re
import glob
import requests
from selenium import webdriver as wd
from bs4 import BeautifulSoup as bs
from selenium.webdriver.common.keys import Keys
import time
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import oracle_db as oradb

def recipe_insert(data):
    conn = oradb.connect()
    query = '''insert into video values 
    (VIDEO_SEQ.NEXTVAL, :1, :2,:3, :4, :5,:6,:7,:8,0, sysdate,null,null)'''

    try:
        cur = conn.cursor()
        cur.execute(query, data)
        oradb.commit(conn)
        print("새 레시피 정보 저장완료")

    except Exception as msg:
        oradb.rollback(conn)
        print('RECIPE 정보 저장(recipe_insert) 에러 발생 : ', msg)

    finally:
        cur.close()
        oradb.close(conn)

def run():
    crawling_list = ['한식', '중식','양식', '일식']
    for key in crawling_list:
        driver = wd.Chrome(ChromeDriverManager().install())
        options = wd.ChromeOptions()
        options.add_experimental_option('excludeSwitches', ['enable-logging'])
        change_kind = ""
        recipe_csv = []
        main_url = 'https://www.10000recipe.com'

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

        def store_info():
            time.sleep(0.2)
            html = driver.page_source
            soup = bs(html, 'html.parser')

            recipe_list = soup.select('.common_sp_list_ul> .common_sp_list_li')
            for recipe in recipe_list:

                recipe_name = recipe.select('.common_sp_caption > .common_sp_caption_tit')[0].text
                recipe_name = re.sub('[^가-힣\w.\s]', '', recipe_name)
                link = 'https://www.10000recipe.com/'+recipe.select('.common_sp_thumb> .common_sp_link')[0]['href']

                driver.get(link)
                try:
                    ## alter 메시지 처리
                    alt = driver.switch_to_alert()
                    alt.accept() #alter 창 확인
                    alt.dismiss() # alter 창 끄기
                    continue
                except:
                    print("no alter")
                time.sleep(1)
                soup = bs(driver.page_source, 'html.parser')


                try:
                    video_name = '' # 영상 이름 초기값 설정
                    # serving(몇인분)
                    serving = soup.select('.view2_summary_info > .view2_summary_info1')[0].text
                    serving = re.sub('인분', '', serving)


                    #소요시간(cook_time)
                    cook_time = soup.select('.view2_summary_info > .view2_summary_info2')[0].text
                    cook_time = re.sub('분', '', cook_time)
                    cook_time = re.sub('이내', '', cook_time)
                    cook_time = re.sub(' ', '', cook_time)
                    #난이도(difficulty)
                    difficulty = soup.select('.view2_summary_info > .view2_summary_info3')[0].text
                    if difficulty == '아무나':
                        difficulty = '초급'
                    elif difficulty =='초급':
                        difficulty = '중급'
                    elif difficulty =='중급':
                        difficulty= '고급'


                    try:

                        # 재료(ingredients)
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
                    except:
                        print("재료크롤링 에러")




                    try:
                        editor_frame = driver.find_element_by_css_selector('.iframe_wrap iframe')
                        driver.switch_to_frame(editor_frame)
                        youa = driver.page_source
                        su = bs(youa, 'html.parser')

                        # youtube link 추출
                        youtube_link = (su.find('div', class_="submessage")).find("a")["href"]
                        print("youyou : ", youtube_link)
                        ###y2mate.com 사이트 영상 다운로드
                        # 새로운 chrome창 열기
                        driver2 = wd.Chrome(ChromeDriverManager().install())
                        options2 = wd.ChromeOptions()
                        # youtube 영상 다운로드를 위한 y2mate사이트 접속.
                        driver2.get('https://www.y2mate.com/en358')
                        driver2.implicitly_wait(3)
                        tabs = driver2.window_handles
                        # youtube link를 가지고 다운버튼 클릭.
                        driver2.find_element_by_name('query').send_keys(youtube_link)
                        time.sleep(3)
                        # 해상도 에따른 다운버튼 클릭.
                        driver2.find_element_by_xpath('//*[@id="btn-submit"]').click()
                        time.sleep(3)
                        # mp4파일의 확장자로 다운로드 클릭.
                        driver2.find_element_by_xpath('//*[@id="mp4"]/table/tbody/tr[2]/td[3]/a').click()
                        time.sleep(10)
                        # 새로운탭과 함께 광고 도출되기때문에 이전 탭의 사이트로 다시 이동.
                        driver2.switch_to.window(driver2.window_handles[-1])
                        time.sleep(6)
                        # driver2.find_element_by_xpath('/html/body/div/div/div/span/span').click()
                        # time.slepp(3)
                        # 다운로드 클릭.
                        driver2.find_element_by_xpath('//*[@id="process-result"]/div/a').click()
                        # 인터넷상황, 파일크기에따라 다운받는속도가 다르기때문에 끊기면 정상적인다운이 불가능해서 여유롭게 80초로 설정.
                        time.sleep(40)  # 1분20초
                        print("다운완료")
                        # 드라이버 닫기.
                        driver2.quit()




                    except Exception as e:
                        # 만약 유튜브 링크가 맞지않다면 새롭게 생성한 크롬창 닫기.
                        youtube_link = 'none'
                        # driver2.quit()
                        print("영상저장 실패:", e)
                    print("youtube link : ",youtube_link)




                except Exception as e:
                    print(e)
                    continue

                category = keyword
                temp = []
                temp.append(recipe_name)

                print(temp)
                if youtube_link !='none':
                    ########## except안빠지면 전처리 (최신 기준/ download에 파일경로 가져와서)
                    try:
                        print("1");
                        list_of_files = glob.glob('C:/Users/user/Downloads/*')  # * means all if need specific format then *.csv
                        latest_file1 = max(list_of_files, key=os.path.getctime)
                        print("latest file : ", latest_file1);
                        latest_file = latest_file1
                        latest_file = (latest_file.split("\\")[1]).split(".")[0]
                        latest_file = latest_file.replace(" ", "")
                        latest_file = re.sub('[^가-힣\w.]', '', latest_file)
                        latest_file = latest_file.replace("ENG", '')
                        latest_file = latest_file.replace("y2mate.com", '')
                        latest_file = latest_file.replace("SUB", '')
                        os.rename(latest_file1, "C:/Users/user/Downloads/" + latest_file + ".mp4")
                        video_name = latest_file
                        print("video_name : ", video_name);
                        temp.append(video_name)

                        ###########
                    except Exception as e:
                        print("영상제목 전처리 실패:", e)

                    temp.append(recipe)
                    temp.append(difficulty)
                    temp.append(category)
                    temp.append(cook_time)
                    temp.append(serving)
                    temp.append(ingredients)
                    print(temp)
                    recipe_insert(temp)





                    recipe_lists = [recipe_name, link]



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

    driver.close()  # 크롬 브라우저 닫기
    driver.quit()  # 드라이버 종료
    import sys
    sys.exit()

if __name__ == "__main__":
    run()