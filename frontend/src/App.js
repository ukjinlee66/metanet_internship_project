import React, { useEffect } from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Main from './layouts/Main';
import RecipeAttractionInfo from './layouts/RecipeAttractionInfo';
import RecipeAttractionList from './layouts/RecipeAttractionList';
import TouristAttractionListReco from './layouts/TouristAttractionListReco';
import Admin from './layouts/Admin.js'
import Mypage from './layouts/Mypage.js'
import ServiceCenter from './layouts/ServiceCenter.js'
import QuestionInfo from './layouts/QuestionInfo.js'
import Member from './views/Member';
import NotFound from './layouts/NotFound';
import CreateRecipe from './layouts/CreateRecipe';
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
              <Route path='/zipcook/member/*' element={<Member/>}/>
              <Route path='/zipcook/CreateRecipe' element={<CreateRecipe/>}/>
              <Route path='*' element={<NotFound/>}/>
          </Routes>
      </BrowserRouter>
  );
}

export default App;
