import React, { useState, useEffect, Fragment } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import Slider from 'react-slick';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import axios from "axios";

// 슬라이더 옵션
const recipeOptions = {
    autoplay: true,
    autoplaySpeed: 6000,
    centerMode: true, // 현재 index 이미지 중앙배치
    centerPadding: '0px', // 안하면 왼쪽에 이전 이미지 테두리보임
    dots: true,
    Infinity: true, //반복
    pauseOnHover : true, // hover시 autoplay 정지
    slidesToShow:3, // 보여줄 slide 수
    responsive: [ 
		{  
			breakpoint: 992, 
			settings: {
				slidesToShow:3 
			} 
		},
		{ 
			breakpoint: 768, 
			settings: {	
				slidesToShow:2 
			} 
		},
        { 
			breakpoint: 0, 
			settings: {	
				slidesToShow:1
			} 
		}
	]
};

function MainRecipeList(props) {
    // 초급 데이터
    const [lowSource, setLowSource] = useState([
        {id:'', img:''},
        {id:'', img:''},
        {id:'', img:''},
        {id:'', img:''}
    ]);
    //중급 데이터
    const [midSource, setMidSource] = useState([
        {id:'', img:''},
        {id:'', img:''},
        {id:'', img:''},
        {id:'', img:''}
    ]);
    //고급 데이터
    const [highSource, setHighSource] = useState([
        {id:'', img:''},
        {id:'', img:''},
        {id:'', img:''},
        {id:'', img:''}
    ]);
    
    const lowUrl = 'http://localhost:8443/getVideo/초급';
    const midUrl = 'http://localhost:8443/getVideo/중급';
    const highUrl = 'http://localhost:8443/getVideo/고급';
    const lowClick = () =>{
        sessionStorage.setItem("listState", '초급')
    }
    const midClick = () =>{
        sessionStorage.setItem("listState", '중급')
    }
    const highClick = () =>{
        sessionStorage.setItem("listState", '상급')
    }
    // 랜덤으로 5개의 관광지 이미지 요청
    const lowInfo = async () => {
        await axios
            .get(lowUrl)
            .then((res) => setLowSource(res.data)); 
    }; 

    // 랜덤으로 5개의 관광지 이미지 요청
    const midInfo = async () => {
        await axios
            .get(midUrl)
            .then((res) => setMidSource(res.data)); 
    }; 

    // 랜덤으로 5개의 관광지 이미지 요청
    const highInfo = async () => {
        await axios
            .get(highUrl)
            .then((res) => setHighSource(res.data)); 
    }; 

    // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
        lowInfo();
        midInfo();
        highInfo();
    }, [])

    // 관광지 이미지 슬라이더로 렌더링
    const lowLevelRender = () => {
        const result = [];
        for (let i = 0; i < 4; i++) {
            result.push(
                <Fragment>
                
                <div class="testimonial-item bg-white rounded">
                    <img class="img-fluid-tour" src={lowSource[i].img} onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo?tourSpot=" + lowSource[i].id}/>
                    <h3>돼지고기김치찜 맛있게 만들기</h3>
                </div>
                </Fragment>
        );}    
    return result;
    };

    const midLevelRender = () => {
        const result = [];
        for (let i = 0; i < 4; i++) {
            result.push(
                <Fragment>
                
                <div class="testimonial-item bg-white rounded">
                    <img class="img-fluid-tour" src={midSource[i].img} onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo?tourSpot=" + midSource[i].id}/>
                    <h3>돼지고기김치찜 맛있게 만들기</h3>
                </div>
                </Fragment>
        );}    
    return result;
    };

    const highLevelRender = () => {
        const result = [];
        for (let i = 0; i < 4; i++) {
            result.push(
                <Fragment>
                
                <div class="testimonial-item bg-white rounded">
                    <img class="img-fluid-tour" src={highSource[i].img} onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo?tourSpot=" + highSource[i].id}/>
                    <h3>돼지고기김치찜 맛있게 만들기</h3>
                </div>
                </Fragment>
        );}    
    return result;
    };

    return (
        <div class="container-xxl py-5 rank-con">
            <p><button onClick={lowClick}><a href = "/zipcook/RecipeAttractionList?search=초급">레시피 작성</a></button></p>
            <div class="container">
                <h1 class="text-center mb-5">이런 관광지는 어떠세요?</h1>
                <p><button onClick={lowClick}><a href = "/zipcook/RecipeAttractionList?search=초급">초급</a></button></p>
                <Slider className='testimonial-carousel' {...recipeOptions}>
                    {lowLevelRender()}
                    <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => alert("슈슉 슈숙. 슉. 하르방은 못참지  -박태준")} />
                </Slider>

                <p><button onClick={midClick}><a href = "/zipcook/RecipeAttractionList?search=중급">중급</a></button></p>
                <Slider className='testimonial-carousel' {...recipeOptions}>
                    {midLevelRender()}
                    <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => alert("슈슉 슈숙. 슉. 하르방은 못참지  -박태준")} />
                </Slider>

                <p><button onClick={highClick}><a href = "/zipcook/RecipeAttractionList?search=고급">고급</a></button></p>
                <Slider className='testimonial-carousel' {...recipeOptions}>
                    {highLevelRender()}
                    <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => alert("슈슉 슈숙. 슉. 하르방은 못참지  -박태준")} />
                </Slider>
                
            </div>
        </div>
    );
}

export default MainRecipeList;
