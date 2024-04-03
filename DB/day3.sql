select * from tab;
select * from employees;

select first_name, email, lower(email) --3
from employees --1
where job_id = 'IT_PROG' --2
and length(first_name) > 5
order by 1; --4

--단일행 함수 first_name --> length(first_name) : 1건 -> 1건

=======
다중행 --여러건 -> 1건, 칼럼이름을 사용하면 null은 제외
=======


select avg(salary), sum(salary) , max(salary), min(salary), count(salary), count(commission_pct)"null제외", count(*)"null포함"
from employees;

-- 총 부서 수
select count(distinct department_id)
from employees;
-- 어떤 부서가 있는지 
select DISTINCT department_id
from employees;

select department_id, avg(salary), sum(salary) , max(salary), min(salary), count(salary), count(commission_pct)"null제외", count(*)"null포함"
from employees
group by department_id;

--select절에 사용한 칼럼이 집계함수를 사용하지 않았다면 반드시 group by절에 참여해야 한다.
--집계 함수는 where 조건절에 사용할 수 없음
--조건을 위해 having 사용
--grouping(칼럼) : 해당 칼럼값이 null이면 1이 출력
select ltrim(department_id) 부서, decode(grouping(job_id),1,department_id||'부서의 합계',job_id) 직책, 
sum(salary) 급여합계, count(*) 직원수, count(commission_pct), 
grouping(department_id), grouping(job_id)  --5
from employees  --1
where department_id is not null --2
--and count(*) > 10 (X)
--대그룹, 소그룹  : rollup - (대그룹)중간합계 제공(null로 표시) < cube - 모든조합의 합계 제공
group by rollup(department_id, job_id) --3,4
--having count(*) > 10 --4,3 : 조건절
order by 부서; --6

--LISTAGG 가로로 모으기
select department_id, job_id,LISTAGG(first_name, ', ') WITHIN GROUP(ORDER BY first_name) --over(PARTITION by job_id) 부서별직원들
from employees;
--group by department_id;

select department_id, job_id, LISTAGG(first_name, ', ') WITHIN GROUP(ORDER BY first_name)
from employees
group by department_id, job_id;

select*from employees;
SELECT*FROM departments;
select*from locations;
select*from countries;
select*from regions;

----cross join(조인문장이 없는 경우 *건수만큼 나온다) 107*27
select first_name, department_name
from employees, departments
order by 1;

--equi join( = 연산자로 join)
--기준이 누구인지? 직원이 부서를 참조, 건수는 직원건수 만큼 출력
select first_name, department_name
from employees, departments
where employees.department_id = departments.department_id
order by 1;

select employees.first_name, salary, jobs.job_title, max_salary
from employees, jobs
where employees.job_id = jobs.job_id
order by 2 desc;

--부서테이블의 manager_id 는 부서장이다. 직원중에 1명이 부서장이다. 부서장의 이름은 무엇인가?
select departments.*, employees.first_name, employees.last_name, departments.manager_id
from employees, departments
where employees.employee_id  = departments.department_id;

--벤더문법(Oracle, Sybase, MySQL, Maria, Postge...) - 표준문법X
select first_name, department_name, emp.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id(+); --한쪽이 null이어도 출력됨

select * from employees where employee_id = 103;

--표준문법
--using은 조인테이블에 같은 이름의 칼럼으로 조인시 사용
--on절 이용 (칼럼의 이름이 다른 경우의 조인)
select first_name, department_name, department_id
from employees emp join departments dept using(department_id)
where department_id > 0;

select first_name, department_name, emp.department_id
from employees emp join departments dept on(emp.department_id = dept.department_id)
where emp.department_id > 0;

---SCOTT
select * from emp;
select * from salgrade;

-- =이 아닌 join방법/ =이 아니기 때문에 using 안됨
select emp.*, salgrade.*
from emp, salgrade
where emp.sal between losal and hisal;

select emp.*, salgrade.*
from emp join salgrade on(emp.sal between losal and hisal);


--self join(참조하고자 하는 칼럼이 자신의 테이블에 있는 경우, 하나의 테이블을 2번 열어서 조인한다.)
select 직원.first_name, 직원.salary, 매니저.first_name, 매니저.salary
from employees 직원, employees 매니저
where 직원.manager_id = 매니저.employee_id
order by 직원 employee_id;

select 직원.first_name, 직원.salary, 매니저.first_name, 매니저.salary
from employees 직원 inner join employees 매니저 on( 직원.manager_id = 매니저.employee_id)
order by 직원 employee_id;

--Outer join : 조인조건에 맞지않은 행도 조회하고자 한다. (없는쪽에 +를 넣는다)
select 직원.first_name, 직원.salary, 매니저.first_name, 매니저.salary
from employees 직원, employees 매니저
where 직원.manager_id(+) = 매니저.employee_id
order by 직원 employee_id;
--왼쪽이 기준
select 직원.first_name, 직원.salary, 매니저.first_name, 매니저.salary
from employees 직원 left outer join employees 매니저 on( 직원.manager_id = 매니저.employee_id)
order by 직원 employee_id;
--오른쪽이 기준
select 직원.first_name, 직원.salary, nvl(매니저.first_name,'매니저 없음'), vnl2(매니저.salary, to_char(매니저.salary), ", ")'매니저없음'
from employees 직원 right outer join employees 매니저 on( 직원.manager_id = 매니저.employee_id)
order by 직원 employee_id;


--직원의 부서정보 보기
select first_name, salary, nvl(department_name, '부서없음')
from employees left outer join departments on (employees.department_id = departments.department_id);

select first_name, salary, nvl(department_name, '부서없음')
from employees inner join departments on (employees.department_id = departments.department_id);

--인원이 없는 부서도 모두 출력됨
select nvl(first_name,'직원없음'), salary, nvl(department_name, '부서없음')
from employees full outer join departments on (employees.department_id = departments.department_id);

--니나와 같은 부서에 근무하는 직원들의 이름과 급여를 조회하시오
select *
from employees
where department_id =
(
select department_id 
from employees 
where first_name = 'Neena'
);

select *
from employees
where first_name = 'Neena';

--David와 같은 직책을 가진 직원들 조회 *ANY or IN
-- >ANY는 아무거나보다 크다이므로 최소보다 크다의 의미
--<ANY는 아무거보다 작다이므로 최대보다 작다의 의미
select *
from employees
where job_id = ANY
(
select job_id
from employees
where first_name = 'David'
);

select count(*) from employees where  first_name = 'David';

--평균 급여보다 더 높은 급여를 받고있는 직원들을 조회
select *
from employees
where salary >
(
select avg(salary)
from employees
)
order by salary;

--급여가 10000 이상인 직원부서와 같은 부서인 직원들 조회
select *
from employees
where department_id = ANY
(
select distinct department_id
from employees
where salary >= 10000
);

--60번 부서에 근무하는 모든 직원의 급여보다 큰 급여를 받는 직원조회
-->ALL은 모두보다 크다이므로 최대보다 크다.
select *
from employees
where salary > All
(
select salary
from employees
where department_id = 60
);

-- <ALL은 모두보다 작다 이므로 최소보다 작다.
select *
from employees
where salary < All
(
select salary
from employees
where department_id = 60
);