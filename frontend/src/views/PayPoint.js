import React, { useState, useEffect }  from "react";
import "../assets/css/style.css";
import Table from "../components/Table";
import axios from "axios";


function PayPointPage() {
  const reqUrl = 'http://localhost:8443/Point/getChargeList?userId='

  const [users, setUsers] = useState([
      { chargeNumber : '',usersNumber :'', chargeKind: '', chargePoint: '', chargeDate: '' }
  ])
  
    useEffect(() => {
      axios
          .get(reqUrl + sessionStorage.getItem("User_Id"))
          .then((res) => {setUsers(res.data)
              console.log("포인트",res.data)}
          );
          
  },[])

  return(
    <Table users={users}/>
  );
}

export default PayPointPage;
