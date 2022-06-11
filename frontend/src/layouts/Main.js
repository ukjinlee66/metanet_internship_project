import React, { useState,useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import MainSearch from '../components/MainSearch';
import MainImg from '../components/MainImg';
import Scrolltop from '../components/Scrolltop';
import Footer from '../components/Footer';
import ChatButton from '../components/ChatButton';
import Navbar from '../components/Navbar';
import MainRecipeList from '../components/MainRecipeList';
import MainFaq from '../components/MainFaq';

function Main(props) {

    return (
        <div class="container-xxl bg-white p-0">
            <Navbar  />
            <MainImg />
            <MainSearch />
            <div class="container-xxl py-3 rank-con">
                <div class="row g-4">
                    <MainRecipeList />
                    <MainFaq/>
                </div>
            </div>
            {/* <TourImg /> */}
            <Scrolltop />
            <ChatButton/>
            <Footer />
        </div>
    );
}

export default Main;