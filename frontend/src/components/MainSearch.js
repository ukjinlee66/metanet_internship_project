import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import RecipeRanking from '../components/RecipeRanking';
import CategorySelect from '../components/CategorySelect';

function MainSearch(props) {
    const [searchInput, setSearchInput] = useState("")
    const [inputColor1, setInputColor1] = useState('')
    const [inputColor2, setInputColor2] = useState('')
    const handleInputColor1 = (e) => {
        setInputColor1(e.target.value)
        
      }

      const handleInputColor2 = (e) => {
        setInputColor2(e.target.value)
      }

    useEffect(() => {}, [inputColor1])
    useEffect(() => {}, [inputColor2])
    // 검색 버튼 클릭 시 이동
    function btClick(e) {
        sessionStorage.setItem("pageSession", 1);
        window.location.href = "/zipcook/RecipeAttractionList?search=" + searchInput+inputColor1+inputColor2;
        sessionStorage.setItem('listState', 'none')
    }

    const colorClick= () => {

    }
    // 검색창에 ENTER 치는 경우에 검색 버튼 클릭으로 간주
    const onKeyPress = (e) => {
        if(e.key=='Enter'){
            btClick();
        }
    }

    return (
        <div class="container-fluid-search bg-zipcook mb-5 wow fadeIn" data-wow-delay="0.1s" >
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

                <div class="d-flex flex-row-reverse">
                    
                    <div class="item" style={{ marginTop:"50px", marginRight:"170px"}}></div>
                    
                    <div class="item" style={{marginTop:"30px", marginLeft:"50px", marginRight:"20px"}}>     
                                    {/* <button class="btn btn-dark border-3 w-90 m-1"  onClick={btClick}>카테고리별</button> */}
                                    
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="options1" id="option1" autocomplete="off" value='&한식' onChange={handleInputColor1}/> 한식
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="options1" id="option2" autocomplete="off" value='&중식' onChange={handleInputColor1}/> 중식
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="options1" id="option3" autocomplete="off" value='&양식' onChange={handleInputColor1}/> 양식
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="options1" id="option3" autocomplete="off" value='&일식' onChange={handleInputColor1}/> 일식
                                        </label>
                                    </div>
                                    {/* <button class="btn btn-dark border-3 w-90 m-1"  onClick={btClick}>난이도별</button> */}
                                    <div style={{marginLeft:"50px"}} class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="options" id="option1" autocomplete="off" value='&초급' onChange={handleInputColor2}/> 초급
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="options" id="option2" autocomplete="off" value='&중급' onChange={handleInputColor2}/> 중급
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="options" id="option3" autocomplete="off" value='&상급' onChange={handleInputColor2}/> 상급
                                        </label>
                                        
                                    </div>
                    </div>
                    <div class="item" style={{marginLeft:"100px"}}></div>
                    <div class="item" style={{marginTop:"30px", marginLeft:"50px"}}><RecipeRanking/></div>
                    
                </div>
                
            
        </div>
    );
}

export default MainSearch;