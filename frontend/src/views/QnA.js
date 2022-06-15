import React, { useState, useEffect }  from "react";
import Table from "../components/TableQna";
import axios from "axios";


function QnAPage() {
  const [qna, setQna] = useState([
      { id: '', name: '', title: '', date: '' }
  ])
  const reqUrl = 'http://localhost:8443/Point/getChargeList?userId='
  
    useEffect(() => {
      axios
          .get(reqUrl + sessionStorage.getItem("User_Id"))
          .then((res) => {setQna(res.data)
              console.log("포인트",res.data)}
          );
          
  },[])
  return (
       <Table qna={qna}/>
  );
}

export default QnAPage;