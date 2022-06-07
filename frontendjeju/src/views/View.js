import React from 'react';
import styled from "styled-components";

const Side = styled.div`
position:absolute;
top:25%;
left:50%;
`

const View = (props) => {
    return (
         <Side>
            <h1>포인트 충전</h1>

         </Side>
    );
}

export default View;