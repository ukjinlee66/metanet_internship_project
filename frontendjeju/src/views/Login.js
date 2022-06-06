import React, { useEffect } from 'react';
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import './views/sign.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import Signin from './views/Signin';
import Signup from './views/Signup';
function Login() 
{
  return (
    
      <div className="App">

        <div className="auth-wrapper">
          <div className="auth-inner">
            <Routes>
              <Route exact path="/zipcook/Signin" element={<Signin />} />
              <Route path="/zipcook/Signin" element={<Signin />} />
              <Route path="/zipcook/Signup" element={<Signup />} />
            </Routes>
          </div>
        </div>
      </div>
    
  );
}

export default Login;
