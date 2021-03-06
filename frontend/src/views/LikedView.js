import React, { Component, useState, useEffect } from 'react';
import styled from "styled-components";
import Scrolltop from '../components/Scrolltop';
import axios from 'axios';
import ViewList from '../components/ViewList';
const Center = styled.h2`
text-align: center;
height: 100vh;
width: 100vh;
`
const LikedView = (props) => {
    const [data, setData] = useState(null);

    const reqUrl = 'http://localhost:8443/MyPage/getLikes?userId='
    useEffect(() => {
        axios
            .get(reqUrl + sessionStorage.getItem("User_Id"))
            .then((res) => {setData(res.data)
                console.log("좋아요",res.data)}
            );
            
    },[])
    return (
        <>
       
            <div class="container-xxl py-5 pdCon" style={{paddingLeft:"50px",backgroundColor:'#ffffff'}} data-wow-delay="0.1s">
                <div class="row g-5 maCon" style={{width:'100vh',height:'100vh',backgroundColor:'#ffffff'}}>
                    <div class="col-lg-5" style={{width:'100%'}}>
                        <ViewList data = {data}/>
                    </div>
                </div>
            </div>
            <Scrolltop />
      
        </>
    );
};

export default LikedView;