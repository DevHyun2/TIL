import React from 'react';

export const constTest = 100;
export var varTest = "문자값";
export function F1(){return <p>함수1</p>}
export const F2 = function(){return <p>함수2</p>}


//export default는 오직 하나만 가능
export default function ExportTest(props) {
  return (
    <div>
      <p>ExportTest함수(default export)</p>
    </div>
  );
}

//각각 export예약어를 사용할 수 있고, 한번에 사용 할 수 있음
//export {ExportTest as default;