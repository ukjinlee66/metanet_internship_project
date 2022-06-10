import React from 'react';
import './sign.css';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import Signin from '../layouts/Signin';
import Navbar from '../components/Navbar';
function Login() {
  return (
    <div className="App">
      <Navbar />
      <div className="auth-wrapper">
        <div className="auth-inner">
          <Signin />
        </div>
      </div>
    </div>
  );
}

export default Login;