import React, { Fragment, useEffect, useState } from 'react';
import { getPostByNo } from '../assets/Data/Data';
import '../assets/css/Post.css';
import { Link, useParams, useNavigate } from 'react-router-dom';
import Footer from '../components/Footer';
import axios from "axios";
import Navbar from "../components/Navbar";
import withImportantStyle from 'react-with-important-style';
import ReportComment from '../components/ReportComment';
import { Input } from 'antd';


const { TextArea } = Input;


const PostView = ({ history, location, match }) => {
  const [ data, setData ] = useState({});
  const { no } = useParams();
  const [ userData, setUserData] = useState({});
  const [commentval, setcommentval] = useState("");

  const navigate = useNavigate();
  const PostListUrl = 'http://localhost:8443/Report/Posts/'+{no}.no;
  
  const reqadd = 'http://localhost:8443/Report/Reply'; // 댓글 입력
  const reqUrl2 = '/Info/comments'; // 한 문의사항 댓글정보 조회


  
  const AppendComments = () => // 댓글 입력 axios
    {
        axios
        .post(reqadd,{},{
            params:{
                reportReply: commentval,
                userKind: Number(1),
                reportTableNumber: Number(data.reportTableNumber)
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
  const getPostView = async (page) => {
    await axios
        .get(PostListUrl, {
        }).then((res) => {
          setData(res.data)
          getUserId(res.data.userNumber)
        })
};
useEffect(() => {
  getPostView();
}, []);

const [isAdmin, setIsAdmin] = useState('0')
    useEffect(() => {
        if (sessionStorage.getItem('User_Kind') === '0') {
        } else {
          setIsAdmin('1')
          console.log("User_Kind"+sessionStorage.getItem("User_Kind"))

        }
    })  

    const [isRefund, setIsRefund] = useState('취소/환불 접수')
    useEffect(() => {
        if (data.reportKind === '취소/환불 접수') {
        } else {
          setIsRefund(data.reportKind)
          console.log("분류:"+ data.reportKind)

        }
    })  

const getUserId = async (uNumber) => {
  await axios
      .get("http://localhost:8443/Report/Posts?userNumber="+uNumber, {
      }).then((res) => {
        setUserData(res.data)
      })
};
useEffect(() => {
  getUserId();
}, []);
  const Button = withImportantStyle('button');
  const moveRefundPage = () =>{
    window.location.href = "zipcook/refundPoint?userId="+userData.userId;
  }
  
  const deleteReport = async (page) => {
    await axios
        .delete("http://localhost:8443/Report/DeletePost/"+data.userNumber)
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
                <label> {userData.userId} </label>
              </div>
              <hr></hr>
              <div className="post-view-row">
                <label>| 작성일</label>
                <label>{ data.crDa }</label>
              </div>
              
              <hr></hr>
              <div className="post-view-row">
                <label>| 분류</label>
                <label>{ data.reportKind }</label>
              </div>
              <hr></hr>
              
              <div className="post-view-row"  style={{marginBottom:"50px"}}>
                <label>| 내용</label>
                
                

                <div>
                
                
                  {
                    data.reportDetail
                  }
                </div>
                
              </div>
              
              <hr></hr>
              <div className="post-view-row">
                <label>| 관리자 답변</label>
                <label>{ data.reportReply }</label>
              </div>
              <hr></hr>
              <div className="post-view-row">
                <label>| 답변일</label>
                <label>{ data.reDa }</label>
              </div>
              
              <hr></hr>
            </>
          ) : '해당 게시글을 찾을 수 없습니다.'
        }
      
                <hr/>
                {isAdmin === '0' ? (
                  <Fragment>
                  
                    <button style={{marginLeft:"10px"}} className="post-view-go-list-btn" onClick={() => navigate(-1)}>목록으로 돌아가기</button>
                    </Fragment>) : (data.reportKind === '취소/환불 접수' ? (<Fragment>
                  
                  <br/><br/>
                  <div><TextArea style={{width: "800px" ,display: "flex", float:"left"}}rows={4} placeholder="댓글을 입력 하세요." onChange={AddComment} value={commentval}/>
                  <Button style={{backgroundColor: "#F2F2F2 !important", color: "white !important", height: "100px !important", width: "100px !important"}} onClick={AppendComments}>등록</Button></div>
                  <br/><br/>
                  <button className="post-view-go-list-btn" onClick={moveRefundPage} >환불 이동</button>
                  <button style={{marginLeft:"10px"}}className="post-view-go-list-btn" onClick={() => navigate(-1)}>목록으로 돌아가기</button>
                  </Fragment>): 
                  <Fragment>
                  <br/><br/>
                  <div><TextArea style={{width: "800px" ,display: "flex", float:"left"}}rows={4} placeholder="댓글을 입력 하세요." onChange={AddComment} value={commentval}/>
                  <Button style={{backgroundColor: "#F2F2F2 !important", color: "white !important", height: "100px !important", width: "100px !important"}} onClick={AppendComments}>등록</Button></div>
                  <br/><br/>
                  <button style={{marginLeft:"10px"}}className="post-view-go-list-btn" onClick={() => navigate(-1)}>목록으로 돌아가기</button>
                  </Fragment>
                )}

                {/* <button className="post-view-go-list-btn" onClick={moveRefundPage} >환불 이동</button>
        <button style={{marginLeft:"10px"}}className="post-view-go-list-btn" onClick={deleteReport}>문의사항 삭제</button>
        <button style={{marginLeft:"10px"}}className="post-view-go-list-btn" onClick={() => navigate(-1)}>목록으로 돌아가기</button> */}
      </div>

        
      <Footer />
    </>
  )
}

export default PostView;