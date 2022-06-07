import React ,{useState, useEffect, Fragment} from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import Pagination from 'react-js-pagination';
import foodImg1 from "../assets/img/bibimbab.jpg"
import foodImg2 from "../assets/img/chicken.jpg"
import foodImg3 from "../assets/img/dduckboggi.jpg"
import styled from "styled-components";

const Nav = styled.nav`
  display: flex;
  overflow: auto;
  height: 100vh;
  &::-webkit-scrollbar {
    width: 8px;
    height: 8px;
    border-radius: 6px;
    background: rgba(255, 255, 255, 0.4);
  }
  &::-webkit-scrollbar-thumb {
    background: rgba(0, 0, 0, 0.3);
    border-radius: 6px;
  }
`;

function Recipelistitem(props) {
    const [tourList, setTourList] = useState([
        {id:'' ,img:foodImg1, source:'', sub_title:'', }
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

    const reqUrl = 'http://localhost:4000/posts'
    const tourSizeUrl = 'http://localhost:4000/posts'

    // 페이지에 따른 관광지 리스트 요청
    const getListItem = async (page) => {
        console.log("getListItem start", decodeURI(window.location.search.split('=')[1]));
        await axios
            .get(reqUrl, {
                params: {
                    videoTitle: decodeURI(window.location.search.split('=')[1])
                }
            })
            .then((res) => setTourList(res.data));  
            // .then((res)=>console.log("RES : ",res.data));
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
                                <h6 class="col-md-10 text-left list-text" typeof='text' id='test' onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?tourSpot=" + tourList[i].id}>{tourList[i].source}</h6>
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
        <Nav>
       
            {/* <h1 class="text-center mb-5 wow fadeInUp" data-wow-delay="0.1s">관광지 리스트</h1> */}
            <div class="tab-class wow fadeInUp" data-wow-delay="0.3s">
                <div class="tab-content-viewlist">
                    <div id="tab-1" class="tab-pane fade show p-0 active">
                        {tourlistRender()}
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
                </div>

            </div>

        
        </Nav>
  
       </Fragment>
        
    );
}

export default Recipelistitem;
