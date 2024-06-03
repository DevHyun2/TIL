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

setenforce 0  						## 보안 비활성화
getenforce
> Permissive
systemctl stop firewalld			## 보안 비활성화
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


https://developers.redhat.com/blog/2019/01/15/podman-managing-containers-pods

# DAY 2

# DAY 3

# DAY 4

# DAY 5

# DAY 6

# DAY 7

# DAY 8

히히 오후 강의만! :)
