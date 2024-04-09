-- 사원 테이블 생성
CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    birthdate VARCHAR2(20) NOT NULL,
    employee_pw NUMBER NOT NULL,
    department VARCHAR2(300),
    rank VARCHAR2(50),
    join_date DATE,
    admin_id NUMBER,
    CONSTRAINT admin_fk FOREIGN KEY (admin_id) REFERENCES employees(employee_id)
);

-- 평가 기준 테이블 생성
CREATE TABLE checkLists (
    check_id NUMBER PRIMARY KEY,
    department VARCHAR2(300),
    rank VARCHAR2(50),
    check_name VARCHAR2(100) NOT NULL,
    description VARCHAR2(500)
);

-- 인사 평가 점수 테이블 생성
CREATE TABLE performances (
    review_id NUMBER PRIMARY KEY,
    employee_id NUMBER NOT NULL,
    check_id NUMBER NOT NULL,
    score NUMBER check (score BETWEEN 1 AND 5),
    review_year NUMBER ,
    CONSTRAINT employee_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    CONSTRAINT check_kf FOREIGN KEY (check_id) REFERENCES checkLists(check_id)
);

-- 자기 평가 점수 테이블 생성
CREATE TABLE selfcheckLists (
    self_id NUMBER PRIMARY KEY,
    employee_id NUMBER NOT NULL,
    check_id NUMBER NOT NULL,
    score NUMBER check (score BETWEEN 1 AND 5),
    self_year NUMBER,
    CONSTRAINT employee_self_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    CONSTRAINT check_self_fk FOREIGN KEY (check_id) REFERENCES checkLists(check_id),
    CONSTRAINT unique_self_year UNIQUE (self_year)
);


--drop
drop table employees;
drop table checklists;
drop table performances;
drop table selfchecklists;

DELETE from checklists;
---------------------------------------------------------------------------------------------
--데이터 삽입
--employees
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (1, '공사장', '1983/04/24', 19830424, NULL, '사장', '2020/02/08', 1);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (101, '박부장', '1979/10/19', 19791019, '인사팀', '부장', '2020/04/20', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (102, '정팀장', '1985/06/21', 19850621, '인사팀', '팀장', '2020/07/10', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (103, '한대리', '1990/11/08', 19901108, '인사팀', '대리', '2021/01/08', NULL);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (201, '김팀장', '1986/03/19', 19860319, 'IT개발팀', '팀장', '2020/06/05', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (202, '박대리', '1989/06/18', 19860618, 'IT개발팀', '대리', '2020/12/10', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (203, '최사원', '1994/08/17', 19940817, 'IT개발팀', '사원', '2021/06/12', NULL);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (301, '서부장', '1983/02/08', 19830208, '마케팅팀', '부장', '2020/03/25', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (302, '이대리', '1990/05/05', 19900505, '마케팅팀', '대리', '2020/09/18', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (303, '유사원', '1995/04/19', 19950419, '마케팅팀', '사원', '2021/04/05', NULL);

COMMIT;
--checkList
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
                (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
                '인사팀', null,
                '전략적 계획 및 개발', '인사팀이 조직의 비전과 목표를 고려하여 인재 관리 전략을 개발하고 실행하는 과정에서 효과적으로 실행되고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
                (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
                '인사팀', null,
                '전략적 계획 및 개발', '인사팀이 인사정책 및 프로그램을 개발할 때 조직의 전략과 목표를 적극적으로 반영하고 있는가');              
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
                (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
                '인사팀', null,
                '인사 운영 및 관리', '인사팀이 채용 및 선발 프로세스를 운영하고 있을 때 효율성과 공정성은 어떤가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
                (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
                '인사팀', null,
                '이해관계자 관리', '인사팀이 내부 이해관계자와의 협력을 향상시키기 위한 노력은 어떠한가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
                (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
                '인사팀', null,
                '이해관계자 관리', '외부 이해관계자와의 관계를 유지하고 발전시키기 위해 인사팀이 하고있는 활동은 어떤가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
                (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
                '인사팀', null,
                '평가 및 개선', '인사팀이 조직의 성과를 평가하고 피드백을 제공하는 프로세스는 어떤가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
                (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
                '인사팀', null,
                '평가 및 개선', '인사 프로세스를 분석하고 개선하기 위한 노력은 어떤가');                
----------------------------------------------------------------------
select admin_id, employee_pw from employees where admin_id = 1 and employee_pw = 19830424;
select * from employees where employee_id = 101;

select * from employees;
select * from checklists;
select * from selfchecklists;
select * from performances;