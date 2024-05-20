select * from tab;
desc employees;
select*from employees;

--조회 : select
--작성순서 : select - from - where - order by
--실행순서 : from - where - from - order by
select employee_id, first_name, salary 급여
from employees
where salary >= 10000
order by 급여 desc;

select employee_id, first_name, salary 급여 --3
from employees --1
where salary >= 10000 --2
order by 3 desc; --4 : order by 할 때 칼럼 이름, 별명, select순서로 가능함

----------------------------------------------------------------------------------

select*
from employees
where salary >= 10000
and commission_pct is not null
and first_name like '_____'
order by 2;

--이런 코드는 바람직하지 않음
select DISTINCT 10+20
from employees;
--이렇게 사용
desc dual;
--dual은 소유자가 sys, hr이 소유자가 아님. sys가 공개한것이다.
--한건의 data를 조회해야 하는 경우 사용
select 10+20
from dual;


----숫자 함수
select 12.5, round(12.5)반올림, round(12.56, 1)소수1자리까지반올림, floor(15.7)버림, ceil(15.1)올림, mod(10,3)나머지
from dual;

----문자 함수(concat은 다른 DB에도 있음, ||연산자는 Oracle, MySQL은 +로 연결)
select first_name, UPPER(first_name)전부대문자, lower(first_name)전부소문자, INITCAP(email)첫문자만대문자, SUBSTR(first_name, 1,3)"1부터3자리 자르기",
length(first_name)문자열길이, first_name||' '||last_name"컨케이트연산자", concat(concat(first_name,' '), last_name)합치기
from employees;

--SCOTT예제
desc emp;
--job이 manager인 직원 조회
-- ' '로 값을 감싸면 대소문자를 구분한다
select* from emp
where job = upper('manager');

select*
from employees
where job_id = UPPER('it_prog');

select*
from employees
where lower(job_id) = lower('it_prog');

select*
from jobs
where job_title like '%Manager';
--연산자는 =을 쓰는게 좋음
--substr 뒤에서부터 자르기
select*
from jobs
where substr(job_title,-7) = initcap('manager');


select first_name, hire_date, SUBSTR(hire_date, 1, 2) 년도, substr(hire_date, 4, 2) 월, substr(hire_date, 7, 2) 일
from employees;

--12월 입사한 직원 조회
select first_name, hire_date, SUBSTR(hire_date, 1, 2) 년도, substr(hire_date, 4, 2) 월, substr(hire_date, 7, 2) 일
from employees
--where substr(hire_date, 4, 2) = 12
--where hire_date like '__/12__';
where TO_CHAR(hire_date,'mm') = 12;

select first_name, INSTR(first_name, 'e') "위치찾기 없으면 0", INSTR(first_name, 'e', 2) "위치찾기 2번부터시작",INSTR(first_name, 'e', -5) "위치찾기 뒤에서 5",
INSTR(first_name, 'e', 2, 2) "2번째시작 2번째 e 찾기"
from employees;


select first_name, lpad(first_name, 10, '*')"왼쪽 10자리 *로 만듦", rpad(first_name, 10, '*')"오른쪽 10자리 *로 만듦"
from employees;

select '&'||ltrim('   Oracle   ')||'&'"왼쪽공백제거", '&'||rtrim('   Oracle   ')||'&'"오른쪽공백제거", '&'||trim('   Oracle   ')||'&'"양쪽공백제거",
    trim('a' from 'aaaaaaaOracleaaaaaa')"특정문자제거"
from dual;

select first_name, trim('A' from first_name)
from employees;

select commission_pct, trim(null from commission_pct)
from employees;

--근무 년수계산시 365로 나누면 안됨(윤년때문)
select first_name, hire_date, sysdate"오늘", sysdate+1"내일", round(sysdate - hire_date)"근무 일수", round(MONTHS_BETWEEN(SYSDATE,hire_date))"근무 개월수",
    round(MONTHS_BETWEEN(SYSDATE,hire_date)/12)"근무 년수", add_months(sysdate, 6)"오늘기준 6개월 후", add_months(sysdate-21, 6)"강의 끝",
    LAST_DAY(hire_date)"그달의 마지막", NEXT_DAY(TRUNC(SYSDATE), '월요일')"다음 월요일",
    to_char(hire_date,'yyyy/mm/dd hh:mi:ss DAY'), NEXT_DAY(hire_date,'화요일')"입사일기준다음화요일",
    round(hire_date,'MM')"월 반올림 16일기준", trunc(hire_date,'MM')"일수 버림"
    
from employees
order by 7 desc, 6 desc, 5 desc;

select*
from v$nls_parameters;
--parameters조회
select*from nls_session_parameters;


select sysdate, to_char(sysdate,'yyyy/mm/dd hh:mi:ss DAY DY D MON hh24/hh12 AM/PM')"24시간/12시간"
from dual;

select to_char(10000000000,"999,999,9999,9999")
from dual;

select *
from employees
where hire_date >= '2005/01/01'; --yyyy

---표기방식 바꾸기(이 시트 안에서만)
alter session set NLS_DATE_FORMAT = 'rr/mm/dd';

select *
from employees
where hire_date >= '01/01/2005'; --rr

select *
from employees
where to_char(hire_date, 'rr/mm/dd') >= '05/01/01';
--nvl(칼럼이름, null일 때 대체 값)
--nvl2)(칼럼이름, null이 아닐 때 타입까지, null일 때 대체 값)
select first_name, salary, nvl2(commission_pct,to_char(commission_pct), '커미션없음'), salary + salary * nvl(commission_pct, 0) 실수령액,
    nvl(to_char(commission_pct),'커미션없음'),nvl(to_char(department_id),'부서없음')
from employees
where nvl(to_char(department_id),'부서없음') = '부서없음'
order by commission_pct nulls first;

select COALESCE(to_char(commission_pct), to_char(department_id), to_char(first_name))"null이아닌값찾기"
from employees;

--decode는 =연산자가 생략된것이다, 즉, =경우만 가능
--case는 SQL문에서 허용되는 모든 연산자가 가능
select first_name, salary, decode(salary, 24000,'매우많음', 17000,'많음', 12008,'적당', '적음')"평가 같다의 조건문",
    decode(length(first_name), 9,'large', 6,'middle', 'small')이름길이,
    case when salary >= 20000 then '많음' 
            when salary < 20000 and salary >= 10000 then ' 적당'
            when salary < 10000 then '적음'
            else '모자람' end 급여평가2,
        job_id, decode(job_id,'AD_PRES','A', 'AD_VP','A', 'IT_PROG','A', 'B')job2,
        case when job_id in('AD_PRES', 'AD_VP', 'IT_PROG') then 'A' else 'B' end job3
from employees;