import React from 'react';
import PostList from '../components/PostList';
import { withRouter } from 'react-router-dom';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';




function btClick(e) {
  window.location.href = "/zipcook/QnaWriteForm";
}
const PostMain = props => {
  return (
    <>
      <Navbar  />
      <h2 align="center">고객센터</h2>
      <PostList />
      <div>
                        <button onClick={btClick}>문의글 작성</button>
      </div>
      <Footer />
    </>
  )
}

export default PostMain;