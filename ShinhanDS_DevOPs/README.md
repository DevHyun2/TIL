# DAY 1

## 기본소개

- 점심시간: 13:00~14:00
- 강사: 최국현
- 메일: tang@linux.com

## 메모파일

```text
https://github.com/
> tangt64/
>> training_memos
>>> government-training
>>>> FZ
```

http://192.168.0.39/files/

https://download.rockylinux.org/pub/rocky/9/isos/x86_64/Rocky-9.4-x86_64-minimal.iso

https://miro.com/welcomeonboard/MWVBWElYczFtMEZsRmdleFlJdHA3MGNVNW1sRDcwS054RGJoUFlRTVUzZjlaRms1a0xNSTVaaU9uaEo5SlpjQ3wzNDU4NzY0NTg1NjQ5MDkwMzU0fDI=?share_link_id=716260514452


https://learn.microsoft.com/ko-kr/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package

1. 리눅스 사용 경험
2. 컨테이너(docker)

## 환경준비

### 설치

```bash
dnf search podman
> podman
> podman-docker
dnf install podman podman-docker -y
podman search httpd
> ~~~
podman pull quay.io/fedora/httpd-24
podman images
> REPOSITORY               TAG         IMAGE ID      CREATED     SIZE
> quay.io/fedora/httpd-24  latest      9322d4821d77  5 days ago  419 MB
podman run -d --name tang-httpd quay.io/fedora/httpd-24
> 2d46718e89d887ab622166fede1df26bcf000726ada0e7e970d98ec94ea63521
podman container ls
> CONTAINER ID  IMAGE                           COMMAND               CREATED        STATUS        PORTS       NAMES
2d46718e89d8  quay.io/fedora/httpd-24:latest  /usr/bin/run-http...  9 seconds ago  Up 9 seconds              tang-httpd
podman container stop --all
podman container rm --all
podman container ls --all

dnf install httpd -y 
systemctl enable --now httpd.service
echo "hello apache" > /var/www/html/index.html
systemctl status httpd
curl localhost/index.html                           ## 80/TCP
> hello apache

systemctl is-active httpd

mkdir htdocs
echo "hello apache from container" > htdocs/index.html
ls -l htdocs/
> index.html
cat htdocs/index.html
> hello apache from container

setenforce 0              ## 보안 비활성화
getenforce
> Permissive
systemctl stop firewalld      ## 보안 비활성화
systemctl is-active firewalld
> inactive


podman run -d --name tang-httpd -p8080:8080 -v /root/htdocs/:/var/www/html  quay.io/fedora/httpd-24
podman container ls
> tang-httpd
curl localhost:8080
> hello apache from container

```

## 설명

컨테이너는 기본적으로 이미지 기반으로 프로그램을 실행.

- hub.docker.io
- quay.io

1. selinux, firewalld 두 개에 대해서 답변.

```bash
podman run -d --pod apace -p 8080:8080 -v /root/container2/:/var/www/html --name container2 quay.io/fedora/httpd-24
getenforce 
> Permissive
setenforce 1
```
2. 컨테이너 실행이 잘 안되는 부분.


```bash
podman run -d --pod apace -p 8080:8080 -v /root/container2/:/var/www/html --name container2 quay.io/fedora/httpd-24

podman [____]  [_____]  [_____]   [____]
       명령어       옵션들         이미지
       verbe      options         target

nano /etc/containers/regsitries.conf
> unqualified-search-registries = ["quay.io"]
podman search centos
> quay.io/centos/centos              

```

### 이미지 태그 확인하기

1. URI: http, https
2. URL: 주소정보를 가지고 있음.

```bash
dnf search container-tools
> container-tools
dnf install container-tools -y
skopeo list-tags docker://quay.io/centos/centos  
                 ------ -----------------------
                 URI    URL
podman run centos/centos:stream9
       --- ---------------------
        \   URL+TAG(version)
         \
          `---> subcommand            


podman run -it centos/centos:stream9 /bin/bash
           ---
           \
            \
             `---> -i: interactive, -t: tty

podman run -it -p8080:80 centos/centos:stream9 /bin/bash
> dnf install httpd -y
> wget https://ko.wordpress.org/latest-ko_KR.tar.gz -O /var/www/html/wordpress.tar.gz
> tar xzf /var/www/html/wordpress.tar.gz -C /var/www/html
> mv /var/www/html/wordpress/* /var/www/html/
> dnf install php php-mysqlnd -y
> httpd -DFOREGROUND
```


## 랩 시간!!

- 가상머신 재구성 혹은 제거 후, 다시 설치진행. 리눅스 버전은 로키리눅스로 진행.
- 포드만이 설치가 되어 있지 않는 경우, Podman설치.
- 이미지 내려받는 기본 주소를 quay.io로 기본 값 변경.
  * /etc/containers/registries.conf

1. fedora/httpd-24
2. fedora/mariadb-105

1번 이미지 포트 8080/TCP로 노출 및 실행한다. 
2번 이미지 포트를 8443/TCP로 노출 및 실행한다.

```bash
podman container stop --all
podman container rm --all
```

```bash
podman run -d -p8080 fedora/httpd-24
podman run -d -p443 -e MYSQL_USER=wordpress -e MYSQL_PASSWORD=wordpress -e MYSQL_DATABASE=wordpress fedora/mariadb-105

podman container ls
> 42851e76a2e6  quay.io/fedora/httpd-24:latest     /usr/bin/run-http...  28 minutes ago  Up 28 minutes  0.0.0.0:46205->8080/tcp  nostalgic_babbage
> 56e780d92c38  quay.io/fedora/mariadb-105:latest  run-mysqld            27 minutes ago  Up 27 minutes  0.0.0.0:35885->8443/tcp  elegant_yalow
curl localhost:<PORT> | grep head -2
mysql -uwordpress -pwordpress -h <VM_IP> -P <PORT>

```

### 연습문제


fedora/httpd-24 웹 서버 이미지.

```bash
## container 1~3
mkdir ~/htdocs/
echo "Hello httpd-test-server" > ~/htdocs/index.html
podman run -d --name httpd-test-1 --rm -p 18081:8080 -v /root/htdocs/:/var/www/html fedora/httpd-24
podman run -d --name httpd-test-2 --rm -p 18082:8080 fedora/httpd-24
podman run -d --name httpd-test-3 --rm -p 18083:8080 fedora/httpd-24

podman exec -it httpd-test-2 ls -l /var/www/html
podman logs httpd-test-2


## container 4
mkdir ~/htdocs/
echo "Hello httpd-test-server" > ~/htdocs/index.html
podman run -d --name httpd-test-1 -p 18082:8080 -v /$USER/htdocs:/var/www/html

curl localhost:18081~18082
```
[포드만 컨테이너](https://developers.redhat.com/blog/2019/01/15/podman-managing-containers-pods)

# DAY 2

## 오늘까지 포드만 기초 계속!! :)

1. [구글미팅](https://meet.google.com/bnt-hqxu-obq)
2. [미로](https://miro.com/welcomeonboard/MWVBWElYczFtMEZsRmdleFlJdHA3MGNVNW1sRDcwS054RGJoUFlRTVUzZjlaRms1a0xNSTVaaU9uaEo5SlpjQ3wzNDU4NzY0NTg1NjQ5MDkwMzU0fDI=?share_link_id=704362905436)


### 호스트 설정

```bash
hostnamectl
> localhost
hostnamectl set-hostname deploy-app.example.com
hostnamectl
> Static hostname: deploy-app.example.com
hostname
> deploy-app.example.com
dnf search hyperv
> hyperv-daemons.x86_64 : Hyper-V daemons suite
> hyperv-daemons-license.noarch : License of the Hyper-V daemons suite
> hyperv-tools.noarch : Tools for Hyper-V guests
> hypervfcopyd.x86_64 : Hyper-V FCOPY daemon
> hypervkvpd.x86_64 : Hyper-V key value pair (KVP) daemon
> hypervvssd.x86_64 : Hyper-V VSS daemon
dnf install hyperv-* -y && reboot
```

### 연습문제 풀이(tomcat)

```bash
podman pull quay.io/openshift-examples/tomcat-example:tomcat
podman run -d --name tomcat-test-1 --rm openshift-examples/tomcat-example:tomcat
podman container ls
podman run -d --name tomcat-test-2 --rm -p 18080:8080 openshift-examples/tomcat-example:tomcat
podman run -d --name httpd-test-3 --rm -p 18081:8080 -v /root/htdocs/:/var/www/html/ fedora/httpd-24
podman container ls
```
```bash
podman create -d --name httpd-test-4 -p 18082:8080 -v /root/htdocs/:/var/www/html/ fedora/httpd-24
podman create  --name httpd-test-5 -p 18085:8080 -v /root/htdocs/:/var/www/html/ fedora/httpd-24
podman start httpd-test-5
podman start httpd-test-4
```

### volume + scp


```bash
WINDOW@ scp .\index.html root@172.23.134.126:/root/
LINUX@ tar cf index.html.tar index.html
LINUX@ podman volume import httpd index.html.tar
```
```bash
nano Dockerfile

ARG IMAGE_VERSION=39
FROM quay.io/fedora/fedora:${IMAGE_VERSION}
LABEL version="1.0"
EXPOSE 80
ENV SOURCE_DIR=/usr/local/src/kernel
RUN dnf install httpd -y
WORKDIR /var/www/html
VOLUME /var/www/html
COPY htdocs/index.html .
USER APACHE
CMD ["/usr/sbin/httpd", "-DFOREGROUND"]
```
```bash
podman build .
podman images
> <none>                                     <none>      fad120655602  24 seconds ago  512 MB
```

1. ubutun, 
2. ~~centos~~, rockylinux, quay.io/rockylinux/rockylinux:9

로키 리눅스로 이미지 빌드 후, 컨테이너 80포트로 접근 후 여러분이 만드신 index.html확인 후 밥먹으로 가기! :)

```bash
mkdir rockylinux-httpd
cd rockylinux-httpd
nano Dockerfile

FROM {{ ROCKYLINUX_IMAGE }}
LABEL devel: poc
EXPOSE 80
RUN dnf install httpd httpd-core -y && dnf clean all
VOLUME /var/www/html
COPY /root/htdocs-rockylinux/index.html /var/www/html
CMD ["/usr/sbin/httpd", "-DFOREGROUND"]
```

### 레지스트리

```bash
podman run -d --name docker-registry -p5000:5000 docker.io/opensuse/registry
podman container start docker-registry


podman build . 

nano /etc/containers/regsitries.conf
> unqualified-search-registries = ["quay.io","localhost:5000"]
> short-name-mode = "enforcing"

podman tag 98fa8fd00c62 localhost:5000/tang/httpd:v1
podman push --tls-verify=false localhost:5000/tang/httpd:v1

skopeo list-tags --tls-verify=false docker://localhost:5000/tang/httpd

```

### 패키징

[동물병원](https://github.com/spring-projects/spring-petclinic)

위의 코드를 가지고 CI/CD이전 단계인 패키징을 다루도록 한다. 개발중인 코드는 분석이 끝나면 활용.(아니면말구!)

```bash
cd ~
dnf install maven-openjdk17.noarch -y
dnf install git -y 

git clone https://github.com/spring-projects/spring-petclinic.git
cd spring-petclinic
./mvnw package
java -jar target/*.jar
```

### 오늘의 랩

1. 위의 petclinic를 컨테이너 이미지로 패키징 한다. 외부에서 접근이 되지 않아도 상관은 없다. 
2. 이미지 빌드 시, 반드시 git으로 clone과정이 포함이 되어야 한다.
3. clone된 소스코드는 컨테이너 이미지 빌드 과정에서 같이 컴파일이 되어야 한다.(maven, glade 무관)
4. 컴파일 된 petclinic은 아래와 같은 명령어로 실행이 된다.


```bash
mkdir rockylinux-petclinic
cd rockylinux-petclinic
nano Containerfile

FROM quay.io/rockylinux/rockylinux:9
EXPOSE 8080
RUN dnf install maven-openjdk17.noarch -y
RUN dnf install git -y 

RUN git clone https://github.com/spring-projects/spring-petclinic.git

WORKDIR spring-petclinic
RUN cp target/spring-petclinic-3.3.0-SNAPSHOT.jar /
CMD ["java","-jar","/spring-petclinic-3.3.0-SNAPSHOT.jar"]
```


# DAY 3

## 컨테이너 마지막

오늘은 Podman기반으로 마지막 강의.

### 이미지 빌드(계속)



### 이미지 태그 및 업로드

이미지 태그...

1. 일반적이 이미지가 빌드가 되면 메타 정보가 없음.
2. 업로드 할 서버나 혹은 이름 변경이 필요시 사용. 

```bash
podman tag <IMAGE_ID> localhost:5000/tang/test:v1
                                     tang/test      ## latest으로 자동설정  
podman untag quay.io/fedora/httpd-24
podman images
podman save -o
pomand load -i
```

### 다중 컨테이너(POD)


### 포드만 연습문제

앞서 사용한 "petclinic"소스코드 기반으로 다음과 같은 작업을 수행한다. 이미지 빌드 시, 사용하는 명령어 및 설정 부분은 이전에 사용한 Containerfile기반으로 수행한다.

1. petclinic를 v2로 릴리즈한다.
2. 위의 릴리즈는 반드시 "Containerfile", "Dockerfile"기반으로 컨테이너 이미지로 패키징한다. 
3. 빌드된 이미지는 레지스트리 서버에 업로드 한다. 애플리케이션 이름은 petclinic, 버전은 v2로 한다.
4. 빌드한 이미지 기반으로 서비스를 실행한다. 
5. 서비스에 접근 가능한 포트는 28080으로 접근이 가능해야 한다. 

# DAY 4

## CI/CD

[레드햇 CI/CD 설명](https://www.redhat.com/ko/topics/devops/what-is-ci-cd?page=8)

### CI/CD개념 설명

### 쿠버네티스(Single On Node Kubernetes) 구성

포드만 PDF SNK 세션 참조.


# DAY 5

### 시스템 장애처리

만약, 리부팅 이후에 쿠버네티스 올바르게 동작되지 않으면..

```bash
swapon -s         ## 확인
> Filename                                Type            Size            Used            Priority
> /dev/dm-1                               partition       4141052         0               -2
swapoff -a
nano /etc/fstab       ## 주석처리
> #/dev/mapper/rl-swap     none                    swap    defaults        0 0
systemctl daemon-reload
systemctl restart kubelet
getenforce
> enforcing
setenforce 0
nano /etc/selinux/config
> SELINUX=permissive 
```

### 런타임 설정(--tls-verify=false)

CRIO런타임 이미지 다운로드 설정. 아래 내용 추가. 

```bash
nano /etc/crio/crio.conf.d/10-crio.conf
> [crio.image]
> ...
> insecure_registries = [ "192.168.10.250:5000" ]
> registries = [ "192.168.10.250:5000" ]    
> ...
systemctl restart crio
```

### 테크톤 설치

[테크톤 허브 사이트](https://hub.tekton.dev/?query=kube)


```bash
kubectl apply -f https://storage.googleapis.com/tekton-releases/operator/previous/v0.70.2/release.yaml
wget https://github.com/tektoncd/cli/releases/download/v0.32.0/tkn_0.32.0_Linux_x86_64.tar.gz 

mkdir ~/bin/
tar xf tkn_0.32.0_Linux_x86_64.tar.gz  -C ~/bin/

kubectl apply -f https://api.hub.tekton.dev/v1/resource/tekton/task/buildah/0.7/raw
kubectl apply -f https://api.hub.tekton.dev/v1/resource/tekton/task/kubernetes-actions/0.2/raw

tkn task list
```

```yaml
nano hello.yaml
apiVersion: tekton.dev/v1beta1
kind: Task
metadata: 
  name: hello
spec:
  steps:
    - image: quay.io/centos/centos
      command: 
        - /bin/bash
        - -c
        - echo "Hello World"
```

```bash
kubectl create -f hello.yaml
kubectl get tasks
tkn task list       
tkn task start hello --showlog
> TaskRun started: hello-run-782d4
> Waiting for logs to be available...
> [unnamed-0] Hello World
```

# DAY 6




# DAY 7

# DAY 8(히히 오후 강의만! :))
