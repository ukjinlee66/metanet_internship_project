import React, { useState, useEffect, Fragment, useRef } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import rankSlide from "../assets/css/rankingSlide.css"
import NewsTicker from "react-advanced-news-ticker"
import { type } from '@testing-library/user-event/dist/type';
import { faBuildingShield } from '@fortawesome/free-solid-svg-icons';

var rankingTitle = [];

const Ticker=()=>
{
            //로그인시 선호도영상 데이터
    const [rankingList, setRankingList] = useState([
        {id:'', searchWordName:''},
        {id:'', searchWordName:''},
        {id:'', searchWordName:''},
        {id:'', searchWordName:''},
        {id:'', searchWordName:''}
    ]);


    // 검색어 랭킹리스트 가져오는 url
    const rankingUrl = 'http://localhost:8443/MainPage/getSearchWordRank';

    // 7개의 검색어 랭킹 리스트 요청
    const getRankingList = async () => {
        await axios
            .get(rankingUrl)
            .then((res) => {
                setRankingList(res.data)
                
               
            }
            )

            
    }; 
    // const changeType = async () =>{
    //     for(let i=0; i<5; i++) {
    //         if(rankingList[i].searchWordName === )
    //     }
    // }
    // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
    getRankingList();
    // changeType();
 
        }, []);
   

    // 레시피 클릭 시 이동
    const btClick=(e)=> {
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/zipcook/RecipeAttractionList?search=" + e.target.value;
        sessionStorage.setItem('listState', 'none')
    }
    
    const finish=() =>{
    } 


    const consolecheck = () => {
    }

    
    const out = () =>
    {
        
        return <button onClick = {btClick} value={rankingList[0].searchWordName}>{rankingList[0].searchWordName}</button>;
    }

    


    return (    <div>#1 {out()}</div>
                        
                        
                        

    );
}

export default Ticker;