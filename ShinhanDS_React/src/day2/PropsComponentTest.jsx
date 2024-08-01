import React from 'react';

//부모가 자식에게 Property 보내면 받기
function PropsComponentTest(props) {
  var {subject} = props;
  subject = subject === undefined ? ["A", "B"] : subject;
  return (
    <div>
      <h1>{props.children}</h1>
      <ul>
        {subject && subject.map((item, index) => (<li key={index}>{item}</li>))}
      </ul>
    </div>
  );
}

export default PropsComponentTest;