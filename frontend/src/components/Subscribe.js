import { Card, Row, Col, Typography } from 'antd';
import React from 'react';
import img1 from '../assets/img/라면.png'
import img2 from '../assets/img/떡국.jpg'
import img3 from '../assets/img/해물탕.jpg'
const { Meta } = Card;
const { Text } = Typography;


const Subscribe = () => (
    <div className="site-card-wrapper" style={{ width: "100vh" }}>
        <Row gutter={300}>
            <Col span={8}>
                <Card
                    onClick={() => { alert("click") }}
                    hoverable
                    style={{
                        width: 300,
                        height: 500,
                    }}
                    cover={<img alt="src1" src={img1} height="240" />}
                >
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text type="success" style={{ fontSize: "40px" }}>7일 구독권</Text>
                    </div>
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text type="success" style={{ fontSize: "25px" }}>30,000 Point</Text>
                    </div>

                    
                </Card>
            </Col>
            <Col span={8}>
                <Card
                    hoverable
                    style={{
                        width: 300,
                        height: 500,
                    }}
                    cover={<img alt="src2" src={img2} />}
                >
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text type="success" style={{ fontSize: "30px" }}>1개월 구독권</Text>
                    </div>
                    <Meta style={{ textAlign: 'center', display: "block" }}
                        title="30,000 Point!"
                    />
                </Card>
            </Col>
            <Col span={8}>
                <Card
                    hoverable
                    style={{
                        width: 300,
                        height: 500,
                    }}
                    cover={<img alt="src1" src={img3} height="240" />}
                >
                    <div className="mb-3" style={{ textAlign: 'center', display: "block" }}>
                        <Text type="success" style={{ fontSize: "30px" }}>3개월 구독권</Text>
                    </div>
                    <Meta style={{ textAlign: 'center', display: "block" }}
                        title="30,000 Point!"
                    />
                </Card>
            </Col>
        </Row>
    </div>

);

export default Subscribe;