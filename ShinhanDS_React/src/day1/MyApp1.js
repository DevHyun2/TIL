import React from 'react';
import Header from './Header';
import Content from './Menu';
import Section from './Section';

//Component : 재사용가능, 반드시 대문자 시작, 외부에서 사용하려면 export필요
function MyApp1(props) {
  //JSX(JavaScript XML) : 반드시 root가 1개, tag 반드시 닫기
  return (
    <div>
      <h1>Function Component1</h1>
      <Header/>
      <Content/>
      <Section/>
      <hr/>
    </div>
  );
}

export default MyApp1;