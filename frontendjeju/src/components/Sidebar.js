import React from "react";
import { NavLink } from "react-router-dom";
import styled from "styled-components";
import profile from "../assets/img/carousel-1.jpg";
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
const Menu = styled.div`
  margin-top: 30px;
  width: 200px;
  display: flex;
  flex-direction: column;
`

function Sidebar() {
    const menus = [
        { name: "시청내역", path: "./View" },
        { name: "좋아요 누른 영상", path: "./LikedView" },
        { name: "저장한 영상", path: "./SaveList" },
        { name: "포인트 사용 내역", path: "./PayPoint" },
        { name: "포인트 충전", path: "./ChargePoint" },
        { name: "문의 내역", path: "./QnA" }
    ];
    return (
        <Side>
            <Profile src={profile}></Profile>
            <Menu>
                {menus.map((menu, index) => {

                    return (
                        <NavLink
                            exact
                            style={{ color: "gray", textDecoration: "none" }}
                            to={menu.path}
                            key={index}
                            activeStyle={{ color: "black" }}
                        >
                            <SidebarItem menu={menu} />
                        </NavLink>
                    );
                })}
            </Menu>
        </Side>
    );
}

export default Sidebar;