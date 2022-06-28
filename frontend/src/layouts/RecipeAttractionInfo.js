import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import Scrolltop from '../components/Scrolltop';
import Footer from '../components/Footer';
import Recipeinfoitem from '../components/Recipeinfoitem';
import Videoitem from './Recipeitem';
import Navbar from '../components/Navbar';

const RecipeAttractionInfo=(props)=> 
{
    return (
        <div>
            <Navbar />
                <div class="container-xxl py-5 wow fadeInUp pdCon" data-wow-delay="0.1s">
                    <hr className='info-hr'/>
                    <div class="row g-5 maCon" style={{width:'100%', minHeight:'1100px'}}>
                        <div class="col-lg-9">
                            <Recipeinfoitem/>
                        </div>
                        <Videoitem/>
                    </div>
                </div>
            <Scrolltop />
            <Footer />
        </div>
    );
}

export default RecipeAttractionInfo;