import React, { useState, useEffect } from 'react';
import Scrolltop from '../components/Scrolltop';
import axios from 'axios';
import ViewList from '../components/ViewList';

const View = (props) => {
    const [data, setData] = useState(null);

    const reqUrl = 'http://localhost:8443/MyPage/getLikes?userId='
    useEffect(() => {
        axios
            .get(reqUrl + sessionStorage.getItem("User_Id"))
            .then((res) => {setData(res.data)
                console.log("시청영상",res.data)}
            );
            
    },[])
    return (
        <div className="auth-wrapper">
       
            <div class="container-xxl py-5 pdCon" style={{paddingLeft:"50px",backgroundColor:'#ffffff'}} data-wow-delay="0.1s">
                <div class="row g-5 maCon" style={{width:'100vh',height:'100vh',backgroundColor:'#ffffff'}}>
                    <div class="col-lg-5" style={{width:'100%'}}>
                        <ViewList data={data}/>
                    </div>
                    
                </div>
            </div>
            <Scrolltop />
      
        </div>
    );
};

export default View;