import React, { useEffect, useState } from 'react';
import {ReactReader} from 'react-reader';
import ReactHlsPlayer from 'react-hls-player'
import axios from 'axios';


function Mono() {


    const [ videoName, setVideoName] = useState('초기값');
    const [data2, setData2] = useState('초기값');

    const getVideoFileName = () =>{

        axios.get(
            'http://localhost:8443/Streaming/getFileName',    
            { params: { videoNumber : 552 } }
         )
     .then(res => { 
         console.log(res);
         console.log(res.data); 
         setVideoName(res.data);
     })
     .catch(()=>console.log("실패"));
 }      



    return (

        <div>

            <h1> {videoName} </h1>
            <button onClick={ getVideoFileName  }> 비디오 이름 클릭</button>
            
            
            <ReactHlsPlayer
            //src="http://localhost:8443/Streaming/hls/시원하고든든한일식요리웰빙양배추탑냉돈까스만개의레시피/시원하고든든한일식요리웰빙양배추탑냉돈까스만개의레시피.m3u8"
            src="videos/output.m3u8"
            autoPlay={false}
            controls={true}
            width="100%"
            height="auto"
            />

            
        </div>

    );

}




export default Mono;