# 직접 도커 이미지 만들어 보기

### 컨테이너는 도커 이미지로 생성…

그럼 도커 이미지는 어떻게 생성할까요?

**도커이미지 생성하는 순서**

![image.png](attachment:cf2a84b9-cd27-49ec-848b-5bd5c48286a5:image.png)

# Docker File 만들기

Docker File 이란 Docker Image를 만들기 위한 설정 파일
→ 컨테이너가 어떻게 행동해야 하는지에 대한 설정들을 정의해 주는 곳

### Docker File 만드는 순서(도커 이미지가 필요한 것이 무엇인지를 생각하기)

1. 베이스 이미지를 명시(파일 스냅샷에 해당)
2. 추가적으로 필요한 파일을 다운 받기 위한 몇가지 명령어를 명시(파일 스냅샷에 해당)
3. 컨테이너 시작 시 실행 될 명령어를 명시(시작시 실행 될 명령어에 해당)

![image.png](attachment:8834d04d-6dd9-41a8-9c22-59d730f832c5:image.png)

### 베이스 이미지는 무엇인가?

- 도커 이미지는 여러개의 레이어로 되어있다.
  그 중에서 `베이스 이미지`는 이 이미지의 기반이 되는 부분이다.
- 레이어는 중간 단계의 이미지라고 생각하면 된다.
- 만약 이 이미지에 무엇인가 추가 한다면?
  → 아래 보이는 레이어가 추가된다. ⇒ `레이어 캐싱`

![image.png](attachment:5094c210-26d0-4767-9114-ecb5ffd5beab:image.png)

### 실습

목표 : “hello” 문구 출력

1. 도커 파일을 만들 폴더 하나 만들기 ex)dockerfile-folder
2. 방금 생성한 도커 파일 폴더를 에디터를 이용해서 실행
3. 파일 하나를 생성, 이름은 dockerfile
4. 그 안에 먼저 어떻게 진행해 나갈지 기본적인 토대를 명시

```docker
#베이스 이미지를 명시해준다.
FROM baseImgae

#추가적으로 필요한 파일들을 다운로드 받는다.
RUN command

#컨테이너 시작시 실행 될 명령어를 명시해준다.
CMD ["executable"]
```

---

**FROM**

- 이미지 생성시 기반이 되는 이미지 레이어
  <이미지이름>:<태그> 형식으로 작성
- 태그를 안붙이면 자동적으로 가장 최신것으로 다운 받음
  ex)ubuntuL14.04

**RUN**

- 도커 이미지가 생성되기 전에 수행할 쉘 명령어

**CMD**

- 컨테이너가 시작되었을 때 실행할 실행 파일 또는 쉘 스크립트
  해당 명령어는 DockerFile내 1회만 사용 가능

---

1. 이제 베이스 이미지부터 실제 값으로 추가해주기
2. 베이스 이미지는 ubuntu를 써도 되고 centos등을 써도 되지만 hello를 출력하는 기능은 굳이 사이즈가 큰 베이스 이미지를 쓸 필요가 없기에 사이즈가 작은 alpine 베이스 이미지를 사용
3. hello 문자를 출력해주기 위해 echo를 사용해야 하는데, 이미 alpine안에 echo를 사용하게 할 수 있는 파일이 있기에 RUN 부분은 생략
4. 마지막으로 컨테이너 시작 시 실행 될 명령어 echo hello를 적어준다

```docker
#베이스 이미지를 명시해준다.
FROM alpine

#추가적으로 필요한 파일들을 다운로드 받는다.
#RUN command

#컨테이너 시작시 실행 될 명령어를 명시해준다.
CMD ["echo", "hello"]
```

# 완성된 도커 파일로 어떻게 이미지를 만드나요?

![image.png](attachment:fc6f263b-657a-49f3-b4ae-c8af030b38d5:image.png)

### **도커 파일에 입력된 것들이 도커 클라이언트에 전달되어서 도커 서버가 인식하게 하여야 합니다.**

`docker bulid ./` 또는 `docker build .`

**Build 명령어는**

- 해당 디렉토리 내에서 dockerfile 이라는 파일을 찾아서 도커 클라이언트에 전달시켜준다
- docker build 뒤에 `./` 와 `.` 는 둘다 현재 디렉토리를 가르킨다.

Step 2/2 자세히 보기

- Step 2에 보면 임시 컨테이너를 생성하고 무언가를 하고 다시 지우는데 왜 그렇게 하는 걸까?

![image.png](attachment:09d94fef-73fc-421a-bcb0-39523e0dbc62:image.png)

![image.png](attachment:2f014947-e70a-4786-9a18-215203f3dd8b:image.png)

![image.png](attachment:42e27041-6073-4736-9b89-49922488df7c:image.png)

![image.png](attachment:dbf5a097-34a8-4ec0-86b8-7ab559688b68:image.png)

![image.png](attachment:b705d321-0b55-4935-9acc-7a359f10d282:image.png)

![image.png](attachment:bbf24ca8-f76e-4492-89f8-c3b3a2cb0c65:image.png)

## 결론

- 베이스 이미지에서 다른 종속성이나 새로운 커맨드를 추가 할 때는 임시 컨테이너를 만든 후 그 컨테이너를 토대로 새로운 이미지를 만든다!!!
- 그리고 그 임시 컨테이너는 지워준다.

![image.png](attachment:cdd06190-2ed6-49a7-a617-65acbe2d9ae0:image.png)

### 도커 이미지에 기억하기 쉬운 이름 주기

![image.png](attachment:ed445405-44c6-4244-ac95-bd290a2230bb:image.png)

docker build -t 나의 도커 아이디 / 저장소/프로젝트 이름 : 버전

⇒ docker build -t devhyun2/print-hello:latest ./
