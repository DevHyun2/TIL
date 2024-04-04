--select문 작성순서 / 실행순서
select--5
from--1
where--2
group by--3
having--4
order by--6

--1.급야를 가장 많이 받는 상위 5명의 직원정보를 조회하시오.
select rownum, aa.*
from(
            select rownum, first_name, salary
            from employees
            order by salary desc)aa
where rownum<6;


--급여 상위 6~10까지 조회
select*
from(
        select rownum rr, aa.*
        from(
                    select rownum, first_name, salary
                    from employees
                    order by salary desc)aa
                    )
where rr between 6 and 10;

select rownum, bb.*
from(
            select rownum rr, aa.*
            from(
                        select rownum, first_name, salary
                        from employees
                        order by salary desc)aa)bb
where rr >= 6 and rr<=10;
 
 --DDL(Data Definition Language) 자동 커밋 : create table~~, drop table, alter table, rename, truncate
 create table emp01(
 empno number(4),
 ename varchar2(20),
 sal number(7,2)
 );
 
 create table emp02(
 empno number(4),
 ename varchar2(20),
 sal number(7,2)
 );
 
 select*from tab;
 
 create table emp_03
 as
 select employee_id, first_name, salary, hire_date
 from employees
 where department_id = 60;
 
 desc emp_03;
 select * from emp_03;
 
 --table 구조는 복사하고 data는 복사하지 않기
 create table emp_04
 as
 select* from employees
 where 1 =0;
 
 select*from emp_03;
 desc emp_03;
 alter table emp_03 add(job varchar2(20);
 alter table emp_03 modify(first_name varchar2(5);
 alter table emp_03 drop column first_name; --주의
 rollback; --불가
 
drop table emp_03; --table삭제
select*from emp01;
truncate table emp01; --구조는 유지, data만 삭제(잘안씀/복구가 안되서)

--DD(Data Dictionary)
select*
from user_tables;

select* from all_tables;

 
 --DML(Data Manipulation Language):insert, delete, update, 자동커밋 아님
 insert into emp01 values(100, '성진', 1000); --같은 session에서는 확인되지만  다른 session에서는 확인 불가
 commit; --DB에 실제로 저장된다
 
 desc emp01;
 
 insert into emp01(empno,ename,sal) values (1,'aa',500);
 insert into emp01(empno,ename,sal) values (1,'aa',500,600); --too many values(error)
 insert into emp01(empno,ename,sal) values (1,aa,500); --column not allowed here(문자 값은 반드시 ''사용 error)
 insert into emp01(empno,sal,ename) values (1,'aa',500); --invalied number (type error)
 insert into emp01(empno,sal) values (1,500); --입력되지 않은 칼럼은 암시적으로 null이다
 insert into emp01(empno,sal) values (2,600);
 insert into emp01(empno,sal, ename) values (3,700, null); --명시적으로 null을 삽입
 
 insert into emp01 values (1,'aa',500);
 insert into emp01 values (1,'aa'); --"not enough values" 칼럼의 개수보다 값이 적다
 
 select*from emp01;
 
 create table emp05
 as
 select employee_id, first_name, salary
 from employees
 where 1=0;
 
 select*from emp05;
 
 insert into emp05
 select employee_id, first_name, salary
 from employees
 where department_id = 60;
 
  insert into emp05
 select department_id,department_name, 0
 from departments;
 
 select*from emp05 order by 1;
 commit; --지금까지 수행한 모든 DML을 DB에 저장한다.
 
 update emp05
 set salary = 30000, first_name = '신한DS'
 where employee_id = 20;
 
 rollback; --commit 이후 지금까지 수행한 모든 DML을 원상복귀한다.
 
 --20번 직원의 급여를 10번 직원의 급여와 같게 만든다.
 update emp05
 set salary = (select distinct salary
                    from emp05
                    where employee_id = 10)
 where employee_id = 20;
 
 select*from emp05 order by 1;
 
 delete
 from emp05
 where employee_id = 10;
 
 --107건
 create table emp06
 as
 select*from employees;
 
  create table emp08
 as
 select*from employees
where job_id = 'IT_PROG';
 
 
 select*from emp06;
 select*from emp08;
 
 update emp08 set job_id = 'firstzone';
 commit;
 
 insert into emp08 values(999,'a','b','zz','1234',sysdate, 'aa',1000,0.1,100,60);
 
 create table emp06
as
select * from employees;

create table emp08
as
select * from employees where job_id = 'IT_PROG';

update emp08 set job_id = 'firstzone';
commit;

select * from emp06;
select * from emp08;

insert into emp08 values(999, 'a','b', 'zz', '1234',sysdate, 'aa',1000, 0.1, 100, 60);
merge into emp06 using emp08 on(emp06.employee_id = emp08.employee_id)
when matched then
        update set emp06.job_id = emp08.job_id
when not matched then
        insert   values(
                        emp08.employee_id,
                        emp08.first_name,
                        emp08.last_name,
                        emp08.email,
                        emp08.phone_number,
                        emp08.hire_date,
                        emp08.job_id,
                        emp08.salary,
                        emp08.commission_pct,
                        emp08.manager_id,
                        emp08.department_id);
 
 
 
 
commit;
rollback;

----------------------------- 자바로 옮기기
select * from employees where department_id = 60 and job_id = 'IT_PROG' and hire_date >= sysdate - 20*365 and salary >= 0;

select * from employees;

inseret into employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

update employees
set EMPLOYEE_ID = ?,
     FIRST_NAME = ?,
     LAST_NAME = ?,
     EMAIL = ?,
     PHONE_NUMBER = ?,
     HIRE_DATE = ?,
     JOB_ID= ?,
     SALARY = ?,
     COMMISSION_PCT = ?,
     MANAGER_ID = ?,
     DEPARTMENT_ID = ?
 where employee_ID = ?

select*from employees;

select * from user_constraints where constraint_name = 'EMP_MANAGER_KF';
select * from user_cons_columns where constraint_name = 'EMP_MANAGER_KF';

--CONSTRAINT
---테이블 생성
DROP TABLE CUSTOMER;
DROP TABLE CUSTOMER2;

--FOREIGN KEY : 외래키, 참조키, 다른테이블(같은테이블)의 PK를 참조한다.
--DEFAULT 값은 제약조건보다 앞부분에 정의한다.
--칼럼 레벨에서 정의하기
CREATE TABLE CUSTOMER
    (
    cust_id number  constraint customer_cust_id_pk  primary key, -- NOT NULL + UNIQUE
    cust_name varchar2(30) not null, -- 반드시 입력해야 한다
    email varchar(30)  constraint customer_email_uk  unique, --유일한 값, NULL 가능
    deptid number  constraint  customer_deptid_fk   references departments(department_id), --참조키, 반드시 부모키가 존재해야 한다
    point2 number constraint customer_point_check  check ( point2 > 0), -- CHECK 조건에 만족해야 한다
    gender char(3)  default '남'   constraint customer_gender_check check (gender in ('남','여' ))-- 한글 1자는 3바이트(UTF-8)
    );

--테이블 레벨에서 정의하기
create table customer2
        (
        cust_id number ,
        cust_name varchar2(30)  not null ,
        email varchar(30) ,
        deptid number ,
        point2 number,
        gender char(3) default '남',
        constraint customer_cust_id_pk2  primary key(cust_id),
        constraint customer_email_uk2  unique(cust_name),
        constraint  customer_deptid_fk2  foreign key(deptid)   references departments(department_id),
        constraint customer_point_check2  check ( point2 > 0) ,
        constraint customer_gender_check2 check ( gender in ('남','여' ) )
        );


INSERT INTO CUSTOMER(CUST_ID, CUST_NAME) VALUES(1, '김길동');
INSERT INTO CUSTOMER(CUST_ID, CUST_NAME, EMAIL) VALUES(2, '김길동', 'EMAIL');
INSERT INTO CUSTOMER(CUST_ID, CUST_NAME, EMAIL) VALUES(3, '김길동', 'EMAIL');
INSERT INTO CUSTOMER(CUST_ID, CUST_NAME, EMAIL, DEPT_ID) VALUES(4, '김길동2', 'EMAIL2', 1111);
INSERT INTO CUSTOMER(CUST_ID, CUST_NAME, EMAIL, DEPT_ID, POINT2) VALUES(5, '김길동2', 'EMAIL2', 10, 100);
INSERT INTO CUSTOMER(CUST_ID, CUST_NAME, EMAIL, DEPT_ID, POINT2, GENDER) VALUES(6, '김길동3', 'EMAIL3', 10, 100, '남');

SELECT * FROM USER_CONSTRAINTS;
--조회
SELECT * FROM CUSTOMER;