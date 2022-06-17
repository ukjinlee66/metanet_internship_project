import React, { useState, useEffect, Fragment, useRef } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import rankSlide from "../assets/css/rankingSlide.css"
import NewsTicker from "react-advanced-news-ticker"
import { type } from '@testing-library/user-event/dist/type';
import { faBuildingShield } from '@fortawesome/free-solid-svg-icons';
import Ticker1 from "./Ticker1"
import Ticker2 from "./Ticker2"
import Ticker3 from "./Ticker3"
import Ticker4 from "./Ticker4"
import Ticker5 from "./Ticker5"
var rankingTitle = [];

const RecipeRanking=()=>
{
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

                //console.log("getRankingList 함수에서 setRankingList 실행 후 값" + rankingList[0].searchWordName)

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
    //console.log("첫 useEffect의 getRankingList() 실행 후 콘솔");

        }, []);


    // 레시피 클릭 시 이동
    const btClick=(e)=> {
        alert(sessionStorage.getItem("first"))
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/zipcook/RecipeAttractionList?search=" + e.target.value;
        sessionStorage.setItem('listState', 'none')
    }

    const finish=() =>{
        //console.log("newsticker 끝!!!!!!"+rankingList[0].searchWordName)
    }


    const consolecheck = () => {
        //console.log("NewsTick 실행")
    }


    const out = () =>
    {
        var res = [];
        //console.log("out함수 실행 / out 함수 내의 rankingTitle: " + rankingList + "랭킹타이틀 타입: " + type(rankingList[0]))
        for(let con of rankingList)
        {
            //console.log(con.searchWordName)
            res.push(
                <Fragment><a onClick={btClick}>
                    {con.searchWordName}
                    </a></Fragment>
            );
        }


        console.log("out함수 return 값 : " + res)
        // return (<Fragment><a onClick={btClick}>{rankingTitle[0]}</a></Fragment>);
        return (res);
    }
    // useEffect(()=>{
    //     out();
    //     console.log("useEffect out 함수 실행/ rankingTitle 값 : " + rankingTitle)
    // },[]);


    return (
        <div class="container">
                <div class="col-md-10">
                        <p></p>
                        <h4>실시간 검색어 랭킹</h4>
                        <NewsTicker
                                rowHeight = {30}
                                maxRows = {1}
                                speed = {600}
                                duration = {4000}
                                autoStart = {true}
                                pauseOnHover = {true}>
                                <Ticker1></Ticker1>
                                <Ticker2></Ticker2>
                                <Ticker3></Ticker3>
                                <Ticker4></Ticker4>
                                <Ticker5></Ticker5>
                        </NewsTicker>
                        {finish()}

                </div>
        </div>
    );
}

export default RecipeRanking;