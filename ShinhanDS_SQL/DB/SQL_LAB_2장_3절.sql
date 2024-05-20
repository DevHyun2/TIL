desc employees;
hr/hr
========================================
--		SELECT �⺻
========================================


1. �޿��� 15000 �̻��� �������� �̸�, �޿�, �μ�id�� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, department_id
from employees
where salary >= 15000;


2. ���� �߿��� ������ 170000 �̻��� �������� �̸�, ������ ��ȸ�Ͻÿ�.
   ������ �޿�(salary)�� 12�� ���� ���Դϴ�.
select first_name, last_name, salary*12 "�� ��"
from employees
where salary >= 170000/12;


3. ���� �߿��� �μ�id�� ���� ������ �̸��� �޿��� ��ȸ�Ͻÿ�.
select first_name, last_name, salary
from employees
where department_id is null;


4. 2004�� ������ �Ի��� ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, hire_date
from employees
where hire_date <= '04/12/31';

select first_name, last_name, salary, hire_date
from employees
where to_char(hire_date,'yyyy') <= '2004';

--�⵵ : yyyy
--�⵵ : yy 1966? 2066?
--�⵵ : RR 50�̻��̸� 1900, 50�̸� 2000
--index(����) : hire_date�� indexó���Ǿ� �ִٸ� �Լ� ���� index�� ������� �ʰԵȴ�. ó������ �˻��ϰ� �ǹǷ� �ӵ��� ��������.


select * from nls_session_parameters;
--��¥ �⺻ ���� : nls_date_format => RR/mm/dd
alter session set nls_date_format = 'yyyy/mm/dd';
-- �������� -- 
1. 80, 50 �� �μ��� ���������鼭 �޿��� 13000 �̻��� ������ �̸�, �޿�, �μ�id
�� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, department_id
from employees
where department_id in (50, 80)
and salary >= 13000;



2. 2005�� ���Ŀ� �Ի��� ������ �߿��� �޿��� 1300 �̻� 20000 ������ �������� 
�̸�, �޿�, �μ�id, �Ի����� ��ȸ�Ͻÿ�.
select first_name, last_name, salary,department_id, hire_date
from employees
where hire_date <= '05/01/01'
and salary between 1300 and 20000;



-- SQL �񱳿����� --
1. 80, 50 �� �μ��� ���������鼭 �޿��� 13000 �̻��� ������ �̸�, �޿�, �μ�id
�� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, department_id
from employees
where department_id in (50, 80)
and salary >= 13000;

2. 2005�� ���Ŀ� �Ի��� ������ �߿��� �޿��� 1300 �̻� 30000 ������ �������� 
�̸�, �޿�, �μ�id, �Ի����� ��ȸ�Ͻÿ�.
select first_name, last_name, salary,department_id, hire_date
from employees
where hire_date <= '05/01/01'
and salary between 1300 and 20000;



3. 2005�⵵ �Ի��� ������ ������ ����Ͻÿ�.
select *
from employees
where hire_date between' 05/01/01' and '05/12/31';


4. �̸��� D�� �����ϴ� ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, hire_date
from employees
where last_name like 'D%';


5. 12���� �Ի��� ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, hire_date
from employees
where hire_date like '____/12/__';


6. �̸��� le �� �� ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, hire_date
from employees
where last_name like '%le%';



7. �̸��� m���� ������ ������ �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, hire_date
from employees
where last_name like '%m';



8. �̸��� ����° ���ڰ� r�� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select first_name, last_name, salary, hire_date
from employees
where last_name like '__r%';



9. Ŀ�̼��� �޴� ������ �̸�, Ŀ�̼�, �޿��� ��ȸ�Ͻÿ�.
select first_name, last_name,commission_pct, salary
from employees
where commission_pct is not null;



10. Ŀ�̼��� ���� �ʴ� ������ �̸�, Ŀ�̼�, �޿��� ��ȸ�Ͻÿ�.
select first_name, last_name,commission_pct, salary
from employees
where commission_pct is null;



11. 2000��뿡 �Ի��ؼ� 30, 50, 80 �� �μ��� ���������鼭, 
�޿��� 5000 �̻� 17000 ���ϸ� �޴� ������ ��ȸ�Ͻÿ�. 
��, Ŀ�̼��� ���� �ʴ� �������� �˻� ��󿡼� ���ܽ�Ű��, ���� �Ի��� ������ 
���� ��µǾ�� �ϸ� �Ի����� ���� ��� �޿��� ���� ������ ���� ��µǷ� �Ͻÿ�.
--invalid identifier : Į���̸� ����
--invalid relational operator : ������ ����
--table or view does not exist : ���̺� �̸� ����
select *
from employees
where to_char(hire_date,'yyyy') between '2000' and '2009'
and department_id in (30,50,80)
and salary between 5000 and 17000
and commission_pct is not null
order by hire_date, salary desc;

