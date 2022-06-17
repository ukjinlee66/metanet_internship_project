import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom'
import axios from 'axios';

const Signin = () => {
  const [inputId, setInputId] = useState('')
  const [inputPw, setInputPw] = useState('')

  const handleInputId = (e) => {
    setInputId(e.target.value)
  }

  const handleInputPw = (e) => {
    setInputPw(e.target.value)
  }
  const BASEURL = "http://localhost:8443/Account/login"
  // login 버튼 클릭 이벤트
  const onClickLogin = () => {
    axios.post(BASEURL, null,{
      params: {
        userId: inputId,
        userPassword: inputPw
      }
    })
      .then(function (response)  
      {
        if (response.data) {
          alert("로그인 성공")
          sessionStorage.setItem('User_Id', response.data.userId)
          sessionStorage.setItem('isManager', response.data.userKind === 0 ? 0 : 1) // 관리자 회원인지 확인
          sessionStorage.setItem('User_Number', response.data.userNumber)
          document.location.href = "http://localhost:3000/zipcook"

        }
        else{ 
          alert("로그인 실패")
          }
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }
  // 페이지 렌더링 후 가장 처음 호출되는 함수
  useEffect(() => { }, [inputId])
  useEffect(() => { }, [inputPw])

  return (
    <form>
      <h3>Sign In</h3>
      <div className="mb-3">
        <label>Id</label>
        <input
          type="text"
          className="form-control"
          placeholder="Enter Id"
          value={inputId}
          onChange={handleInputId}
        />
      </div>
      <div className="mb-3">
        <label>Password</label>
        <input
          type="password"
          className="form-control"
          placeholder="Enter password"
          value={inputPw}
          onChange={handleInputPw}
        />
      </div>
      <div className="mb-3">
        <div className="custom-control custom-checkbox">
          <input
            type="checkbox"
            className="custom-control-input"
            id="customCheck1"
          />
          <label className="custom-control-label" htmlFor="customCheck1">
            Remember me
          </label>
        </div>
      </div>
      <div className="d-grid">
        <button type="button" className="btn btn-primary" onClick={onClickLogin}>
          Login
        </button>
      </div>
      <p className="forgot-password text-right">
        Forgot <Link to="/zipcook/member/FindSignPa">password?</Link>
      </p>
      <p className="forgot-password text-right">
        Forgot <Link to="/zipcook/member/FindSignId">Id?</Link>
      </p>
    </form>
  )
}


export default Signin;