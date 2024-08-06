import React, { useEffect, useMemo, useState } from "react";
import { Button } from "react-bootstrap";

function MemoTest(props) {
  const [count, setCount] = useState(0);
  const increment = () => {
    setCount(count + 1);
  };
  const expensiveCalculation = (num) => {
    console.log("Calculating...");
    for (let i = 0; i < 1000000000; i++) {
      num += 1;
    }
    return num;
  };
  //함수호출.... 함수를 수행하는데 시간이 오래걸린다.
  //해결: 의존배열값이 변경될때만 재계산하고 다른 변화에 의해 재rendering될때는 기존값을 기억했다가 재사용
  const calculation = useMemo(()=> expensiveCalculation(count),[count]);
  const [myname, setMyname] = useState("");
  const changehandler = (e) => {
    console.log(e.target.value);
    setMyname(e.target.value);
  };
  
  //성능최적화를 위해 사용
  //useMemo(), React.memo(), useCallback()
  //값저장: useMemo()
  //컴포넌트 저장: React.memo()
  //함수 저장: useCallback()
  useEffect(()=>{console.log("changehandler변경됨");},[myname]);


  return (
    <div>
      Count: {count}
      <Button onClick={increment}>+</Button>
      <input onChange={changehandler}></input>
      <p>입력한 정보: {myname}</p>
      <h2>Expensive Calculation: {calculation}</h2> 
    </div>
  );
}

export default MemoTest;