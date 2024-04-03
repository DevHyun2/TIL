========================================
		JOIN
========================================
select * from tab;
select * from employees;
desc employees;
desc jobs
desc locations;
1.�������� �̸��� ���޸�(job_title)�� ��ȸ�Ͻÿ�.
--��������
select first_name, job_title
from employees emp, jobs j
where emp.job_id = j.job_id;

--ANSI ǥ�ع���
select first_name, job_title
from employees emp inner join jobs j on(emp.job_id = j.job_id);




2.�μ��̸��� �μ��� ���� ���ø�(city)�� ��ȸ�Ͻÿ�.
--����
select department_name, city
from departments dep, locations loc
where dep.location_id = loc.location_id;

select department_name, city
from departments dep join locations loc
on (dep.location_id = loc.location_id);



3. ������ �̸��� �ٹ��������� ��ȸ�Ͻÿ�. (employees, departments, locations,countries)
 SELECT FIRST_NAME, COUNTRY_NAME
 FROM EMPLOYEES, DEPARTMENTS, LOCATIONS, COUNTRIES
 WHERE employees.department_id = departments.department_id
 AND departments.location_id = locations.location_id
 AND locations.country_id = countries.country_id;

 SELECT FIRST_NAME, COUNTRY_NAME
 FROM EMPLOYEES JOIN DEPARTMENTS ON (employees.department_id = departments.department_id)
 JOIN LOCATIONS ON (departments.location_id = locations.location_id)
 JOIN COUNTRIES ON (locations.country_id = countries.country_id);
 
 --Į�� �̸��� ���ٸ� USING
 SELECT FIRST_NAME, COUNTRY_NAME
 FROM EMPLOYEES JOIN DEPARTMENTS USING (department_id)
 JOIN LOCATIONS USING (location_id)
 JOIN COUNTRIES USING (country_id);


4. ��å(job_title)�� 'manager' �� ����� �̸�, ��å, �μ����� ��ȸ�Ͻÿ�.
 SELECT FIRST_NAME, JOB_ID, DEPERTMENT_NAME
 FROM EMPLOYEES E, JOBS J, DEPARTMENTS D
 WHERE E.JOB_ID =J.JOB_ID
 AND E.DEPARTMENT_ID = D.DEPARTMENT_ID
 AND SUBSTR(J.JOB_TITLE, -7) = INITCAP('manager');


5. �������� �̸�, �Ի���, �μ����� ��ȸ�Ͻÿ�.
 select first_name, hire_date, department_name
 from employees join departments using(department_id);


6. �������� �̸�, �Ի���, �μ����� ��ȸ�Ͻÿ�.
��, �μ��� ���� ������ �ִٸ� �� ���������� ��°���� ���Խ�Ų��.
 select first_name, hire_date, department_name
 from employees left outer join departments using(department_id);


7. ������ �̸��� ��å(job_title)�� ����Ͻÿ�.
��, ������ �ʴ� ��å�� �ִٸ� �� ��å������ ��°���� ���Խ�Ű�ÿ�.
select first_name, job_title
from employees right outer join jobs using (job_id);

--������ �������� -> �������� ����� 1�� (>, = , <)
--������(Į��) �������� - > �������� ����� 2�� �̻� ( >ANY, >ALL, exist in)
--�μ��� �ּ� �޿��� �޴� ������ ������ ��ȸ�Ͻÿ�
select *
from employees
where (department_id, salary) in 
(
select department_id, min(salary)
from employees
group by department_id
);

--������ �޴� �޿��� ������ ���� �μ��� �޿����� ���� �޿��� �޴� ������ �̸�, �μ���ȣ, �޿��� ��ȸ�Ͻÿ�.
--��� ���� ����
select *
from employees outeremp
where salary < (select avg(salary) from employees where department_id = outeremp.department_id);

------------��������������� ���� ��� (�ζ��κ� - from���� select�� ���)
select employees.*, inlineview.avgsal
from
(
select department_id, avg(salary) avgsal
from employees
group by department_id
) inlineview, employees
where inlineview.department_id = employees.department_id
and salary < inlineview.avgsal;

--select ���� �� select (��Į�󼭺�����)
select employees.*, inlineview.avgsal, (select avg(salary))

========================================
		SubQuery
========================================
1. 'IT'�μ����� �ٹ��ϴ� �������� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
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


2. 'Alexander' �� ���� �μ����� �ٹ��ϴ� ������ �̸��� �μ�id�� ��ȸ�Ͻÿ�.
select first_name, department_id
from employees
where department_id = ANY
(
select department_id 
from employees 
where first_name = 'Alexander'
);


3. 80���μ��� ��ձ޿����� ���� �޿��� �޴� ������ �̸�, �μ�id, �޿��� ��ȸ�Ͻÿ�.
select first_name, department_id, salary
from employees
where salary > ANY
(
select avg(salary)
from employees
where department_id = 80
)
order by salary;


4. 'South San Francisco'�� �ٹ��ϴ� ������ �ּұ޿����� �޿��� ���� �����鼭 
50 ���μ��� ��ձ޿����� ���� �޿��� �޴� ������ �̸�, �޿�, �μ���, 
�μ�id�� ��ȸ�Ͻÿ�.
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

1. BLAKE�� ������ �μ��� ���� ��� ����� �̸��� �Ի����� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�.
������� BLAKE�� ���ܽ�ŵ�ϴ�.
select ename, hiredate,deptno
from emp
where deptno =
(
select deptno from emp where ename = 'BLAKE'
); 


2. �μ��� ��ġ�� DALLAS�� ��� ����� �̸�, �μ���ȣ , ������ ǥ���Ͻÿ� 

select ename, hiredate, deptno
from emp
where deptno = (
select deptno from dept where loc= 'DALLAS');



desc emp;
3. KING���� �����ϴ� ��� ����� �̸��� �޿��� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ� 
select * from emp;

select *
from emp
where mgr =
(
select empno
from emp
where ename = 'KING'
);
