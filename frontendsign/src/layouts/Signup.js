import React, { Component } from 'react'
import {Link} from 'react-router-dom';
import './sign.css'
export default class SignUp extends Component {
  render() {
    return (
      <div className="SIGN">
        <nav className="navbar navbar-expand-lg navbar-light fixed-top">
            <div className="container">
                <Link className="navbar-brand" to={'/jeju/Signin'}>
                    positronX
                </Link>
                <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                        <Link className="nav-link" to={'/jeju/Signin'}>
                        Login
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to={'/jeju/Signup'}>
                        Sign up
                        </Link>
                    </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div className="auth-wrapper">
            <div className="auth-inner">
                
      <form>
        <h3>Sign Up</h3>
        <div className="mb-3">
          <label>First name</label>
          <input
            type="text"
            className="form-control"
            placeholder="First name"
          />
        </div>
        <div className="mb-3">
          <label>Last name</label>
          <input type="text" className="form-control" placeholder="Last name" />
        </div>
        <div className="mb-3">
          <label>Email address</label>
          <input
            type="email"
            className="form-control"
            placeholder="Enter email"
          />
        </div>
        <div className="mb-3">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            placeholder="Enter password"
          />
        </div>
        <div className="d-grid">
          <button type="submit" className="btn btn-primary">
            Sign Up
          </button>
        </div>
        <p className="forgot-password text-right">
          Already registered <a href="/sign-in">sign in?</a>
        </p>
      </form>
            </div>
        </div>
    </div>
    )
  }
}