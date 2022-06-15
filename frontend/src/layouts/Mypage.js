import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import styled from "styled-components";
import ListSearch from '../components/ListSearch';
import Scrolltop from '../components/Scrolltop';
import Footer from '../components/Footer';
import Sidebar from '../components/Sidebar';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from '../components/Navbar';
import View from '../views/View';
import LikedView from '../views/LikedView';
import SaveList from '../views/SaveList';
import PayPoint from '../views/PayPoint';
import ChargePoint from '../views/ChargePoint';
import QnA from '../views/QnA';
import RefundPointPage from '../views/RefundPoint';
import MainSearch from '../components/MainSearch';
import BuySubscribe from '../views/BuySubscribe';

const Center = styled.div`
  height: 100vh;
  display: flex;
  flex-direction: row;
  width : 100%;
  `

function Mypage(props) {
    return (

        <div class="container-xxl bg-white p-0">

            <Navbar />
            <MainSearch />
            <Center>
                        <Sidebar />

                <Routes>
                    <Route exact path="/" element={<View />} />
                    <Route path="/View" element={<View />} />
                    <Route path="/LikedView" element={<LikedView />} />
                    <Route path="/SaveList" element={<SaveList />} />
                    <Route path="/PayPoint" element={<PayPoint />} />
                    <Route path="/ChargePoint" element={<ChargePoint />} />
                    <Route path="/QnA" element={<QnA />} />
                    <Route path="/refundPoint" element={<RefundPointPage />} />
                    <Route path="/BuySubscribe" element={<BuySubscribe />} />
                </Routes>
            </Center>
            <Scrolltop />
            <Footer />

        </div>

    );
}

export default Mypage;