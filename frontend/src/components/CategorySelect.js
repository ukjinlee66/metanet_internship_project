import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import { Radio, Typography } from 'antd';
import axios from "axios";

const { Title } = Typography;


function RecipeRanking(props) {
        const [inputRecKind, setInputRecKind] = useState('')
        const [inputLevel, setInputLevel] = useState('')

        const handleInputRecKind = (e) => {
                setInputRecKind(e.target.value)
        }
        const handleInputLevel = (e) => {
                setInputLevel(e.target.value)
        }

        useEffect(() => { }, [inputRecKind])
        useEffect(() => { }, [inputLevel])

        // 레시피 클릭 시 이동
        function btClick(e) {
                sessionStorage.setItem("pageSession", 1);
                window.location.href = "/zipcook/RecipeAttractionList";
                sessionStorage.setItem("listState", e.target.value)
        }

        function reset(e) {
            
        }
        useEffect(() =>{},[inputLevel])
        useEffect(() =>{},[inputRecKind])


        return (
                <div class="row g-2">
                    <div class="col-md-10">
                        <div class="row g-2">
                            <div class="col-md-12">
                                <div className="mb-3" style={{ display: "flex" }}>
                                        <div style={{ paddingLeft: '10px',paddingTop:'3px', display: "flex" }}>
                                            <Title level={3}>분류 : </Title>&nbsp;&nbsp;&nbsp;
                                                <Radio.Group defaultValue="한식" buttonStyle="solid" >
                                                    <Radio.Button value="한식" onChange={handleInputRecKind}>한식</Radio.Button>
                                                    <Radio.Button value="중식" onChange={handleInputRecKind}>중식</Radio.Button>
                                                    <Radio.Button value="양식" onChange={handleInputRecKind}>양식</Radio.Button>
                                                    <Radio.Button value="일식" onChange={handleInputRecKind}>일식</Radio.Button>
                                                </Radio.Group>
                                        </div>
                                        <br />
                                        <div style={{ paddingLeft: '30px',paddingTop:'3px', display: "flex" }}>
                                            <Title level={3}>난이도 : </Title>&nbsp;&nbsp;&nbsp;
                                                <Radio.Group defaultValue="초급" buttonStyle="solid">
                                                    <Radio.Button value="초급" onChange={handleInputLevel}>초급</Radio.Button>
                                                    <Radio.Button value="중급" onChange={handleInputLevel}>중급</Radio.Button>
                                                    <Radio.Button value="상급" onChange={handleInputLevel}>상급</Radio.Button>
                                                </Radio.Group>
                                        </div>
                                <div style={{ paddingLeft: "30px", width: "100px" }}>
                                    <button type="button" style={{ width: "100px" }} onClick={reset} className="btn btn-primary" value="초기화">초기화</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );
}

export default RecipeRanking;