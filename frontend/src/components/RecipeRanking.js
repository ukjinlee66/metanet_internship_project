import React, { useState, useEffect, Fragment, useRef } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import rankSlide from "../assets/css/rankingSlide.css"
import NewsTicker from "react-advanced-news-ticker"
import { type } from '@testing-library/user-event/dist/type';



function RecipeRanking(props) {

            //로그인시 선호도영상 데이터
    const [rankingList, setRankingList] = useState([
        {id:'', searchWordName:''},
        {id:'', searchWordName:''},
        {id:'', searchWordName:''},
        {id:'', searchWordName:''},
        {id:'', searchWordName:''}
    ]);

    const searchWordRef = useRef();

    

  

    

    // 검색어 랭킹리스트 가져오는 url
    const rankingUrl = 'http://localhost:8443/MainPage/getSearchWordRank';

    // 7개의 검색어 랭킹 리스트 요청
    const getRankingList = async () => {
        await axios
            .get(rankingUrl)
            
            .then((res) => {
                console.log("res.data:   "+res.data)
                setRankingList(res.data)
                searchWordRef.current = res.data
            }
            )

            
    }; 
    // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
    getRankingList();
    
        }, [])


    //  useEffect(() => { }, [rankingList])

    



    // 레시피 클릭 시 이동
    function btClick(e) {
        alert(sessionStorage.getItem("first"))
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/zipcook/RecipeAttractionList?search=" + e.target.value;
        sessionStorage.setItem('listState', 'none')
    }

    const rankingRender1 = () => {
        const result = [];
        result.push(
            <Fragment>
               
            </Fragment>
        )
        return result;
    };
    const rankingRender2 = () => {
        const result = [];
        result.push(
            <Fragment>
                
            </Fragment>
        )
        return result;
    };
    const rankingRender3 = () => {
        const result = [];
        result.push(
            <Fragment>
             
            </Fragment>
        )
        return result;
    };
    const rankingRender4 = () => {
        const result = [];
        result.push(
            <Fragment>
              
            </Fragment>
        )
        return result;
    };
    const rankingRender5 = () => {
        const result = [];
        result.push(
            <Fragment>
                
            </Fragment>
        )
        return result;
    };

    return (
        <div class="container">
                <div class="col-md-10">
                        <p></p>
                        <h4>실시간 검색어 랭킹</h4>
                        <button onClick={btClick}  value={rankingList[0].searchWordName}>{rankingList[0].searchWordName}</button>
                        <NewsTicker
                                ref = {searchWordRef}
                                rowHeight = {45}
                                maxRows = {2}
                                speed = {600}
                                duration = {4000}
                                autoStart = {true}
                                pauseOnHover = {true}
                                id = "myId"
                                className = "myClassName1 myClassName2"
                                style = {{marginTop: 34}}>
                                <div><button onClick={btClick} value={searchWordRef.current}>#1 {searchWordRef.current}</button></div>   
                                <div><button onClick={btClick} value={searchWordRef.current}>#2 {searchWordRef.current}</button></div> 
                                <div><button onClick={btClick} value={searchWordRef.current}>#3 {searchWordRef.current}</button></div>  
                                <div><button onClick={btClick} value={searchWordRef.current}>#4 {searchWordRef.current}</button></div>  
                                <div><button onClick={btClick} value={searchWordRef.current}>#5 {searchWordRef.current}</button></div>   
                                
                        </NewsTicker>
                            
                            
                </div>
        </div>
    );
}

export default RecipeRanking;