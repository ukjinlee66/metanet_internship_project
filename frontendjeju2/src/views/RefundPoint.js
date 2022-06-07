import React, { useEffect, useState } from "react";
import styled from "styled-components";
import axios from "axios";
const SubTitleFont = styled.div`
// font-size: 1.5em;
text-align: center;
width: 100vh;
`


const RefundPoint = (props) => {
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
  const [inputText, setInputText] = useState('');

  const handleChange = (e) => {  // <- input값으로 text 변경 함수
    setInputText(e.target.value)
    console.log("input", inputText)
  };
  const serachId = () => {
    console.log("reset", inputText)
    setInputText('');
  };
  useEffect(() => {
		console.log(inputText);
	}, [inputText]);

출처: https://zereight.tistory.com/779 [김정혁 블로그:티스토리]
  return (

    <SubTitleFont>
      {/* <form onSubmit={handleSubmit}> */}
      <h2>포인트 환불</h2><br />
      아이디 검색 :&nbsp;
      <input type='text'
        placeholder="아이디 검색"
        value={inputText}
        onChange={handleChange}
      ></input>
      <button type="button" onClick={serachId}>계좌 조회</button><br />
      환불 가능 포인트 :&nbsp;
      <input type='text'
        //value={point}
        name='point'
      ></input><br />
      환불할 포인트 :&nbsp;
      <input type='text'
        //value={refundpoint}
        name='refundpoint'
      ></input><br />
      계좌 :&nbsp;
      <select name="bank">
        <option value="">은행선택</option>
        <option value="shinhan">신한은행</option>
        <option value="kakao">카카오뱅크</option>
        <option value="naver">네이버페이</option>
      </select>&nbsp;
      <input type='text'
        //value={AccountNumber}
        name='AccountNumber'
      ></input><br />
      <br /><br /><button type="submit" onClick={handleSubmit}>환불하기</button>
      {/* </form> */}
    </SubTitleFont>
  );
}

export default RefundPoint;