import React from 'react';
import './sign.css';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import { Routes, Route } from "react-router-dom";
import Signin from '../layouts/Signin';
import Navbar from '../components/Navbar';
import SignUp from '../layouts/Signup';
import PassWordFind from '../layouts/FindSignPa';
import NotFound from '../layouts/NotFound';
import ChangePassWord from '../layouts/ChangePa';
import IdFind from '../layouts/FindSignId'
import EditSign from '../layouts/EditSign';
function Member() {
  return (
    <div className="App">
      <Navbar />
      <div className="auth-wrapper">
        <div className="auth-inner">
        <Routes>
                <Route path="/Login" element={<Signin/>} />
                <Route path="/Signup" element={<SignUp/>} />
                <Route path='/FindSignPa' element={<PassWordFind/>} />
                <Route path='/ChangePa' element={<ChangePassWord/>}/>
                <Route path='/FindSignId' element={<IdFind/>}/>
                <Route path='/EditSign' element={<EditSign/>}/>
                <Route path='*' element={<NotFound/>}/>
        </Routes>
        
        </div>
      </div>
    </div>
  );
}

export default Member;