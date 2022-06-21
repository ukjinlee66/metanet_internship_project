import React, { useState, useEffect, Fragment } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';


const getToday=()=>{
  var date = new Date();
  var year = date.getFullYear();
  var month = ("0" + (1 + date.getMonth())).slice(-2);
  var day = ("0" + date.getDate()).slice(-2);

  return year + "-" + month + "-" + day;
}
const QnaWriteForm = () => {
  const [reportName, setReportName] = useState('')
  const [reportDetail, setReportDetail] = useState('')
  const [inputReportKind, setInputReportKind] = useState('')
  const [refundMoney, setRefundMoney]= useState('')
  const handleInputTitle = (e) => {
    setReportName(e.target.value)
  }

  const handleInputDetail = (e) => {
    setReportDetail(e.target.value)
  }
  const handleInputRefundMoney = (e) => {
    setRefundMoney(e.target.value)
  }

  const handleInputReportKind = (e) => {
    
    setInputReportKind(e.target.value)
  }
  useEffect(() => {}, [reportName])
  useEffect(() => {}, [reportDetail])
  useEffect(() => {console.log(inputReportKind)}, [inputReportKind])

  // 문의글 등록
  const BASEURL = "http://localhost:8443/Report/Post"

  const submitReport = () => {
    axios.post(BASEURL, null, {
      params: {
        userNumber : sessionStorage.getItem("User_Number"),
        reportDetail : reportDetail,
        reportKind: inputReportKind,
        reportName: reportName,
      }
    })
      .then(function (response) {
        if (response.data == -1) alert("문의글 작성 실패")
        else{
          alert("문의글 작성 성공")
          document.location.href = "/zipcook/PostMain?reportTitle=" //문의글 백 연결
        }
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }
  // const refundRender = () => {
  //   if(refundMoney === '취소/환불 접수'){
  //     alert("취소/환불");
  //   return <div className="mb-3">
  //           <label>환불 희망 금액</label>
  //           <br />
  //           <input type="text" name="refundMoney" placeholder="Enter refund Money" value={refundMoney} onChange={handleInputRefundMoney} />
  //         </div>
  //   }
  //   else{
  //     return ''
  //   }
  // }
    return (
        <Fragment>
        <Navbar></Navbar>
        <div class="auth-wrapper" >
        <div class="auth-inner"style={{width:'1500px'}}>
      <form >
        <h3>문의글 작성</h3>
        <div className="mb-3">
          <label>제목</label>
          <input
            type="text"
            className="form-control"
            name='Title'
            placeholder="Enter title"
            value={reportName}
            onChange={handleInputTitle}
          />
        </div>

        <div className="mb-3">
          <label>문의 분류</label>
          <br />
          <input type="radio" name="User_RecKind" value="포인트 결제 문의" onChange={handleInputReportKind} />포인트 결제 문의&nbsp;&nbsp;&nbsp;
          <input type="radio" name="User_RecKind" value="취소/환불 접수" onChange={handleInputReportKind} />취소/환불 접수&nbsp;&nbsp;&nbsp;
          <input type="radio" name="User_RecKind" value="불편사항" onChange={handleInputReportKind} />불편사항&nbsp;&nbsp;&nbsp;
          <input type="radio" name="User_RecKind" value="콘텐츠 요청" onChange={handleInputReportKind} />콘텐츠 요청&nbsp;&nbsp;&nbsp;
          <input type="radio" name="User_RecKind" value="기타" onChange={handleInputReportKind} />기타&nbsp;&nbsp;&nbsp;
        </div>
        

        <div className="mb-3" style={{height:'500px'}}>
          <label>문의내용</label>
          <textarea
            style={{minHeight:'450px' ,borderWidth: 1,
            borderRadius: 5,
            borderStyle: 'solid'}}
            className="form-control"
            name='reportDetail'
            placeholder="Enter report content"
            value={reportDetail}
            onChange={handleInputDetail}
          />
        </div>
        

        

        <div className="mb-3">
          <input
            type="hidden"
            className="form-control"
            name='User_Point'
            value={0}
          />
        </div>
        <div className="d-grid">
          <button type="submit" className="btn btn-primary" onClick={submitReport}>
            등 록
          </button>
        </div>
        <p className="forgot-password text-right">
          <Link to="/zipcook/PostMain?reportTitle="><h5>취 소</h5></Link>
        </p>

      </form>
      </div>
      </div>
      <Footer></Footer>
      </Fragment>
      
    )
  
}
export default QnaWriteForm;