---

# Docker Compose란 무엇인가?

docker compose는 다중 컨테이너 도커 애플리케이션을 정의하고 실행하기 위한 도구입니다.

### 페이지를 리프래쉬 했을 때 숫자 0 부터 1씩 계속 올라가는 간단한 앱 만들어 보면서 Docker Compose 학습하기

![image.png](attachment:68ad0924-94aa-49e8-877c-7fab4ffe0429:image.png)

# 어플리케이션 소스 작성하기

새로운 프로젝트를 만들 폴더 하나 만들기

![image.png](attachment:08fd2d28-6b92-418b-a67b-b19f64ef2256:image.png)

기본적인 노드 부분 완성하기

## 레디스란?

Redis(Remote Dictionary Server)는 메모리 기반의 키-값 구조 데이터관리 시스템
모든 데이터를 메모리에 저장하고 빠르게 조회할 수 있는 비관계형 데이터베이스(NoSQL)이다.

### 레디스를 쓰는 이유?

메모리에 저장을 하기 때문에 MySQL같은 데이터베이스에 데이터를 저장하는 것과 데이터를 불러올 때 훨씬 빠르게 처리할 수가 있으며, 비록 메모리에 저장하지만 영속적으로 보관이 가능.
그래서 서버를 재부팅해도 데이터를 유지할 수 있는 장점이 있음.

## Node.js 환경에서 Redis 사용방법

- 먼저 reids-server를 작동시켜주어야 한다
- 그리고 reids 모듈을 다운받는다
- 레디스 모듈을 받은 후 레디스 클라이언트를 생성하기 위해서 Redis에서 제공하는 createClient() 함수를 이용해서 redis.createClient로 레디스 클라이언트를 생성해준다
- 하지만 여기서 redis server가 작동하는 곳과 Node.js 앱이 작동하는 곳이 다른 곳이라면 host인자와 port인자를 명시해주어야 한다.

ex)

![image.png](attachment:9879f309-712c-48c2-b1ce-9bd5b1bda102:image.png)

만약 Redis 서버가 작동하는 곳이
redis-server.com 이라면 Host 옵션을 주면 된다

“https://redis-server.com”

레디스의 기본 포트는 “6379”번 이다.

## 도커 환경에서 레디스 클라이언트 생성시 주의사항

보통 도커를 사용하지 않는 환경에서는 Redis 서버가 작동되고 있는 곳의 host 옵션을 URL로 위에처럼 주면 되지만,
도커 Compose를 사용할 때는 host 옵션을 docker-compose.yml 파일에 명시한 컨테이너 이름으로 주면된다.

페이지를 리프레쉬 했을 때 0부터 1씩 계속 올라가는 기능

```jsx
const express = require("express");
const redis = require("redis");

//레디스 클라이언트 생성
const client = redis.createClient({
  host: "redis-server",
  port: 6379,
});

const app = express();

//숫자는 0 부터 시작
client.set("number", 0);

app.get("/", (req, res) => {
  client("number", (err, number) => {
    //현재 숫자를 가져온 후 1씩 올려줍니다.
    client.set("number", parseInt(number) + 1);
    res.send("숫자가 1씩 올라갑니다. 숫자: " + number);
  });
});

app.listen(8080);
console.log("server is running");
```

# Dockerfile 작성하기

Node.js를 위한 이미지를 만들기 위해서 Dockerfile을 작성하는 것이기에 저번에 Node.js 앱을 위한 Dockerfile과 똑같이 만들어 주면 된다.

![image.png](attachment:66979e17-8906-46ed-960e-ad8c0e01a94c:image.png)

# Docker Containers 간 통신할 때 나타나는 에러

![image.png](attachment:52f83870-bcd6-45d9-bd7b-099ccf3fe9a6:image.png)

레디스 클라이언트가 작동하려면 레디스 서버가 켜져있어야 한다.

먼저 레디스 서버를 위한 컨테이너를 실행하고, 노드를 위한 컨테이너를 실행한다.

docker build 도커아이디/앱이름
docker run -p 5000:8080 이미지이름

![image.png](attachment:8b9c401a-4b3f-4457-b328-0606158f142a:image.png)

⇒ 레디스 서버를 위한 컨테이너를 실행하고 노드를 위한 컨테이너를 실행할 때 위와 같이 에러가 난다.

Why error??

![image.png](attachment:c699241b-a9de-4a11-9495-6824fe930159:image.png)

### 그러면 어떻게 컨테이너 사이에 통신을 할 수 있게 해줄까요?

⇒ 멀티 컨테이너 상황에서 쉽게 네트워크를 연결시켜주기 위해서 `Docker Compose` 를 이용하면 된다.

# 도커 Compose 파일 작성하기

docker-compose.yml 파일 작성

![image.png](attachment:79d1a5a8-42ad-43e8-87d1-001eae27200d:image.png)

docker-compose 파일 구조

![image.png](attachment:e8319384-3e4b-4e71-be8f-5383e0c59d57:image.png)

![image.png](attachment:eeadd81a-509f-441b-83ac-a5b225aebef3:image.png)

- version → 도커 컴포즈의 버전
- service → 이곳에 실행하려는 컨테이너를 정의
  - redis-server → 컨테이너 이름
    - image → 컨테이너에서 사용하는 이미지
  - node → 컨테이너 이름
    - build → 현 디렉토리에 있는 Dockerfile을 사용
    - ports → 포트 맵핑 로컬포트 : 컨테이너 포트

이렇게 docker compose를 다 작성한 후에 도커 컴포즈를 이용해서 앱을 실행

docker-compose up

# Docker Compose로 컨테이너 멈추기

도커 컴포즈를 통해 작동시킨 컨테이너들을 한꺼번에 중단 시키려면
docker compose down으로 할 수 있습니다.

docker compose up —build
다른 터미널에서 경로 진입 후 docker compose down

docker-compose up ⇒ 이미지가 없을 때 이미지를 빌드하고 컨테이너 빌드

docker-compose up —build ⇒ 이미지가 있든 없든 이미지를 빌드하고 컨테이너 빌드

### 굳이 다른 터미널을 켜지 않고 하나의 터미널로 해결하고 싶다면

![image.png](attachment:f1d60fe8-0ead-429e-b6d4-b552d46ac01f:image.png)
