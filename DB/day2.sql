select * from tab;
desc employees;
select*from employees;

--��ȸ : select
--�ۼ����� : select - from - where - order by
--������� : from - where - from - order by
select employee_id, first_name, salary �޿�
from employees
where salary >= 10000
order by �޿� desc;

select employee_id, first_name, salary �޿� --3
from employees --1
where salary >= 10000 --2
order by 3 desc; --4 : order by �� �� Į�� �̸�, ����, select������ ������

----------------------------------------------------------------------------------

select*
from employees
where salary >= 10000
and commission_pct is not null
and first_name like '_____'
order by 2;

--�̷� �ڵ�� �ٶ������� ����
select DISTINCT 10+20
from employees;
--�̷��� ���
desc dual;
--dual�� �����ڰ� sys, hr�� �����ڰ� �ƴ�. sys�� �����Ѱ��̴�.
--�Ѱ��� data�� ��ȸ�ؾ� �ϴ� ��� ���
select 10+20
from dual;


----���� �Լ�
select 12.5, round(12.5)�ݿø�, round(12.56, 1)�Ҽ�1�ڸ������ݿø�, floor(15.7)����, ceil(15.1)�ø�, mod(10,3)������
from dual;

----���� �Լ�(concat�� �ٸ� DB���� ����, ||�����ڴ� Oracle, MySQL�� +�� ����)
select first_name, UPPER(first_name)���δ빮��, lower(first_name)���μҹ���, INITCAP(email)ù���ڸ��빮��, SUBSTR(first_name, 1,3)"1����3�ڸ� �ڸ���",
length(first_name)���ڿ�����, first_name||' '||last_name"������Ʈ������", concat(concat(first_name,' '), last_name)��ġ��
from employees;

--SCOTT����
desc emp;
--job�� manager�� ���� ��ȸ
-- ' '�� ���� ���θ� ��ҹ��ڸ� �����Ѵ�
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
--�����ڴ� =�� ���°� ����
--substr �ڿ������� �ڸ���
select*
from jobs
where substr(job_title,-7) = initcap('manager');


select first_name, hire_date, SUBSTR(hire_date, 1, 2) �⵵, substr(hire_date, 4, 2) ��, substr(hire_date, 7, 2) ��
from employees;

--12�� �Ի��� ���� ��ȸ
select first_name, hire_date, SUBSTR(hire_date, 1, 2) �⵵, substr(hire_date, 4, 2) ��, substr(hire_date, 7, 2) ��
from employees
--where substr(hire_date, 4, 2) = 12
--where hire_date like '__/12__';
where TO_CHAR(hire_date,'mm') = 12;

select first_name, INSTR(first_name, 'e') "��ġã�� ������ 0", INSTR(first_name, 'e', 2) "��ġã�� 2�����ͽ���",INSTR(first_name, 'e', -5) "��ġã�� �ڿ��� 5",
INSTR(first_name, 'e', 2, 2) "2��°���� 2��° e ã��"
from employees;


select first_name, lpad(first_name, 10, '*')"���� 10�ڸ� *�� ����", rpad(first_name, 10, '*')"������ 10�ڸ� *�� ����"
from employees;

select '&'||ltrim('   Oracle   ')||'&'"���ʰ�������", '&'||rtrim('   Oracle   ')||'&'"�����ʰ�������", '&'||trim('   Oracle   ')||'&'"���ʰ�������",
    trim('a' from 'aaaaaaaOracleaaaaaa')"Ư����������"
from dual;

select first_name, trim('A' from first_name)
from employees;

select commission_pct, trim(null from commission_pct)
from employees;

--�ٹ� ������� 365�� ������ �ȵ�(���⶧��)
select first_name, hire_date, sysdate"����", sysdate+1"����", round(sysdate - hire_date)"�ٹ� �ϼ�", round(MONTHS_BETWEEN(SYSDATE,hire_date))"�ٹ� ������",
    round(MONTHS_BETWEEN(SYSDATE,hire_date)/12)"�ٹ� ���", add_months(sysdate, 6)"���ñ��� 6���� ��", add_months(sysdate-21, 6)"���� ��",
    LAST_DAY(hire_date)"�״��� ������", NEXT_DAY(TRUNC(SYSDATE), '������')"���� ������",
    to_char(hire_date,'yyyy/mm/dd hh:mi:ss DAY'), NEXT_DAY(hire_date,'ȭ����')"�Ի��ϱ��ش���ȭ����",
    round(hire_date,'MM')"�� �ݿø� 16�ϱ���", trunc(hire_date,'MM')"�ϼ� ����"
    
from employees
order by 7 desc, 6 desc, 5 desc;

select*
from v$nls_parameters;
--parameters��ȸ
select*from nls_session_parameters;


select sysdate, to_char(sysdate,'yyyy/mm/dd hh:mi:ss DAY DY D MON hh24/hh12 AM/PM')"24�ð�/12�ð�"
from dual;

select to_char(10000000000,"999,999,9999,9999")
from dual;

select *
from employees
where hire_date >= '2005/01/01'; --yyyy

---ǥ���� �ٲٱ�(�� ��Ʈ �ȿ�����)
alter session set NLS_DATE_FORMAT = 'rr/mm/dd';

select *
from employees
where hire_date >= '01/01/2005'; --rr

select *
from employees
where to_char(hire_date, 'rr/mm/dd') >= '05/01/01';
--nvl(Į���̸�, null�� �� ��ü ��)
--nvl2)(Į���̸�, null�� �ƴ� �� Ÿ�Ա���, null�� �� ��ü ��)
select first_name, salary, nvl2(commission_pct,to_char(commission_pct), 'Ŀ�̼Ǿ���'), salary + salary * nvl(commission_pct, 0) �Ǽ��ɾ�,
    nvl(to_char(commission_pct),'Ŀ�̼Ǿ���'),nvl(to_char(department_id),'�μ�����')
from employees
where nvl(to_char(department_id),'�μ�����') = '�μ�����'
order by commission_pct nulls first;

select COALESCE(to_char(commission_pct), to_char(department_id), to_char(first_name))"null�̾ƴѰ�ã��"
from employees;

--decode�� =�����ڰ� �����Ȱ��̴�, ��, =��츸 ����
--case�� SQL������ ���Ǵ� ��� �����ڰ� ����
select first_name, salary, decode(salary, 24000,'�ſ츹��', 17000,'����', 12008,'����', '����')"�� ������ ���ǹ�",
    decode(length(first_name), 9,'large', 6,'middle', 'small')�̸�����,
    case when salary >= 20000 then '����' 
            when salary < 20000 and salary >= 10000 then ' ����'
            when salary < 10000 then '����'
            else '���ڶ�' end �޿���2,
        job_id, decode(job_id,'AD_PRES','A', 'AD_VP','A', 'IT_PROG','A', 'B')job2,
        case when job_id in('AD_PRES', 'AD_VP', 'IT_PROG') then 'A' else 'B' end job3
from employees;