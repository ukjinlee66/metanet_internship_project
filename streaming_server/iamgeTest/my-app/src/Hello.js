import React, { useEffect, useState } from 'react';
import {ReactReader} from 'react-reader';
import ReactHlsPlayer from 'react-hls-player'
import axios from 'axios';

function Hello() {

    const BASEURL = "http://localhost:8443/Account/test1"
  
    const [data, setData] = useState('처음값');
    const [data2, setData2] = useState('처음값');


    const [inputId, setInputId] = useState('');
    const [inputPw, setInputPw] = useState('');


    const [imgUrl, setImgUrl] = useState(new Blob());



    const handleInputId = (e) => {
        setInputId(e.target.value)
        }

    const handleInputPw = (e) => {
        setInputPw(e.target.value)
        }

    //axios get 요청 
    const onEventHandle1 = () => {  // 중괄호는 본문 여러 줄로 구성되어 있음을 알려줍니다.

        console.log("이벤트 시작 ");
        axios.get( BASEURL)
        .then(res => { 
            
            console.log(res.data);
            setData(res.data);
        })
        .catch(()=>console.log("실패"));


    }        

    //axios get 쿼리스트링 요청 
    const onEventHandle2 = () => {  // 중괄호는 본문 여러 줄로 구성되어 있음을 알려줍니다.


        console.log("이벤트 시작 ");
        axios.get(
               'http://localhost:8443/Account/getAccount',    
               { params: { userId: 'wwong7247' } }
            )
        .then(res => { 
            console.log(res);
            console.log(res.data);
            //setData2(res.data);
        })
        .catch(()=>console.log("실패"));
    }      


    //axios post 요청 
    const onClickLogin = () => {
        axios.post('http://localhost:8443/Account/login', null,{
              
          params: {
            userId: inputId,
            userPassword: inputPw
          }
        })
          .then(function (response) {
            if (response.data) {
              alert("로그인 성공")    
            }
            else{ 
              alert("로그인 실패")
              console.log(response)}
          })
          .catch(function (error) {
            console.log(error);
            alert("오류")
          })
    }




   //axios get 쿼리스트링 요청 - bytearray 받기  
   const onEventHandle3 = async () => {  // 중괄호는 본문 여러 줄로 구성되어 있음을 알려줍니다.

        axios({

            url: 'http://localhost:8443/Streaming/getImageByte' ,

            method: 'get',

            responseType: 'blob',

            params: { videoNumber: 552 } 
        })
        .then(res => { 

    //    const base64String = btoa(String.fromCharCode(...new Uint8Array(res)));  
        
            console.log(res);
            console.log(res.data);

        setImgUrl(res.data);
        })
        .catch(()=>console.log("실패"));


}     





    
    // // console.log("reader : ",ReactReader.readAsArrayBuffer(res.data));
    // console.log(imgUrl);
    // // console.log(window.URL.createObjectURL(imgUrl));
    return (
        <div>
            <h1>{data}</h1>
            <h1>{data2}</h1>
            
            <div className="mb-3">
                <label>Id</label>
                <input
                type="text"
                className="form-control"
                placeholder="Enter Id"
                value={inputId}
                onChange={handleInputId}
                />
            </div>

            <div className="mb-3">
                <label>Password</label>
                <input
                type="password"
                className="form-control"
                placeholder="Enter password"
                value={inputPw}
                onChange={handleInputPw}
                />
            </div>

            <button type="button" className="btn btn-primary"  onClick={onClickLogin}>
                Login
            </button>



            <button onClick={ onEventHandle1 }>Get클릭</button>
            <button onClick={ onEventHandle2 }>get쿼리클릭</button>
            <button onClick={ onEventHandle3 }>이미지 바이트 어레이</button>
            <img src={window.URL.createObjectURL(imgUrl)} alt="W3Schools.com" width="104" height="142"/>
            
         
        </div>
      );


}

export default Hello;