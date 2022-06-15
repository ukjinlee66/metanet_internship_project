import React, { useState, useEffect } from 'react'
import axios from 'axios';


const EditSign = () => {
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
  useEffect(() => { }, [inputName])
  useEffect(() => { }, [inputId])
  useEffect(() => { }, [inputPassword])
  useEffect(() => { }, [inputPhone])
  useEffect(() => { }, [inputEmail])
  useEffect(() => { }, [inputAddr])
  useEffect(() => { }, [inputRecKind])

  const BASEURL = "http://localhost:8443/Account"

  // BASEURL + "/updateAccount"
  //회원 정보 수정
  const onClickEdit = () => {
    axios.post(BASEURL + "/updateAccount", null, {
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
        if (response.data =="") alert("회원 정보 수정 실패")
        else {
          alert("회원 정보 수정 성공")
          document.location.href = "http://localhost:3000/zipcook/"

        }

      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }

  useEffect(() => {
    axios
      .get(BASEURL + "/getAccount", {
        params: {
          userId: sessionStorage.getItem("User_Id")
        }
      })
      .then((res) => {
        setInputName(res.data.userName)
        setInputId(res.data.userId)
        setInputPassword(res.data.userPassword)
        setInputPhone(res.data.userPhoneNumber)
        setInputEmail(res.data.userEmail)
        setInputAddr(res.data.userAddr)
        setInputRecKind(res.data.userReckind)
      })
  }, [])

  return (
    <form >
      <h3>회원 정보 수정</h3>
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
        <input
          type="text"
          className="form-control"
          name='User_Id'
          placeholder="Enter ID"
          value={inputId}
          onChange={handleInputId}
          readOnly
        />
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
        ></input>
      </div>

      <div className="mb-3">
        <label>RecKind</label>
        <br />
        <input type="radio" name="User_RecKind" onChange={handleInputRecKind} value="한식" />한식&nbsp;
        <input type="radio" name="User_RecKind" onChange={handleInputRecKind} value="중식" />중식&nbsp;
        <input type="radio" name="User_RecKind" onChange={handleInputRecKind} value="양식" />양식&nbsp;
        <input type="radio" name="User_RecKind" onChange={handleInputRecKind} value="일식" />일식
      </div>

      <div className="d-grid">
        <button type="submit" className="btn btn-primary" onClick={onClickEdit}>
          회원 정보 수정
        </button>
      </div>

    </form>
  )

}
export default EditSign;