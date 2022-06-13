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
const View = (props) => {
    const [data, setData] = useState(null);
    const BASEURL = "http://localhost:8443/MyPage"
    const onClick = async() => {
        try{
            const response = await axios.get(BASEURL + '/addViews' + "/한식");  
            setData(response.data);  
            console.log(response.data)
          }catch(e){
            console.log(e);
          }
    }
    return (
        <div className="auth-wrapper">
       
            <div class="container-xxl py-5 wow fadeInUp pdCon" style={{paddingLeft:"50px",backgroundColor:'#ffffff'}} data-wow-delay="0.1s">
                <div class="row g-5 maCon" style={{width:'100vh',height:'100vh',backgroundColor:'#ffffff'}}>
                    <div class="col-lg-5" style={{width:'100%'}}>
                        <ViewList/>
                        
                    </div>
                    
                </div>
            </div>
            <Scrolltop />
      
        </div>
    );
};

export default View;