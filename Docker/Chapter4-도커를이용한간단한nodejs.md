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

# WORKING DIRECTORY 명시해주기

도커 파일에 이 WORKDIR이라는 부분을 추가해주어야 한다.

하지만 이 부분을 무엇을 위해서 추가해 주어야 할까?

```jsx
# Create app directory
WORKDIR /usr/src/app
```

우선 정의를 보면…

이미지안에서 어플리케이션 소스 코드를 갖고있을 디렉토리를 생성하는 것이다.

그리고 이 디렉토리가 어플리케이션에 working 디렉토리가 된다.

![image.png](attachment:9788d86a-52c4-4f71-8c82-68348abf2818:image.png)

현재 만들어 놓은 이미지의 Root 디렉토리를 봐보자.

docker run -it <이미지 이름> sh(or ls …)

![image.png](attachment:4045b24c-b557-4634-a420-b25f08284b00:image.png)

![image.png](attachment:028622a2-1392-4957-8370-2da57dda6688:image.png)

이렇게 workdir를 지정하지 않고 그냥 COPY할 때 생기는 문제점

1. 혹시 이 중에서 원래 이미지에 있던 파일 이름과 같다면?
   ex) 베이스 이미지에 이미 home이라는 폴더가 있고 COPY를 하므로서 새로 추가 되는 폴더 중에 home이라는 폴더가 있다면 중복이 되므로 원래 있던 폴더가 덮어씌어져 버린다.
2. 모든 파일이 한 디렉토리에 들어가 버리니 너무 정리 정돈이 안되어 있다.

그래서 모든 어플리케이션을 위한 소스들은 WORK디렉토리를 따로 만들어서 보관한다.

![image.png](attachment:1cd6eb8a-860e-4267-b7aa-ab99681b58c5:image.png)

새로운 dockerfile로 이미지 다시 생성 후 컨테이너에서 실행

docker build -t <docker hub 아이디/앱이름>.

docker run -it <이미지 이름> sh

워크 디렉토리에 파일이 잘 들어가 있는지 확인
명령어 ls 입력

![image.png](attachment:8f2ccc8a-4430-4e65-bbc0-eb6fdc420a66:image.png)

WORKDIR 설정 후 터미널에 들어오면 기본적으로 WORK디렉토리에서 시작하게 됨

### 경로 상태

![image.png](attachment:1f6122a8-c198-463f-a0ee-d6b847910e3b:image.png)

# 어플리케이션 소스 변경으로 다시 빌드하는 것에 대한 문제점

어플리케이션을 만들다 보면 소스 코드를 계속 변경시켜줘야 하며 그에 따라서 변경된 부분을 확인하면서 개발을 해 나가야 한다.
그래서 도커를 이용해서 어떻게 실시간으로 소스가 반영되게 하는지 알아보자.

현재까지 만든 어플을 소스 변경시 변경 된 소스를 반영시켜주기 위해서는…

![image.png](attachment:e5057c8e-9f8a-41c5-ad62-93f2db90e28b:image.png)

![image.png](attachment:91efc49c-fdfa-4c97-8768-1f54fc58745f:image.png)

# 어플리케이션 소스 변경으로 재빌드 시 효율적으로 하는 법

완성된 Dockerfile

![image.png](attachment:87438b66-336a-4a5f-bb62-bf2f5652d80a:image.png)

![image.png](attachment:e9e77583-a428-45a6-8117-66b13fa9908f:image.png)

위에 도표를 보면 완성본 Dockerfile에는 RUN 위에 COPY package.json ./ 이 하나가 추가 되고
원래의 COPY가 RUN 아래로 내려갔습니다.

그 이유는 무엇일까요?

npm install 할 때 불 필요한 다운로드를 피하기 위해서 입니다. 원래 묘듈을 다시 받는 것은 모듈에 변화가 생겨야만 다시 받아야 하는데, 소스 코드에 조금의 변화만 생겨도 모듈 전체를 다시 받는 문제점이 있습니다.

![image.png](attachment:aaf8ec44-424a-4ca0-bc32-170c86c2abb5:image.png)

결국은 RUN npm install 전 단계에서 COPY 할 때 조금이라도 바뀐것이 있다면 npm install이 다시 실행된다.

그러기에 RUN npm install 전 단계에서 COPY 할 때는 오직 module에 관한 것만 해준다.

그리고 RUN npm install 이후에 다시 모든 파일들을 COPY 해준다.

![image.png](attachment:8d3cb8fe-9c46-417a-bb60-83f5ba0b5933:image.png)

이렇게 해줘서 모듈은 모듈에 변화가 생길때만 다시 다운받아주며, 소스 코드에 변화가 생길 때 모듈을 다시 받는 현상을 없애 줬습니다.

# Docker Volumes에 대하여

이제는 npm install 전에 package.json만 따로 변경을 해줘서 쓸데없이 모듈을 다시 받지는 않아도 되게 됐습니다.

하지만 아직도 소스를 변경할 때마다 변경된 소스 부분은 COPY 한 후 이미지를 다시 빌드를 해주고 컨테이너를 다시 실행해줘야지 변경된 소스가 화면에 반영이 됩니다.

이러한 작업은 너무나 시간 소요가 크며 이미지도 너무나 많이 빌드하게 됩니다. 이러한 문제점을 해결하기 위해서 Volume을 사용하게 됩니다.

그럼 Docker Volume은 무엇인가요?

현재까지 컨테이너에 소스 코드를 COPY로 넣어줬습니다.

![image.png](attachment:7e554736-014b-4f62-abd0-3b36a82e12df:image.png)

![image.png](attachment:4fdee668-049c-4992-876a-0d998a8639a2:image.png)

### Volume을 사용해서 어플리케이션 실행하는 법

docker run -p 5000:8080 -v /usr/src/app/node_modules -v $(pwd):/usr/src/app <이미지 아이디>

![image.png](attachment:8db2a695-43a4-42ff-a6bf-e788640a27ec:image.png)

`pwd` (print working directory)
현재 작업 중인 디렉토리의 이름을 출력하는 데 쓰인다.

![image.png](attachment:b039a7a8-b664-4889-be84-3feef38e14a1:513599b7-318c-4922-9629-28075dcbafa3.png)

![image.png](attachment:e236737a-a540-4879-ad47-cb3aa65ec8ce:image.png)
