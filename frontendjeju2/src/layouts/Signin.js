import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Signin =() =>{
  const [inputId, setInputId] = useState('')
  const [inputPw, setInputPw] = useState('')

  const handleInputId = (e) => {
    setInputId(e.target.value)
}

const handleInputPw = (e) => {
    setInputPw(e.target.value)
}

const BASEURL = "http://localhost:4000/users"
// login 버튼 클릭 이벤트
const onClickLogin = () => {
    console.log('click login')
    axios.get(BASEURL,{
      params: {
        User_Email: inputId,
        User_Password: inputPw
      }
    })
    .then(function (response) {
      if(response.data != 0) {
        alert("로그인 성공")
        document.location.href = "http://localhost:3000/zipcook"
      }
      else alert("로그인 실패")
    })
    .catch(function (error) {
      console.log(error);
      alert("오류")
    })
}
// 페이지 렌더링 후 가장 처음 호출되는 함수
useEffect(() => {console.log(inputId)},[inputId])
useEffect(() => {console.log(inputPw)},[inputPw])
  
    return (
      <form>
        <h3>Sign In</h3>
        <div className="mb-3">
          <label>Email address</label>
          <input
            type="email"
            className="form-control"
            placeholder="Enter email"
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
          Forgot <a href="#">password?</a>
        </p>
      </form>
    )
  }


export default Signin;