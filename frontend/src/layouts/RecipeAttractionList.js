import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import Scrolltop from '../components/Scrolltop';
import Footer from '../components/Footer';
import Recipelistitem from '../components/Recipelistitem';
import Map from '../components/Map';
import ChatButton from '../components/ChatButton';
import Navbar from '../components/Navbar';
import MainSearch from '../components/MainSearch';


function RecipeAttractionList(props) {
    return (
        <div class="container-xxl bg-white p-0">
            <Navbar/>
            <MainSearch />
            <div class="container-xxl py-6 wow fadeInUp pdCon" data-wow-delay="0.1s">
                <div class="row g-5 maCon" style={{width:'100%'}}>
                    <div class="col-lg-10">
                        <Recipelistitem/>
                    </div>
                    <Map/>
                </div>
            </div>
            <Scrolltop />
            <Footer />
        </div>
    );
}

export default RecipeAttractionList;