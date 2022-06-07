import React, { Component, useState, useEffect } from 'react';
import styled from "styled-components";
import Scrolltop from '../components/Scrolltop';
import axios from 'axios';
import ViewList from '../components/ViewList';
const Center = styled.h2`
text-align: center;
height: 100vh;
width: 100vh;
`
const SaveList = (props) => {
    const [data, setData] = useState(null);
    const onClick = async() => {
        try{
            const response = await axios.get('http://localhost:4000/posts');  
            setData(response.data);  
            console.log(response.data)
          }catch(e){
            console.log(e);
          }
    }
    return (
        <>
        {/* <div>
            <div>
                <button onClick={onClick}>불러오기</button>
            </div>
            {data && <textarea rows={7} value={JSON.stringify(data, null, 2)} readOnly={true} />}
        </div> */}
       
            <div class="container-xxl py-5 wow fadeInUp pdCon2" data-wow-delay="0.1s">
                <div class="row g-5 maCon2" style={{width:'100vh',height:'100vh'}}>
                    <div class="col-lg-5" style={{width:'100%'}}>
                        <ViewList/>
                    </div>
                </div>
            </div>
            <Scrolltop />
      
        </>
    );
};

export default SaveList;