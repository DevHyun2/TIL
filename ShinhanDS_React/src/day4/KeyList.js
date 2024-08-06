import React, { useCallback, useEffect, useRef, useState } from "react";
import Card from "./Card";

const DUMMY_ARR = [
  { userid: 1, username: "jin1" },
  { userid: 2, username: "jin2" },
];
const KeyList = () => {
  const [arr, setArr] = useState(DUMMY_ARR);
  const nextUserId = useRef(3);
  //함수메모, 최초1회만 함수를 할당 []
  const handleClick = useCallback(() => {
    console.log("handleClick~~~");
  },[]); //의존배열이 비어있다면 최초한번 수행한다.

  //Test용, handleClick메서드가 변경되었는지 확인하기 위해 추가
  useEffect(()=>{
    console.log("handClick메서드가 다시 만들어졌음");
  },[handleClick]);

  return (
    <div>
      <h2>key가 index일때와 유일한 값일때의 차이</h2>
      {arr.map((item, index) => (
        <Card key={item.userid} item={item} handleClick={handleClick}></Card>
      ))}
      <button
        onClick={() => {
          setArr([
            {
              userid: `${nextUserId.current}`,
              username: `Hi~${nextUserId.current}`,
            },
            ...arr,
          ]);
          nextUserId.current += 1;
        }}
      >
        앞부분에 아이템 추가, Reindexing발생
      </button>
    </div>
  );
};

export default KeyList;
