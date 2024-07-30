import React from 'react';

function EnvTest(props) {

  console.log("PUBLIC_URL : 공백" + process.env.PUBLIC_URL);
  console.log("CHANEL_ID : " + process.env.REACT_APP_CHANEL_ID);
  console.log("CHANEL_ID2 : " + process.env.REACT_APP_CHANEL_ID2);
  console.log("REACT_APP_IMAGE_PATH : " + process.env.REACT_APP_IMAGE_PATH);

  return (
    <div>
      <h1>환경변수 사용하기(서버재시작 필요)</h1>
    </div>
  );
}

export default EnvTest;