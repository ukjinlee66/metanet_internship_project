import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

const FindSignPa =() => {
  const [inputName, setInputName] = useState('')
  const [inputEmail, setInputEmail] = useState('')
  const [inputValidate, setInputValidate] = useState('')

  const handleInputName = (e) => {
    setInputName(e.target.value)
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
        <label>Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이메일 확인 요청 받기</label>
        <div className="mb-3" style={{ display: 'flex', flexDirection: 'row' }}>
          <input
            type="email"
            className="form-control"
            onChange={handleInputEmail}
            value={inputEmail}
            placeholder="Email"
          />
          <button type="submit" className="btn btn-primary">
            Send
          </button>
        </div>
        <label>인증번호 입력</label>
        <div className="mb-3" style={{ display: 'flex', flexDirection: 'row' }}>
          <input
            type="email"
            className="form-control"
            onChange={handleInputValidate}
            value={inputValidate}
            placeholder="Check!"
          ></input>
        </div>
        <div class="row">
          <div class="col-xl"></div>
          <div class="col-xl">
            <Link to="/zipcook/member/ChangePa">
              <button type="submit" className="btn btn-primary">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;확인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </button>
            </Link>

            <Link to="/zipcook/member/Login">
              <button type="submit" style={{float:'right'}} className="btn btn-primary" >
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;취소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </button>
            </Link>
          </div>
        </div>
      </form>
    )
  }
export default FindSignPa;