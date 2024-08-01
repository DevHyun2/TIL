import React from 'react';

function ControllerButton({clickHandler, clickHandler2}) {
  return (
    <div>
      <p>Handler event추가</p>
      <button onClick={clickHandler}>+1</button>
      <button onClick={clickHandler}>+10</button>
      <button onClick={clickHandler}>+100</button>
      <button onClick={clickHandler}>-1</button>
      <button onClick={clickHandler}>-10</button>
      <button onClick={clickHandler}>-100</button>
      <hr/>
      <p>함수 직접 구현</p>
      <button onClick={() => clickHandler2(1)}>+1</button>
      <button onClick={() => clickHandler2(10)}>+10</button>
      <button onClick={() => clickHandler2(100)}>+100</button>
      <button onClick={() => clickHandler2(-1)}>-1</button>
      <button onClick={() => clickHandler2(-10)}>-10</button>
      <button onClick={() => clickHandler2(-100)}>-100</button>
    </div>

  );
}

export default ControllerButton;