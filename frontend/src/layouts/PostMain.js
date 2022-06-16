import React from 'react';
import PostList from '../components/PostList';
import { withRouter } from 'react-router-dom';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import ReportSearch from '../components/ReportSearch';



function btClick(e) {
  window.location.href = "/zipcook/QnaWriteForm";
}
const PostMain = props => {
const searchReport = decodeURI(window.location.search.split('=')[1])

  return (
    <>
      <Navbar  />
      <br></br><br></br>
      <h2 align="center">고객센터</h2>
      <div style={{width: "80%", margin:"50px 0px 0px 200px"}}>
      <ReportSearch></ReportSearch>
      </div>
      <PostList />
      <div><br></br><br></br><br></br><br></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button onClick={btClick}>문의글 작성</button>
      </div>
      <Footer />
    </>
  )
}

export default PostMain;