import React, { useState,useEffect } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';


const EditSign = () => {
  const [inputName, setInputName] = useState('')
  const [inputId, setInputId] = useState('')
  const [inputPassword, setInputPassword] = useState('')
  const [inputPhone, setInputPhone] = useState('')
  const [inputEmail, setInputEmail] = useState('')
  const [inputAddr, setInputAddr] = useState('')
  const [inputRecKind, setInputRecKind] = useState('')
  const [users, setUsers] = useState([
    {id:0 ,User_Name:'',User_Id:'',User_Password:'',User_Phone_Number:'',
    User_Email:'',User_Point:0 ,User_Addr:'',User_RecKind:'',User_Kind:'',User_Date:''}
  ])
  

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
        console.log(users)
      })
  }
  // BASEURL + "/updateAccount"
  //회원 정보 수정
  const onClickEdit = () => {
    axios.patch(test + "/1",{
      
      User_Addr : inputAddr
    })
      .then(function (response) {
        if (response.data == 1) alert("회원 정보 수정 실패")
        else{
          alert("회원 정보 수정 성공")
          // document.location.href = "http://localhost:3000/zipcook/Login"
          
        }
        
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  }

  //주소 변경
  const handleInputAddr = (e) => {
    setInputAddr(e.target.value)
  }
  useEffect(() => {console.log(inputAddr)}, [inputAddr])

  const test = "http://localhost:4000/users"
  useEffect(() => {
    axios
      .get(test + "?User_Id=jhj774")
      .then((res) =>{
        setUsers(res.data)
        console.log(res.data)
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
            value={users[0].User_Name}
            // onChange={handleInputName}
            readOnly
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
            value={users[0].User_Id}
            // onChange={handleInputId}
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
            value={users[0].User_Password}
            // onChange={handleInputPassword}
          />
        </div>
        <div className="mb-3">
          <label>Phone</label>
          <input
            type="text"
            className="form-control"
            name='User_Phone_Number'
            placeholder="Enter Phone"
            value={users[0].User_Phone_Number}
            readOnly
            // onChange={handleInputPhone}
          />
        </div>
        <div className="mb-3">
          <label>Email</label>
          <input
            type="email"
            className="form-control"
            name='User_Email'
            placeholder="Enter Email"
            value={users[0].User_Email}
            readOnly
            // onChange={handleInputEmail}
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
          <input type="radio" name="User_RecKind" value="한식"  />한식&nbsp;
          <input type="radio" name="User_RecKind" value="중식"  />중식&nbsp;
          <input type="radio" name="User_RecKind" value="양식"  />양식&nbsp;
          <input type="radio" name="User_RecKind" value="일식"  />일식
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