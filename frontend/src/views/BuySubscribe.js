import React, { Component, useState, useEffect } from 'react';
import styled from "styled-components";
import Scrolltop from '../components/Scrolltop';
import Subscribe from '../components/Subscribe';
import Navbar from '../components/Navbar';
import MainSearch from '../components/MainSearch';
import Footer from '../components/Footer';
const Center = styled.h2`
text-align: center;
height: 100vh;
width: 100vh;
`
const BuySubscribe = (props) => {
    return (
        <div class="container-xxl bg-white p-0">
            <Navbar/>
            <MainSearch />
       
            <div class="container-xxl py-5 pdCon" style={{backgroundColor:'#ffffff'}} data-wow-delay="0.1s">
                <div class="row g-5 maCon" style={{backgroundColor:'#ffffff'}}>
                    <div class="col-lg-5" >
                        <Subscribe/>
                    </div>
                </div>
            </div>
            <Scrolltop />
            <Footer />
        </div>
      
    );
};

export default BuySubscribe;