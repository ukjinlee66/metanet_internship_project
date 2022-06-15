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

        useEffect(() => { console.log("분류", inputRecKind) }, [inputRecKind])
        useEffect(() => { console.log("난이도", inputLevel) }, [inputLevel])

        // 레시피 클릭 시 이동
        function btClick(e) {
                sessionStorage.setItem("pageSession", 1);
                window.location.href = "/zipcook/RecipeAttractionList";
                sessionStorage.setItem("listState", e.target.value)
        }



        return (
                <div class="row g-2">
                    <div class="col-md-10">
                        <div class="row g-2">
                            <div class="col-md-12">
                                <div className="mb-3" style={{ paddingLeft: '20.4em', display: "flex" }}>
                                        <div style={{ paddingLeft: '30px', display: "flex" }}>
                                            <Title level={3}>분류 : </Title>&nbsp;&nbsp;&nbsp;
                                                <Radio.Group defaultValue="한식" buttonStyle="solid" >
                                                    <Radio.Button value="한식" onChange={handleInputRecKind}>한식</Radio.Button>
                                                    <Radio.Button value="중식" onChange={handleInputRecKind}>중식</Radio.Button>
                                                    <Radio.Button value="양식" onChange={handleInputRecKind}>양식</Radio.Button>
                                                    <Radio.Button value="일식" onChange={handleInputRecKind}>일식</Radio.Button>
                                                </Radio.Group>
                                        </div>
                                        <br />
                                        <div style={{ paddingLeft: '30px', display: "flex" }}>
                                            <Title level={3}>난이도 : </Title>&nbsp;&nbsp;&nbsp;
                                                <Radio.Group defaultValue="초급" buttonStyle="solid">
                                                    <Radio.Button value="초급" onChange={handleInputLevel}>초급</Radio.Button>
                                                    <Radio.Button value="중급" onChange={handleInputLevel}>중급</Radio.Button>
                                                    <Radio.Button value="상급" onChange={handleInputLevel}>상급</Radio.Button>
                                                </Radio.Group>
                                        </div>
                                <div style={{ paddingLeft: "25px", width: "100px" }}>
                                    <button type="button" style={{ width: "100px" }} className="btn btn-primary" value="검색">검색</button>
                                    <button type="button" style={{ width: "100px", marginTop: "27px" }} className="btn btn-primary" value="초기화">초기화</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
                // <div class="container">
                //         <div class="col-md-10">
                //                 <div className="mb-3">
                //                         <label>분류</label>
                //                         <br />
                //                         <input type="radio" name="RecKind" value="한식" onChange={handleInputRecKind} />한식&nbsp;
                //                         <input type="radio" name="RecKind" value="중식" onChange={handleInputRecKind} />중식&nbsp;
                //                         <input type="radio" name="RecKind" value="양식" onChange={handleInputRecKind} />양식&nbsp;
                //                         <input type="radio" name="RecKind" value="일식" onChange={handleInputRecKind} />일식
                //                 </div>
                //                 <div className="mb-3">
                //                         <br />
                //                         <input type="radio" name="Level" value="초급" onChange={handleInputLevel} />초급&nbsp;
                //                         <input type="radio" name="Level" value="중급" onChange={handleInputLevel} />중급&nbsp;
                //                         <input type="radio" name="Level" value="상급" onChange={handleInputLevel} />상급
                //                 </div>

                //         </div>
                // </div>
        );
}

export default RecipeRanking;