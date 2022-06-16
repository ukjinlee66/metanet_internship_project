import React, { useState, useEffect }  from "react";
import Table from "../components/TableQna";
import axios from "axios";


function QnAPage() {
  const [qna, setQna] = useState([
      { reportTableNumber: '', reportName: '', reportKind: '', reportDetail: '',reportReply:'',crDa:'' }
  ])
  const reqUrl = 'http://localhost:8443/Report/MyReportList'

    useEffect(() => {
      axios
          .get(reqUrl,{
            params:{
              userNumber : sessionStorage.getItem("User_Number")
            }
          })
          .then((res) => {
              setQna(res.data)
              console.log("qna",res.data)}
          );
          
  },[])
  return (
       <Table qna={qna}/>
  );
}

export default QnAPage;