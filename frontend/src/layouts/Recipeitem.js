//import { Space } from 'antd';
import React from 'react';
import Recipedetaillist from '../components/Recipedetailitem';
export const Videoitem = ()=>
{
    return (
      <div class="col-lg-3" style={{ paddingRight: 0}} >
        {/* <Space
          direction="vertical"
          size="middle"
          style={{
            display: "flex",
          }}
        > */}
        <Recipedetaillist/>
        {/* </Space> */}
      </div>
    );
}
export default Videoitem;