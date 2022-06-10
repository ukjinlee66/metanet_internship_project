import React,{useEffect,useState} from "react";
import styled from "styled-components";
import axios from "axios";
const SubTitleFont = styled.div`
// font-size: 1.5em;
text-align: center;
width: 100vh;
`


const ChargePointPage = (props) => {
  const BASEURL = "http://localhost:4000/data"
  function handleSubmit(e) {
    e.preventDefault();
    axios.post(BASEURL, {
      User_Point: inputText

    })
    .then(function (response) {
      console.log(response);
    })
    .catch(function (error) {
      console.log(error);
    });
    alert("제출");
  }
  const [inputText, setInputText] = useState(0);
  
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
  const onReset = () => {
    setInputText(0);
  };
  return (
    
    <SubTitleFont>
      {/* <form onSubmit={handleSubmit}> */}
      <h2>포인트 충전</h2>
      <input type='text'
             value={inputText}
             placeholder="금액을 입력해주세요."
             ></input>
      <button type="button" onClick={onReset}>금액 초기화</button><br />
      잔여 포인트: <text> 0원</text><br /><br />
      <button type="button" onClick={onChangeInput1}>+1만원</button>
      <button type="button" onClick={onChangeInput2}>+5만원</button>
      <button type="button" onClick={onChangeInput3}>+10만원</button>
      <button type="button" onClick={onChangeInput4}>+100만원</button><br/><br /><br />
      <button type="submit" onClick={handleSubmit}>제출</button>
      {/* </form> */}
    </SubTitleFont> 
  );
}

export default ChargePointPage;