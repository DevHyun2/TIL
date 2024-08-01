import React from 'react';
import PropsComponentTest from 'day2/PropsComponentTest';

function MyApp4(props) {
  const arr = ["HTML", "CSS", "JS", "ReactJS"];
  return (
    <div>
      <PropsComponentTest subject={arr}>배열로 들어온 속성값 보내기</PropsComponentTest>
      <PropsComponentTest>보낸 값 없음</PropsComponentTest>
    </div>
  );
}

export default MyApp4;