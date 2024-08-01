import { useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';

function LifeCycleFunction(props) {
  const [count, setCount] = useState(0);
  const [count2, setCount2] = useState(0);
  const [currentTime, setCurrentTime] = useState("00:00:00");

  const now = () => {
    const date = new Date();
    const h = String(date.getHours()).padStart(2, "0");
    const m = String(date.getMinutes()).padStart(2, "0");
    const s = String(date.getSeconds()).padStart(2, "0");

  setCurrentTime(`${h}:${m}:${s}`);
    console.log("타이머실행");
  };
  useEffect(() => {
    const timer = setTimeout(now, 1000);
    //useEffect후에 뒷정리할 메서드를 return한다. clean-up
    return () => {
      clearTimeout(timer);
      console.log("timer변수가 제거됨");
    }
  }, [currentTime]); //currentTime상태값이 변경시마다 실행
  useEffect(() => {
    console.log("loading시 1회(빈 의존배열)");
  }, []);
  useEffect(() => {
    console.log("최초 redering시 1회(의존배열 생략)");
  });
  useEffect(() => {
    console.log("rendering될 때 마다 실행 + count 변경시");
  }, [count]);
  useEffect(() => {
    console.log("rendering될 때 마다 실행 + count2 변경시");
  }, [count2]);
  useEffect(() => {
    console.log("rendering될 때 마다 실행 + count1, count2 변경시");
  }, [count, count2]);
  const addHander = () => {
    setCount(count + 1);
  };
  const addHander2 = () => {
    setCount2(count2 - 1);
  };
  return (
    <div>
      <h1>함수의 LifeCycle : count1 = {count} count2 = {count2}</h1>
      <Button onClick={addHander}>1증가</Button>
      <Button onClick={addHander2}>1감소</Button>
    </div>
  );
}

export default LifeCycleFunction;