import React, { useEffect, useState } from 'react';
import { getPostByNo } from '../assets/Data/Data';
import '../assets/css/Post.css';
import { Link, useParams, useNavigate } from 'react-router-dom';
import Footer from '../components/Footer';
import axios from "axios";
import Navbar from "../components/Navbar";
const PostView = ({ history, location, match }) => {
  const [ data, setData ] = useState({});

  const { no } = useParams();
  const navigate = useNavigate();
  const PostListUrl = 'http://localhost:8443/Report/Posts/'+{no}.no;

  const getPostView = async (page) => {
    await axios
        .get(PostListUrl, {
        }).then((res) => {
          setData(res.data)
        })
};
useEffect(() => {
  getPostView();
}, []);

  const moveRefundPage = () =>{
    window.location.href = "zipcook/refundPoint?userId="+'wwong7247';
  }
  
  const deleteUrl = "http://localhost:8443/Report/DeletePost/"+data.reportTableNumber;
  const deleteReport = async (page) => {
    await axios
        .get(deleteUrl)
};
  return (
    <>
    <Navbar></Navbar>
      <br/><br></br><br></br><br></br>
      <h2 align="center">게시글 상세정보</h2>
      <br></br><br></br><br></br>
      
      <div className="post-view-wrapper">
        {
          data ? (
            <>
              <div className="post-view-row">
                <label>| 게시글 번호</label>
                <label>{ data.reportTableNumber }</label>
              </div>
              <hr></hr>
              <div className="post-view-row">
                <label>| 제목</label>
                <label>{ data.reportName }</label>
              </div>
              <hr></hr>
              <div className="post-view-row">
                <label>| 작성자</label>
                <label>{ data.userId }</label>
              </div>
              <hr></hr>
              <div className="post-view-row">
                <label>| 작성일</label>
                <label>{ data.crDa }</label>
              </div>
              <hr></hr>
              <div className="post-view-row">
                <label>| 답변일</label>
                <label>{ data.reDa }</label>
              </div>
              <hr></hr>
              <div className="post-view-row">
                <label>| 분류</label>
                <label>{ data.reportKind }</label>
              </div>
              <hr></hr>
              
              <div className="post-view-row">
                <label>| 내용</label>
                
                

                <div>
                
                
                  {
                    data.reportDetail
                  }
                </div>
                
              </div>
              <hr></hr>
            </>
          ) : '해당 게시글을 찾을 수 없습니다.'
        }
        <button className="post-view-go-list-btn" onClick={moveRefundPage} >환불 이동</button>
        <button style={{marginLeft:"10px"}}className="post-view-go-list-btn" onClick={deleteReport}>문의사항 삭제</button>
        <button style={{marginLeft:"10px"}}className="post-view-go-list-btn" onClick={() => navigate(-1)}>목록으로 돌아가기</button>
        
      </div>
      <Footer />
    </>
  )
}

export default PostView;