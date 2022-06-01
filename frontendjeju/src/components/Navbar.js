import React, { Fragment, useEffect, useState, useRef } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import logo from '../assets/img/logo2.png';
import { Navbar, Nav, Form, FormControl, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

function Navbar1(props) {

    const [ScrollY, setScrollY] = useState(0); // window 의 pageYOffset값을 저장 

    // useRef를 통해 css 변경
    const stickyChange = useRef(null);

    // 스크롤의 Y축을 감시하여 특정 지점 이동 시 Navbar가 화면 일정 지점에 따라가도록 설정
    function handleScroll() {
        setScrollY(window.pageYOffset);
        if (ScrollY > 300) {
            stickyChange.current.style.top = '0px';
        } else {
            stickyChange.current.style.top = '-100px';
        }
    }

    useEffect(() => {
        function scrollListener() { window.addEventListener("scroll", handleScroll); } //  window 에서 스크롤을 감시 시작
        scrollListener(); // window 에서 스크롤을 감시
        return () => { window.removeEventListener("scroll", handleScroll); }; //  window 에서 스크롤을 감시를 종료
    });

    return (
        <Fragment>
            {/* <nav className="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0" ref={stickyChange}> */}
            <Navbar bg="light" variant="light">
                <Navbar.Brand href="/jeju"><img class="logo" src={logo} /></Navbar.Brand>
                <div class="nav justify-content-end bg-light">
                    <Nav className="mr-auto">
                        <Nav.Link href="#features">아무거나</Nav.Link>
                        <Nav.Link href="#pricing">국제화</Nav.Link>
                        <Nav.Link href="/jeju/Mypage">마이 페이지</Nav.Link>
                    </Nav>
                        <button type="button" className="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                            <span className="navbar-toggler-icon"></span>
                        </button>

                        <div className="collapse navbar-collapse" id="navbarCollapse">
                            <div className="navbar-nav ms-auto p-4 p-lg-0">
                                {/* <a href="/jeju/Maps" className="nav-item nav-link">Map</a>
                        <a href="/jeju/TouristAttractionList?search=" className="nav-item nav-link">List</a>
                        <a href="/jeju/TouristAttractionInfo" className="nav-item nav-link">Info</a> */}
                            </div>
                            {/* <a href="/jeju" className="btn btn-primary bg-jeju-nav rounded-0 py-4 px-lg-5 d-none d-lg-block">Home<i class="fa fa-arrow-right ms-3"></i></a> */}
                        </div>
                    
                </div>

            </Navbar>
            {/* </nav> */}



        </Fragment >
    );
}

export default Navbar1;