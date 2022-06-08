import React, { useState } from 'react'
import axios from 'axios';


const SignUp = () => {
  
  {
    return (
      <form
        >
        <h3>Sign Up</h3>
        <div className="mb-3">
          <label>Name</label>
          <input
            type="text"
            className="form-control"
            name='User_Name'
            placeholder="Enter name"
            
          />
        </div>
        <div className="mb-3">
          <label>Id</label>
          <input type="text"
            className="form-control"
            name='User_Id'
            placeholder="Enter ID"
     />
        </div>
        <div className="mb-3">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            name='User_Password'
            placeholder="Enter Password"
   
          />
        </div>
        <div className="mb-3">
          <label>Phone</label>
          <input
            type="text"
            className="form-control"
            name='User_Phone_Number'
            placeholder="Enter Phone"
  
          />
        </div>
        <div className="mb-3">
          <label>Email</label>
          <input
            type="email"
            className="form-control"
            name='User_Email'
            placeholder="Enter Email"

          />
        </div>
        <div className="mb-3">
          <label>Addr</label>
          <input
            type="text"
            className="form-control"
            name='User_Addr'
            placeholder="Enter Address"

          />
        </div>

        <div className="mb-3">
          <label>RecKind</label>
          <br />
          <input type="radio" name="User_RecKind" value="1" />한식
          <input type="radio" name="User_RecKind" value="2" />중식
          <input type="radio" name="User_RecKind" value="3" />양식
          <input type="radio" name="User_RecKind" value="4" />일식
        </div>

        <div className="mb-3">
          <input
            type="hidden"
            className="form-control"
            name='User_Point'
            value={0}
          />
        </div>
        <div className="d-grid">
          <button type="submit" className="btn btn-primary">
            Sign Up
          </button>
        </div>
        <p className="forgot-password text-right">
          Already registered <a href="/zipcook/Login">sign in?</a>
        </p>
      </form>
    )
  }
}
export default SignUp;