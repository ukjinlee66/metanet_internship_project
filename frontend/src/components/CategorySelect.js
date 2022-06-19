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
        window.location.href = "/zipcook/RecipeAttractionList";
        sessionStorage.setItem("listState", e.target.value)
    }



    return (
            <div class="container">
                    <div class="col-md-8">   
                        <button class="btn btn-dark border-3 w-90 m-1"  onClick={btClick}>카테고리별</button>
                            <button class="btn btn-dark border-3 w-80 m-2" onClick={btClick} value="한식">한식</button>
                            <button class="btn btn-dark border-3 w-80 m-2" onClick={btClick} value="중식">중식</button>
                            <button class="btn btn-dark border-3 w-80 m-2" onClick={btClick} value="양식">양식</button>
                            <button class="btn btn-dark border-3 w-80 m-2" onClick={btClick} value="일식">일식</button>
                        <button class="btn btn-dark border-3 w-90 m-1"  onClick={btClick}>난이도별</button>
                            <button class="btn btn-dark border-3 w-80 m-2" onClick={btClick} value="초급">초급</button>
                            <button class="btn btn-dark border-3 w-80 m-2" onClick={btClick} value="중급">중급</button>
                            <button class="btn btn-dark border-3 w-80 m-2" onClick={btClick} value="상급">상급</button>
                            
                    </div>
            </div>
    );
}

export default RecipeRanking;