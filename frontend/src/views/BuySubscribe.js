import React, { Component, useState, useEffect } from 'react';
import styled from "styled-components";
import Scrolltop from '../components/Scrolltop';
import axios from 'axios';
import Subscribe from '../components/Subscribe';
const Center = styled.h2`
text-align: center;
height: 100vh;
width: 100vh;
`
const BuySubscribe = (props) => {
    return (
        <>
       
            <div class="container-xxl py-5 pdCon" style={{paddingLeft:"50px",backgroundColor:'#ffffff'}} data-wow-delay="0.1s">
                <div class="row g-5 maCon" style={{width:'100vh',height:'100vh',backgroundColor:'#ffffff'}}>
                    <div class="col-lg-5" style={{width:'100%'}}>
                        <Subscribe/>
                    </div>
                </div>
            </div>
            <Scrolltop />
      
        </>
    );
};

export default BuySubscribe;