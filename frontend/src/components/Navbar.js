import React, { Fragment, useEffect, useState, useRef } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import logo from '../assets/img/logo.png';
import { Avatar } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import axios from 'axios';

function Navbar(props) {
    const [ScrollY, setScrollY] = useState(0); // window 의 pageYOffset값을 저장 

    // useRef를 통해 css 변경
    const stickyChange = useRef(null);
    function btClick(e) {
        if(e.target.value === "MyPage"){
            sessionStorage.setItem("pageSession", 1);
            window.location.href = "/zipcook/" + e.target.value;
        }else if(e.target.value === "BuySubscribe"){
            sessionStorage.setItem("pageSession", 1);
            window.location.href = "/zipcook/" + e.target.value;
        }else if(e.target.value === "PostMain"){
            window.location.href = "/zipcook/" + e.target.value;
        }else if(e.target.value === "RefundPage"){
            window.location.href = "/zipcook/" + e.target.value;
        }
        else{
            sessionStorage.setItem("pageSession", 1);
            window.location.href = "/zipcook/member/" + e.target.value;
        }
    }
    function AvClick(e){
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/zipcook/MyPage";
    }
    function logOut(e) {
        sessionStorage.removeItem("User_Id")
        sessionStorage.removeItem("User_Number")
        sessionStorage.removeItem("User_Kind")
        window.location.href = "/zipcook"
    }
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

    const [isLogin, setIsLogin] = useState(false)
    useEffect(() => {
        if (sessionStorage.getItem('User_Id') === null) {
        } else {
            setIsLogin(true)

        }
    })
    const BASEURL = "http://localhost:8443/Account"
    const [point, setPoint] = useState(0)
    useEffect(()=>{
        axios
      .get(BASEURL + "/getAccount", {
        params: {
          userId: sessionStorage.getItem("User_Id")
        }
      })
      .then((res) => {
        setPoint(res.data.userPoint)

      })
    },[])

    return (
        <Fragment>

            <nav className="navbar bg-white navbar-light shadow sticky-top p-0" ref={stickyChange}>

                <a href="/zipcook" className="navbar-brand d-flex align-items-center text-center py-0 px-4 px-lg-5">
                    <img class="logo" src={logo} />
                </a>
                {isLogin === false ? (
                    <div class="justify-content-md-end">
                        <button class="btn btn-white border-0 w-15 m-3" onClick={btClick} value="Login">로그인</button>
                        <button class="btn btn-white border-0 w-15 m-3" onClick={btClick} value="Signup">회원가입</button>

                    </div>
                ) : ((sessionStorage.getItem("User_Kind") == 1 ?(
                    <div class="justify-content-md-end">
                    <button class="btn btn-white border-0 w-15 m-3" onClick={btClick} value="PostMain">고객센터</button>
                    <button class="btn btn-white border-0 w-15 m-3" onClick={btClick} value="RefundPage">환불 페이지</button>
                    <button class="btn btn-white border-0 w-20 m-3" onClick={logOut} value="Logout">로그아웃</button>
                    </div>
                ) : (
                    <div class="justify-content-md-end">
                    {/* <p style={{fontSize:'12px'}}>구독 마감 날짜 : {buy}</p> */}
                    <p style={{fontSize:'12px'}}>포인트 : {point}</p>
                    <button class="btn btn-white border-0 w-20 m-3" onClick={btClick} value="BuySubscribe">구독권 구입</button>
                    <button class="btn btn-white border-0 w-20 m-3" onClick={logOut} value="Logout">로그아웃</button>
                    <button class="btn btn-white border-0 w-20 m-3" onClick={btClick} value="EditSign">회원정보</button>
                    <Avatar onClick={AvClick} shape="square" size={64} icon={<UserOutlined />}/>
                    {/* <button class="btn btn-white border-0 w-20 m-3" onClick={btClick} value="MyPage">마이페이지</button> */}
                    </div>
                ))

                )
}


                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <div className="navbar-nav ms-auto p-4 p-lg-0">
                        {/* <a href="/zipcook/Maps" className="nav-item nav-link">Map</a>
                        <a href="/zipcook/TouristAttractionList?search=" className="nav-item nav-link">List</a>
                        <a href="/zipcook/TouristAttractionInfo" className="nav-item nav-link">Info</a> */}

                        {/* <a href="/zipcook" className="btn btn-primary bg-zipcook-nav rounded-0 py-4 px-lg-5 d-none d-lg-block">Home<i class="fa fa-arrow-right ms-3"></i></a> */}
                    </div>
                </div>

            </nav>


        </Fragment>
    );
}

export default Navbar;