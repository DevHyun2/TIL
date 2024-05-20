--**PL/SQL
set SERVEROUTPUT on;

declare
--스칼라
    v_empid NUMBER(10) := 100; -- 스칼라 타입
    v_fname VARCHAR2(40);
--참조
    v_empid2 employees.employee_id%type := 200; -- 참조 타입
    v_fname2 employees.first_name%type := '신한금융';
    v_empRecord employees%rowtype; -- 열 전부 가져오기
begin
    v_fname := '스티븐';
    DBMS_OUTPUT.put_line('---------------------------');
    DBMS_OUTPUT.put_line('v_empid =' || v_empid);
    DBMS_OUTPUT.put_line('v_fname =' || v_fname);
    DBMS_OUTPUT.put_line('v_empid2 =' || v_empid2);
    DBMS_OUTPUT.put_line('v_fname2 =' || v_fname2);
    
    select first_name
    into v_fname
    from employees
    where employee_id = v_empid;
    
    select *
    into v_emprecord
    from employees
    where employee_id = v_empid2;
    
    DBMS_OUTPUT.put_line('select 후 v_fname =' || v_fname);
    DBMS_OUTPUT.put_line('select 후 v_empRecord =' || v_empRecord.first_name);
    DBMS_OUTPUT.put_line('select 후 v_empRecord =' || v_empRecord.salary);
    
    DBMS_OUTPUT.put_line('---------------------------');
end;
/   

--DBMS_OUTPUT : 패키지 이름
--.put_line() : 함수, Java의 println()과 같다.
--" " : 식별자
-- ' ' : 값
-- / : 실행


-------------------------------------------------------------------------------------------------

DECLARE
    --타입 정의
    TYPE fname_table IS TABLE OF employees.first_name%TYPE INDEX BY BINARY_INTEGER;
    type empRecordType is record
         (
          v_empid employees.employee_id%type,
          v_fname employees.first_name%type,
          v_salary number(8,2)
          );
    --변수 선언
    fname_arr fname_table;
    v_emp empRecordType; 
    --첨자 선언
    index2 BINARY_INTEGER := 0;
BEGIN

    select employee_id, first_name, salary
    into v_emp
    from employees
    where employee_id = 100;
    dbms_output.put_line('직원번호: ' || v_emp.v_empid);
    dbms_output.put_line('이름: ' || v_emp.v_fname);
    dbms_output.put_line('급여: ' || v_emp.v_salary);
    
    
    --조건문
    if(v_emp.v_salary > 10000) then
         DBMS_OUTPUT.put_line('-----------------');
         dbms_output.put_line(' 급여가 높다 ');
         DBMS_OUTPUT.put_line('-----------------');
    else
          dbms_output.put_line(' 급여가 낮다 ');
    end if;
    
    
    
    FOR fnameRec IN (select first_name from employees where department_id = 60)LOOP
        index2 := index2+1;
        fname_arr(index2) := fnameRec.first_name;
        dbms_output.put_line('Record =' || fnameRec.first_name || '  배열 = ' || fname_arr(index2));
    END LOOP;

end;
/


----------------------------------------------------------------------------------------------------------------------
--반복문

declare
    i number := 1; --DB는 1부터 시작
    
begin

    LOOP
        DBMS_OUTPUT.PUT_LINE('i = ' || i);
        i := i+1;
        if i > 5 then
             DBMS_OUTPUT.PUT_LINE('i는 5까지');
             exit;
        end if;
    end LOOP;
    DBMS_OUTPUT.put_line('-----------------------------');
    for j in reverse 1..5 loop --거꾸로
        DBMS_OUTPUT.PUT_LINE('j = ' || j);
    end loop;

end;
/


-----------------------------------------------------------------------------------------------------------
--프로시저
CREATE OR REPLACE PROCEDURE sp_empall(v_deptid employees.department_id%TYPE)
IS
BEGIN
    FOR empRecord IN (SELECT * From employees WHERE department_id = v_deptid) LOOP
        dbms_output.put_line(empRecord.first_name);
        dbms_output.put_line(empRecord.email);
        dbms_output.put_line(empRecord.salary);
    END LOOP;
END;
/

CREATE OR REPLACE PROCEDURE sep_empsal(v_salary employees.salary%TYPE)
IS
BEGIN
    FOR empRecord IN (SELECT * From employees WHERE salary = v_salary) LOOP
        dbms_output.put_line(empRecord.first_name);
        dbms_output.put_line(empRecord.email);
        dbms_output.put_line('급여: ' || empRecord.salary);
        dbms_output.put_line('부서코드' || empRecord.department_id);
    END LOOP;
END;
/

execute sp_empall; --sql+ 
execute sp_empall(50);

execute sp_empsal(17000);

desc user_source;
select * from user_source;




create or replace procedure sp_empinfo (v_empid in employees.employee_id%TYPE,
                v_fname out employees.first_name%TYPE,
                v_job out employees.job_id%TYPE,
                v_salary out employees.salary%TYPE)
IS
    --a number;
BEGIN
    select first_name, job_id, salary
    into v_fname, v_job, v_salary
    from employees
    where  employee_id = v_empid;
END;
/

execute sp_empinfo; 

variable x varchar2(25);
variable y varchar2(25);
variable z number;

execute sp_empinfo (200, :x, :y, :z);
print x y z;
print y;
print z;

----------------
--function
create or replace function f_bonus(v_empid employees.employee_id%type)
    return number
is
    v_bonus number(10,2);
begin
    select salary * 1.5
    into v_bonus
    from employees
    where employee_id = v_empid;
    return v_bonus;
end;
/

select f_bonus(100)
from dual;

select ltrim(employee_id), first_name, length(first_name), salary, f_bonus(employee_id)
from employees;

-------------------
--커서 : select건수가 여러건인 경우 반드시 커서를 사용한다
--1. 커서 선언
--2. 커서 Open
--3. 커서 Fetch
--4. 커서 Close

--명시적 커서이용
create or replace procedure sp_emp2
is
    v_empRecord employees%rowtype;
    cursor cur_emp is select * from employees; -- 1. 커서 선언
begin
   --2.커서 Open(실행)
   open cur_emp;
   loop
        --3. 커서 Fetch
        fetch cur_emp into v_empRecord;
        exit when cur_emp%notfound;
        dbms_output.put_line('직원이름 : ' || v_empRecord.first_name);
   
   end loop;
  
    --4.커서 Close
    close cur_emp;
end;
/

execute sp_emp2;

--암시적 커서를 이용
create or replace procedure sp_emp3
is 
begin

   for  v_empRecord in (select * from employees) loop
        dbms_output.put_line('직원이름 : ' || v_empRecord.first_name);
   end loop;
  
end;
/

execute sp_emp3;

--저장프로시저 : sp_empByDeptSal, 특정 부서의 특정금액 이상의 급여를 받는 직원조회하고 출력
--저장함수 : f_tax : 60번 부서의 직원들의 tax를 계산하는 함수(급여의 10%)

CREATE OR REPLACE PROCEDURE sp_empByDeptSal(
   v_deptid in employees.department_id%type , v_salary in employees.salary%type)
IS
BEGIN
   for v_empRecord in (  select * from employees where department_id = v_deptid and salary >=  v_salary  ) loop
        dbms_output.put_line('직원이름:'||v_empRecord.first_name);
        dbms_output.put_line('직원이름:'||v_empRecord.department_id);
        dbms_output.put_line('직원이름:'||v_empRecord.salary);
        dbms_output.put_line('*********************************************');
   end loop;
END;
/
--첫 번째 arg : 세금을 부여할 부서
--두 번째 arg : 직원번호
create or replace function f_tax(v_deptid in employees.department_id%type,v_empid in employees.employee_id%type)
    return number
is
    v_tax number := 0;
begin
        select salary * 0.1
        into v_tax
        from employees 
        where employee_id = v_empid 
        and department_id = v_deptid;
    return v_tax;
end;
/

execute sp_empByDeptSal(50, 5000);
select employee_id, salary, department_id, f_tax(60, employee_id)세금 --세금이 나와야함
from employees;



---------------------------------------------------
--패키지(묶음)
CREATE OR REPLACE PACKAGE pkg_exam1 IS
    PROCEDURE sp_empByDeptSal2(v_deptid in employees.department_id%type , v_salary in employees.salary%type);
    FUNCTION f_tax2(v_deptid in employees.department_id%type,v_empid in employees.employee_id%type) RETURN NUMBER;
end;
/

--몸체
CREATE OR REPLACE PACKAGE body pkg_exam1 IS
            PROCEDURE sp_empByDeptSal2(v_deptid in employees.department_id%type , v_salary in employees.salary%type)
            IS
            BEGIN
               for v_empRecord in (  select * from employees where department_id = v_deptid and salary >=  v_salary  ) loop
                    dbms_output.put_line('직원이름:'||v_empRecord.first_name);
                    dbms_output.put_line('직원이름:'||v_empRecord.department_id);
                    dbms_output.put_line('직원이름:'||v_empRecord.salary);
                    dbms_output.put_line('*********************************************');
               end loop;
            END;
            
            function f_tax2(v_deptid in employees.department_id%type,v_empid in employees.employee_id%type) return number
            is
                v_tax2 number := 0;
            begin
                    select salary * 0.1
                    into v_tax2
                    from employees 
                    where employee_id = v_empid 
                    and department_id = v_deptid;
                return v_tax2;
            end;
end;
/
execute PKG_EXAM1.sp_empByDeptSal2(50,5000);
select employee_id, salary, department_id, PKG_EXAM1.f_tax2(60, employee_id)세금 --세금이 나와야함
from employees;

--패키지 이름 : PKG_EXAM2
--sp_empinfo
--f_bonus

CREATE OR REPLACE PACKAGE pkg_exam2 IS
            procedure sp_empinfo (v_empid in employees.employee_id%TYPE,
                                                    v_fname out employees.first_name%TYPE,
                                                    v_job out employees.job_id%TYPE,
                                                    v_salary out employees.salary%TYPE);
            function f_bonus(v_empid employees.employee_id%type)  return number;
end;
/

CREATE OR REPLACE PACKAGE body pkg_exam2 IS
              procedure sp_empinfo (v_empid in employees.employee_id%TYPE,
                                                     v_fname out employees.first_name%TYPE,
                                                     v_job out employees.job_id%TYPE,
                                                     v_salary out employees.salary%TYPE)
                IS
                    --a number;
                BEGIN
                        select first_name, job_id, salary
                        into v_fname, v_job, v_salary
                        from employees
                        where  employee_id = v_empid;
                END;
                
             function f_bonus( v_empid in employees.employee_id%type  )  return number
            is
                v_bonus  number(10,2);
            begin
                select salary * 1.5
                into v_bonus
                from  employees
                where  employee_id = v_empid;
                return v_bonus;
            end;
end;
/

select employee_id, salary, pkg_exam2.f_bonus(employee_id) from employees;
variable a varchar2(30);
variable b varchar2(30);
variable c nuber;
execute pkg_exam2.sp_empinfo(100, :a, :b, :c);
print a;
print b;
print c;

---------------------------------------------trigger
create table emp_trigger
        (
        id number primary key,
        name varchar2(100)
        );

insert into emp_trigger values(1, '김');
insert into emp_trigger values(10, '김');
commit;
---insert, delete, update라는 사건이 발생하면 자동으로 실행되는 프로그램 만들기(트리거)
--for each row : 건별마다,emp_trigger테이블에 insert 한 건마다 emp_sal01에 insert한다.
create or replace trigger trigger_emp1
after insert on emp_trigger for each row
begin
    dbms_output.put_line('================emp_trigger 테이블 insert 성공=================');
    insert into emp_sal01 values(seq_emp_sal01.nextval, 100, :new.id);
end;
/

select * from emp_trigger;
select * from emp_sal01;

create table emp_sal01
        (
        salno number(4) primary key,
        salary number(7,2),
        empid number(4) references emp_trigger(id)
        );
create sequence seq_emp_sal01;

--참조하는 테이블이 있으면 지울 수 없다.
--자식테이블이 존재하면 부모table은 지울 수 없다.
delete from emp_trigger where id = 6;

create or replace trigger trigger_delete
before delete on emp_trigger for each row
begin
    dbms_output.put_line('================emp_trigger 테이블 delete 하기=================');
    delete from emp_sal01 where empid = :old.id;
end;
/

CREATE TABLE 상품(
        상품코드 CHAR(6) PRIMARY KEY,
        상품명 VARCHAR2(12) NOT NULL,
        제조사 VARCHAR(12),
        소비자가격 NUMBER(8),
        재고수량 NUMBER DEFAULT 0
        );

CREATE TABLE 입고(
        입고번호 NUMBER(6) PRIMARY KEY,
        상품코드 CHAR(6) REFERENCES 상품(상품코드),
        입고일자 DATE DEFAULT SYSDATE,
        입고수량 NUMBER(6),
        입고단가 NUMBER(8),
        입고금액 NUMBER(8)
        );

CREATE TABLE 출고(
        출고번호 NUMBER(6) PRIMARY KEY,
        상품코드 CHAR(6) REFERENCES 상품(상품코드),
        출고일자 DATE DEFAULT SYSDATE,
        출고수량 NUMBER(6),
        출고단가 NUMBER(8),
        출고금액 NUMBER(8)
        );
        
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00001','세탁기', 'LG', 500); 
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00002','컴퓨터', 'LG', 700);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00003','냉장고', '삼성', 600);

commit;
select * from 상품;

--상품이 입고되면 상품의 재고 수량을 수정한다 (trigger)
create or replace trigger trigger_재고수정
after insert on 입고 for each row
begin 
    update 상품
    set 재고수량 = 재고수량 + :new.입고수량
    where 상품코드 = :new.상품코드;
end;
/

INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(1, 'A00001', 5, 320, 1600);
INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(2, 'A00001', 20, 320, 1600);
INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(4, 'A00002', 30, 320, 4600);
SELECT * FROM 입고;
SELECT * FROM 상품;

--출고 trigger  : 출고되면 재고를 - 하기)
create or replace trigger trigger_재고수정2
after insert on 출고 for each row
begin 
    update 상품
    set 재고수량 = 재고수량 - :new.출고수량
    where 상품코드 = :new.상품코드;
end;
/

INSERT INTO 출고(출고번호, 상품코드, 출고수량, 출고단가, 출고금액) 
VALUES(2, 'A00001', 10, 320, 1600);

select * from 출고;
select * from 상품;

--employees테이블의 100번직원의 부서를 수정
update employees
set department_id = 50
where employee_id = 100;

select * from employees where employee_id = 100;
select * from job_history;