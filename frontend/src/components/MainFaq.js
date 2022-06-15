import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import ReactDOM from "react-dom";
import Faq from 'react-faq-component';

function MainFaq() {
  const [rows, setRowsOption] = useState(null);
  const data = {
    title: "FAQ | 자주 찾는 질문",
    rows: [
      {
        title: "환불이 안돼요",
        content: `한달째 환불이 안돼요 빨리해결해주세요`
      },
      {
        title: "영상 재생이 안돼요",
        content:
          "이럴거면 유튜브 보죠"
      },
      {
        title: "비밀번호 변경이 안돼요",
        content: `해킹당해서 비밀번호 바꾸려는데 안돼요 `
      },
      {
        title: "댓글 등록이 안돼요",
        content: <p>current version is 1.2.1</p>
      }
    ]
  };
  // useEffect(() => {
  //     if (rows) {
  //         setTimeout(() => {
  //             rows[0].expand();
  //         }, 2500);

  //         setTimeout(() => {
  //             rows[0].close();
  //         }, 5000);

  //         setTimeout(() => {
  //             rows[0].scrollIntoView();
  //             // rows[0].scrollIntoView(true);
  //         }, 10000);
  //     }
  // }, [rows]);

  return (
    <div>
      <h2 className="section-title">FAQ section</h2>

      <div className="faq-style-wrapper">
        <Faq data={data} getRowOptions={setRowsOption} />
      </div>
    </div>
  );
}

const rootElement = document.getElementById("root");
ReactDOM.render(<MainFaq />, rootElement);

export default MainFaq;