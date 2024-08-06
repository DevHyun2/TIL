import React from "react";

const Light=({room,on})=>{
     console.log(room,on);
     return<div>{on?"💡":"⬛"}</div>;
    };

    //component가 변경되지않았다면 재rendering되지 않음
    export default React.memo(Light);

    export function Light2({room,on}){
         console.log(room,on);
         return<div>{on?"💡":"⬛"}</div>;
        };