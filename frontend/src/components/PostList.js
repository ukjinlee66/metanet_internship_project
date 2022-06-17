import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import CommonTable from '../components/CommonTable';
import CommonTableColumn from '../components/CommonTableColumn';
import CommonTableRow from '../components/CommonTableRow';
import axios from "axios";
const PostList = () => {
  const [ dataList, setDataList ] = useState([
  ]);
  const searchReport = decodeURI(window.location.search.split('=')[1])
  const searchPostListUrl = 'http://localhost:8443/Report/Posts/SearchPost?reportTitle='+ searchReport;
  const PostListUrl = 'http://localhost:8443/Report/List'
  // 7개의 검색어 랭킹 리스트 요청
  const getPostList = async () => {
    if(searchReport != ''){
      await axios
          .get(searchPostListUrl)
          .then((res) => {
            setDataList(res.data)
            console.log(dataList)
          }
          )}
        else if(searchReport == ''){
          await axios
          .get(PostListUrl)
          .then((res) => {
            setDataList(res.data)
            console.log(dataList)
          }
          )
        }
        }; 
        

  useEffect(() => {
    getPostList();
  }, []);
  

  return (
    <>
      <CommonTable headersName={['글번호', '제목', '등록일', '분류']}>
        {
          dataList ? dataList.map((item, index) => {
            return (
              <CommonTableRow key={index}>
                <CommonTableColumn>{ item.reportTableNumber }</CommonTableColumn>
                <CommonTableColumn>
                  <Link to={`/zipcook/postView/${item.reportTableNumber}`}>{item.reportName}</Link>
                </CommonTableColumn>
                <CommonTableColumn>{ item.crDa }</CommonTableColumn>
                <CommonTableColumn>{ item.reportKind }</CommonTableColumn>
              </CommonTableRow>
            )
          }) : ''
        }
      </CommonTable>
    </>
  )
}

export default PostList;