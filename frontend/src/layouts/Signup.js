import React, { useState,useEffect } from 'react'
import axios from 'axios';


const SignUp = () => {
  const [inputName, setInputName] = useState('')
  const [inputId, setInputId] = useState('')
  const [inputPassword, setInputPassword] = useState('')
  const [inputPhone, setInputPhone] = useState('')
  const [inputEmail, setInputEmail] = useState('')
  const [inputAddr, setInputAddr] = useState('')
  const [inputRecKind, setInputRecKind] = useState('')

  const handleInputName = (e) => {
    setInputName(e.target.value)
  }
  const handleInputId = (e) => {
    setInputId(e.target.value)
  }
  const handleInputPassword = (e) => {
    setInputPassword(e.target.value)
  }
  const handleInputPhone = (e) => {
    setInputPhone(e.target.value)
  }
  const handleInputEmail = (e) => {
    setInputEmail(e.target.value)
  }
  const handleInputAddr = (e) => {
    setInputAddr(e.target.value)
  }
  const handleInputRecKind = (e) => {
    setInputRecKind(e.target.value)
  }
  useEffect(() => {}, [inputName])
  useEffect(() => {}, [inputId])
  useEffect(() => {}, [inputPassword])
  useEffect(() => {}, [inputPhone])
  useEffect(() => {}, [inputEmail])
  useEffect(() => {}, [inputAddr])
  useEffect(() => {}, [inputRecKind])

  // 아이디 중복 확인 이벤트
  const BASEURL = "http://localhost:8443/Account"
  const checkId = () => {
    axios.post(BASEURL + "/validateId", null, {
      params: {
        userId: inputId
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
        userName: inputName,
        userId: inputId,
        userPassword: inputPassword,
        userPhoneNumber: inputPhone,
        userEmail: inputEmail,
        userAddr: inputAddr,
        userReckind: inputRecKind
      }
    })
      .then(function (response) {
        if (response.data == -1) alert("회원 가입 실패")
        else{
          alert("회원 가입 성공")
          document.location.href = "http://localhost:3000/zipcook/member/Login"
        }
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }
    return (
      <form >
        <h3>Sign Up</h3>
        <div className="mb-3">
          <label>Name</label>
          <input
            type="text"
            className="form-control"
            name='User_Name'
            placeholder="Enter name"
            value={inputName}
            onChange={handleInputName}
          />
        </div>
        <div className="mb-3">
          <label>Id</label>
          <div style={{display:'flex'}}>
          <input type="text"
            className="form-control"
            name='User_Id'
            placeholder="Enter ID"
            style={{width:'70%'}}
            value={inputId}
            onChange={handleInputId}
          />&nbsp;
          <button type="button" className="btn btn-primary" style={{float:'right'}} onClick={checkId}>중복 체크</button>
        </div>
        </div>
        <div className="mb-3">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            name='User_Password'
            placeholder="Enter Password"
            value={inputPassword}
            onChange={handleInputPassword}
          />
        </div>
        <div className="mb-3">
          <label>Phone</label>
          <input
            type="text"
            className="form-control"
            name='User_Phone_Number'
            placeholder="Enter Phone"
            value={inputPhone}
            onChange={handleInputPhone}
          />
        </div>
        <div className="mb-3">
          <label>Email</label>
          <input
            type="email"
            className="form-control"
            name='User_Email'
            placeholder="Enter Email"
            value={inputEmail}
            onChange={handleInputEmail}
          />
        </div>
        <div className="mb-3">
          <label>Addr</label>
          <input
            type="text"
            className="form-control"
            name='User_Addr'
            placeholder="Enter Address"
            value={inputAddr}
            onChange={handleInputAddr}
          />
        </div>

        <div className="mb-3">
          <label>RecKind</label>
          <br />
          <input type="radio" name="User_RecKind" value="한식" onChange={handleInputRecKind} />한식&nbsp;
          <input type="radio" name="User_RecKind" value="중식" onChange={handleInputRecKind} />중식&nbsp;
          <input type="radio" name="User_RecKind" value="양식" onChange={handleInputRecKind} />양식&nbsp;
          <input type="radio" name="User_RecKind" value="일식" onChange={handleInputRecKind} />일식
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
            Sign Up
          </button>
        </div>
        <p className="forgot-password text-right">
          Already registered <a href="/zipcook/Login">sign in?</a>
        </p>

      </form>
    )
  
}
export default SignUp;