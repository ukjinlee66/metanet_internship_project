import React, {Fragment, useEffect, useState} from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import { Space } from 'antd';



function ReportComment(props)
{
    
    useEffect(()=>
    {
        GetReportComment();
    },[]);
    // 상세 페이지 출력 댓글 정보 
    const [Comments, setComments] = useState([{id:'', userNumber:'', videoNumber:'', userId:'', commentsContexts:'', crDa:'', deDa:''}])
    const axio = axios.create({baseURL: 'http://localhost:8443'})
    const reqUrl = '/Info/comments'; // 한 레시피의 댓글정보 조회
    
    const GetReportComment = async () =>
    {
        await axio
        .get(reqUrl, {
            params: {
                videoNumber: (props.number)
            }
        })
        .then((res)=>{setComments(res.data)});
    }

    // 상세페이지 관광지 정보 렌더링
    const RecRender = () => 
    {
        var result=[];
        for (let i = 0; i < Comments.length;i++)
        {
            if (Comments[i].userNumber != 0)
            {
                result.push(
                    <Space
                    direction="vertical"
                    size="middle"
                    style={{
                        display: "flex",
                    }}
                    >
                    {Comments[i].userId} : {Comments[i].commentsContexts} | {Comments[i].crDa}
                    </Space>
                )
            }
        }
        return (result);
    }

    


    return (
        <Fragment>
            {RecRender()}
        </Fragment>
    );
}

export default ReportComment;