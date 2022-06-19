import { Card, Row, Col, Typography } from 'antd';
import React from 'react';
import img1 from '../assets/img/라면.png'
import img2 from '../assets/img/떡국.jpg'
import img3 from '../assets/img/해물탕.jpg'
import axios from 'axios';
import { ajaxPrefilter } from 'jquery';


const { Meta } = Card;
const { Text } = Typography;



const Subscribe = () => {
    const BASEURL = "http://localhost:8443/Point/buy"
    const id = sessionStorage.getItem("User_Id")
    function cardClick(e) {
        var point = 0;
        if (e == 7) {
            point = 30000
        } else if (e == 30) {
            point = 100000
        } else if (e == 90) {
            point = 250000
        }
        axios.post(BASEURL, null,
            {
                params: {
                    userId: id,
                    buyKind: e,
                    buyPoint: point
                }
            })
            .then(function (response) {
                if (response.data == -1) {
                    alert("구독권 구매 실패")
                } else {
                    alert("구독권 구매 완료")
                    document.location.href = "http://localhost:3000/zipcook/MyPage"
                }
            })
            .catch(function (error) {
                console.log(error);
                alert("에러")
            });
    }

    return (
        <div style={{ display: 'inline-flex' }}>
            <div>
                <Card
                    onClick={() => cardClick(7)}
                    hoverable
                    style={{
                        width: 300,
                        height: 500,
                    }}
                    cover={<img alt="src1" src={img1} height="240" />}
                >
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text style={{ fontSize: "30px" }}>30일 구독권</Text>
                    </div>
                    <Meta style={{ textAlign: 'center', display: "block" }}
                        title="30,000 Point!"
                    />
                </Card>
            </div>
            <div style={{ paddingLeft: '200px' }}>
                <Card
                    onClick={() => cardClick(30)}
                    hoverable
                    style={{
                        width: 300,
                        height: 500,
                    }}
                    cover={<img alt="src2" src={img2} />}
                >
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text style={{ fontSize: "30px" }}>90일 구독권</Text>
                    </div>
                    <del>
                        <Meta style={{ textAlign: 'center', display: "block" }}
                            title="120,000 Point!"
                        />
                    </del>
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text type="success" style={{ fontSize: "20px" }}>"100,000 Point!"</Text>
                    </div>
                </Card>
            </div>
            <div style={{ paddingLeft: '200px' }}>
                <Card
                    onClick={() => cardClick(90)}
                    hoverable
                    style={{
                        width: 300,
                        height: 500,
                    }}
                    cover={<img alt="src1" src={img3} height="240" />}
                >
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text style={{ fontSize: "30px" }}>365일 구독권</Text>
                    </div>
                    <del>
                        <Meta style={{ textAlign: 'center', display: "block" }}
                            title="360,000 Point!"
                        />
                    </del>
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text type="success" style={{ fontSize: "20px" }}>"250,000 Point!"</Text>
                    </div>

                </Card>
            </div>
        </div>
    );
};

export default Subscribe;