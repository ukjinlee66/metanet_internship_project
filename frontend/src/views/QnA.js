import React, { useState, useEffect }  from "react";
import Table from "../components/TableQna";
import axios from "axios";


function QnAPage() {
  const reqUrl = 'http://localhost:4000/qna'

  const [qna, setQna] = useState([
      { id: '', name: '', title: '', date: '' }
  ])
  
  useEffect(() => {
      axios
          .get(reqUrl)
          .then((res) => {setQna(res.data)
              console.log(res.data)}
          );
          
  },[])
  
  return (
       <Table qna={qna}/>
  );
}

export default QnAPage;