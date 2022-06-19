import React, { useEffect, useState } from "react";
import styled from "styled-components";
import axios from "axios";
const RefundPoint = (props) => {
  const getUserId = decodeURI(window.location.search.split('=')[1])
  const [inputText, setInputText] = useState(getUserId);
  const [refundPoint, setRefundPoint] = useState();
  const [point,setPoint] = useState(0);
  
  const BASEURL = "http://localhost:8443/Point/refund"
  const FindURL = "http://localhost:8443/Account/getAccount"
  const handleSubmit = (e) => {

    axios.post(BASEURL, null,{
      params:{
      refundPoint: refundPoint,
      userId: inputText
    }
    })
      .then(function (response) {
        if(response.data == -1){
          alert("환불 실패")
        }else if(response.data ==  1){
          alert("환불 성공");
          document.location.href = "http://localhost:3000/zipcook/PostMain?reportTitle="

      }
      })
      .catch(function (error) {
        alert("실패");
        console.log(error);
      });

  }

  const serachId = (e) => {

    axios.get(FindURL, {
      params: {
        userId: inputText
      }
    })
      .then(function (response) {
        if (response.data == "") {
          alert("없는 아이디")
          console.log("dfdf")
          console.log(response)
          console.log(response.data)
        }else{
          alert("존재하는 아이디")
          setPoint(response.data.userPoint);
          console.log("dfdf")
          console.log(response)
          console.log(response.data)
        }
        
      })
      .catch(function (error) {
        console.log(error);
        alert("오류")
      })
  };

  const handleChange = (e) => {  // <- input값으로 text 변경 함수
    setInputText(e.target.value)
  };
  const handleChange2 = (e) => {  // <- input값으로 text 변경 함수
    setRefundPoint(e.target.value)
  };

  useEffect(() => { }, [inputText]);
  useEffect(() => { }, [refundPoint]);
  useEffect(() => { }, [point]);

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
                style={{textAlign:'end'}}
                value={point}
                name='point'
              ></input>
            </div>
            <div className="mb-3">
              <label>환불할 포인트</label>
              <input
                type='text'
                className="form-control"
                style={{textAlign:'end'}}
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
              <button type="button" className="btn btn-primary" onClick={handleSubmit}>환불하기</button>
            </div>
          </form>
        </div>
      </div>
    </div>

  );
}

export default RefundPoint;