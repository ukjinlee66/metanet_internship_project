import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import RecipeRanking from '../components/RecipeRanking';
import CategorySelect from '../components/CategorySelect';

function MainSearch(props) {
    const [searchInput, setSearchInput] = useState("")

    // 검색 버튼 클릭 시 이동
    function btClick(e) {
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/jeju/RecipeAttractionList?search=" + searchInput;
    }

    // 검색창에 ENTER 치는 경우에 검색 버튼 클릭으로 간주
    const onKeyPress = (e) => {
        if(e.key=='Enter'){
            btClick();
        }
    }

    return (
        <div class="container-fluid-search bg-jeju mb-5 wow fadeIn" data-wow-delay="0.1s" >
            <div class="container">
                <div class="row g-2">
                    <div class="col-md-10">
                        <div class="row g-2">
                            <div class="col-md-12">
                                <input type="text" class="form-control border-0" placeholder="관심있는 레시피를 검색하세요." onChange={(event) => setSearchInput(event.target.value)} onKeyPress={onKeyPress} value={searchInput}/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-dark border-0 w-100" onClick={btClick}>Search</button>
                    </div>
                </div>
            </div>
            <RecipeRanking/>
            <CategorySelect/>
        </div>
    );
}

export default MainSearch;