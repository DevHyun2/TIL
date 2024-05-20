-- SELF JOIN
1. 직원의 이름과 관리자 이름을 조회하시오.
--벤더(Oracle, MySQL)문법
 select emp.first_name, mgr.first_name
 from employees emp, employees mgr
 where emp.manager_id = mgr.employee_id;
 
  --ANSI 표준문법
 select emp.first_name, mgr.first_name
 from employees emp inner join employees mgr
on (emp.manager_id = mgr.employee_id);


2. 직원의 이름과 관리자 이름을 조회하시오.
관리자가 없는 직원정보도 모두 출력하시오.

  --벤더(Oracle)문법
  select emp.first_name, mgr.first_name
 from employees emp, employees mgr
 where emp.manager_id = mgr.employee_id(+);

  --ANSI 표준문법
 select emp.first_name, mgr.first_name
 from employees emp left outer join employees mgr
on (emp.manager_id = mgr.employee_id);
 

3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오.
단, 관리직원수가 3명 이상인 관리자만 출력되도록 하시오.
 
--벤더(Oracle, MySQL)문법
select mgr.first_name, count(emp.first_name)
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id
group by rollup(mgr.first_name)
having count(emp.first_name) > 3;
 
  --ANSI 표준문법
select mgr.first_name, count(emp.first_name)직원수
from employees emp left outer join employees mgr
on (emp.manager_id = mgr.employee_id)
group by rollup(mgr.first_name) --grouping 
having count(emp.first_name) > 3 --grouping 한 후 조건 추출
order by 직원수 desc;

select count(*)
from employees
where manager_id = 100; -- 조건에 맞는 data를 추출 grouping하기 전 -> 그룹하면 사용 못함 


========================================
		SubQuery
========================================


1. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
그리고 부서가 없는 직원에 대해서는 '<부서없음>' 이 출력되도록 한다.
(outer-join , nvl() );

select first_name, hire_date, nvl(department_name,'<부서없음>')
from employees emp left outer join departments dep using(department_id);




2. 직원의 직책에 따라 월급을 다르게 지급하려고 한다.
직책에 'Manager'가 포함된 직원은 급여에 0.5를 곱하고
나머지 직원들에 대해서는 원래의 급여를 지급하도록 한다. 
적절하게 조회하시오. (decode)

select first_name, job_title, salary, decode(substr(job_title, -7),'Manager', salary*0.5, salary)수령액
from employees emp join jobs j using(job_id);



3. 각 부서별로 최저급여를 받는 직원의 이름과 부서id, 급여를 조회하시오.
--(다중행(칼럼) 서브쿼리)

select first_name, department_id, salary
from employees
where (department_id, salary)in(
                                                        select department_id, min(salary)
                                                        from employees
                                                        group by department_id
                                                        );     
                                                        
--(inlineview)
select first_name, employees.department_id, salary
from employees, (
                                select department_id, min(salary)minsal
                                from employees
                                group by department_id
                                )aa
where employees.department_id = aa.department_id
and employees.salary = aa.minsal;

--<상관 서브쿼리>
select first_name, outeremp.department_id, salary
from employees outeremp
where salary = (select min(salary) from employees where department_id = outeremp.department_id);

4. 각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도
출력결과에 포함시키시오. 그리고 직급별 인원수가 3명 이상인 직급만 출력결과에 포함시키시오.

select job_title, count(first_name)
from employees right outer join jobs using(job_id)
group by job_title
having count(first_name) >=3
order by 2 desc;



5. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.

select first_name, employees.department_id, salary
from employees, (
                                select department_id, max(salary)minsal
                                from employees
                                group by department_id
                                )aa
where employees.department_id = aa.department_id
and employees.salary = aa.minsal;





6. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 
최소급여를 마지막에 포함시켜 출력 하시오.
--Scalar 서브쿼리 -> select절에 서브쿼리 추가

select first_name, department_id, salary, (select min(salary) from employees where department_id = outeremp.department_id) 최소급여
from employees outeremp;

--<inlineview>
select first_name, department_id, salary, inlineview.minsal 최소급여
from employees outeremp join (select department_id, min(salary)minsal from employees group by department_id)inlineview
using(department_id);

==========================================
	Inline View 와 Top-N SubQuery
==========================================

1. 급여를 가장 많이 받는 상위 5명의 직원 정보를 조회하시오.
select rownum, aa.*
from ( --select전 넘버링
            select rownum, first_name, salary
            from employees
            order by salary desc
            )aa
where rownum <= 5; --select가 다끝난 다음 넘버링

--급여가 상위 6~10까지 조회하기
--select후 rownum부여되고, odder by 후 display한다.
select rownum, bb.*
from(
            select rownum rr, aa.*
            from (
                        select rownum, first_name, salary
                        from employees
                        order by salary desc
                        )aa
            )bb
where rr between 6 and 10;

2. 커미션을 가장 많이 받는 상위 3명의 직원 정보를 조회하시오.









3. 월별 입사자 수를 조회하되, 입사자 수가 5명 이상인 월만 출력하시오.





4. 년도별 입사자 수를 조회하시오. 
단, 입사자수가 많은 년도부터 출력되도록 합니다.


