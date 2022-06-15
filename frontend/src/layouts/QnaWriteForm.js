import React, { useState,useEffect, Fragment } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';

const QnaWriteForm = () => {
  const [reportName, setReportName] = useState('')
  const [reportDetail, setReportDetail] = useState('')
  const [inputReportKind, setInputReportKind] = useState('')

  const handleInputTitle = (e) => {
    setReportName(e.target.value)
  }

  const handleInputDetail = (e) => {
    setReportDetail(e.target.value)
  }

  const handleInputReportKind = (e) => {
    setInputReportKind(e.target.value)
  }
  useEffect(() => {}, [reportName])
  useEffect(() => {}, [reportDetail])
  useEffect(() => {console.log(inputReportKind)}, [inputReportKind])

  // 아이디 중복 확인 이벤트
  const BASEURL = "http://localhost:8443/Account"
  const checkId = () => {
    axios.post(BASEURL + "/validateId", null, {
      params: {
        userId: sessionStorage.getItem("id")
      }
    })
      .then(function (response) {
        if (response.data == 1) {
          alert("사용가능 한 아이디입니다")
        }
        else alert("이미 존재하는 아이디입니다")
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }
  const onClickSignUp = () => {
    axios.post(BASEURL + "/signUpAccount", null, {
      params: {
        reportName: reportName,
        reportDetail: reportDetail,
        userReckind: inputReportKind,
        userNumber : sessionStorage.getItem("userNumber")
      }
    })
      .then(function (response) {
        if (response.data == -1) alert("문의글 작성 실패")
        else{
          alert("문의글 작성 성공")
          document.location.href = "http://localhost:3000/zipcook/Login" //문의글 백 연결
        }
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }
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
          <input type="radio" name="User_RecKind" value="환불" onChange={handleInputReportKind} />환불&nbsp;&nbsp;&nbsp;
          <input type="radio" name="User_RecKind" value="영상" onChange={handleInputReportKind} />영상&nbsp;&nbsp;&nbsp;
          <input type="radio" name="User_RecKind" value="로그인" onChange={handleInputReportKind} />로그인&nbsp;&nbsp;&nbsp;
          <input type="radio" name="User_RecKind" value="결제" onChange={handleInputReportKind} />결제
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
          <button type="submit" className="btn btn-primary" onClick={onClickSignUp}>
            등 록
          </button>
        </div>
        <p className="forgot-password text-right">
          <Link to="/zipcook/PostMain"><h5>취 소</h5></Link>
        </p>

      </form>
      </div>
      </div>
      <Footer></Footer>
      </Fragment>
      
    )
  
}
export default QnaWriteForm;