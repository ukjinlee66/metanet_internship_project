import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";

function Question(props) {
    const [recipeClick, setRecipeClick] = useState("")


    const [searchInput, setSearchInput] = useState("")

    // 검색 버튼 클릭 시 이동
    function btClick(e) {
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/jeju/ServiceCenter";
    }

    // 검색창에 ENTER 치는 경우에 검색 버튼 클릭으로 간주
    const onKeyPress = (e) => {
        if(e.key=='Enter'){
            btClick();
        }
    }

    return (
            <div class="container">
                    <div class="col-md-10">
                        <br/><br/><br/><br/>
                        <h1> 자주묻는 질문</h1>
                        <br/><br/>
                        <div class="container">
                            <div class="row g-2">
                                <div class="col-md-10">
                                    <div class="row g-2">
                                        <div class="col-md-12">
                                            <input type="text" class="form-control border-0" placeholder="질문 입력하세요" onChange={(event) => setSearchInput(event.target.value)} onKeyPress={onKeyPress} value={searchInput}/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <button class="btn btn-dark border-0 w-100" onClick={btClick}>Search</button>
                                </div>
                            </div>
                        </div>  
                        <p>
                        <table border="1" width= "300">
                            <th>NO.</th>
                            <th>제목</th>
                            <th>분류</th>
                            <tr>
                                <td>1</td>
                                <td><a href = "/jeju/QuestionInfo">환불받고 싶어요</a></td>
                                <td>환불</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td><a href = "/jeju/QuestionInfo">영상이 안나와요</a></td>
                                <td>영상</td>
                            </tr>
                            </table>
                        </p>
                        <p>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="돼지고기김치찜">고객센터</button>
                        </p>
                    </div>
            </div>
    );
}

export default Question;