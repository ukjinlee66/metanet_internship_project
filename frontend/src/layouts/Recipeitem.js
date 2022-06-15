import { Space } from 'antd';
import React, { useEffect, useState, useRef } from 'react';
import Recipedetaillist from '../components/Recipedetailitem';
export function Videoitem()
{
    const [ScrollY, setScrollY] = useState(0); // window 의 pageYOffset값을 저장 
    // useRef를 통해 css 변경
    const stickyChange = useRef(null);
    function handleScroll() { 
        setScrollY(window.pageYOffset);
        if(ScrollY > 300) {
            stickyChange.current.style.top = '75px';
        } else {
            stickyChange.current.style.top = '-100px';
        }
    }
    useEffect(() => {
        function scrollListener() {  window.addEventListener("scroll", handleScroll); } //  window 에서 스크롤을 감시 시작
        scrollListener(); // window 에서 스크롤을 감시
        return () => { window.removeEventListener("scroll", handleScroll); }; //  window 에서 스크롤을 감시를 종료
    });
    return (
      <div class="col-lg-3" style={{ paddingRight: 0 ,position: "sticky"}} ref={stickyChange}>
        <Space
          direction="vertical"
          size="middle"
          style={{
            display: "flex",
          }}
        >
        <Recipedetaillist/>
        </Space>
      </div>
    );
}
export default Videoitem;