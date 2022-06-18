import React ,{useState, useEffect, Fragment} from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import Pagination from 'react-js-pagination';
import qs from 'qs';

function Recipelistitem(props) {
   
    const [item, setItem] = useState([
        {videoTitle:'', color1:'', color2:''}
    ])

    const [recipe, setRecipe] = useState([
        {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
        {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
        {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
        {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
        {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}
    ])

    const [listSize, setListSize] = useState(1);
    const [page, setPage] = useState(Number(sessionStorage.getItem("pageSession")));

    const [priority, setPriority] = useState("SearchTotime");
    const [color, setColor] = useState("Time");



    // 특정 페이지 요청 시 작동하는 함수
    const handlePageChange = nowPage => {
        
        getRecipeItem(nowPage);
        alert('페이지 변경'+nowPage)
        setPage(nowPage);
        sessionStorage.setItem("pageSession", nowPage);
    };
    const getListInfo = () => {
    const info = decodeURI(window.location.search.split('&'))
    if (info.split(',').length== 3){
        let title = info.split(',')[0].split('=')[1];
        let color1 = info.split(',')[1]; 
        let color2 = info.split(',')[2]; 
        console.log("1"+title,"2" +color1, "3"+color2);
    }
    else if(info.split(',').length==2){
    
    
    }
}
    useEffect(() => {
        getListInfo();
    }, [])

    
  
    

    const reqwUrl = 'http://localhost:8443/List/Search';
    
    const sortUrl = 'http://localhost:8443/List/Sort';
    
    const tourSizeUrl = 'http://localhost:8443/List/Search';
    const elaUrl = '/log/searchKeyword';

    const sortBtClick = (e) =>{
        sessionStorage.setItem("sortType", e.target.value);
        getsortItem();
    

    
    const info = decodeURI(window.location.search.split('='))
    alert(info);
    }
    // 조회수에 따른 레시피 리스트 요청
    const getRecipeItem = async (page) => {
        console.log("getSearchItem start", decodeURI(window.location.search.split('=')[1]));
        if (sessionStorage.getItem("listState") != 'none') {
            await axios
            .get(reqwUrl, {
                params: {
                    videoTitle: decodeURI(window.location.search.split('=')[1]),
                    Color : sessionStorage.getItem("listState")
                }
            })
            .then((res) => setRecipe(res.data));  
        }else{
        await axios
            .get(reqwUrl, {
                params: {
                    videoTitle: decodeURI(window.location.search.split('=')[1])
                }
            })
            .then((res) => setRecipe(res.data));  
        }
    }
    // 업로드 시간 순서에 따른 레시피 리스트 요청
    const getsortItem = async (page) => {

        console.log("레시피 0번: "+recipe[0])
        console.log("getListItem start", decodeURI(window.location.search.split('=')[1]));

        await axios
            .get(sortUrl, {
                params: {
                recipe
                    // Color : sessionStorage.getItem("sortType")
                },
                paramsSerializer: params => {
                  return qs.stringify(params, {arrayFormat: 'brackets'})
                }
                
            })
            .then((res) => setRecipe(res.data));  
    }
    // 좋아요 수 순위에 따른 레시피 리스트 요청
    const getToLikeItem = async (page) => {
        console.log("getListItem start", decodeURI(window.location.search.split('=')[1]));
        await axios
            .get(reqwUrl, {
                params: {
                    videoTitle: decodeURI(window.location.search.split('=')[1])
                }
            })
            .then((res) => setRecipe(res.data));  
    }

    // 검색에 따른 관광지 리스트의 총 길이 요청
    const getlistSize = async () => {
        console.log("getListSize start");
        await axios
            .get(tourSizeUrl, {
                params: {
                    videoTitle: decodeURI(window.location.search.split('=')[1])
                }
            })
            .then((res) => console.log(res.data));  
    }

    

   // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
        
        getRecipeItem(page);
    }, [])
    useEffect(() => {}, [color])

    // 관광지 리스트 렌더링
    const recipelistRender = () => {
        const result = [];
        for (let i = 0; i < recipe.length; i++) {
            result.push(
                // 출력 관광지 리스트의 관광지 id을 값으로 상세페이지에 보냄
                <div class="list-item p-4 mb-4">
                    <div class="row g-4 list-section">
                        <div class="col-md-4 d-flex align-items-start">
                            <img class="img-list" src={recipe[i].img} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?tourSpot=" + recipe[i].id} />
                        </div>
                        <div class="col-md-8 list-info">
                            <div className='row'>
                                <h4 class="col-md-10 text-left list-text" typeof='text' id='test' onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?tourSpot=" + recipe[i].id}>{recipe[i].videoTitle}</h4>
                                <p className='col-md-2' id={'btn' + (i+1)}></p>
                            </div>
                            <hr className='list-hr'/>
                            <p class="list-p">

                                영상길이 : {recipe[i].videoLength} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                조회수 : {recipe[i].videoView} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                난이도 : {recipe[i].recipeLevel} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                카테고리 : {recipe[i].recipeKind} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </p>
                        </div>
                    </div>
                </div>
            );}
        
             
        
        return result;
    };

    return (
        <Fragment>
            {/* <h1 class="text-center mb-5 wow fadeInUp" data-wow-delay="0.1s">관광지 리스트</h1> */}
            <div class="tab-class wow fadeInUp" data-wow-delay="0.3s">
                <div class="tab-content-tourlist">
                    <div id="tab-1" class="tab-pane fade show p-0 active">
                        <button name='searchToTime' onClick={sortBtClick} value="Time">시간순</button> &nbsp;&nbsp;
                        <button name='searchToView' onClick={sortBtClick} value="View">조회순</button> &nbsp;&nbsp;
                        <button name='searchToLike' onClick={sortBtClick} value="Like">인기순</button> &nbsp;&nbsp;
                        {recipelistRender()}
                    </div>
                </div>
            </div>
            <Pagination
                    activePage={page}
                    itemsCountPerPage={5}
                    totalItemsCount={15}
                    pageRangeDisplayed={5}
                    prevPageText="<"
                    nextPageText=">"
                    onChange={handlePageChange}
            />
        </Fragment>
    );
}

export default Recipelistitem;
