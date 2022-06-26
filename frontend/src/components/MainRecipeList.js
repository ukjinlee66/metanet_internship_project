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



function MainRecipeList(props) 
{
    //로그인 여부 체크
    const [isLogin, setIsLogin] = useState(false)
    useEffect(() => {
        if (sessionStorage.getItem('User_Id') === null) {
        } else {
            setIsLogin(true)

        }
    })
    //로그인여부체크 끝-------------

    const axio = axios.create({baseURL: 'http://localhost:8443'})
    const reqgetimg = '/Streaming/getImage'
    function MyUploader() {
    const [image, setImage] = useState("");
    
    const getImage = (props) => {
        axio
        .get(reqgetimg, 
            {
            params: {
                videoNumber: (props.number)
            }
        })
        .then((res) => {
        const base64 = btoa(
        new Uint8Array(res.data).reduce(
            (data, byte) => data + String.fromCharCode(byte),
            ''
        )
        )
        setImage(base64)
        })
        return image;
    }
    
    return (
        <div className="App">
        <img src={image} alt=""/>
        <button onClick={getImage}>getdata</button>
        </div>
    );
    }

    // 인기 영상 데이터
    const [popular, setPopular] = useState([
        {id:'', recipeImg:'', videoNumber: '' , videoTitle:''},
        {id:'', recipeImg:'', videoNumber: '' ,videoTitle:''},
        {id:'', recipeImg:'', videoNumber: '' ,videoTitle:''},
        {id:'', recipeImg:'', videoNumber: '' ,videoTitle:''},
        {id:'', recipeImg:'', videoNumber: '' ,videoTitle:''}
    ]);

    const [prefer, setPrefer] = useState([
        {id:'', recipeImg:'', videoNumber: '' , videoTitle:''},
        {id:'', recipeImg:'', videoNumber: '' ,videoTitle:''},
        {id:'', recipeImg:'', videoNumber: '' ,videoTitle:''},
        {id:'', recipeImg:'', videoNumber: '' ,videoTitle:''},
        {id:'', recipeImg:'', videoNumber: '' ,videoTitle:''}
    ]);

    

    

    



    let videoSlides = [
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+popular[0].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[0].videoNumber}/><p>{popular[0].videoTitle}</p></a>,
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+popular[1].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[1].videoNumber}/><p>{popular[1].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+popular[2].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[2].videoNumber}/><p>{popular[2].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+popular[3].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[3].videoNumber}/><p>{popular[3].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+popular[4].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popular[4].videoNumber}/><p>{popular[4].videoTitle}</p></a>  ];
    
    
    let loginVideoSlides = [
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+prefer[0].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + prefer[0].videoNumber}/><p>{prefer[0].videoTitle}</p></a>,
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+prefer[1].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + prefer[1].videoNumber}/><p>{prefer[1].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+prefer[2].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + prefer[2].videoNumber}/><p>{prefer[2].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+prefer[3].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + prefer[3].videoNumber}/><p>{prefer[3].videoTitle}</p></a> ,
        <a style={{cursor:'pointer'}}><img  src={"data:image/png;base64,"+prefer[4].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + prefer[4].videoNumber}/><p>{prefer[4].videoTitle}</p></a>  ];
        







    const callback = function(index){
        console.log("callback",index);
    }


    
    const popularUrl = 'http://localhost:8443/MainPage/getMainVideoList';

    // 5개의 인기 영상 데이터 이미지 요청
    const popularInfo = async () => {
        if(sessionStorage.getItem("User_Id") == null){
        await axios
            .get(popularUrl)
            .then((res) => setPopular(res.data)); 
            }else {
        await axios
            .get(popularUrl, 
                {
                    params : {
                        userId : sessionStorage.getItem("User_Id")
                    }
                })
            .then((res) => {
                setPrefer(res.data);
                
            }
                ); 
            }
    }

    


    // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
        popularInfo();
    }, [])



    return (
        <div class="container-xxl py-5 rank-con">
            <div class="container" >

            {(sessionStorage["User_Id"] === null) || (sessionStorage["User_Kind"] == 1) //관리자일 경우 버튼 표시
             ?
             <button class="btn btn-secondary" style={{color:"white",float:"right"}} onClick={(e)=>{window.location.href="/zipcook/CreateRecipe"}}>레시피 작성</button>
             :
             <p/>
             }
            {isLogin === false ? (
                <Fragment>
                    <h1 className="text-center mb-5">인기영상</h1>
                    <Carousel slides={videoSlides} autoplay={true} interval={5000} onSlideChange={callback} />
                <p></p><p></p>
                </Fragment>
                ) : (
                <Fragment>
                    <h1 className="text-center mb-5">선호 영상</h1>
                    <Carousel slides={loginVideoSlides} autoplay={true} interval={5000} onSlideChange={callback} />
                    <p></p><p></p>
                </Fragment>

                )
            }

                
                

                
                
            </div>
        </div>
    );
}

export default MainRecipeList;