import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom'
import axios from 'axios';

function Subscribe() {



    return (
        <>
            <div className="App">
                <h1>구독권 구매</h1>
                <div className="auth-wrapper" style={{display:"-webkit-inline-box"}}>
                    <div className="auth-inner" style={{ width: '300px', height: '500px', boxShadow: ' 0px 14px 80px rgb(34 35 58 / 5%' }}>
                        <form>
                            <h3>1개월 구독</h3>
                            <div className="mb-3">
                                <label>Id</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="Enter Id"

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
                            <div className="mb-3">
                                <div className="custom-control custom-checkbox">
                                    <input
                                        type="checkbox"
                                        className="custom-control-input"
                                        id="customCheck1"
                                    />
                                    <label className="custom-control-label" htmlFor="customCheck1">
                                        Remember me
                                    </label>
                                </div>
                            </div>
                            <div className="d-grid">
                                <button type="button" className="btn btn-primary" >
                                    Login
                                </button>
                            </div>
                        </form>
                    </div>
                    <div className="auth-inner" style={{ width: '300px', height: '500px', boxShadow: ' 0px 14px 80px rgb(34 35 58 / 5%' }}>
                        <form>
                            <h3>3개월 구독</h3>
                            <div className="mb-3">
                                <label>Id</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="Enter Id"

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
                            <div className="mb-3">
                                <div className="custom-control custom-checkbox">
                                    <input
                                        type="checkbox"
                                        className="custom-control-input"
                                        id="customCheck1"
                                    />
                                    <label className="custom-control-label" htmlFor="customCheck1">
                                        Remember me
                                    </label>
                                </div>
                            </div>
                            <div className="d-grid">
                                <button type="button" className="btn btn-primary" >
                                    Login
                                </button>
                            </div>
                        </form>
                    </div>
                    <div className="auth-inner" style={{ width: '300px', height: '500px', boxShadow: ' 0px 14px 80px rgb(34 35 58 / 5%' }}>
                        <form>
                            <h3>6개월 구독</h3>
                            <div className="mb-3">
                                <label>Id</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="Enter Id"

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
                            <div className="mb-3">
                                <div className="custom-control custom-checkbox">
                                    <input
                                        type="checkbox"
                                        className="custom-control-input"
                                        id="customCheck1"
                                    />
                                    <label className="custom-control-label" htmlFor="customCheck1">
                                        Remember me
                                    </label>
                                </div>
                            </div>
                            <div className="d-grid">
                                <button type="button" className="btn btn-primary" >
                                    Login
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </>
    );
}

export default Subscribe;