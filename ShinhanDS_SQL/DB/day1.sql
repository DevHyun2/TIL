select * from tab;

--*�� ��� Į���� �ǹ��Ѵ�.
select * 
from employees;

select employees.*
from employees;

--Į���� �����ϱ�, �����밡��, as�� ��������
select employee_id as ������ȣ, first_name �����̸�
from employees;

--�������� �ٹ��ϴ� �μ���, (�ߺ������ϱ� distinct)
select distinct DEPARTMENT_ID
from employees;

--null : ���ǵ� ���� ����.(�μ����� ����.)
select employees.*
from employees;

select distinct DEPARTMENT_ID, first_name, last_name
from employees;

--���������
select  first_name, last_name, SALARY, SALARY*12 ����
from employees;

--invalid identifier : ��ȿ���� ���� �ĺ���, Į���̸��� Ʋ��
--table�� �����ϸ� Data Dictionary(data����)�� Į�� �̸��� �빮�ڷ� ����.(ORACLE)
select  first_name, "last_name", SALARY, SALARY*12 ����
from employees;

--SQL���� " "�� ����ϸ� �ĺ��� �̸��̴�. Ư�����ڰ� �ʿ��� �� ���
--sQL���� ' '�� ���� �ǹ��Ѵ�.
--||�� concat�������̴�. ���ڿ��� ����, +�� ����� �Ѵ�.
--null�� ���񱳺Ұ�(is ���), ���Ұ�(null������ ����� ����� null)
--nvl(commission_pct, 1) : null���� üũ -> null�̸� 1�� ����
select  first_name, "LAST_NAME", SALARY, SALARY*12 "�� ��", LAST_NAME || ' -> ' || SALARY, commission_pct, nvl(commission_pct, 1)*salary
from employees
where commission_pct is null
--���� where
;

select first_name, last_name, salary, commission_pct, nvl(commission_pct, 0) * salary + salary "���� �޿�"
from employees
where department_id is not null;

select '�̸���' || first_name || ' ' || last_name || '�޿���' || salary "�����Ұ�"
from employees;

--�񱳿�����, ���� �߰� and
--2005�� 1�� 30�� ����(1/30 ����)�� �Ի��� ���� ��ȸ
--����Ŭ�� �ڵ�����ȯ ����
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

-----------------�޿��� 10000�̻� 20000����
select*
from employees
where salary>=10000 and salary<=20000;
--between
select*
from employees
where salary between 10000 and 20000;
 
 ---------------�μ��� 60, 90, 100�� ���� ��ȸ
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

---------------------like�� % or _(under bar)
--% : �ϳ��̻� ������ ����
-- _ : �ϳ��� ������ ����

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

--Oracle�� asc�϶� null�� �������� ���´�.
--Oracle�� desc�϶� null�� ���� ���´�.
select*
from employees
where manager_id is not null
order by commission_pct asc;--asc��������

--asc �϶� null�� ���� ������ �ϱ� (nulls first)
select*
from employees
where manager_id is not null
order by commission_pct asc nulls first;--asc��������

--desc �϶� null�� �������� ������ �ϱ� (nulls last)
select*
from employees
where manager_id is not null
order by commission_pct desc nulls last;--asc��������

select*
from employees
where department_id not in (50, 30, 10);
--�Ǽ���ŭ ����ؼ� ����
select 10+20
from employees;

select 10+20, sysdate
from dual;

select * from dual;

--DBMS : oracle, sybase, mysql, mariadb, postgre
--database : oracleXE���� XE
--table(column, row�� ����)
--������ �־�� ���� ���� : DBA(dmin) -> sys, system, �Ϲݻ���� -> hr (lockǮ��), scott�߰�
--CRUD�۾�
--insert(Create)
--select(Read)
--update(Update)
--delete(Delete)

select Display�� ������(*, Į����, ����, �Լ�, distinct, ����)
from ���̺��
where ���ǵ� (�񱳿�����, ��������...)
order by ������ Į�� asc, Į�� desc + null first or null last

--��������� ���� table
desc dual;
--------------
desc employees;