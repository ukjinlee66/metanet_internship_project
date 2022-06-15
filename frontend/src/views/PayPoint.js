import React, { useState, useEffect} from "react";
import "../assets/css/style.css";
import Table from "../components/Table";
import axios from "axios";


function PayPointPage() {
  const reqUrl = 'http://localhost:8443/Point/getChargeList?userId='

  const [users, setUsers] = useState([
    { chargeNumber: '', usersNumber: '', chargeKind: '', chargePoint: '', chargeDate: '' }
  ])

  useEffect(() => {
    axios
      .get(reqUrl + sessionStorage.getItem("User_Id"))
      .then((res) => {
        setUsers(res.data)
        console.log("포인트", res.data)
      }
      );

  }, [])

  return (
    <div style={{width:"100vh"}}>
      <div >
      <button name='searchToTime' className="btn btn-primary" value="Time">충전 내역</button> &nbsp;&nbsp;
      <button name='searchToView' className="btn btn-primary" value="View">사용 내역</button> &nbsp;&nbsp;
      <button name='searchToLike' className="btn btn-primary" value="Like">환불 내역</button> &nbsp;&nbsp;
      </div>

      <Table users={users} />
       </div>
  );
}

export default PayPointPage;
