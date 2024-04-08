-- 사원 테이블 생성
CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    birthdate VARCHAR2(20) NOT NULL,
    employee_pw VARCHAR2(300) NOT NULL,
    department VARCHAR2(300),
    rank VARCHAR2(50),
    join_date DATE,
    admin_id NUMBER,
    CONSTRAINT admin_fk FOREIGN KEY (admin_id) REFERENCES employees(employee_id)
);

-- 평가 기준 테이블 생성
CREATE TABLE checkLists (
    check_id NUMBER PRIMARY KEY,
    check_name VARCHAR2(100) NOT NULL,
    department VARCHAR2(300),
    rank VARCHAR2(50),
    description VARCHAR2(500)
);

-- 인사 평가 점수 테이블 생성
CREATE TABLE performances (
    review_id NUMBER PRIMARY KEY,
    employee_id NUMBER NOT NULL,
    check_id NUMBER NOT NULL,
    score NUMBER,
    review_year NUMBER,
    CONSTRAINT employee_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    CONSTRAINT check_kf FOREIGN KEY (check_id) REFERENCES checkLists(check_id)
);

-- 자기 평가 점수 테이블 생성
CREATE TABLE selfcheckLists (
    self_id NUMBER PRIMARY KEY,
    employee_id NUMBER NOT NULL,
    check_id NUMBER NOT NULL,
    score NUMBER,
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

---------------------------------------------------------------------------------------------
--데이터 삽입
--employees
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES 
                (1, '공사장', '1983/04/24', '19830424', NULL, '사장', '2020/02/08', 1),
                (101, '박부장', '1979/10/19', '19791019', '인사팀', '부장', '2020/04/20', NULL),
                (102, '정팀장', '1985/06/21', '19850621', '인사팀', '팀장', '2020/07/10', NULL),
                (103, '한대리', '1990/11/08', '19901108', '인사팀', '대리', '2021/01/08', NULL),
                (201, '김팀장', '1986/03/19', '19860319', 'IT개발팀', '팀장', '2020/06/05', NULL),
                (202, '박대리', '1989/06/18', '19860618', 'IT개발팀', '대리', '2020/12/10', NULL),
                (203, '최사원', '1994/08/17', '19940817', 'IT개발팀', '사원', '2021/06/12', NULL),
                (301, '서부장', '1983/02/08', '19830208', '마케팅팀', '부장', '2020/03/25', NULL),
                (302, '이대리', '1990/05/05', '19900505', '마케팅팀', '대리', '2020/09/18', NULL),
                (303, '유사원', '1995/04/19', '19950419', '마케팅팀', '사원', '2021/04/05', NULL);
/*
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (101, '박부장', '1979/10/19', '19791019', '인사팀', '부장', '2020/04/20', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (102, '정팀장', '1985/06/21', '19850621', '인사팀', '팀장', '2020/07/10', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (103, '한대리', '1990/11/08', '19901108', '인사팀', '대리', '2021/01/08', NULL);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (201, '김팀장', '1986/03/19', '19860319', 'IT개발팀', '팀장', '2020/06/05', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (202, '박대리', '1989/06/18', '19860618', 'IT개발팀', '대리', '2020/12/10', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (203, '최사원', '1994/08/17', '19940817', 'IT개발팀', '사원', '2021/06/12', NULL);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (301, '서부장', '1983/02/08', '19830208', '마케팅팀', '부장', '2020/03/25', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (302, '이대리', '1990/05/05', '19900505', '마케팅팀', '대리', '2020/09/18', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (303, '유사원', '1995/04/19', '19950419', '마케팅팀', '사원', '2021/04/05', NULL);
*/
COMMIT;
----------------------------------------------------------------------
INSERT INTO checkLists (check_id, check_name, department, rank, description)
VALUES (1, 'Productivity', 101, 'Manager', 'Productivity of the employee within the department.');


select * from employees;
select * from checklists;
select * from selfchecklists;
select * from performances;