import React ,{useState, useEffect, Fragment} from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import Pagination from 'react-js-pagination';
import foodImg1 from "../assets/img/bibimbab.jpg"
import foodImg2 from "../assets/img/chicken.jpg"
import foodImg3 from "../assets/img/dduckboggi.jpg"
import foodImg4 from "../assets/img/dubujorim.jpg"
import foodImg5 from "../assets/img/jajangmyeon.jpg"
//import https from 'https'
// const fs = import('fs');
// const httpsAgent = new https.Agent({
//     rejectUnauthorized: false, // (NOTE: this will disable client verification)
//     cert: fs.readFileSync("./private.key"),
//     key: fs.readFileSync("./public.pem"),
//     passphrase: "YYY"
//   });

function Recipelistitem(props) {
    // 현재 페이지 출력 관광지 리스트 
    // const [tourList, setTourList] = useState([
    //     {id:'' ,img:foodImg1, source:'비빔밥 레시피', sub_title:'', location:{coordinates:['', '']}}, 
    //     {id:'' ,img:foodImg2, source:'칰킨 레시피', sub_title:'', location:{coordinates:['', '']}},
    //     {id:'' ,img:foodImg3, source:'떡볶이 레시피', sub_title:'', location:{coordinates:['', '']}},
    //     {id:'' ,img:foodImg4, source:'두부조림 레시피', sub_title:'', location:{coordinates:['', '']}},
    //     {id:'' ,img:foodImg5, source:'짜장면 레시피', sub_title:'', location:{coordinates:['', '']}}
    // ])
    const [tourList, setTourList] = useState([
        {id:'' ,img:foodImg1, source:'', sub_title:'', }, 
        {id:'' ,img:foodImg2, source:'', sub_title:'', },
        {id:'' ,img:foodImg3, source:'', sub_title:'', },
        {id:'' ,img:foodImg4, source:'', sub_title:'', },
        {id:'' ,img:foodImg5, source:'', sub_title:'', }
    ])

    const [listSize, setListSize] = useState(1);
    const [page, setPage] = useState(Number(sessionStorage.getItem("pageSession")));

    const mapLoction = [];

    // 특정 페이지 요청 시 작동하는 함수
    const handlePageChange = nowPage => {
        getListItem(nowPage);
        setPage(nowPage);
        sessionStorage.setItem("pageSession", nowPage);
    };

    const reqUrl = 'http://localhost:8443/List/Search'
    const tourSizeUrl = 'http://localhost:8443/List/Search'
    const elaUrl = '/log/searchKeyword'

    // 페이지에 따른 관광지 리스트 요청
    const getListItem = async (page) => {
        console.log("getListItem start", decodeURI(window.location.search.split('=')[1]));
        await axios
            .get(reqUrl, {
                params: {
                    videoTitle: decodeURI(window.location.search.split('=')[1])
                }
            })
            // .then((res) => setTourList(res.data));  
            .then((res)=>console.log("RES : ",res.data));
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

    // 엘라스틱 서치에 로그 데이터 전송
    // const insertElastic = async (searchKeyword) => {
    //     await axios
    //         .get(elaUrl, {
    //             params:{
    //                 search: searchKeyword,
    //                 logClass:'searchLog'
    //             }
    //         })
    //         .then();
    // }

   // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
        //insertElastic(decodeURI(window.location.search.split('=')[1]));
        //getlistSize();
        getListItem(page);
    }, [])

    // 관광지 리스트 렌더링
    const tourlistRender = () => {
        const result = [];
        for (let i = 0; i < tourList.length; i++) {
            result.push(
                // 출력 관광지 리스트의 관광지 id을 값으로 상세페이지에 보냄
                <div class="list-item p-4 mb-4">
                    <div class="row g-4 list-section">
                        <div class="col-md-4 d-flex align-items-start">
                            <img class="img-list" src={tourList[i].img} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?tourSpot=" + tourList[i].id} />
                        </div>
                        <div class="col-md-8 list-info">
                            <div className='row'>
                                <h4 class="col-md-10 text-left list-text" typeof='text' id='test' onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?tourSpot=" + tourList[i].id}>{tourList[i].source}</h4>
                                <p className='col-md-2' id={'btn' + (i+1)}></p>
                            </div>
                            <hr className='list-hr'/>
                            <p class="list-p">{tourList[i].sub_title}</p>
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
                        {tourlistRender()}
                    </div>
                </div>
            </div>
            <Pagination
                    activePage={page}
                    itemsCountPerPage={5}
                    totalItemsCount={listSize}
                    pageRangeDisplayed={5}
                    prevPageText="<"
                    nextPageText=">"
                    onChange={handlePageChange}
            />
        </Fragment>
    );
}

export default Recipelistitem;
