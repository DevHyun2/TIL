-- ��� ���̺� ����
CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    birthdate VARCHAR2(20) NOT NULL,
    employee_pw VARCHAR2(300) NOT NULL,
    department VARCHAR2(300),
    rank VARCHAR2(50),
    join_date DATE,
    admin_id NUMBER, -- �̴� �����ڵ� ��� ���̺� ���Ե��� �����մϴ�.
    CONSTRAINT admin_fk FOREIGN KEY (admin_id) REFERENCES employees(employee_id)
);

-- �� ���� ���̺� ����
CREATE TABLE checkLists (
    check_id NUMBER PRIMARY KEY,
    check_name VARCHAR2(100) NOT NULL,
    department VARCHAR2(300),
    rank VARCHAR2(50),
    description VARCHAR2(500)
);

-- �λ� �� ���� ���̺� ����
CREATE TABLE performances (
    review_id NUMBER PRIMARY KEY,
    employee_id NUMBER NOT NULL,
    check_id NUMBER NOT NULL,
    score NUMBER,
    review_year NUMBER,
    CONSTRAINT employee_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    CONSTRAINT check_kf FOREIGN KEY (check_id) REFERENCES checkLists(check_id)
);

-- �ڱ� �� ���� ���̺� ����
CREATE TABLE selfcheckLists (
    self_id NUMBER PRIMARY KEY,
    employee_id NUMBER NOT NULL,
    check_id NUMBER NOT NULL,
    score NUMBER,
    self_year NUMBER,
    CONSTRAINT employee_self_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    CONSTRAINT check_self_fk FOREIGN KEY (check_id) REFERENCES checkLists(check_id)
);
drop table employees;
drop table checklists;
drop table performances;
drop table selfchecklists;
---------------------------------------------------------------------------------------------
--������ ����
--employees
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (1, '������', '1983/04/24', '19830424', NULL, '����', '2020/02/08', 1);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (101, '�ں���', '1979/10/19', '19791019', '�λ���', '����', '2020/04/20', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (102, '������', '1985/06/21', '19850621', '�λ���', '����', '2020/07/10', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (103, '�Ѵ븮', '1990/11/08', '19901108', '�λ���', '�븮', '2021/01/08', NULL);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (201, '������', '1986/03/19', '19860319', 'IT������', '����', '2020/06/05', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (202, '�ڴ븮', '1989/06/18', '19860618', 'IT������', '�븮', '2020/12/10', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (203, '�ֻ��', '1994/08/17', '19940817', 'IT������', '���', '2021/06/12', NULL);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (301, '������', '1983/02/08', '19830208', '��������', '����', '2020/03/25', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (302, '�̴븮', '1990/05/05', '19900505', '��������', '�븮', '2020/09/18', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (303, '�����', '1995/04/19', '19950419', '��������', '���', '2021/04/05', NULL);
----------------------------------------------------------------------
INSERT INTO checkLists (check_id, check_name, department, rank, description)
VALUES (1, 'Productivity', 101, 'Manager', 'Productivity of the employee within the department.');



select * from employees;