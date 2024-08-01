import React from 'react';
import MyFunctionComponent, { MyFunctionComponent2 } from './MyFunctionComponent';
import MyClassComponent from './MyClassComponent';
import { propTypes } from 'prop-types';

export default function MyApp3(props) {
  const myData = {subjecct:"리엑트학습", score:100};
  return (
    <div>
      <MyFunctionComponent subject="react1" score={99}>function1</MyFunctionComponent>
      <MyFunctionComponent subject="react1" score={98}>function2</MyFunctionComponent>
      <MyFunctionComponent2 subject="react1" score={98}>function3</MyFunctionComponent2>
      <MyFunctionComponent2 {...myData}>function4</MyFunctionComponent2>
      <MyFunctionComponent2>function5</MyFunctionComponent2>

      <MyClassComponent subject="react2" score={88}>class1</MyClassComponent>
      <MyClassComponent subject="react2" score={87}>class2</MyClassComponent>
      <MyClassComponent>class3</MyClassComponent>
    </div>
  );
}

//default props - console로 경고, javaScript로 처리하도록 권장
MyFunctionComponent2.defaultProps = {subject:"default subject1", score:50};
MyClassComponent.defaultProps = {subject:"default subject2", score:55};

//prop Type 지정 - 타입이 일치하지 않을경구 console로 경고
MyFunctionComponent2.propTypes = {subject:propTypes.string, score:propTypes.number};
MyClassComponent.propTypes = {subject:propTypes.string, score:propTypes.number}; 