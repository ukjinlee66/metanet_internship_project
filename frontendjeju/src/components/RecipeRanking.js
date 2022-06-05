import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";

function RecipeRanking(props) {
    const [recipeClick, setRecipeClick] = useState("")

    // 레시피 클릭 시 이동
    function btClick(e) {
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/jeju/RecipeAttractionList?search=" + e.target.value;
    }



    return (
            <div class="container">
                    <div class="col-md-10">
                            실시간랭킹:    
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="돼지고기김치찜">1. 돼지고기김치찜</button>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="돼지고기김치찜">2. 간장계란밥</button>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="돼지고기김치찜">3. 김치라면</button>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="돼지고기김치찜">4. 참치라면</button>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="돼지고기김치찜">5. 쫄면</button>
                            
                    </div>
            </div>
    );
}

export default RecipeRanking;