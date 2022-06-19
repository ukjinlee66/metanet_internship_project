import React, { useState, useEffect } from "react";
import "../assets/css/style.css";
import Table from "../components/Table";
import axios from "axios";


const PayPointPage = () => {
  const reqUrl = 'http://localhost:8443/Point/'
  const [users, setUsers] = useState([
    { number: '', usersNumber: '', kind: '', point: '', date: '' }
  ])

  const BtClick = (e) => {
    sessionStorage.setItem("searchType", e.target.value)
    getItem();
  }

  const getItem = async () => {

    await axios
        .get(reqUrl + sessionStorage.getItem("searchType"), {
            params: {
              userId: sessionStorage.getItem("User_Id")
            }
        })
        .then((res) =>{
          setUsers(res.data)
        });  
  }
  // useEffect(() => {
  //   axios
  //     .get(reqUrl + "getChargeList"),{
  //       params:{
  //         userId: sessionStorage.getItem("User_Id")
  //       }
  //     }
  //     .then((res) => {
  //       setUsers(res.data)
  //     }
  //     );

  // },[])
  return (
    <div style={{ width: "100vh" }}>
      <div >
        <button name='searchToCharge' className="btn btn-primary" onClick={BtClick} value="getChargeList">충전 내역</button> &nbsp;&nbsp;
        <button name='searchToBuy' className="btn btn-primary" onClick={BtClick} value="getBuyList">사용 내역</button> &nbsp;&nbsp;
        <button name='searchToRefund' className="btn btn-primary" onClick={BtClick} value="getRefundList">환불 내역</button> &nbsp;&nbsp;
      </div>
      <Table users={users} />
    </div>
  );
}

export default PayPointPage;
