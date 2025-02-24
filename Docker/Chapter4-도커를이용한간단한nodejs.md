> Node.js 공식 홈페이지에서 도커를 이용하여 Node.js를 이용하는 예시부분을 사용하여 도커를 실전에 도입하는 연습하기

### 이번 챕터는 Dockerfile을 어떤식으로 작성한는지 중점적으로 다룸

![image.png](attachment:a77a9701-e33c-455d-8c3b-ba1b8e88c4fb:image.png)

### package.json 만들기

![image.png](attachment:9a5fd160-73a7-4019-a107-9b5d72155b76:image.png)

```json
{
  "name": "nodejs-docker-app",
  "version": "1.0.0",
  "description": "",
  "main": "server.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "dependencies": {
    "express": "4.17.1",
    "nodemon": "2.0.4"
  },
  "author": "",
  "license": "ISC"
}
```

### server.js 시작점 만들기

![image.png](attachment:2ede03b3-9155-427c-8061-348d52719840:image.png)

![image.png](attachment:c8402760-5556-4d45-80b2-54dcaf659b9b:image.png)

```jsx
const express = require("express");

const PORT = 8080;

//APP
const app = express();
app.get("/", (req, res) => {
  res.send("반가워요!!!!!!!");
});

app.listen(PORT);
console.log("Server is running");
```

### Dockerfile 작성하기

Node.js 앱을 도커 환경에서 실행하려면 먼저 이미지를 생성하고 그 이미지를 이용해서 컨테이너를 실행한 후 그 컨테이너 안에서 Node.js 앱을 실행해야 한다.

그래서 그 이미지를 먼저 생성하려면 Dockerfile을 먼저 작성해야한다.

![image.png](attachment:5da2b062-744d-4fdf-8d24-e92f02a445ae:image.png)

가장 근본이 되는 것 부터 작성

![image.png](attachment:7dcef72f-f4b2-464c-9eea-c1fb242820ae:image.png)

```docker
FROM node

RUN npm install

CMD ["node", "server.js"]
```

### 왜 저번에는 alpine 베이스 이미즈를 썼는데 이번엔 node 이미지를 쓰나요?

- alpine 베이스 이미지로 빌드시
  ⇒ npm not found 에러가 발생
- 그 이유는 alpine 이미지는 가장 최소한의 경량화된 파일들이 들어있기에 npm을 위한 파일이 들어있지 않음
  ⇒ RUN 부분의 npm install을 할 수가 없음
- 그렇기에 npm이 들어있는 베이스 이미지를 찾아야 하는데 그 중 하나가 node 이미지임

### npm install 이란?

![image.png](attachment:9bd493d7-0597-4a12-ba9a-c86c1e223b48:image.png)

- npm은 Node.js로 만들어진 모듈을 웹에서 받아서 설치하고 관리해주는 프로그램
- npm install은 package.json에 적혀있는 종속성들을 웹에서 자동으로 다운 받아서 설치해주는 명령어

### “node” “server”는 무엇인가요?

- 노드 웹 서버를 작동시키려면 node + 엔트리 파일 이름을 입력해야 한다.

### 결과

![image.png](attachment:c07a93e4-7336-499a-9cb1-56b4e479b418:image.png)

package.json이 없다는 에러가 발생…

# Package.json이 없다고 뜨는 이유..?

![image.png](attachment:b820d865-19e5-45c8-aa99-d21e709c2ff9:image.png)

⇒ **package.json은 컨테이너 밖에 존재하기 때문… && sever.js 파일도 동일**

COPY를 이용해서 package.json을 컨테이너 안으로 넣어주어야 한다!!

![image.png](attachment:6c40a54b-cf66-471b-b0b8-d98404e964a8:image.png)

Dockerfile

![image.png](attachment:06348354-22d7-43a6-ab83-d7b4105d42a7:image.png)

docker run devhyun2/nodejs

![image.png](attachment:873f0fdf-5aa3-4dd2-99f1-12868921540a:image.png)

[localhost:8080](http://localhost:8080) 접속 시 접속 안됨…

# 생성한 이미지로 어플리케이션 실행 시 접근이 안되는 이유(포트 맵핑)

![image.png](attachment:4d55cac0-398a-4f57-89fd-99f9aef9ae64:image.png)

### 새롭게 추가 된 부분은 무엇을 위한 부분인가?

우리가 이미지를 만들 때 로컬에 있던 파일들을 컨테이너에 복사 해줘야 했다.

그것과 비슷하게 네트워크도 로컬 네트워크에 있던것을 컨테이너 내부에 있는 네트워크에 연결을 시켜 주어야 한다.

![image.png](attachment:af0832a1-7aa3-4995-ba3e-ae898e9bf7a0:image.png)

![image.png](attachment:e7bd03f0-0001-4820-885c-1cba1c2f7182:image.png)
