import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import OwlCarousel from 'react-owl-carousel'; 
import 'owl.carousel/dist/assets/owl.carousel.css';  
import 'owl.carousel/dist/assets/owl.theme.default.css'; 


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
                    <img className="img-fluid" src="https://post-phinf.pstatic.net/MjAxODEyMThfMTcx/MDAxNTQ1MTE5OTc4Njg0.e0xskMHMFbYFsGjkH_4lFRjPxoPITOFFRKB_AUQF43kg.kRpk68pT3qBCDqelh5zPoHFyQIldwVJvvpDlmnJZT-og.JPEG/%EC%A0%9C%EC%A3%BC%EB%8F%84%EA%B0%80%EB%B3%BC%EB%A7%8C%ED%95%9C%EA%B3%B3_%281%29.jpg?type=w1200
" alt=""/>
                </div>
                <div className="owl-carousel-item position-relative">
                    <img className="img-fluid" src="https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/1jPF/image/6dTBQAAJW6QLbLUaneCZWL3Vhf4.jpg
" alt=""/>
                </div>
            </OwlCarousel>
        </div>     
    );
}
export default MainImg;