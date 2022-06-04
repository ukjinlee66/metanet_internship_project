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
                            <button class="btn btn-dark border-3 w-60 m-2" onClick={btClick} value="">한식</button>
                            <button class="btn btn-dark border-3 w-60 m-2" onClick={btClick} value="">중식</button>
                            <button class="btn btn-dark border-3 w-60 m-2" onClick={btClick} value="">양식</button>
                            <button class="btn btn-dark border-3 w-60 m-2" onClick={btClick} value="">일식</button>
                            
                    </div>
            </div>
    );
}

export default RecipeRanking;