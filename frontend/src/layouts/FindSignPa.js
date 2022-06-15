import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

const FindSignPa =() => {
  const [inputName, setInputName] = useState('')
  const [inputId, setInputId] = useState('')
  const [inputEmail, setInputEmail] = useState('')
  const [inputValidate, setInputValidate] = useState('')

  const handleInputName = (e) => {
    setInputName(e.target.value)
  }
  const handleInputId = (e) => {
    setInputId(e.target.value)
  }
  const handleInputValidate = (e) => {
    setInputValidate(e.target.value)
  }
  const handleInputEmail = (e) => {
    setInputEmail(e.target.value)
  }
  useEffect(() => { }, [inputName])
  useEffect(() => { }, [inputValidate])
  useEffect(() => { }, [inputEmail])
  
  
  const BASEURL = "http://localhost:8443/Account"

  const onClickSendEmail = () => {
    axios.post(BASEURL + "/sendPasswordByEmail", null, {
      params: {
        userName: inputName,
        userEmail: inputEmail
      }
    })
      .then(function (response) {
        if (response.data == -1) {
         alert("메일 보내기 실패")

        }else{
          alert("메일 보내기 성공")
          sessionStorage.setItem("random",response.data)
        } 
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }
  const onClickSendvalidate = () => {
      if(inputValidate == sessionStorage.getItem("random")){
        alert("회원 인증 성공")
        sessionStorage.setItem("User_Id",inputId)
        sessionStorage.removeItem("random")
        window.location.href = "http://localhost:3000/zipcook/member/ChangePa"
      }else alert("회원 인증 실패")
  }

    return (
      <form>
        <h3>비밀번호 찾기</h3>
        <div className="mb-3">
          <label>이름 입력</label>
          <input
            type="name"
            onChange={handleInputName}
            value={inputName}
            className="form-control"
            placeholder="Name"
          />
        </div>
        <div className="mb-3">
          <label>아이디 입력</label>
          <input
            type="text"
            onChange={handleInputId}
            value={inputId}
            className="form-control"
            placeholder="Id"
          />
        </div>
        <label>Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          이메일 확인 요청 받기</label>
        <div className="mb-3" style={{ display: 'flex', flexDirection: 'row' }}>
          <input
            type="email"
            className="form-control"
            onChange={handleInputEmail}
            value={inputEmail}
            placeholder="Email"
          />
          <button type="button" onClick={onClickSendEmail} className="btn btn-primary">
            Send
          </button>
        </div>
        <label>인증번호 입력</label>
        <div className="mb-3" style={{ display: 'flex', flexDirection: 'row' }}>
          <input
            type="text"
            className="form-control"
            onChange={handleInputValidate}
            value={inputValidate}
            placeholder="Check!"
          ></input>
        </div>
        <div class="row">
          <div class="col-xl">
            {/* <Link to="/zipcook/member/ChangePa"> */}
              <button type="button" onClick={onClickSendvalidate} className="btn btn-primary">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;확인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </button>
            {/* </Link> */}

            <Link to="/zipcook/member/Login">
              <button type="button" style={{float:'right'}} className="btn btn-primary" >
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;취소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </button>
            </Link>
          </div>
        </div>
      </form>
    )
  }
export default FindSignPa;