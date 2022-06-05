import React, { useEffect } from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Main from './layouts/Main';
import RecipeAttractionInfo from './layouts/RecipeAttractionInfo';
import RecipeAttractionList from './layouts/RecipeAttractionList';
import TouristAttractionListReco from './layouts/TouristAttractionListReco';
import Admin from './layouts/Admin.js'
import Signin from './layouts/Signin.js'
import Signup from './layouts/Signup.js'
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
              <Route path='/jeju' element={<Main/>}/>
              <Route path='/jeju/RecipeAttractionList' element={<RecipeAttractionList/>}/>
              <Route path='/jeju/RecipeAttractionInfo' element={<RecipeAttractionInfo/>}/>
              <Route path='/jeju/TouristAttractionListReco' element={<TouristAttractionListReco/>}/>
              <Route path='/jeju/Maps' element={<Admin/>}/>
              <Route path='/jeju/Mypage/*' element={<Mypage/>}/>
              <Route path='/jeju/ServiceCenter' element={<ServiceCenter/>}/>
              <Route path='/jeju/QuestionInfo' element={<QuestionInfo/>}/>
              <Route path='/jeju/Signin' element={<Signin/>}/>
              <Route path='/jeju/Signup' element={<Signup/>}/>
          </Routes>
      </BrowserRouter>
  );
}

export default App;
