import axios from "axios";
import { useEffect } from 'react';

function App() {
  const callApi = async()=>{
    axios.get("/api/data").then((res)=>{console.log(res.data.test);});
  };

  useEffect(()=>{
    callApi();
  }, []);
  
  return (
    <div className="App">
	...
    </div>
  );
}

export default App;