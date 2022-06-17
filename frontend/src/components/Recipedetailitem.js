import React from 'react';
import {useEffect, useState, useRef} from 'react';
import axios from "axios";
import VideoHover from './VideoHoverPlay.js';
import vide from "../Recipe/고등어조림.mp4";
const axio = axios.create({baseURL: 'http://localhost:8443'})
const reqUrl = '/Info/detail'; // 한 레시피 정보 조회
const reqUrl2 = '/Info/comments'; // 한 레시피의 댓글정보 조회

const reqSub = '/Info/LoginSub'; // 로그인 유저에 따른 관심분야 4개의 서브리스트
const reqSub2 = '/Info/Sub'; // 비로그인 유저에 따른 해당 게시글과 같은분야의 4개의 서브리스트
const reqCrCom = '/Info/CrCo'; // 로그인 유저의 댓글 작성
const reqDeCom = '/Info/CrCo'; // 로그인 유저의 댓글 삭제
const reqUpCom = '/Info/CrCo'; // 로그인 유저의 댓글 수정
const GetVideo = '/Info/Videonum'; // 해당 게시글의 동영상 파일을 받아온다.

const Recipedetaillist=()=>
{
  const [ScrollY, setScrollY] = useState(0); // window 의 pageYOffset값을 저장 

  // useRef를 통해 css 변경
  const stickyChange = useRef(null);
  // const [subList, SetsubList] = useState=([
  //   {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
  //   {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
  //   {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''},
  //   {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}
  // ])
  
  // const checkUserLogin = async () =>  // 회원의 로그인 여부 확인해서 서브 리스트 구성.
  // {
  //   {sessionStorage.getItem("userNumber") === true 
  //   ?
  //   ( await axio
  //     .get(reqSub,{
  //         params:{
  //             userNumber: sessionStorage.getItem("userNumber"),
  //             videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
  //         }
  //     })
  //     .then((res)=>SetsubList(res.data))
  //   )
  //   :
  //   (await axio
  //     .get(reqSub2,{
  //         params:{
  //             userNumber: sessionStorage.getItem("userNumber"),
  //             videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
  //         }
  //     })
  //     .then((res)=>SetsubList(res.data))
  //     )
  //   }
  // }
  
  useEffect(()=>
  {
    function scrollListener() { window.addEventListener("scroll", handleScroll); } //  window 에서 스크롤을 감시 시작
    scrollListener(); // window 에서 스크롤을 감시
    return () => { window.removeEventListener("scroll", handleScroll); }; //  window 에서 스크롤을 감시를 종료
    //checkUserLogin();
  },[]);
  
  const videoRender = async () =>
  {
    //const result = [];
    // const result = [];
    // for (let i = 0; i < subList.length;i++)
    // {
    //   result.push(
    //     <VideoHover name = {subList[i].videoName}/>
    //   )
    // }
    //return result;
  }
  // 스크롤의 Y축을 감시하여 특정 지점 이동 시 Navbar가 화면 일정 지점에 따라가도록 설정
  function handleScroll() {
  setScrollY(window.pageYOffset);
  if (ScrollY > 600) {
      stickyChange.current.style.top = '0px';
  } else {
      stickyChange.current.style.top = '50px';
  }
}
  return(
    <nav className="navbar bg-white navbar-light shadow sticky-top p-0" ref={stickyChange}>
      <VideoHover name = {vide}/>
      <h3>Video1</h3>
      <VideoHover name = {vide}/>
      <h3>Video2</h3>
      <VideoHover name = {vide}/>
      <h3>Video3</h3>
        {/* {videoRender()} */}
    </nav>
  );
};

export default Recipedetaillist;