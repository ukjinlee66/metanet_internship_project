import React from 'react';
import './sign.css';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import Signup from '../layouts/Signup';
import Navbar from '../components/Navbar';
function Signup1() 
{
  return (
    <div className="App">
      <Navbar />
      <div className="auth-wrapper">
        <div className="auth-inner">
          <Signup />
        </div>
      </div>
    </div>
  );
}

export default Signup1;