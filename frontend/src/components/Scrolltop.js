import React, { Fragment } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';

// 스크롤을 맨 위로 올려주는 버튼
function Scrolltop(props) {
    return (
        <Fragment>
             <a href="#" className="btn btn-lg btn-primary bg-zipcook-nav btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
        </Fragment>
    );
}

export default Scrolltop;