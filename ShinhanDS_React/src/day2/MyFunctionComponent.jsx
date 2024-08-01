import React from 'react';

function MyFunctionComponent(props) {
  const inlineStyle = {border : "1px solid green", color:"blue"};
  const {subject, score, children} = props; //{subject: "", score: --}
  return (
    <div style={inlineStyle}>
      <h1 style={{color : "red"}}>FunctionCompnent 리뷰</h1>
      <p>속성받기 subject: {props.subject}</p>
      <p>속성받기 subject: {subject}</p>
      <p>속성받기 score: {props.score}</p>
      <p>속성받기 score: {score}</p>
      <p>태그사이의 내용 children: {props.children}</p>
      <p>태그사이의 내용 children: {children}</p>
    </div>
  );
}

export function MyFunctionComponent2({subject, score, children}) {
  const inlineStyle = {border : "1px solid green", color:"blue"};
  return (
    <div style={inlineStyle}>
      <h1 style={{color : "red"}}>FunctionCompnent2 리뷰</h1>
      <p>속성받기 subject: {subject}</p>
      <p>속성받기 score: {score}</p>
      <p>태그사이의 내용 children: {children}</p>
    </div>
  );
}

export default MyFunctionComponent;