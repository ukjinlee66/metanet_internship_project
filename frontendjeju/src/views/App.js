import React, { useEffect } from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Main from './layouts/Main';
import RecipeAttractionInfo from './layouts/RecipeAttractionInfo';
import RecipeAttractionList from './layouts/RecipeAttractionList';
import TouristAttractionListReco from './layouts/TouristAttractionListReco';
import Admin from './layouts/Admin.js'
import Signin from './layouts/Signin.js'
import Signup from './layouts/Signup.js'
import Login from './layouts/Login.js';
import Mypage from './layouts/Mypage.js'
import ServiceCenter from './layouts/ServiceCenter.js'
import QuestionInfo from './layouts/QuestionInfo.js'



function App() {
  useEffect(async () => {
    window.onpageshow = (event) => {
      if (event.persisted) {
        window.location.reload();
      }
    };
  }, [])

  return (
      <BrowserRouter>
      
          <Routes>
              <Route path='/zipcook' element={<Main/>}/>
              <Route path='/zipcook/RecipeAttractionList' element={<RecipeAttractionList/>}/>
              <Route path='/zipcook/RecipeAttractionInfo' element={<RecipeAttractionInfo/>}/>
              <Route path='/zipcook/TouristAttractionListReco' element={<TouristAttractionListReco/>}/>
              <Route path='/zipcook/Maps' element={<Admin/>}/>
              <Route path='/zipcook/Mypage/*' element={<Mypage/>}/>
              <Route path='/zipcook/ServiceCenter' element={<ServiceCenter/>}/>
              <Route path='/zipcook/QuestionInfo' element={<QuestionInfo/>}/>
              <Route path='/zipcook/Signin/*' element={<Login/>}/>
              <Route path='/zipcook/Signup/*' element={<Signup/>}/>
          </Routes>
          
      </BrowserRouter>
  );
}

export default App;
