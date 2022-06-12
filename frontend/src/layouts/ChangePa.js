import React from 'react';
import '../views/sign.css';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import { Link } from 'react-router-dom';
function ChangePassWord() {
  return (
    <form>
      <h3>비밀번호 변경</h3>
      <div className="mb-3">
        <label>변경 할 비밀번호</label>
        <input
          type="password"
          className="form-control"
          placeholder="PassWord"
        />
      </div>
      <div className="mb-3">
        <label>비밀번호 확인</label>
        <input
          type="password"
          className="form-control"
          placeholder="PassWord Check"
        />
      </div>
      <div class="row">
        <div class="col-xl"></div>
        <div class="col-xl">
          <Link to="/zipcook/member/Login">
            <button type="submit" className="btn btn-primary">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;확인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
  );
}

export default ChangePassWord;