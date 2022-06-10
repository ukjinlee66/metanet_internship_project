import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import foodImg1 from "../assets/img/bibimbab.jpg"
import foodImg2 from "../assets/img/chicken.jpg"
import foodImg3 from "../assets/img/dduckboggi.jpg"
import foodImg4 from "../assets/img/dubujorim.jpg"
import foodImg5 from "../assets/img/jajangmyeon.jpg"
import foodImg6 from "../assets/img/jokbal.jpg"
import foodImg7 from "../assets/img/junbyeong.jpg"
import foodImg8 from "../assets/img/kimchizikae.jpg"
import foodImg9 from "../assets/img/ramen.jpg"
function MainRecipeList(props) {
    const [recipeClick, setRecipeClick] = useState("")

    // 레시피 클릭 시 이동
    function btClick(e) {
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/zipcook/RecipeAttractionList";
    }



    return (
            <div class="container">
                    <div class="col-md-10">
                        <p>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="low">초급</button>
                        </p>
                        <img class="img-fluid-tour" src={foodImg1} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/> 
                        <img class="img-fluid-tour" src={foodImg2} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/>
                        <img class="img-fluid-tour" src={foodImg3} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/>
                        <p>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="low">중급</button>
                        </p>
                        <img class="img-fluid-tour" src={foodImg4} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/> 
                        <img class="img-fluid-tour" src={foodImg5} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/>
                        <img class="img-fluid-tour" src={foodImg6}onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/>
                        
                        <p>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="low">상급</button>
                        </p>
                        <img class="img-fluid-tour" src={foodImg7} onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/> 
                        <img class="img-fluid-tour" src={foodImg8}onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/>
                        <img class="img-fluid-tour" src={foodImg9}onClick={(e) => window.location.href = "/zipcook/RecipeAttractionInfo"}/>
                        
                            
                    </div>
            </div>
    );
}

export default MainRecipeList;