-- 급여를 가장 많이 받는 상위 5명 조회
select rownum, aa.* 
from (
            select  first_name, salary
            from employees
            order by salary desc
            )aa
where rownum <= 5;

-- 급여를 가장 많이 받는 5번째 직원 조회
select *
from(
            select rownum rr, aa.* 
            from (
                        select  first_name, salary
                        from employees
                        order by salary desc
                        )aa
            )bb
where bb.rr = 5;

--row_number() : 중복없이 전체 순위 지정
--rank() : 중복랭크제외 순서 지정
--dense_rank() : 중복랭크를 하나의 순서로 지정

SELECT *
FROM(
            select  first_name, salary, 
                    row_number() over (order by salary desc) 랭크1,
                    rank() over (order by salary desc) 랭크2,
                    dense_rank() over (order by salary desc) 랭크3
            from employeeS
            )
WHERE ROWNUM <= 5;

------------------------------------------------------
--테이블 복사(EMPLOYEES -> EMP_COPY) : 제약조건중 not null만 복사됨
--테이블 복사(DEPARTMENTS -> DEPT_COPY)

--DDL(create table, drop table, rename, truncate) : 자동 commit 됨
CREATE TABLE EMP_COPY
AS
SELECT * FROM employees WHERE DEPARTMENT_ID = 60;

CREATE TABLE DEPT_COPY
AS
SELECT  * FROM departments WHERE MANAGER_ID IS NOT NULL;

--제약조건 확인방법
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_COPY';
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'EMP_COPY';

SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'DEPT_COPY';

--제약조건 추가하기
ALTER TABLE EMP_COPY ADD CONSTRAINT EMP_COPY_EMPID_PK PRIMARY KEY(EMPLOYEE_ID);
ALTER TABLE DEPT_COPY ADD CONSTRAINT DEPT_COPY_EMPID_PK PRIMARY KEY(DEPARTMENT_ID);

ALTER TABLE EMP_COPY ADD CONSTRAINT EMP_COPY_DEPTID_FK FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPT_COPY(DEPARTMENT_ID);

--제약조건 없애기
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_COPY_EMPID_PK; --Remove all references to the key before the key is to be dropped
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_COPY_EMPID_PK CASCADE; -- cascade : 부모가 없애면 자식도 없애라

--조회하기
SELECT * FROM EMP_COPY;
SELECT * FROM DEPT_COPY;

--DML(insert, delete, update) : 자동 commit아님, 커밋 필요, 저장 취소 rollback
--무결성 : 잘못된 데이터는 입력 불가
            --NOT NULL, PK, FK, UNIQUE, CHECK
INSERT INTO EMP_COPY VALUES(103,'AA','BB','CC','444',SYSDATE,'AA',1000,NULL,333,77); --unique constraint (HR.EMP_COPY_EMPID_PK) violated
INSERT INTO EMP_COPY VALUES(109,'AA','BB','CC','444',SYSDATE,'AA',1000,NULL,333,77); --존재하지 않는 부서//FK 지정 안되어 있음 -> 삽입 가능

INSERT INTO EMP_COPY VALUES(108,'AA','BB','CC','444',SYSDATE,'AA',1000,NULL,333,100);--FK 지정으로 제약조건 맞추기 -> 존재하는 부서만 삽입 가능

DELETE FROM EMP_COPY WHERE DEPARTMENT_ID = 77;

------------------------------------------------------------------------
--가상 테이블 뷰
--select문만 저장, view를 통해서 테이블을 이용
--OR REPLACE : 존재하면 대체함
--NOFORCE : 컴파일 오류이면 생성불가
--FORCE : 컴파일 오류여도 생성
CREATE VIEW EMP_DEPT60_VIEW
AS
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 60;

CREATE OR REPLACE VIEW EMP_DEPT60_VIEW
AS
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 60;

CREATE OR REPLACE FORCE VIEW EMP_DEPT60_VIEW
AS
SELECT * FROM EMPLOYEES2 WHERE DEPARTMENT_ID = 60; --경고: 컴파일 오류와 함께 뷰가 생성되었습니다

CREATE OR REPLACE NOFORCE VIEW EMP_DEPT60_VIEW
AS
SELECT * FROM EMPLOYEES2 WHERE DEPARTMENT_ID = 60; -- "table or view does not exist"

CREATE VIEW EMP_DEPT60_VIEW
AS
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 60 WITH CHECK OPTION; -- 조건의 칼럼 데이터를 바꿀 수 없게 만들기

--만들어 둔 VIEW  조회
SELECT * FROM USER_VIEWS; --DATA사정 검사, SELCET문이 저장되어 있음

SELECT * FROM EMP_DEPT60_VIEW; -- VIEW를 통해서 실제 TABLE의 DATA를 조회

--데이터 변경
UPDATE EMP_DEPT60_VIEW
SET SALARY = 9999
WHERE EMPLOYEE_ID = 107;

ROLLBACK;

UPDATE EMP_DEPT60_VIEW
SET SALARY = 90
WHERE EMPLOYEE_ID = 107;


--직원이 근무하는 부서의 나라이름을 출력하시오
--복잡한 SQL문이 자주 사용된다면 VIEW로 만들어 놓는다. DML은 불가
DROP VIEW EMP_COUNTRY_VIEW;

Create View Emp_Country_View
As
Select Employees.First_Name, Countries.Country_Name,Region_Id
From Employees, Departments, Locations, Countries
Where Employees.Department_Id = Departments.Department_Id
And Departments.Location_Id = Locations.Location_Id
And Locations.Country_Id = Countries.Country_Id;

SELECT * FROM USER_VIEWS;

SELECT * 
FROM EMP_COUNTRY_VIEW JOIN REGIONS USING(REGION_ID);

--------------------------------
--자동번호 시퀀스(ORACLE에만 있음
--1부터 시작해서 1씩 증가한다
CREATE SEQUENCE BOARD_SEQ;

CREATE TABLE BOARD
            (
            BNO NUMBER CONSTRAINT BOARD_BNO_PK PRIMARY KEY,
            TITLE VARCHAR2(50) NOT NULL,
            CONTENT VARCHAR2(2000),
            WRITER VARCHAR2(30),
            CREATE_DATE DATE DEFAULT SYSDATE
            );            

--데이터 삽입
INSERT INTO BOARD(BNO, TITLE) VALUES(999, '금요일');
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '금요일', '꽃구경가기', 'JIN', SYSDATE); --중간에 사라진 번호를 채우지 않음

--데이터 삭제
DELETE FROM BOARD WHERE BNO = 5;

--출력
SELECT * FROM BOARD;

SELECT * FROM USER_SEQUENCES;

SELECT * FROM DEPARTMENTS;
INSERT INTO DEPARTMENTS VALUES(DEPARTMENTS_SEQ.NEXTVAL, 'TEST', NULL, NULL);


-----------------------------------------------
--INDEX(색인) : 목적은 검색속도 향상, 단점- 만드는 시간이 소요, 공간을 차지
--ORACLE은 PRIMARY KEY가 자동으로 INDEX로 만들어진다. 추가가 가능
--INDEX설정한 칼럼을 조작하면(함수사용), INDEX는 사용되지 않게 되므로 주의한다.
SELECT * FROM USER_IND_COLUMNS WHERE TABLE_NAME = 'EMPLOYEES';

SELECT *  FROM  EMPLOYEES
WHERE INITCAP(first_name) = 'Alexander';

--실행계획 보는 방법
EXPLAIN PLAN FOR 
SELECT *  FROM  EMPLOYEES
WHERE INITCAP(first_name) = 'Alexander';

EXPLAIN PLAN FOR 
SELECT *  FROM  EMPLOYEES
WHERE first_name = 'Alexander';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);
-------------------------


----INDEX 있을 때, 없을 때 비교
CREATE TABLE EMP_COPY2 --구조와 데이터 복사, NOT NULL 제약조건 복사, 나머지 제약조건 복사X
AS
SELECT * FROM EMPLOYEES;

CREATE TABLE EMP_COPY3
AS
SELECT * FROM EMPLOYEES;

INSERT INTO EMP_COPY3
SELECT * FROM  EMP_COPY3;

SELECT COUNT(*) FROM EMP_COPY2;

SELECT * FROM EMP_COPY2;
INSERT INTO EMP_COPY2 VALUES(2, 'AA', 'BB', 'ZZ', '1234', SYSDATE, 'IT', 12345, NULL, NULL, NULL);

SELECT * FROM EMP_COPY2 WHERE FIRST_NAME = 'AA';
SET TIMING ON;
ROLLBACK;

CREATE INDEX EMP_COPY2_FIRSTNAME_IX ON EMP_COPY2(FIRST_NAME);

select * from departments;