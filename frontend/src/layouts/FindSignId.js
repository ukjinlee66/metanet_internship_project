import React, { Component, useState } from 'react'
import { Link } from 'react-router-dom'
export default class Signin extends Component {

  render() {
    return (
      <form>
        <h3>아이디 찾기</h3>
        <div className="mb-3">
          <label>이름</label>
          <input
            type="name"
            className="form-control"
            placeholder="Enter name"
          />
        </div>
        <div className="mb-3">
          <label>이메일</label>
          <input
            type="email"
            className="form-control"
            placeholder="Enter email"
          />
        </div>
        <div className="mb-3">
            <label>연락처</label>
            <input
                type="tel"
                className="form-control"
                placeholder="Enter phone number"
            />
        </div>
        <div class="row">
            <div class="col-xl"></div>
            <div class="col-xl">
            <Link to="/zipcook/member/Login">
                <button type="submit" className="btn btn-primary">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;찾기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </button>
               </Link> 
            </div>
            
            <div class="col-xl">
            <Link to="/zipcook/member/Login">
                <button type="submit" className="btn btn-primary">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;취소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </button>
                </Link>
            </div>
        </div>
        
      </form>
    )
  }
}