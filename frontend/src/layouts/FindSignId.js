import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'


const FindSignId = () => {
  const [inputName, setInputName] = useState('')
  const [inputPhone, setInputPhone] = useState('')
  const [inputEmail, setInputEmail] = useState('')

  const handleInputName = (e) => {
    setInputName(e.target.value)
  }
  const handleInputPhone = (e) => {
    setInputPhone(e.target.value)
  }
  const handleInputEmail = (e) => {
    setInputEmail(e.target.value)
  }
  useEffect(() => { }, [inputName])
  useEffect(() => { }, [inputPhone])
  useEffect(() => { }, [inputEmail])

  const BASEURL = "http://localhost:8443/Account"
  const onClickFindId = () => {
    axios.post(BASEURL + "/findId", null, {
      params: {
        userName: inputName,
        userPhoneNumber: inputPhone,
        userEmail: inputEmail
      }
    })
      .then(function (response) {
        if (response.data == "no ID") alert("회원을 찾을 수 없습니다.")
        else {
          console.log(response.data)
          let id = response.data
          alert("회원님의 아이디는 : "+id+" 입니다.")
          document.location.href = "http://localhost:3000/zipcook/member/Login"
        }
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }


  return (
    <form>
      <h3>아이디 찾기</h3>
      <div className="mb-3">
        <label>이름</label>
        <input
          type="text"
          className="form-control"
          onChange={handleInputName}
          value={inputName}
          placeholder="Enter name"
        />
      </div>
      <div className="mb-3">
        <label>이메일</label>
        <input
          type="email"
          onChange={handleInputEmail}
          value={inputEmail}
          className="form-control"
          placeholder="Enter email"
        />
      </div>
      <div className="mb-3">
        <label>연락처</label>
        <input
          type="text"
          onChange={handleInputPhone}
          value={inputPhone}
          className="form-control"
          placeholder="Enter phone number"
        />
      </div>
      <div class="row">
        <div class="col-xl">
            <button type="submit" onClick={onClickFindId} className="btn btn-primary">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;찾기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </button>        
          <Link to="/zipcook/member/Login">
            <button type="submit" style={{float:'right'}} className="btn btn-primary">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;취소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </button>
          </Link>
        </div>
      </div>

    </form>
  )
}
export default FindSignId;