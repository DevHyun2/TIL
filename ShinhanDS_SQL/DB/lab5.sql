--테이블 생성
create table merchants
            (
            ID number,                                  --아이디
            name varchar2(50),                   --상호명
            business_id varchar2(50),         --사업자 등록번호
            tax_type varchar2(50),              --과세 유형
            category_id number                   --업종분류 아이디
            );
            
create table card_usages
            (
            ID number,                                  --아이디
            created_at date,                          --사용일
            category number,                     --구분(0 - 결제, 1 - 취소)
            amount number,                         --금액
            merchant_id number                  --결제 가맹점 아이디
            );
--테이블 제거
drop table merchants;
drop table card_usages;
---테이블 데이터 삽입
insert into merchants values (3907, 'KFC학동역', '201-81-89732', '일반과세자', 1);
insert into merchants values (4989, '미켈(mikelle)고깃집', '785-49-00298', '일반과세자', 1);
insert into merchants values (6297, '뉴발란스 강남점', '241-85-50334', '일반과세자', 6);
insert into merchants values (27052, '주식회사이마트몰', '104-86-50432', '일반과세자', 2);
insert into merchants values (118009, '플라이앤컴퍼니(주)', '211-88-57343', '일반과세자', 1);

insert into card_usages values (195772, sysdate, 0, 2700, 3907);
insert into card_usages values (2530342, sysdate, 0, 12300, 3907);
insert into card_usages values (899325, sysdate, 0, 45000, 4989);
insert into card_usages values (400811, sysdate, 0, 4000, 6297);
insert into card_usages values (743640, sysdate, 0, 299000, 27052);
insert into card_usages values (1052039, sysdate, 1, -12900, 118009);
insert into card_usages values (1120840, sysdate, 0, 20800, 118009);

--출력
select ltrim(ID), name, business_id, tax_type, ltrim(category_id) from merchants;
select ltrim(ID), created_at, ltrim(category), ltrim(amount), ltrim(merchant_id) from card_usages;

----풀이
select sum(amount)aa
from
            (
            select rownum aa, rr.amount
            from (select rownum a, amount from card_usages)rr
            )rr2
where rr2.aa <=2;

select*
from
            (
            select mer.id, mer.name, sum(card.amount)
            from merchants mer join card_usages card on (mer.id = card.merchant_id)
            where card.category = 0
            group by mer.id, mer.name
            order by 3 desc
            )
where rownum <= 5;

-------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------

create table EMPLOYEES_shinhan(
    id number primary key ,
    NAME VARCHAR(20) not null,
    SALARY number(20,0) not null,
    BRANCH_ID NUMERIC  not null);
    
insert into EMPLOYEES_shinhan values(1015, 'Vex', 900, 1);
insert into EMPLOYEES_shinhan values(3317, ' Stephanie', 250, 3);
insert into EMPLOYEES_shinhan values(3884 , 'Audrina',470, 1);
insert into EMPLOYEES_shinhan values(3912, ' Courtney', 300, 2);

create table SELLINGS_shinhan (
CAR_ID number not null,
EMPLOYEE_ID number not null,
CREATED_AT date not null,
PRICE NUMERIC(20,0) not null);

insert into SELLINGS_shinhan values(306, 3317,  to_date('2016-07-19 12:40:54','yyyy-mm-dd hh24:mi:ss'), 500);
insert into SELLINGS_shinhan values(414, 3884 , to_date('2016-07-17 07:53:19','yyyy-mm-dd hh24:mi:ss'), 1700);
insert into SELLINGS_shinhan values(537, 3317,  to_date('2016-07-22 18:47:05','yyyy-mm-dd hh24:mi:ss'), 1600);
insert into SELLINGS_shinhan values(594, 3884,  to_date('2016-12-02 19:33:28','yyyy-mm-dd hh24:mi:ss'), 700);
insert into SELLINGS_shinhan values(810, 3912,  to_date('2016-07-09 03:09:21','yyyy-mm-dd hh24:mi:ss'), 4100);
insert into SELLINGS_shinhan values(900, 1015,  to_date('2016-08-14 13:20:56','yyyy-mm-dd hh24:mi:ss'), 15300);
commit;

select * from  EMPLOYEES_shinhan;
select * from SELLINGS_shinhan;

-------풀이

select salary, sell.price
from EMPLOYEES_shinhan emp join SELLINGS_shinhan sell on (emp.salary = sell.price)
where created_at between '2016-07-01%' and '2016-07-31%';

select emp.name, max(emp.salary)
from EMPLOYEES_shinhan emp join SELLINGS_shinhan sell on (emp.id = sell.employee_id)
where to_char(created_at, 'yyyy-mm') = '2016-07'
group by emp.name
having round(sum(sell.price)/max(emp.salary)) between 0 and 10
order by 2 desc, 1asc;

-------------------------------------------------------------------
select emp.name, max(emp.salary)
from   EMPLOYEES_shinhan emp join SELLINGS_shinhan  sell on (emp.id = sell.EMPLOYEE_ID)
where emp.id in (select  EMPLOYEE_ID
                                    from SELLINGS_shinhan
                                    where  to_char(CREATED_AT, 'yyyy-mm')  = '2016-07' )
group by emp.name
having round(sum(sell.PRICE) /max(emp.salary)) between 0 and 10
order by 2 desc, 1 asc ;