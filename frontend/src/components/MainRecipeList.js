import React, { useState, useEffect, Fragment } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import Slider from 'react-slick';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import axios from "axios";
import {Carousel} from '3d-react-carousal';

// 슬라이더 옵션



function MainRecipeList(props) {

    // 인기 영상 데이터
    const [popular, setPopular] = useState([
        {id:'', img:'', videoNumber: '1' , videoTitle:''},
        {id:'', img:'', videoNumber: '2' ,videoTitle:''},
        {id:'', img:'', videoNumber: '3' ,videoTitle:''},
        {id:'', img:'', videoNumber: '4' ,videoTitle:''},
        {id:'', img:'', videoNumber: '5' ,videoTitle:''}
    ]);

    

    



    let videoSlides = [
        <a style={{cursor:'pointer'}}><img  src="https://picsum.photos/800/300/?random" alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[0].videoNumber}/><p>{popular[0].videoTitle}</p></a>,
        <a style={{cursor:'pointer'}}><img  src="https://picsum.photos/800/300/?random" alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[0].videoNumber}/><p>{popular[1].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src="https://picsum.photos/800/300/?random" alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[0].videoNumber}/><p>{popular[2].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src="https://picsum.photos/800/300/?random" alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[0].videoNumber}/><p>{popular[3].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src="https://picsum.photos/800/300/?random" alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[0].videoNumber}/><p>{popular[4].videoTitle}</p></a>  ];






    const callback = function(index){
        console.log("callback",index);
    }


    

    // 초,중,고 를 바꿔야됨
    const popularUrl = 'http://localhost:8443/MainPage/getMainVideoList';
    const preferUrl = 'http://localhost:8443/getVideo/로그인영상';

    // 5개의 인기 영상 데이터 이미지 요청
    const popularInfo = async () => {
        if(sessionStorage.getItem("User_Id") == null){
        await axios
            .get(popularUrl)
            .then((res) => setPopular(res.data)); 
            }else {
        await axios
            .get(preferUrl)
            .then((res) => setPopular(res.data)); 
            }
    }

    


    // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
        popularInfo();
    }, [])



    return (
        <div class="container-xxl py-5 rank-con">
            <div class="container" >
                <h1 class="text-center mb-5">인기영상</h1>
                
                <Carousel slides={videoSlides} autoplay={true} interval={5000} onSlideChange={callback} />
                <p></p><p></p>
                

                
                
            </div>
        </div>
    );
}

export default MainRecipeList;
