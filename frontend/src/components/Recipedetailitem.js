import React from 'react';
import {useEffect, useState, useRef, Fragment} from 'react';
import axios from "axios";
import ReactHlsPlayer from 'react-hls-player'
import VideoHover from './VideoHoverPlay.js';
import vide from "../Recipe/고등어조림.mp4";
const axio = axios.create({baseURL: 'http://localhost:8443'})
const reqUrl = '/Info/detail'; // 한 레시피 정보 조회
const reqUrl2 = '/Info/comments'; // 한 레시피의 댓글정보 조회

const reqSub = '/Info/LoginSub'; // 로그인 유저에 따른 관심분야 4개의 서브리스트
const reqSub2 = '/Info/Sub'; // 비로그인 유저에 따른 해당 게시글과 같은분야의 4개의 서브리스트
const GetVideo = '/Info/Videonum'; // 해당 게시글의 동영상 파일을 받아온다.

const Recipedetaillist=()=>
{
  const [ScrollY, setScrollY] = useState(0); // window 의 pageYOffset값을 저장 

  // useRef를 통해 css 변경
  const stickyChange = useRef(null);
  // const [subList, SetsubList] = useState=([ // subList 영상은 3개로 고정
  //   {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
  //   {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}, 
  //   {id:'' ,img:'', videoTitle:'', videoContexts:'', videoName:'', recipeLevel: '',recipeTime:'', recipeSize:'',recipeIngredient:'', recipeKind: '', videoLength:'', crDa:'' ,upDa:'', deDa:'', videoView: ''}
  // ])
  // const [videoName, setvideoName] = useState(['']); // subList의 영상 이름을 저장할 배열 State
  // const subListRef = useRef(subList);
  // const videoNameRef = useRef(videoName);
  // const SetvideosubList = () =>
  // {
  //   const result = [];
  //   for(let i=0;i<3;i++)
  //   {
  //     var url = 'http://localhost:8443/Streaming/hls/' + subListRef.current[i].videoName + '/' + subListRef.current[i].videoName + '.m3u8';
  //     result.push(url);
  //   }
  //   videoNameRef.current = result;
  //   setvideoName(result);
  // }

  // const checkUserLogin = async () =>  // 회원의 로그인 여부 확인해서 서브 리스트 구성.
  // {
  //   {sessionStorage.getItem("User_Number") != null
  //   ?
  //   ( await axio // 로그인했을 경우 해당 회원의 관심 분야 서브 리스트 호출
  //     .get(reqSub,{
  //         params:{
  //             userNumber: sessionStorage["User_Number"],
  //             videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
  //         }
  //     })
  //     .then((res)=>{
  //       subListRef.current = res.data;
  //       SetsubList(res.data)
  //       SetvideosubList();
  //     })
  //   )
  //   :
  //   (await axio // 로그인 유저가 아닐 경우 게시글과 같은 분야의 서브 리스트 호출
  //     .get(reqSub2,{
  //         params:{
  //             videoNumber: Number(decodeURI(window.location.search.split('=')[1]))
  //         }
  //     })
  //     .then((res)=>{
  //       subListRef.current = res.data;
  //       SetsubList(res.data);
  //       SetvideosubList();
  //     })
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
    const result = [];
    // for (let i = 0; i < subListRef.current.length;i++)
    // {
    //   result.push(
    //     <Fragment>
    //     <ReactHlsPlayer
    //         src={videoNameRef.current[i]}
    //         autoPlay={false}
    //         controls={true}
    //     />
    //     <p>제목 : {subListRef.current[i].videoTitle} || 조회수 : {subListRef.current[i].videoView} <br/> 업로드 날짜 : {subListRef.current[i].crDa}
    //     || 난이도 : {subListRef.current[i].recipeLevel} || 분야 : {subListRef.current[i].recipeKind}</p>
    //     </Fragment>
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
}

export default Recipedetaillist;