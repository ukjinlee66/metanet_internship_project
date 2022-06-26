import React, {Fragment, useEffect, useState, useRef} from 'react';
// import 'bootstrap/dist/css/bootstrap.css';
// import '../assets/css/bootstrap.min.css';
// import '../assets/css/style.css';
import '../index.css';
import axios from "axios";
import { Input } from 'antd';
import { LikeOutlined, DislikeOutlined } from '@ant-design/icons';
import withImportantStyle from 'react-with-important-style';
import RecipeinfoComments from './RecipeinfoComments.js';
import ReactHlsPlayer from 'react-hls-player'
const { TextArea } = Input;
const Recipeinfo = (props) => 
{
    

    // 상세 페이지 출력 관광지 정보 
    const [Recipe, setRecipe] = useState({id:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', crDa:'' ,upDa:'', deDa:'', videoView: ''})
    const [Like, setLike] = useState(0);
    const [Likecount, setLikecount] = useState(0);
    const [commentval, setcommentval] = useState("");
    const axio = axios.create({baseURL: 'http://localhost:8443'})
    const reqUrl = '/Info/detail'; // 한 레시피 정보 조회
    const reqUrl2 = '/Info/comments'; // 한 레시피의 댓글정보 조회
    const reqdelRec = '/deleteDetail'; // 한 레시피 삭제
    const reqadd = '/Info/addcomment'; // 댓글 입력
    const reqlike = '/Info/addLikes'; // 좋아요 추가
    const requnlike = '/Info/deleteLikes'; // 좋아요 삭제
    const reqislike = '/Info/isLiked'; // 좋아요 확인
    const reqcountlike = '/Info/getlikecount'; //좋아요 개수 확인
    const reqaddView = '/List/Views'; // 조회수 증가
    const Button = withImportantStyle('button');
    const [videoName,setvideoName] = useState=('');
    

    // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
        getInfoItem(); // 기본 레시피 정보를 가져오는 함수
        countlike(); // 좋아요 수 확인
        checkUserLike(); // 좋아요 여부를 확인하는 함수
    }, [])

    // 레시피에 대한 상세정보 요청
    const getInfoItem = async () => {
        await axio // 레시피 정보 요청
            .get(reqUrl, {
                params: {
                    videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
                }
            })
            .then((res) => {
                setRecipe(res.data); //Recipe 객체에 값 할당.
                let url = 'http://localhost:8443/Streaming/hls/' + res.data.videoName + '/' + res.data.videoName + '.m3u8';
                setvideoName(url); //영상 정보 저장.
            });
        await axio// 조회수 요청
            .post(reqaddView,{},{
                params: {
                    videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
                }
            })
            .then((res)=> console.log("조회수 증가"));
    }

    // 레시피에 대한 좋아요 수 요청
    const countlike =() => {
        axio
            .get(reqcountlike, {
                params: {
                    videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
                }
            })
            .then((res) => setLikecount(res.data));
    }

    const DelRecipe = () => // 관리자 계정일 경우 레시피 삭제
    {
        var num = Number(decodeURI(window.location.search.split('=')[1]));
        axio
            .delete(`${reqdelRec}/${num}`)
            .then((res) => 
            {
                console.log("Delete Recipe!");
                this.props.history.goBack();
            });
    }


    const UnLikefunc =()=> // DB에 해당 회원이 해당 게시글의 좋아요를 취소했기 때문에 좋아요테이블의 데이터 삭제.
    {
        if (Like == true)
        {
            axio
                .post(requnlike,{}, {
                    params: {
                        videoName: Recipe.videoName,
                        userId: sessionStorage["User_Id"]
                    }
                })
                .then((res)=>{
                    setLikecount(Likecount - 1);
                    setLike(!Like);
                });
        }
        return;
    }

    const Likefunc =()=> // DB에 해당 회원이 게시글의 좋아요 했기 때문에 좋아요 테이블의 데이터 추가.
    {
        if (Like == false)
        {
            axio
                .post(reqlike,{}, {
                    params: {
                        videoName: Recipe.videoName,
                        userId: sessionStorage["User_Id"]
                    }
                })
                .then((res)=>{
                    setLikecount(Likecount + 1);
                    setLike(!Like);
                });
        }
        return;
    }

    const checkUserLike = async () =>  // 회원의 좋아요 여부 확인
    {
        if (sessionStorage["User_Id"] != null)
        {
            await axio
            .get(reqislike,{
                params:{
                    videoNumber: Number(decodeURI(window.location.search.split('=')[1])),
                    userNumber: sessionStorage['User_Number']
                }
            })
            .then((res)=>setLike(res.data)); // 좋아요면 true 아니면 false
        }
    }

    

    const AppendComments = () => // 댓글 입력 axios
    {
        axio
        .post(reqadd,{},{
            params:{
                Comments: commentval,
                userNumber: Number(sessionStorage.getItem('User_Number')),
                videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
            }
        })
        .then((res)=>{
            alert("댓글 작성 완료");
            window.location.reload();
    }
        );
    }

    const AddComment = async(event) =>
    {
        await setcommentval(event.currentTarget.value);
    }

    const changelike = async(event) =>
    {
        await setLikecount(Likecount);
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
            <center> {/*main 영상*/}
                <ReactHlsPlayer
                    src={videoName}
                    autoPlay={false}
                    controls={true}
                />
            </center>
            <hr/>
                {/* 레시피 정보 표시 */}
                <div style={{fontFamily: "Roboto", float: "left"}}>
                    <p style={{fontSize: "20px"}}>{Recipe.videoContexts}</p>
                </div>
                {/* 회원 여부와 세션에따른 like, unlike 버튼 표시. */}
                
                {(sessionStorage["User_Id"] != undefined)
                ? 
                (
                <div>
                {(sessionStorage['User_Kind'] == 1) //관리자 일 경우 레시피를 삭제할 수 있다.
                ? 
                <Button style={{backgroundColor: "#886A08 !important", color: "white !important",float: "right !important", height: "46px !important", width: "50px !important"}} onClick={DelRecipe}>레시피 삭제</Button>
                :
                <p/>
                }
                <p style={{textAlign:"right"}}>좋아요 : {Likecount}</p>
                <Button style={{backgroundColor: "#886A08 !important", color: "white !important",float: "right !important", height: "46px !important", width: "50px !important"}} onClick={UnLikefunc}><DislikeOutlined/></Button>
                <Button style={{backgroundColor: "#088A85 !important", color: "white !important",float: "right !important", height: "46px !important", width: "50px !important"}} onClick={Likefunc}><LikeOutlined /></Button>
                </div>)
                : 
                (
                <div><p style={{textAlign:"right"}}>좋아요 : {Likecount}</p><Button style={{backgroundColor: "#088A85 !important", color: "white !important",float: "right !important", height: "46px !important", width: "50px !important"}}><DislikeOutlined /></Button>
                <Button style={{backgroundColor: "#886A08 !important", color: "white !important",float: "right !important", height: "46px !important", width: "50px !important"}}><LikeOutlined /></Button></div>
                )
                }
                <br/><br/>
                {(sessionStorage["User_Id"] === undefined)
                ?
                (<p/>)
                :
                (<div><hr/><TextArea style={{width: "800px" ,display: "flex", float:"left"}}rows={4} placeholder="댓글을 입력 하세요." onChange={AddComment} value={commentval}/>
                <Button style={{backgroundColor: "#F2F2F2 !important", color: "white !important", height: "100px !important", width: "100px !important"}} onClick={AppendComments}>등록</Button></div>)
                }
                <br/><br/>
                <hr/>
                <RecipeinfoComments number={Number(decodeURI(window.location.search.split('=')[1]))} Comm={commentval}/>
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