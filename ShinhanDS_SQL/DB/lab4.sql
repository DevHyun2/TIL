-- SELF JOIN
1. ������ �̸��� ������ �̸��� ��ȸ�Ͻÿ�.
--����(Oracle, MySQL)����
 select emp.first_name, mgr.first_name
 from employees emp, employees mgr
 where emp.manager_id = mgr.employee_id;
 
  --ANSI ǥ�ع���
 select emp.first_name, mgr.first_name
 from employees emp inner join employees mgr
on (emp.manager_id = mgr.employee_id);


2. ������ �̸��� ������ �̸��� ��ȸ�Ͻÿ�.
�����ڰ� ���� ���������� ��� ����Ͻÿ�.

  --����(Oracle)����
  select emp.first_name, mgr.first_name
 from employees emp, employees mgr
 where emp.manager_id = mgr.employee_id(+);

  --ANSI ǥ�ع���
 select emp.first_name, mgr.first_name
 from employees emp left outer join employees mgr
on (emp.manager_id = mgr.employee_id);
 

3. ������ �̸��� �����ڰ� �����ϴ� ������ ���� ��ȸ�Ͻÿ�.
��, ������������ 3�� �̻��� �����ڸ� ��µǵ��� �Ͻÿ�.
 
--����(Oracle, MySQL)����
select mgr.first_name, count(emp.first_name)
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id
group by rollup(mgr.first_name)
having count(emp.first_name) > 3;
 
  --ANSI ǥ�ع���
select mgr.first_name, count(emp.first_name)������
from employees emp left outer join employees mgr
on (emp.manager_id = mgr.employee_id)
group by rollup(mgr.first_name) --grouping 
having count(emp.first_name) > 3 --grouping �� �� ���� ����
order by ������ desc;

select count(*)
from employees
where manager_id = 100; -- ���ǿ� �´� data�� ���� grouping�ϱ� �� -> �׷��ϸ� ��� ���� 


========================================
		SubQuery
========================================


1. �������� �̸�, �Ի���, �μ����� ��ȸ�Ͻÿ�.
��, �μ��� ���� ������ �ִٸ� �� ���������� ��°���� ���Խ�Ų��.
�׸��� �μ��� ���� ������ ���ؼ��� '<�μ�����>' �� ��µǵ��� �Ѵ�.
(outer-join , nvl() );

select first_name, hire_date, nvl(department_name,'<�μ�����>')
from employees emp left outer join departments dep using(department_id);




2. ������ ��å�� ���� ������ �ٸ��� �����Ϸ��� �Ѵ�.
��å�� 'Manager'�� ���Ե� ������ �޿��� 0.5�� ���ϰ�
������ �����鿡 ���ؼ��� ������ �޿��� �����ϵ��� �Ѵ�. 
�����ϰ� ��ȸ�Ͻÿ�. (decode)

select first_name, job_title, salary, decode(substr(job_title, -7),'Manager', salary*0.5, salary)���ɾ�
from employees emp join jobs j using(job_id);



3. �� �μ����� �����޿��� �޴� ������ �̸��� �μ�id, �޿��� ��ȸ�Ͻÿ�.
--(������(Į��) ��������)

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

--<��� ��������>
select first_name, outeremp.department_id, salary
from employees outeremp
where salary = (select min(salary) from employees where department_id = outeremp.department_id);

4. �� ���޺�(job_title) �ο����� ��ȸ�ϵ� ������ ���� ������ �ִٸ� �ش� ���޵�
��°���� ���Խ�Ű�ÿ�. �׸��� ���޺� �ο����� 3�� �̻��� ���޸� ��°���� ���Խ�Ű�ÿ�.

select job_title, count(first_name)
from employees right outer join jobs using(job_id)
group by job_title
having count(first_name) >=3
order by 2 desc;



5. �� �μ��� �ִ�޿��� �޴� ������ �̸�, �μ���, �޿��� ��ȸ�Ͻÿ�.

select first_name, employees.department_id, salary
from employees, (
                                select department_id, max(salary)minsal
                                from employees
                                group by department_id
                                )aa
where employees.department_id = aa.department_id
and employees.salary = aa.minsal;





6. ������ �̸�, �μ�id, �޿��� ��ȸ�Ͻÿ�. �׸��� ������ ���� �ش� �μ��� 
�ּұ޿��� �������� ���Խ��� ��� �Ͻÿ�.
--Scalar �������� -> select���� �������� �߰�

select first_name, department_id, salary, (select min(salary) from employees where department_id = outeremp.department_id) �ּұ޿�
from employees outeremp;

--<inlineview>
select first_name, department_id, salary, inlineview.minsal �ּұ޿�
from employees outeremp join (select department_id, min(salary)minsal from employees group by department_id)inlineview
using(department_id);

==========================================
	Inline View �� Top-N SubQuery
==========================================

1. �޿��� ���� ���� �޴� ���� 5���� ���� ������ ��ȸ�Ͻÿ�.
select rownum, aa.*
from ( --select�� �ѹ���
            select rownum, first_name, salary
            from employees
            order by salary desc
            )aa
where rownum <= 5; --select�� �ٳ��� ���� �ѹ���

--�޿��� ���� 6~10���� ��ȸ�ϱ�
--select�� rownum�ο��ǰ�, odder by �� display�Ѵ�.
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

2. Ŀ�̼��� ���� ���� �޴� ���� 3���� ���� ������ ��ȸ�Ͻÿ�.









3. ���� �Ի��� ���� ��ȸ�ϵ�, �Ի��� ���� 5�� �̻��� ���� ����Ͻÿ�.





4. �⵵�� �Ի��� ���� ��ȸ�Ͻÿ�. 
��, �Ի��ڼ��� ���� �⵵���� ��µǵ��� �մϴ�.


