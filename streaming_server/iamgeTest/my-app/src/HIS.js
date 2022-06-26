import React, { useEffect, useState } from 'react';
import {ReactReader} from 'react-reader';
import ReactHlsPlayer from 'react-hls-player'
import axios from 'axios';


function HIS() {


    const [ videoName, setVideoName] = useState('');
    const [data2, setData2] = useState('');

    const getVideoFileName = () =>{

        axios.get(
            'http://localhost:8443/MainPage/getDetail',    
            { params: { videoNumber : 552 } }
         )
     .then(res => { 
         console.log(res);
         console.log(res.data.videoName); 
         let url = 'http://localhost:8443/Streaming/hls/' + res.data.videoName + '/' + res.data.videoName + '.m3u8';
         setVideoName(url);
     })
     .catch(()=>console.log("실패"));
 }      



    return (

        <div>

            <h1> {videoName} </h1>
            <button onClick={ getVideoFileName  }> 비디오 이름 클릭</button>
            
            
            <ReactHlsPlayer
            src={videoName}
            
            autoPlay={false}
            controls={true}
            width="100%"
            height="auto"
            />

            
        </div>

    );

}




export default HIS;