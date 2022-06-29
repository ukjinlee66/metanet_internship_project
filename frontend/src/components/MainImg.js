import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import OwlCarousel from 'react-owl-carousel'; 
import 'owl.carousel/dist/assets/owl.carousel.css';  
import 'owl.carousel/dist/assets/owl.theme.default.css'; 
import mainImg1 from '../assets/img/main2jpg.jpg'
import mainImg2 from '../assets/img/motchamzi.png'
import '../assets/css/owl.css';  

// OwlCarousel(슬라이더) 옵션 설정
const options = {
    autoplay: true,
    smartSpeed: 1500,
    items: 1,
    dots: false,
    loop: true,
    nav : false,
    navText : [
        '<i class="bi bi-chevron-left"></i>',
        '<i class="bi bi-chevron-right"></i>'
    ]
};

function MainImg(props) {
    return (
        <div className="container-fluid p-0">
            <OwlCarousel className="header-carousel" {...options}>
                <div className="owl-carousel-item position-relative">
                    <img className="img-fluid" src={mainImg1} />
                </div>
                <div className="owl-carousel-item position-relative">
                     <img className="img-fluid" src={mainImg2} />

                </div>
            </OwlCarousel>
        </div>     
    );
}
export default MainImg;