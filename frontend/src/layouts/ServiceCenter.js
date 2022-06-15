import React, { useState, useEffect }  from "react";
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import Table from "../components/MainTableQna";
import axios from "axios";
import Navbar from '../components/Navbar';


function btClick(e) {
    window.location.href = "/zipcook/QnaWriteForm";
}
function ServiceCenter(props) {
        
        const reqUrl = 'http://localhost:4000/qna'

        const [qna, setQna] = useState([
            { id: '1', name: '환불', title: '환불이 안돼요', date: '2022/02/02' }
        ])
        
        useEffect(() => {
            axios
                .get(reqUrl)
                .then((res) => {setQna(res.data)
                    console.log(res.data)}
                );
                
        },[])
        
        return (
            <div>
            <Navbar></Navbar>
                <div class="container-xxl bg-white p-0">
                    <div>
                        <h1>고객센터</h1>
                    </div>
                    <div>
                        <Table qna={qna}/>
                    </div>
                    <div>
                        <button onClick={btClick}>문의글 작성</button>
                    </div>
                </div>
            </div>
        );

}

export default ServiceCenter;