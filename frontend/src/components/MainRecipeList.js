import React, { useState, useEffect, Fragment, useRef } from 'react';
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
    const [image, setImage] = useState("");
    const [videoSlides, setvideoSlides] = useState(['']);
    const popularUrl = 'http://localhost:8443/MainPage/getMainVideoList';
    //로그인여부체크 끝-------------
    
    const axio = axios.create({baseURL: 'http://localhost:8443'})
    const reqgetimg = '/Streaming/getImage'


    // 인기 영상 데이터
    const [popular, setPopular] = useState([
        {id:'', recipeImg:'', videoNumber: '' , videoTitle:''}
    ]);

    const [prefer, setPrefer] = useState([
        {id:'', recipeImg:'', videoNumber: '' , videoTitle:''}
    ]);

    const popularRef = useRef(popular)
    const preferRef = useRef(prefer)
    useEffect(() => 
    {
        popularInfo();
        if (sessionStorage.getItem('User_Id') === null) {
        } else {
            setIsLogin(true)
        }
        
    },[]);

    const assignslides = async(num) => 
    {
        var result = [];
        if (num == 0)
        {
            var cnt = 0;
            for(let i = 0; i < popularRef.current.length;i++)
            {
                if(cnt==3)
                    break;
                result.push(
                    <a style={{cursor:'pointer'}}><img style={{width:"flex !important", height:"340px"}}  src={"data:image/png;base64,"+popularRef.current[i].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + popularRef.current[i].videoNumber}/><p>{popularRef.current[i].videoTitle}</p></a>
                );
                cnt= cnt+1;
            }
        }
        else
        {
            for(let i = 0; i < preferRef.curren.length;i++)
            {
                if(cnt==3)
                    break;
                result.push(
                    <a style={{cursor:'pointer'}}><img  style={{width:"300px", height:"340px"}} src={"data:image/png;base64,"+preferRef.current[i].recipeImg} alt="1" onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo?videoNumber=" + preferRef.current[i].videoNumber}/><p>{preferRef.current[i].videoTitle}</p></a>
                );
                cnt= cnt+1;
            }
        }
        setvideoSlides(result);
    }

    const callback = function(index){
    }

    
    

    // 3개의 인기 영상 데이터 이미지 요청
    const popularInfo = async() => 
    {
        console.log("Start",sessionStorage["User_Id"]);
        if(sessionStorage.getItem("User_Id") == null)
        {
            await axios
            .get(popularUrl)
            .then((res) => 
            {   
                popularRef.current = res.data
                setPopular(res.data);
                assignslides(0);
            });
        }
        else 
        {
            await axios
            .get(popularUrl, 
                {
                    params : {
                        userId : sessionStorage.getItem("User_Id")
                    }
                })
            .then((res) => {
                preferRef.current = res.data
                setPrefer(res.data);
                assignslides(1);
            });
        }
    }

    


    



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
                    <Carousel slides={videoSlides} autoplay={true} interval={5000} onSlideChange={callback} />
                    <p></p><p></p>
                </Fragment>

                )
            }
            </div>
        </div>
    );
}

export default MainRecipeList;