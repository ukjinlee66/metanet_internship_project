import React,{useState} from 'react';
import '../views/sign.css';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import { Link } from 'react-router-dom';
import axios from 'axios';

function ChangePassWord() {
  
  const [Password, setPassword] = useState("")
  const [confirmPassword, setconfirmPassword] = useState("")

  const onPasswordHandler = (e) => {
    setPassword(e.currentTarget.value)
  }
  const onconfirmPasswordHandler = (e) => {
    setconfirmPassword(e.currentTarget.value)
}
const hasNotSameError = passwordEntered =>
Password != confirmPassword ? true : false;

const BASEURL = "http://localhost:8443/Account"
const onSubmitHandler = (e) => {
  e.preventDefault();

  if(Password !== confirmPassword){
      return alert('비밀번호와 비밀번호 확인은 같아야 합니다.')
  }
  axios.post(BASEURL + "/updatePassword", null, {
    params: {
      userId: sessionStorage.getItem("User_Id"),
      newPassword: Password
    }
  })
    .then(function (response) {
      if (response.data == 1) {
        alert("비밀번호 변경 완료")
        sessionStorage.removeItem("User_Id")
        document.location.href = "http://localhost:3000/zipcook/member/Login"

      }
      else alert("비밀번호 변경 실패")
    })
    .catch(function (error) {
      console.log(error);
      alert("오류")
    })

}


  return (
    <form onSubmit={onSubmitHandler}>
      <h3>비밀번호 변경</h3>
      <div className="mb-3">
        <label>변경 할 비밀번호</label>
        <input
          type="password"
          value={Password}
          onChange={onPasswordHandler}
          className="form-control"
          placeholder="PassWord"
        />
      </div>
      <div className="mb-3">
        <label>비밀번호 확인</label>
        <input
          type="password"
          value={confirmPassword}
          onChange={onconfirmPasswordHandler}
          name="confirmPassword"
          onError={hasNotSameError('confirmPassword')} // 해당 텍스트필드에 error 핸들러 추가
          className="form-control"
          placeholder="PassWord Check"
        />
        <span >{hasNotSameError('confirmPassword') ? "❌입력한 비밀번호와 일치하지 않습니다.❌" : "✅비밀번호 확인✅"}</span>
      </div>
      <div class="row">
        <div class="col-xl">

            <button type="submit" className="btn btn-primary">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;확인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </button>

          <Link to="/zipcook/member/Login">
            <button type="button" style={{float:'right'}} className="btn btn-primary">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;취소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </button>
          </Link>
        </div>
      </div>
    </form>
  );
}

export default ChangePassWord;