import React, { useState, useEffect }  from "react";
import "../assets/css/style.css";
import Table from "../components/Table";
import axios from "axios";


function PayPointPage() {
  const reqUrl = 'http://localhost:4000/posts'

  const [users, setUsers] = useState([
      { id: '', name: '', point: '', date: '' }
  ])
  
  useEffect(() => {
      axios
          .get(reqUrl)
          .then((res) => {setUsers(res.data)
              console.log(res.data)}
          );
          
  },[])

  return(
    <Table users={users}/>
  );
}

export default PayPointPage;
