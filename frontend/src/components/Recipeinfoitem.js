import React, {Fragment, useEffect, useState, useRef} from 'react';
// import 'bootstrap/dist/css/bootstrap.css';
// import '../assets/css/bootstrap.min.css';
// import '../assets/css/style.css';
import '../index.css';
import axios from "axios";
import vide from "../Recipe/고등어조림.mp4";
import { Input } from 'antd';
import { LikeOutlined, DislikeOutlined } from '@ant-design/icons';
import withImportantStyle from 'react-with-important-style';
import RecipeinfoComments from './RecipeinfoComments.js';

const { TextArea } = Input;
function Recipeinfo(props) 
{
    // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
        getInfoItem(); // 기본 레시피 정보를 가져오는 함수
        checkUserLike(); // 좋아요 여부를 확인하는 함수
    }, [])

    // 상세 페이지 출력 관광지 정보 
    const [Recipe, setRecipe] = useState({id:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', crDa:'' ,upDa:'', deDa:'', videoView: ''})
    const [Like, setLike] = useState(false);
    const axio = axios.create({baseURL: 'http://localhost:8443'})
    const reqUrl = '/Info/detail'; // 한 레시피 정보 조회
    const reqUrl2 = '/Info/comments'; // 한 레시피의 댓글정보 조회
    const Button = withImportantStyle('button');

    // 레시피에 대한 상세정보 요청
    const getInfoItem = async () => {
        await axio
            .get(reqUrl, {
                params: {
                    videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
                }
            })
            .then((res) => setRecipe(res.data));
    }

    const UnLikefunc = async() => // DB에 해당 회원이 해당 게시글의 좋아요를 취소했기 때문에 좋아요테이블의 데이터 삭제.
    {
        await axio
            .get(reqUrl2, {
                params: {
                    userNumber: sessionStorage.getItem("userNumber"),
                    videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
                }
            })
    }

    const Likefunc = async() => // DB에 해당 회원이 게시글의 좋아요 했기 때문에 좋아요 테이블의 데이터 추가.
    {
        await axio
            .get(reqUrl2, {
                params: {
                    userNumber: sessionStorage.getItem("userNumber"),
                    videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
                }
            })
    }

    const checkUserLike = async () =>  // 회원의 좋아요 여부 확인
    {
        await axio
        .get(reqUrl2,{
            params:{
                userNumber: sessionStorage.getItem("userNumber"),
                videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
            }
        })
        .then((res)=>setLike(res.data)); // 좋아요면 true 아니면 false
    }

    // 상세페이지 관광지 정보 렌더링
    const tourSpotRender = () => {
        return(
            <Fragment>
            <div class="mb-5" style={{fontFamily: "Roboto"}}>
                <p style={{fontSize: "50px"}}>{Recipe.videoTitle}</p>
                <p>난이도 : {Recipe.recipeLevel} / 조리시간 : {Recipe.recipeTime}분 / 업로드 일자 : {Recipe.crDa}</p>
            </div>
            <hr/>
            <center>
                <video width="700" height="700" preload="auto" controls>
                    <source src={vide} type="video/mp4"/>
                </video>
            </center>
            <hr/>
                {/* 레시피 정보 표시 */}
                <div style={{fontFamily: "Roboto", float: "left"}}>
                    <p style={{fontSize: "20px"}}>{Recipe.videoContexts}</p>
                </div>
                {/* 회원 여부와 세션에따른 like, unlike 버튼 표시. */}
                {sessionStorage.getItem("userNumber") === true
                ?
                (Like 
                ? <Button style={{backgroundColor: "#886A08 !important", color: "white !important",float: "right !important", height: "46px !important", width: "50px !important"}} onClick={UnLikefunc}><DislikeOutlined/></Button>
                : <Button style={{backgroundColor: "#088A85 !important", color: "white !important",float: "right !important", height: "46px !important", width: "50px !important"}} onClick={Likefunc}><LikeOutlined /></Button>
                )
                :
                <Button style={{backgroundColor: "#088A85 !important", color: "white !important",float: "right !important", height: "46px !important", width: "50px !important"}}><LikeOutlined /></Button>
                }
                <br/><br/>
                <hr/>
                <TextArea style={{width: "800px" ,display: "flex", float:"left"}}rows={4} placeholder="댓글을 입력 하세요."/>
                <Button style={{backgroundColor: "#F2F2F2 !important", color: "white !important", height: "100px !important", width: "100px !important"}}>등록</Button>
                <br/><br/>
                <hr/>
                <RecipeinfoComments number={Number(decodeURI(window.location.search.split('=')[1]))}/>
            </Fragment>
        );
    };


    return (
        <Fragment>
            {tourSpotRender()}
        </Fragment>
    );
}

export default Recipeinfo;