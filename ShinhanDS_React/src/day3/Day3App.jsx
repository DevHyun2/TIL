import React, { useEffect, useState } from 'react';
import DisplayCount from './DisplayCount';
import ControllerButton from './ControllerButton';

function Day3App(props) {
  //data상태관리 , 값 변경시 자동으로 UI적용... 함수형 컴포넌트에서 useState()를 사용
  const [count, setCount] = useState(0);
  const clickHandler = (e) => {
    setCount(count + Number(e.target.innerText));
    //의미 : count = count + Number(e.target.innerText)
  };
  const clickHandler2 = (value) => {
    setCount(count + value);
    //의미 : count = count + value
  };

  //life cycle관리할 때 사용되는  Hook
  useEffect(() => {
    console.log("count가 변경되면 수행" + count);
  }, [count]);
  
  return (
    <div>
      <h1>Count App</h1>
      <DisplayCount count={count}/>
      <ControllerButton clickHandler={clickHandler} clickHandler2={clickHandler2}/>
    </div>
  );
}

export default Day3App;