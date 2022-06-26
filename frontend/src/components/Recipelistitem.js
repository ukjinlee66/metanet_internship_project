import React ,{useState, useEffect, Fragment, useRef} from 'react';
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
        {id:'' ,recipeImg:'', videoNumber:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
        {id:'' ,recipeImg:'', videoNumber:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
        {id:'' ,recipeImg:'', videoNumber:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
        {id:'' ,recipeImg:'', videoNumber:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
        {id:'' ,recipeImg:'', videoNumber:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}
    ])

    const [listSize, setListSize] = useState(1);
    const [page, setPage] = useState(Number(sessionStorage.getItem("pageSession")));

    const [priority, setPriority] = useState("SearchTotime");
    const [sortColor, setSortColor] = useState("Time");



    // 특정 페이지 요청 시 작동하는 함수
    const handlePageChange = nowPage => {
        
        alert('페이지 변경'+nowPage)
        setPage(nowPage);
        sessionStorage.setItem("pageSession", nowPage);
    };
    useEffect(() => {
    }, [page])

    const itemRef = useRef(item)
    const getListInfo = () => {
    
    if( decodeURI(window.location.search).indexOf('&') != -1){
        const info = decodeURI(window.location.search.split('&'))
        if (window.location.search.match(/&/g).length==2){
            let title = info.split(',')[0].split('=')[1];
            let color1 = info.split(',')[1]; 
            let color2 = info.split(',')[2]; 
            let result = [{videoTitle:title, color1:color1, color2:color2}]
            itemRef.current = result
        }
        else if(window.location.search.match(/&/g).length==1){
            let title = info.split(',')[0].split('=')[1];
            let color1 = info.split(',')[1]; 
            let result = [{videoTitle:title, color1:color1, color2: ''}]
            itemRef.current = result
        }
    }
    else if(decodeURI(window.location.search).indexOf('&') == -1) {
        let title = decodeURI(window.location.search.split('=')[1]);
        let result = [{videoTitle : title, color1:'', color2: ''}]
        itemRef.current = result
        
    }


    
}
    useEffect(() => {
        getListInfo();
    }, [])

    
  
    

    const reqwUrl = 'http://localhost:8443/List/Search';
    
    const sortUrl = 'http://localhost:8443/List/Sort';
    
    const tourSizeUrl = 'http://localhost:8443/List/Search';
    const elaUrl = '/log/searchKeyword';

    

    // 조회수에 따른 레시피 리스트 요청
    const getRecipeItem = async (page) => {
        if( decodeURI(window.location.search).indexOf('&') != -1){
            const info = decodeURI(window.location.search.split('&'))
            if (window.location.search.match(/&/g).length==2){
                await axios
                .get(reqwUrl, {
                    params: {
                        videoTitle: itemRef.current[0].videoTitle,
                        Color : itemRef.current[0].color1,
                        Color2 : itemRef.current[0].color2
                    }
                    })
                    .then((res) => {
                        setRecipe(res.data);
                        console.log("item",item)
                    }
                    )
            }
            else if(window.location.search.match(/&/g).length==1){
                await axios
                .get(reqwUrl, {
                    params: {
                        videoTitle: itemRef.current[0].videoTitle,
                        Color : itemRef.current[0].color1
                    }
                })
                .then((res) => {
                    setRecipe(res.data);
                }
                )
            }
        }
        else if(decodeURI(window.location.search).indexOf('&') == -1) {
            await axios
            .get(reqwUrl, {
                params: {
                    videoTitle: itemRef.current[0].videoTitle
                }
            })
            .then((res) => {
                setRecipe(res.data);
                console.log("item",item)
            }
            )
            
        }
          
        }


        useEffect(() => {
            getRecipeItem();
        }, [item])
    
    // 업로드 시간 순서에 따른 레시피 리스트 요청
    const getsortItem = async (e) => {
        console.log("click sort", e.target.value)
        await axios
            .get(sortUrl, {
                params: {
                list : JSON.stringify(recipe),
                Color : e.target.value
                }
                
            })
            .then((res) => setRecipe(res.data));  
    }


    



    // 레시피 리스트 렌더링
    const recipelistRender = (page) => {
        const result = [];
        for (let i = page*5-5; i < page*5; i++) {
            if(i > recipe.length-1) break;
            else{
                console.log(recipe.length)
            result.push(
                // 출력 레시피 리스트의 레시피 번호를 값으로 상세페이지에 보냄
                <div class="list-item p-4 mb-4">
                    <div class="row g-4 list-section">
                        <div class="col-md-4 d-flex align-items-start">
                            <img class="img-list" src={"data:image/png;base64,"+recipe[i].recipeImg} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + recipe[i].videoNumber} />
                        </div>
                        <div class="col-md-8 list-info">
                            <div className='row'>
                                <h4 class="col-md-10 text-left list-text" typeof='text' id='test' onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + recipe[i].videoNumber}>{recipe[i].videoTitle}</h4>
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
        }
             
        
        return result;
    };

    return (
        <Fragment>
            {/* <h1 class="text-center mb-5 wow fadeInUp" data-wow-delay="0.1s">관광지 리스트</h1> */}
            <div class="tab-class wow fadeInUp" data-wow-delay="0.3s">
                <div class="tab-content-tourlist">
                    <div id="tab-1" class="tab-pane fade show p-0 active">
                        <button name='searchToTime' onClick={getsortItem} value="Time">시간순</button> &nbsp;&nbsp;
                        <button name='searchToView' onClick={getsortItem} value="View">조회순</button> &nbsp;&nbsp;
                        <button name='searchToLike' onClick={getsortItem} value="Like">인기순</button> &nbsp;&nbsp;
                        {recipelistRender(sessionStorage.getItem('pageSession'))}
                    </div>
                </div>
            </div>
            <Pagination
                    activePage={page}
                    itemsCountPerPage={5}
                    totalItemsCount={recipe.length}
                    pageRangeDisplayed={5}
                    prevPageText="<"
                    nextPageText=">"
                    onChange={handlePageChange}
            />
        </Fragment>
    );
}

export default Recipelistitem;
