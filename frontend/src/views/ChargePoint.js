import React, { useEffect, useState } from "react";
import axios from "axios";



const ChargePointPage = (props) => {
  const BASEURL = "http://localhost:8443/Point/charge"
  const id = sessionStorage.getItem("User_Id")
  function handleSubmit(e) {
    e.preventDefault();
    axios.post(BASEURL, null,
      {
        params: {
          chargeKind: kind,
          chargePoint: inputText,
          userId: id
        }
      })
      .then(function (response) {
        if (response.data == -1) {
          alert("충전 실패")
        } else {
          alert("충전완료")
          document.location.href = "http://localhost:3000/zipcook/MyPage"
        }
      })
      .catch(function (error) {
        console.log(error);
        alert("에러")
      });
  }
  const [inputText, setInputText] = useState(0);
  const [kind, setKind] = useState('');
  const onChangeInput1 = () => {
    setInputText(inputText => inputText + 10000);
  };
  const onChangeInput2 = () => {
    setInputText(inputText => inputText + 50000);
  };
  const onChangeInput3 = () => {
    setInputText(inputText => inputText + 100000);
  };
  const onChangeInput4 = () => {
    setInputText(inputText => inputText + 1000000);
  };
  const handleInputRecKind = (e) => {
    setKind(e.target.value)
  }
  useEffect(() => { }, [kind])
  const onReset = () => {
    setInputText(0);
  };
  return (
    <div className="App">
      <div className="auth-wrapper">
        <div className="auth-inner" style={{ width: "480px" }}>
          <form>
            <h3>포인트 충전</h3>
            <input type='text'
              className="form-control"
              style={{ width: "65%", display: 'inline' }}
              value={inputText}
              placeholder="금액을 입력해주세요."
            /><button type="button" style={{ float: 'right' }} className="btn btn-primary" onClick={onReset}>금액 초기화</button><br />

            잔여 포인트: <text> 0원</text><br /><br />

            <button type="button" className="btn btn-primary" onClick={onChangeInput1}>+1만원</button>&nbsp;
            <button type="button" className="btn btn-primary" onClick={onChangeInput2}>+5만원</button>&nbsp;
            <button type="button" className="btn btn-primary" onClick={onChangeInput3}>+10만원</button>&nbsp;
            <button type="button" className="btn btn-primary" onClick={onChangeInput4}>+100만원</button><br /><br /><br />
            <div className="mb-3">
              <label>충전 방식</label>
              <br />
              <input type="radio" name="User_RecKind" value="현금결제" onChange={handleInputRecKind} />현금결제&nbsp;
              <input type="radio" name="User_RecKind" value="카드결제" onChange={handleInputRecKind} />카드결제&nbsp;
            </div>
            <div class="d-grid">
              <button type="submit" style={{ float: 'center' }} className="btn btn-primary" onClick={handleSubmit}>제출</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default ChargePointPage;