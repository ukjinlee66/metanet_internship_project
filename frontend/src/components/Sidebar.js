
import React, { useState, useEffect } from "react";
import "antd/dist/antd.css";
import { NavLink } from "react-router-dom";
import styled from "styled-components";
import profile from "../assets/img/logo.png";
import SidebarItem from "./SidebarItem";


const Side = styled.div`
  display: flex;
  border-right: 1px solid #e0e0e0;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 20%;
`
const Profile = styled.img`
  width: 150px;
  height: 150px;
  border-radius: 100%;
`
const Menu1 = styled.div`
  margin-top: 30px;
  width: 200px;
  display: flex;
  flex-direction: column;
`

const Sidebar = () => {
    const [isAdmin, setIsAdmin] = useState(false)
    useEffect(() => {
        if (sessionStorage.getItem('User_Kind') == 0) {
            console.log("admin",isAdmin)
        } else {
            setIsAdmin(true)
            console.log("admin",isAdmin)
        }
    }, [])

    const menus = [
        { name: "시청내역", path: "./View" },
        { name: "좋아요 누른 영상", path: "./LikedView" },
        { name: "저장한 영상", path: "./SaveList" },
        { name: "포인트 사용 내역", path: "./PayPoint" },
        { name: "포인트 충전", path: "./ChargePoint" },
        { name: "문의 내역", path: "./QnA" },
        { name: "구독권 구매", path: "./BuySubscribe" }
    ];

    const Adminmenus = [
        { name: "문의 내역", path: "./QnA" },
        { name: "환불 페이지", path: "./refundPoint" },
        { name: "레시피 댓글", path:"./"}
    ];

    let Kind = null;
    if(isAdmin === false){
         Kind = menus 
        console.log("false",Kind)
    }else if(isAdmin === true){
         Kind = Adminmenus
         console.log("true",Kind)
    }

    return (

        <Side>
            <Profile src={profile}></Profile>
            <Menu1>
                {Kind.map((menu, index) => {

                    return (
                        <NavLink
                            exact
                            style={{ color: "gray", textDecoration: "none" }}
                            to={menu.path}
                            key="{menu}"
                            activeStyle={{ color: "black" }}
                        >
                            <SidebarItem menu={menu} />
                        </NavLink>
                    );
                })}
            </Menu1>
        </Side>
    );
}

export default Sidebar;