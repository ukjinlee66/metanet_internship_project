import React, { useEffect, useState } from 'react';
import {ReactReader} from 'react-reader';
import ReactHlsPlayer from 'react-hls-player'
import axios from 'axios';
function VIDEO() {
const [imgUrl, setImgUrl] = useState('');
const getVideoFileName = () =>{
axios.get(
'http://localhost:8443/MainPage/getDetail',
{ params: { videoNumber : 552 } }
)
.then(res => {
console.log(res);
console.log(res.data.recipeImg);
setImgUrl( "data:image/png;base64," + res.data.recipeImg );
})
.catch(()=>console.log("실패"));
}
return (
<div>
<h1> dd </h1>
<button onClick={ getVideoFileName }> 비디오 이름 클릭</button>
<img src={imgUrl} alt="W3Schools.com" width="104" height="142"/>
</div>
);
}
export default VIDEO;