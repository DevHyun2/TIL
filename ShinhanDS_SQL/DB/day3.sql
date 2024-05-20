select * from tab;
select * from employees;

select first_name, email, lower(email) --3
from employees --1
where job_id = 'IT_PROG' --2
and length(first_name) > 5
order by 1; --4

--������ �Լ� first_name --> length(first_name) : 1�� -> 1��

=======
������ --������ -> 1��, Į���̸��� ����ϸ� null�� ����
=======


select avg(salary), sum(salary) , max(salary), min(salary), count(salary), count(commission_pct)"null����", count(*)"null����"
from employees;

-- �� �μ� ��
select count(distinct department_id)
from employees;
-- � �μ��� �ִ��� 
select DISTINCT department_id
from employees;

select department_id, avg(salary), sum(salary) , max(salary), min(salary), count(salary), count(commission_pct)"null����", count(*)"null����"
from employees
group by department_id;

--select���� ����� Į���� �����Լ��� ������� �ʾҴٸ� �ݵ�� group by���� �����ؾ� �Ѵ�.
--���� �Լ��� where �������� ����� �� ����
--������ ���� having ���
--grouping(Į��) : �ش� Į������ null�̸� 1�� ���
select ltrim(department_id) �μ�, decode(grouping(job_id),1,department_id||'�μ��� �հ�',job_id) ��å, 
sum(salary) �޿��հ�, count(*) ������, count(commission_pct), 
grouping(department_id), grouping(job_id)  --5
from employees  --1
where department_id is not null --2
--and count(*) > 10 (X)
--��׷�, �ұ׷�  : rollup - (��׷�)�߰��հ� ����(null�� ǥ��) < cube - ��������� �հ� ����
group by rollup(department_id, job_id) --3,4
--having count(*) > 10 --4,3 : ������
order by �μ�; --6

--LISTAGG ���η� ������
select department_id, job_id,LISTAGG(first_name, ', ') WITHIN GROUP(ORDER BY first_name) --over(PARTITION by job_id) �μ���������
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

----cross join(���ι����� ���� ��� *�Ǽ���ŭ ���´�) 107*27
select first_name, department_name
from employees, departments
order by 1;

--equi join( = �����ڷ� join)
--������ ��������? ������ �μ��� ����, �Ǽ��� �����Ǽ� ��ŭ ���
select first_name, department_name
from employees, departments
where employees.department_id = departments.department_id
order by 1;

select employees.first_name, salary, jobs.job_title, max_salary
from employees, jobs
where employees.job_id = jobs.job_id
order by 2 desc;

--�μ����̺��� manager_id �� �μ����̴�. �����߿� 1���� �μ����̴�. �μ����� �̸��� �����ΰ�?
select departments.*, employees.first_name, employees.last_name, departments.manager_id
from employees, departments
where employees.employee_id  = departments.department_id;

--��������(Oracle, Sybase, MySQL, Maria, Postge...) - ǥ�ع���X
select first_name, department_name, emp.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id(+); --������ null�̾ ��µ�

select * from employees where employee_id = 103;

--ǥ�ع���
--using�� �������̺� ���� �̸��� Į������ ���ν� ���
--on�� �̿� (Į���� �̸��� �ٸ� ����� ����)
select first_name, department_name, department_id
from employees emp join departments dept using(department_id)
where department_id > 0;

select first_name, department_name, emp.department_id
from employees emp join departments dept on(emp.department_id = dept.department_id)
where emp.department_id > 0;

---SCOTT
select * from emp;
select * from salgrade;

-- =�� �ƴ� join���/ =�� �ƴϱ� ������ using �ȵ�
select emp.*, salgrade.*
from emp, salgrade
where emp.sal between losal and hisal;

select emp.*, salgrade.*
from emp join salgrade on(emp.sal between losal and hisal);


--self join(�����ϰ��� �ϴ� Į���� �ڽ��� ���̺� �ִ� ���, �ϳ��� ���̺��� 2�� ��� �����Ѵ�.)
select ����.first_name, ����.salary, �Ŵ���.first_name, �Ŵ���.salary
from employees ����, employees �Ŵ���
where ����.manager_id = �Ŵ���.employee_id
order by ���� employee_id;

select ����.first_name, ����.salary, �Ŵ���.first_name, �Ŵ���.salary
from employees ���� inner join employees �Ŵ��� on( ����.manager_id = �Ŵ���.employee_id)
order by ���� employee_id;

--Outer join : �������ǿ� �������� �൵ ��ȸ�ϰ��� �Ѵ�. (�����ʿ� +�� �ִ´�)
select ����.first_name, ����.salary, �Ŵ���.first_name, �Ŵ���.salary
from employees ����, employees �Ŵ���
where ����.manager_id(+) = �Ŵ���.employee_id
order by ���� employee_id;
--������ ����
select ����.first_name, ����.salary, �Ŵ���.first_name, �Ŵ���.salary
from employees ���� left outer join employees �Ŵ��� on( ����.manager_id = �Ŵ���.employee_id)
order by ���� employee_id;
--�������� ����
select ����.first_name, ����.salary, nvl(�Ŵ���.first_name,'�Ŵ��� ����'), vnl2(�Ŵ���.salary, to_char(�Ŵ���.salary), ", ")'�Ŵ�������'
from employees ���� right outer join employees �Ŵ��� on( ����.manager_id = �Ŵ���.employee_id)
order by ���� employee_id;


--������ �μ����� ����
select first_name, salary, nvl(department_name, '�μ�����')
from employees left outer join departments on (employees.department_id = departments.department_id);

select first_name, salary, nvl(department_name, '�μ�����')
from employees inner join departments on (employees.department_id = departments.department_id);

--�ο��� ���� �μ��� ��� ��µ�
select nvl(first_name,'��������'), salary, nvl(department_name, '�μ�����')
from employees full outer join departments on (employees.department_id = departments.department_id);

--�ϳ��� ���� �μ��� �ٹ��ϴ� �������� �̸��� �޿��� ��ȸ�Ͻÿ�
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

--David�� ���� ��å�� ���� ������ ��ȸ *ANY or IN
-- >ANY�� �ƹ��ų����� ũ���̹Ƿ� �ּҺ��� ũ���� �ǹ�
--<ANY�� �ƹ��ź��� �۴��̹Ƿ� �ִ뺸�� �۴��� �ǹ�
select *
from employees
where job_id = ANY
(
select job_id
from employees
where first_name = 'David'
);

select count(*) from employees where  first_name = 'David';

--��� �޿����� �� ���� �޿��� �ް��ִ� �������� ��ȸ
select *
from employees
where salary >
(
select avg(salary)
from employees
)
order by salary;

--�޿��� 10000 �̻��� �����μ��� ���� �μ��� ������ ��ȸ
select *
from employees
where department_id = ANY
(
select distinct department_id
from employees
where salary >= 10000
);

--60�� �μ��� �ٹ��ϴ� ��� ������ �޿����� ū �޿��� �޴� ������ȸ
-->ALL�� ��κ��� ũ���̹Ƿ� �ִ뺸�� ũ��.
select *
from employees
where salary > All
(
select salary
from employees
where department_id = 60
);

-- <ALL�� ��κ��� �۴� �̹Ƿ� �ּҺ��� �۴�.
select *
from employees
where salary < All
(
select salary
from employees
where department_id = 60
);