# 기본적인 도커 클라이언트 명령어 알아보기

![image.png](attachment:798cdc97-efb6-4b76-90e9-9c924df1e424:image.png)

### ex) docker run alpine ls

![image.png](attachment:cb4f4b5b-1ceb-40f9-8e86-3a362c4e984c:image.png)

1. Alpine 이미지를 이용해서 컨테이너를 생성
2. 생성할 때 Alpine 이미지 안에 들어있던 파일 스탭샷들(bin, dev, etc 등등)이 컨테이너 안에 있는
   하드디스크로 다운로드 됨
3. 이미지 이름 뒤에 다른 명령어를 더 붙여서 원래 이미지 안에 들어있는
   기본 커맨드는 무시가 되고 ls 명령어가 실행됨

## 하지만 어떻게 Alpine 이미지를 이용해 ls 명령어를 실행가능?

- Alpine 이미지 파일 스냅샷안에 이미 ls를 사용 사능하게 하는 파일이 있음.

## Hello-world 이미지로는 ls 명령어 사용 불가능

- docker run hello-world ls 하면 아래와 같은 오류가 뜸
- 설명을 보면 excutable file not found.(실행할 수 있는 파일을 못찾음)

![image.png](attachment:c96ebe61-2d24-4877-92cb-331719d2e555:image.png)

# 컨테이너들 나열하기

### 현재 실행중인 컨테이너 나열

docker ps

![image.png](attachment:e4783bcf-5321-40fc-b8fb-3939dc34ed1a:image.png)

![image.png](attachment:ce136880-edd6-4221-851e-0b2b2f1cfa80:image.png)

### 실습

1. 2개의 Terminal을 작동시킵니다.
2. 첫 번째 Terminal에서 container 하나를 실행
   (하지만 이 때 컨테이너를 켰다가 바로 끄면 3번을 할 때 이미 프로세스가 꺼져있기 때문에 리스트에서 볼 수 없음)
3. 그리고 두번 째 Terminal에서 docker ps로 확인
4. 그러면 꺼져있는 container도 확인하고 싶다면?

**모든 컨테이너 나열**

docker ps -a

![image.png](attachment:462e3d35-10df-4e55-97f1-ea58bc3932d3:image.png)

### 이미지 설명

1. CONTAINER ID : 컨테이너의 고유한 아이디 해쉬 값. 실제로는 더욱 길지만 일부분만 표출
2. IMAGE : 컨테이너 생성시 사용한 도커 이미지
3. COMMAND : 컨테이너 시작시 실행될 명령어. 대부분 이미지에 내장되어 있으므로 별도 설정 필요X
4. CREATED : 컨테이너가 생성된 시간
5. STATUS : 컨테이너의 상태. 실행중은 UP, 종료는 Exited, 일시정지 Pause.
6. PORTS : 컨테이너가 개방한 포트와 호스트에 연결한 포트. 특별한 설정을 하지 않는 경우 출력X
7. NAMES : 컨테이너 고유한 이름. 컨테이너 생성시 —name 옵션으로 이름을 설정하지 않으면 도커 엔진이 임의로 형용사와 명사를 조합해 설정.
   id와 마찬가지로 중복이 안되고 docker rename명령어로 이름을 변경할 수 있음.
   docker rename original-name changed-name

### 원하는 항목만 보기

docker ps —format ‘table{{.Names}}/talbe{{.IMAGE}}’

![image.png](attachment:82a49762-cf68-4e4c-8cfe-08ee72d02c95:image.png)

# 도커 컨테이너의 생명주기

![image.png](attachment:ccb4bea2-761c-475b-9896-0668c08917f6:image.png)

Docker run <이미지 이름> = Docker create<이미지 이름> + Docker start<컨테이너 아이디/이름>

docker create hello-world

![image.png](attachment:c5b6e082-4fde-466a-bbf7-456723cb815b:image.png)

- ID가 생성됨

![image.png](attachment:581bcdf3-fb95-47fd-b38d-83efd2bee0fa:image.png)

docker start -a <ID>

![image.png](attachment:819efa11-556f-43ae-bf71-90563f592cb2:image.png)

-a → attach의 줄임말

docker start <ID>

![image.png](attachment:9aebc471-95fd-41e3-99d5-e87b3b001975:image.png)

# docker stop vs docker kill

### 도커의 생명주기중에서 중지 부분

docker stop 과 docker kill로 중지할 수 있습니다.

docker stop <컨테이너의 아이디 또는 이름>

docker kill <컨테이너의 아이디 또는 이름>

![image.png](attachment:effad976-3170-450a-a0aa-5fbf45af702f:image.png)

## Stop과 Kill의 차이점

1. `Stop`은 Gracefully(자비롭게)하게 중지를 시킵니다.
   1. 자비롭게 그동안 하던 작업들을(메시지를 보내고 있었다면 보내고 있던 메시지)완료하고 컨테이너를 중지 시킨다.
2. `Kill` 같은 경우는 Stop과 달리 어떠한 것도 기다리지 않고 바로 컨테이너를 중지 시킵니다.

![image.png](attachment:92e92920-54ad-49a7-b87a-e137089f2b42:image.png)

# 컨테이너 삭제하기

![image.png](attachment:e48d370e-761d-45e3-bdfa-8b59b3d806f7:image.png)

### 중지된 컨테이너를 삭제하고 싶다면?

docker rm <아이디/이름>

- 실행중인 컨테이너는 먼저 중지한 후에 삭제 가능

![image.png](attachment:0579c588-de19-49e0-b7fa-16e820f58ff3:image.png)

### 모든 컨테이너를 삭제하고 싶다면?

docker rm `docker ps -a -q` (백틱)

![image.png](attachment:7bc5cddd-1a23-4945-a93d-36287cb6f5d8:image.png)

### 이미지를 삭제하고 싶다면?

docker rmi <이미지id>

### 한번에 컨테이너, 이미지, 네트워크 모두 삭제하고 싶다면?

docker system prune

- 도커를 쓰지 않을 때 모두 정리하고 싶을 때 사용해주면 좋음
- 하지만 이것도 실행중인 컨테이너에는 영향을 주지 않음

# 실행중인 컨테이너에 명령어 전달

### 이미 실행중인 컨테이너에 명령어를 전달하고 싶다면?

docker exec <컨테이너 아이디>

1. 먼저 터미널 2개를 실행
2. 첫 번째 터미널에서 컨테이너 하나를 실행
   (docker run alpine ping localhost)
3. 두 번째 터미널에서 컨테이너가 잘 작동하고 있는지 확인하고 명령어를 전달
   (docker exec <컨테이너아이디> ls)

### docker run vs docker exec

1. docker run은 새로 컨테이너를 만들어서 실행
2. docker exec은 이미 실행중인 컨테이너에 명령어를 전달

# 레디스를 활용한 컨테이너 이해

![image.png](attachment:6c429b56-caa0-4d4f-b5eb-e8903cd4de96:image.png)

위의 도표와 같이 먼저 레디스 서버를 실행 한 후, 레디스 클라이언트를 통해 서버에 명령어를 전달

1. 먼저 첫 번째 터미널을 실행 후, 레디스 서버 작동
   docker run redis
2. 그 후 레디스 클라이언트를 켜야 하는데 첫 번째 터미널에서 아무것도 할 수 없음.
   그러니 두 번째 터미널을 켜서 레디스 클라이언트를 작동
   redis-cli
3. 에러가 날 것 → 왜 why?

![image.png](attachment:ba28d9a4-0a9a-4e42-8501-8cab72266c69:image.png)

**redis 클라이언트가 레디스 서버가 있는 컨테이너 밖에서 실행을 하려 하니 redis 서버에 접근을 할 수가 없기에
reids 클라이언트를 작동하려 할 때 에러가 발생**

그렇다면 어떻게 사용할 수 있을까?

→ redis 클라이언트도 컨테이너 안에서 실행을 시켜야 한다.

1. 먼저 이전과 똑같이 첫 번째 터미널을 킨 후, 레디스 서버 작동
   docker run redis
2. 이제는 이전 시간에 배운 exec을 써먹을 차례.
   그러니 redis 서버가 실행중인 컨테이너에 exec을 이용하여 redis 클라이언트도 실행해보자.
   docker exec -it <컨테이너 아이디> redis-cli

![image.png](attachment:5a84ff1b-d181-41b0-b81a-d5d7c1b21713:image.png)

### -it 란?

![image.png](attachment:349da2db-ef54-4199-872a-998c70a2b4cb:image.png)

-i interactive(상호적인)

-t terminal

-i + -t = -it

### redis-cli

![image.png](attachment:e5c54620-8e2d-4480-8fd0-7fb1c9b5fe47:image.png)

# 실행중인 컨테이너에서 터미널 생활 즐기기

![image.png](attachment:3f68934c-a0f5-4b48-98e0-6467275e90c6:image.png)

![image.png](attachment:523da648-c301-4aab-92a2-82d7d247dd2b:image.png)

sh → sh, bash, zsh, powershell

# 컨테이너를 쉘 환경으로 접근해보기

1. 먼저 첫 번째 터미널을 실행 한 후, alpine 이미지를 이용해서 컨테이너 실행
   docker run alpine ping localhost
2. 그 후 exec을 이용하고 마지막 명령어 부분에 sh를 입력한 후 컨테이너 안에서 터미널 환경을 구축
   docker exec -it 컨테이너 아이디 sh
3. 그 안에서 여러가지 터미널에서 원래 할 수 있는 작동들을 해보기
   -ls → 컨테이너 디렉토리에 있는 내용 확인
   -touch new-file → 파일 생성
   -export hello=hi / echo $hello → 변수 생성 출력

![image.png](attachment:fdf3e639-1e3b-4654-9646-fbc1541e5add:image.png)

### 터미널 환경에서 빠져 나오려면 control + D
