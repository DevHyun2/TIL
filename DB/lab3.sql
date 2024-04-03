========================================
		JOIN
========================================
select * from tab;
select * from employees;
desc employees;
desc jobs
desc locations;
1.직원들의 이름과 직급명(job_title)을 조회하시오.
--벤더문법
select first_name, job_title
from employees emp, jobs j
where emp.job_id = j.job_id;

--ANSI 표준문법
select first_name, job_title
from employees emp inner join jobs j on(emp.job_id = j.job_id);




2.부서이름과 부서가 속한 도시명(city)을 조회하시오.
--벤더
select department_name, city
from departments dep, locations loc
where dep.location_id = loc.location_id;

select department_name, city
from departments dep join locations loc
on (dep.location_id = loc.location_id);



3. 직원의 이름과 근무국가명을 조회하시오. (employees, departments, locations,countries)
 SELECT FIRST_NAME, COUNTRY_NAME
 FROM EMPLOYEES, DEPARTMENTS, LOCATIONS, COUNTRIES
 WHERE employees.department_id = departments.department_id
 AND departments.location_id = locations.location_id
 AND locations.country_id = countries.country_id;

 SELECT FIRST_NAME, COUNTRY_NAME
 FROM EMPLOYEES JOIN DEPARTMENTS ON (employees.department_id = departments.department_id)
 JOIN LOCATIONS ON (departments.location_id = locations.location_id)
 JOIN COUNTRIES ON (locations.country_id = countries.country_id);
 
 --칼럼 이름이 같다면 USING
 SELECT FIRST_NAME, COUNTRY_NAME
 FROM EMPLOYEES JOIN DEPARTMENTS USING (department_id)
 JOIN LOCATIONS USING (location_id)
 JOIN COUNTRIES USING (country_id);


4. 직책(job_title)이 'manager' 인 사람의 이름, 직책, 부서명을 조회하시오.
 SELECT FIRST_NAME, JOB_ID, DEPERTMENT_NAME
 FROM EMPLOYEES E, JOBS J, DEPARTMENTS D
 WHERE E.JOB_ID =J.JOB_ID
 AND E.DEPARTMENT_ID = D.DEPARTMENT_ID
 AND SUBSTR(J.JOB_TITLE, -7) = INITCAP('manager');


5. 직원들의 이름, 입사일, 부서명을 조회하시오.
 select first_name, hire_date, department_name
 from employees join departments using(department_id);


6. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
 select first_name, hire_date, department_name
 from employees left outer join departments using(department_id);


7. 직원의 이름과 직책(job_title)을 출력하시오.
단, 사용되지 않는 직책이 있다면 그 직책정보도 출력결과에 포함시키시오.
select first_name, job_title
from employees right outer join jobs using (job_id);

--단일행 서브쿼리 -> 서브쿼리 결과가 1건 (>, = , <)
--다중행(칼럼) 서브쿼리 - > 서브쿼리 결과가 2건 이상 ( >ANY, >ALL, exist in)
--부서별 최소 급여를 받는 직원의 정보를 조회하시오
select *
from employees
where (department_id, salary) in 
(
select department_id, min(salary)
from employees
group by department_id
);

--본인이 받는 급여가 본인이 속한 부서의 급여보다 적은 급여를 받는 직원이 이름, 부서번호, 급여를 조회하시오.
--상관 서브 쿼리
select *
from employees outeremp
where salary < (select avg(salary) from employees where department_id = outeremp.department_id);

------------상관서브쿼리보다 좋은 방법 (인라인뷰 - from절에 select을 사용)
select employees.*, inlineview.avgsal
from
(
select department_id, avg(salary) avgsal
from employees
group by department_id
) inlineview, employees
where inlineview.department_id = employees.department_id
and salary < inlineview.avgsal;

--select 절에 들어간 select (스칼라서브쿼리)
select employees.*, inlineview.avgsal, (select avg(salary))

========================================
		SubQuery
========================================
1. 'IT'부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오.
select first_name, salary, hire_date
from  employees
where department_id = 
(
select department_id
from departments
where department_name = 'IT'
);

select first_name, salary, hire_date
from employees join departments using(department_id)
where department_name = 'IT';


2. 'Alexander' 와 같은 부서에서 근무하는 직원의 이름과 부서id를 조회하시오.
select first_name, department_id
from employees
where department_id = ANY
(
select department_id 
from employees 
where first_name = 'Alexander'
);


3. 80번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서id, 급여를 조회하시오.
select first_name, department_id, salary
from employees
where salary > ANY
(
select avg(salary)
from employees
where department_id = 80
)
order by salary;


4. 'South San Francisco'에 근무하는 직원의 최소급여보다 급여를 많이 받으면서 
50 번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 급여, 부서명, 
부서id를 조회하시오.
select * from  locations;
select * from departments;
select * from employees;


select first_name, salary, department_name, department_id
from employees join departments using (department_id)
where salary >
        (
        select min(salary)
        from employees  join departments USING (department_id)
        join locations USING (location_id)
        where city = 'South San Francisco'
        )
and salary > 
        (
        select avg(salary)
        from employees
        where department_id = 50
        );

select first_name, salary, departments.department_name
from employees  join departments USING (department_id)
from departments join locations USING (location_id);

select *
from locations
where city = 'South San Francisco';

select avg(salary)
from employees
where department_id = 50;

-------------------scott/tiger (emp, dept)

1. BLAKE와 동일한 부서에 속한 모든 사원의 이름및 입사일을 표시하는 질의를 작성하시오.
결과에서 BLAKE는 제외시킵니다.
select ename, hiredate,deptno
from emp
where deptno =
(
select deptno from emp where ename = 'BLAKE'
); 


2. 부서의 위치가 DALLAS인 모든 사원의 이름, 부서번호 , 직무를 표시하시오 

select ename, hiredate, deptno
from emp
where deptno = (
select deptno from dept where loc= 'DALLAS');



desc emp;
3. KING에게 보고하는 모든 사원의 이름과 급여를 표시하는 질의를 작성하시오 
select * from emp;

select *
from emp
where mgr =
(
select empno
from emp
where ename = 'KING'
);
