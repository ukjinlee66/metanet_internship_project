import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";

function MainRecipeList(props) {
    const [recipeClick, setRecipeClick] = useState("")

    // 레시피 클릭 시 이동
    function btClick(e) {
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/zipcook/TouristAttractionList";
    }



    return (
            <div class="container">
                    <div class="col-md-10">
                        <p>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="low">초급</button>
                        </p>
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/> 
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/>
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/>
                        <p>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="low">중급</button>
                        </p>
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/> 
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/>
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/>
                        
                        <p>
                            <button class="btn btn-dark border-0 w-20 m-3" onClick={btClick} value="low">상급</button>
                        </p>
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/> 
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/>
                        <img class="img-fluid-tour" src='https://image.fmkorea.com/files/attach/new2/20210728/3674493/3731487823/3787216388/37dbf32737fa8f62174e3764bae950ab.jpg' onClick={(e) => window.location.href = "/zipcook/TouristAttractionInfo"}/>
                        
                            
                    </div>
            </div>
    );
}

export default MainRecipeList;