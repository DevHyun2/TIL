select * from tab;

--*는 모든 칼럼을 의미한다.
select * 
from employees;

select employees.*
from employees;

--칼럼을 나열하기, 별명사용가능, as는 생략가능
select employee_id as 직원번호, first_name 직원이름
from employees;

--직원들이 근무하는 부서들, (중복제거하기 distinct)
select distinct DEPARTMENT_ID
from employees;

--null : 정의된 값이 없다.(부서값이 없다.)
select employees.*
from employees;

select distinct DEPARTMENT_ID, first_name, last_name
from employees;

--산술연산자
select  first_name, last_name, SALARY, SALARY*12 연봉
from employees;

--invalid identifier : 유효하지 않은 식별자, 칼럼이름이 틀림
--table을 생성하면 Data Dictionary(data사전)에 칼럼 이름이 대문자로 들어간다.(ORACLE)
select  first_name, "last_name", SALARY, SALARY*12 연봉
from employees;

--SQL문에 " "를 사용하면 식별자 이름이다. 특수문자가 필요할 때 사용
--sQL문에 ' '은 값을 의미한다.
--||는 concat연산자이다. 문자열을 연결, +는 산술만 한다.
--null은 값비교불가(is 사용), 계산불가(null참여한 계산은 결과가 null)
--nvl(commission_pct, 1) : null인지 체크 -> null이면 1로 변경
select  first_name, "LAST_NAME", SALARY, SALARY*12 "연 봉", LAST_NAME || ' -> ' || SALARY, commission_pct, nvl(commission_pct, 1)*salary
from employees
where commission_pct is null
--조건 where
;

select first_name, last_name, salary, commission_pct, nvl(commission_pct, 0) * salary + salary "실제 급여"
from employees
where department_id is not null;

select '이름은' || first_name || ' ' || last_name || '급여는' || salary "직원소개"
from employees;

--비교연산자, 조건 추가 and
--2005년 1월 30일 이후(1/30 포합)에 입사한 직원 조회
--오라클은 자동형변환 제공
--'10000' -> 10000
--'hire_date' -> to_date('05/01/30')
select*
from employees
where salary >= 10000
and commission_pct is not null
and job_id = 'SA_REP'
and hire_date >= '05/01/30';

select*
from employees
where department_id != 80;

-----------------급여가 10000이상 20000이하
select*
from employees
where salary>=10000 and salary<=20000;
--between
select*
from employees
where salary between 10000 and 20000;
 
 ---------------부서가 60, 90, 100인 직원 조회
select*
from employees
where department_id = 60 OR department_id = 90 OR department_id = 100;

select*
from employees
where department_id in (60, 90, 100);
---------not in
select*
from employees
where department_id != 50 and department_id != 30 and department_id != 10;

---------------------like문 % or _(under bar)
--% : 하나이상 임의의 문자
-- _ : 하나의 임의의 문자

select*
from employees
where email like 'S%';

select*
from employees
where email like '%AN%';

select*
from employees
where email like '%A';

select*
from employees
where email like '_____';

select*
from employees
where email not like '_____';

select * from tab;
select * from emp where mgr is null;

--Oracle은 asc일때 null이 마지막에 나온다.
--Oracle은 desc일때 null이 먼저 나온다.
select*
from employees
where manager_id is not null
order by commission_pct asc;--asc생략가능

--asc 일때 null이 먼저 나오게 하기 (nulls first)
select*
from employees
where manager_id is not null
order by commission_pct asc nulls first;--asc생략가능

--desc 일때 null이 마지막에 나오게 하기 (nulls last)
select*
from employees
where manager_id is not null
order by commission_pct desc nulls last;--asc생략가능

select*
from employees
where department_id not in (50, 30, 10);
--건수만큼 산술해서 나옴
select 10+20
from employees;

select 10+20, sysdate
from dual;

select * from dual;

--DBMS : oracle, sybase, mysql, mariadb, postgre
--database : oracleXE버전 XE
--table(column, row가 삽입)
--계정이 있어야 접근 가능 : DBA(dmin) -> sys, system, 일반사용자 -> hr (lock풀기), scott추가
--CRUD작업
--insert(Create)
--select(Read)
--update(Update)
--delete(Delete)

select Display할 정보들(*, 칼럼들, 수식, 함수, distinct, 별명)
from 테이블들
where 조건들 (비교연산자, 논리연산자...)
order by 정렬할 칼럼 asc, 칼럼 desc + null first or null last

--산술연산을 위한 table
desc dual;
--------------
desc employees;