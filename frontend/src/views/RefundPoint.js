import React, { useEffect, useState } from "react";
import styled from "styled-components";
import axios from "axios";
const RefundPoint = (props) => {

  const [inputText, setInputText] = useState('');
  const [refundPoint, setRefundPoint] = useState(0);
  const [recipe, setRecipe] = useState([
    {
      User_Number: 0, User_Name: '', User_Id: '', User_Password: '', User_Phone_Number: '', User_Email: '', User_Point: '', User_Addr: '',
      User_RecKind: '', User_Kind: '', User_Date: ''
    }
  ])
  const BASEURL = "http://localhost:4000/users"
  const handleSubmit = (e) => {

    axios.put(BASEURL + "?User_id=" + recipe[0].User_Id, {
      User_Point: refundPoint
    })
      .then(function (response) {
        alert("성공");
        console.log(response);
      })
      .catch(function (error) {
        alert("실패");
        console.log(error);
      });

  }

  const serachId = (e) => {

    axios.get(BASEURL, {
      params: {
        User_Id: inputText
      }
    })
      .then(function (response) {
        if (response.data != 0) {
          alert("존재하는 아이디")
          setRecipe(response.data)

        }
        else alert("없는 아이디")
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
      .finally(() => {
        console.log("지금 실행", recipe)

      })
    setInputText('');
  };

  const handleChange = (e) => {  // <- input값으로 text 변경 함수
    setInputText(e.target.value)
  };
  const handleChange2 = (e) => {  // <- input값으로 text 변경 함수
    setRefundPoint(e.target.value)
  };

  useEffect(() => { }, [inputText]);
  useEffect(() => { }, [refundPoint]);
  useEffect(() => { console.log("유즈이펙트 실행", recipe) }, [recipe]);

  return (
    <div className="App">
      <div className="auth-wrapper">
        <div className="auth-inner">
          <form>
            <h3>포인트 환불</h3>
            <div className="mb-3">
              <label>아이디 검색</label>
              <div>
                <input
                  type='text'
                  className="form-control"
                  placeholder="아이디 검색"
                  style={{ width: '65%', display: 'inline' }}
                  value={inputText}
                  onChange={handleChange}
                />
                <button type="button" className="btn btn-primary" style={{ float: 'right' }} onClick={serachId}>아이디 조회</button><br />
              </div>
            </div>
            <div className="mb-3">
              <label>환불 가능 포인트</label>
              <input
                type='text'
                className="form-control"
                value={recipe[0].User_Point}
                name='point'
              ></input>
            </div>
            <div className="mb-3">
              <label>환불할 포인트</label>
              <input
                type='text'
                className="form-control"
                value={refundPoint}
                onChange={handleChange2}
              ></input>
            </div>
            <div className="mb-3">
              <label>환불 계좌</label>
              <select name="bank" className="form-control">
                <option value="">은행선택</option>
                <option value="shinhan">신한은행</option>
                <option value="kakao">카카오뱅크</option>
                <option value="naver">네이버페이</option>
              </select>
              <input type='text'
                className="form-control"
                //value={AccountNumber}
                name='AccountNumber'
                style={{marginTop:'2%'}}
                placeholder="계좌 번호 입력"
              ></input>
            </div>
            <div className="d-grid">
              <button type="submit" className="btn btn-primary" onClick={handleSubmit}>환불하기</button>
            </div>
          </form>
        </div>
      </div>
    </div>

  );
}

export default RefundPoint;