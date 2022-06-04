import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';

function Footer(props) {
    return (
        <div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
            <div class="container py-5">
                <div class="row g-5">
                    <div class="col-lg-2">
                        <h5 class="text-white mb-4">Youkjin Lee</h5>
                        <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>Incheon</p>
                        <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>010-7208-0753</p>
                        <p class="mb-2"><i class="fa fa-envelope me-3"></i>ukjinlee66@naver.com</p>
                        <a class="btn btn-outline-light btn-social" href="https://github.com/ukjinlee66"><i class="fab fa-github"></i></a>
                    </div>
                    <div class="col-lg-2">
                        <h5 class="text-white mb-4">Juwoong Kim</h5>
                        <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>Seoul</p>
                        <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>010-4578-2534</p>
                        <p class="mb-2"><i class="fa fa-envelope me-3"></i>wwong7247@gmail.com</p>
                        <a class="btn btn-outline-light btn-social" href="https://github.com/JuwoongKim"><i class="fab fa-github"></i></a>
                    </div>
                    <div class="col-lg-2">
                        <h5 class="text-white mb-4">SeongJae Bu</h5>
                        <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>Seoul</p>
                        <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>010-2510-6859</p>
                        <p class="mb-2"><i class="fa fa-envelope me-3"></i>qntjdwp35@gmail.com</p>
                        <a class="btn btn-outline-light btn-social" href="https://github.com/BuSeongJae"><i class="fab fa-github"></i></a>
                    </div>
                    <div class="col-lg-2">
                        <h5 class="text-white mb-4">Daeun Koo</h5>
                        <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>Seoul</p>
                        <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>010-9638-0960</p>
                        <p class="mb-2"><i class="fa fa-envelope me-3"></i>kxxdaeun@gmail.com</p>
                        <a class="btn btn-outline-light btn-social" href="https://github.com/koodaeun"><i class="fab fa-github"></i></a>
                    </div>
                    <div className="col-lg-2">
                        <h5 className="text-white mb-4">Hyojae Jung</h5>
                        <p className="mb-2"><i className="fa fa-map-marker-alt me-3"></i>Seoul</p>
                        <p className="mb-2"><i className="fa fa-phone-alt me-3"></i>010-4173-1348</p>
                        <p className="mb-2"><i className="fa fa-envelope me-3"></i>jhj774@naver.com</p>
                        <a className="btn btn-outline-light btn-social" href="https://github.com/JHJaVa1"><i
                            className="fab fa-github"></i></a>
                    </div>
                    <div class="col-lg-4">
                        <h5 class="text-white mb-4">Education Center</h5>
                        <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>9층, 70 가산디지털1로 금천구 서울특별시</p>
                        <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>02-6278-9352</p>

                    </div>
                </div>
            </div>
            <div class="container">
                <div class="copyright">
                    <div class="row">
                        <div class="col-md-8 text-center text-md-start">
                            &copy; ilda, All Right Reserved. 
							Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>,
                            Distributed By <a class="border-bottom" href="https://themewagon.com" target="_blank">ThemeWagon</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Footer;