import React from 'react';
import ExportTest,{constTest, varTest, F1, F2} from './ExportTest';
import "day1/external.css";

//함수형Component : 컴포넌트 이름은 반드시 대문자
function MyApp2(props) {
  var myname = "리엑트JS";
  const score = 99;
  const student = {name:"재환", major:"컴공"}
  //이 부분의 값은 JSX에서 읽어서 출력시 display안됨(랜더링안됨)
  let score2 = null;
  let score3 = undefined;
  let score4 = false;

  const hobbyArr = ["Sports", "Music", "Movie"];
  const hobbyDisplay = hobbyArr.map((item, index)=><li key={index}>{item}</li>);

//import한 값, 함수 사용하기
console.log(constTest);
console.log(varTest);

const inlineStyle = {border:"3px dotted blue", color:"orange"}

  return (
    <div style={inlineStyle}>
      <h1 style={{backgroundColor:"green"}}>함수형Component</h1>
      <p className='myStyle2'>이름은 {myname}</p>
      <p className='myStyle'>점수는 {score}</p>
      <p>{student.name}---{student.major}</p>
      {/* 랜더링 안될 시 랜더링 되게 하는 방법 */}
      <p>점수2는 {score2}----{score2 == null?"No값":"score2"}</p>
      <p>점수3는 {score3}----{score3 === undefined?"No값":"score3"}</p>
      <p>점수4는 {score4}----{score4 === false?"No값":"score4"}</p>
      {/* <p>주석</p> */}
      <div>
        <p>{hobbyArr}</p>
        <ul>{hobbyArr.map((item,index)=><li key={index}>{item}</li>)}</ul>
      </div>
      <hr/>
      <ul>{hobbyDisplay}</ul>
      {/* import연습 */}
      <ExportTest/>
      <F1/>
      <F2/>
      <p>constTest: {constTest}</p>
      <p>varTest: {varTest}</p>
    </div>
  );
}

export default MyApp2;