import React, {Fragment, useEffect, useState} from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import { Space } from 'antd';


const RecipeinfoComments= (props)=>
{
    const axio = axios.create({baseURL: 'http://localhost:8443'})
    const reqdel = '/Info/deletecomment'; // 댓글 삭제
    const reqedit = '/Info/editcomment'; // 댓글 수정
    const [Comments, setComments] = useState([{id:'',commentsNumber:'',userNumber:'', videoNumber:'', userId:'', commentsContexts:'', crDa:'', deDa:''}]);
    const reqUrl = '/Info/comments'; // 한 레시피의 댓글정보 조회
    useEffect(()=>
    {
        GetRecipeComments();
    },[]);
    // 상세 페이지 출력 댓글 정보 
    

    const GetRecipeComments = async () =>
    {
        await axio
        .get(reqUrl, {
            params: {
                videoNumber: (props.number)
            }
        })
        .then((res)=>{setComments(res.data)});
    }

    const EditComment = async () =>
    {
        await axio
        .post(reqedit,{},{
                Comments: String(props.Comm),
                CommentsNumber: Number(sessionStorage.getItem("User_Number"))
        })
        .then((res)=>{
            alert("댓글 수정 완료");
            window.location.reload();
        });
    }

    const DeleteComment = async (num) =>
    {
        await axio
        .post(reqdel,{}, {
            params:{
                commentsNumber: num
            }   
        })
        .then((res)=>{
            alert("댓글 삭제 완료");
            window.location.reload();
        });
    }

    // 상세페이지 관광지 정보 렌더링
    const RecRender = () => 
    {
        var result=[];
        for (let i = 0; i < Comments.length;i++)
        {
            var temp = Comments[i].commentsNumber;
            var check = false;
            if(sessionStorage['User_Id'] === Comments[i].userId || sessionStorage['User_Kind'] == 1)
                check = true;
            if (Comments[i].userNumber != 0 && Comments[i].deDa == null)
            {
                var temp = Comments[i].commentsNumber;
                result.push(
                    <Space
                    direction="horizontal"
                    size="middle"
                    style={{
                        display: "flex",
                    }}
                    >
                    {Comments[i].userId} : {Comments[i].commentsContexts} | {Comments[i].crDa}
                    {/* <button onClick={EditComment}>수정</button> */}
                    {check == true
                    ?
                        <button value={temp} onClick={()=>DeleteComment(temp)}value>삭제</button>
                    :
                        <p/>
                    }
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

export default RecipeinfoComments;