-- ��� ���̺� ����
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

-- �� ���� ���̺� ����
CREATE TABLE checkLists (
    check_id NUMBER PRIMARY KEY,
    department VARCHAR2(300),
    rank VARCHAR2(50),
    check_name VARCHAR2(100) NOT NULL,
    description VARCHAR2(500)
);

-- �λ� �� ���� ���̺� ����
CREATE TABLE performances (
    review_id NUMBER PRIMARY KEY,
    employee_id NUMBER NOT NULL,
    check_id NUMBER NOT NULL,
    score NUMBER check (score BETWEEN 1 AND 5),
    review_year NUMBER ,
    CONSTRAINT employee_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    CONSTRAINT check_kf FOREIGN KEY (check_id) REFERENCES checkLists(check_id)
);

-- �ڱ� �� ���� ���̺� ����
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
--������ ����
--employees
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (1, '������', '1983/04/24', 19830424, NULL, '����', '2020/02/08', 1);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (101, '�ں���', '1979/10/19', 19791019, '�λ���', '����', '2020/04/20', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (102, '������', '1985/06/21', 19850621, '�λ���', '����', '2020/07/10', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (103, '�Ѵ븮', '1990/11/08', 19901108, '�λ���', '�븮', '2021/01/08', NULL);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (201, '������', '1986/03/19', 19860319, 'IT������', '����', '2020/06/05', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (202, '�ڴ븮', '1989/06/18', 19860618, 'IT������', '�븮', '2020/12/10', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (203, '�ֻ��', '1994/08/17', 19940817, 'IT������', '���', '2021/06/12', NULL);

INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (301, '������', '1983/02/08', 19830208, '��������', '����', '2020/03/25', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (302, '�̴븮', '1990/05/05', 19900505, '��������', '�븮', '2020/09/18', NULL);
INSERT INTO employees (employee_id, name, birthdate, employee_pw, department, rank, join_date, admin_id)
VALUES (303, '�����', '1995/04/19', 19950419, '��������', '���', '2021/04/05', NULL);

COMMIT;
--checkList(�μ���)
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '�λ���', null,
        '������ ��ȹ �� ����', '�λ����� ������ ������ ��ǥ�� ����Ͽ� ���� ���� ������ �����ϰ� �����ϴ� �������� ȿ�������� ����ǰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '�λ���', null,
        '������ ��ȹ �� ����', '�λ����� �λ���å �� ���α׷��� ������ �� ������ ������ ��ǥ�� ���������� �ݿ��ϰ� �ִ°�');              
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '�λ���', null,
        '�λ� � �� ����', '�λ����� ä�� �� ���� ���μ����� ��ϰ� ���� �� ȿ������ �������� ���');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '�λ���', null,
        '���ذ����� ����', '�λ����� ���� ���ذ����ڿ��� ������ ����Ű�� ���� ����� ��Ѱ�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '�λ���', null,
        '���ذ����� ����', '�ܺ� ���ذ����ڿ��� ���踦 �����ϰ� ������Ű�� ���� �λ����� �ϰ��ִ� Ȱ���� ���');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '�λ���', null,
        '�� �� ����', '�λ����� ������ ������ ���ϰ� �ǵ���� �����ϴ� ���μ����� ���');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '�λ���', null,
        '�� �� ����', '�λ� ���μ����� �м��ϰ� �����ϱ� ���� ����� ���');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT������', null,
        '������Ʈ ���� �� ����', '���� ��� ������ �������� ������Ʈ�� ���࿡ ��� ���� �⿩�ϰ� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT������', null,
        '������ �ǻ����', '������ ���� ������ �ǻ������ ������Ʈ�� ȿ������ � ������ ��ġ�� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT������', null,
        '��� ���� �� ǰ�� ����', '���� ��� ������ ������Ʈ�� ����� ǰ���� � ������ ��ġ�� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT������', null,
        '���� �ذ� �� ����', '���� ������� ������ �ذ��ϴµ� �󸶳� �ɼ��ϰ� �����ϰ� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT������', null,
        '���� �� �� ����', '�������� ����� ����� ������ ����� �����ϴ� �� ���� �����ϴ� ���α׷� �� Ȱ���� ���� ��� ���ϴ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '��������', null,
        '���� �� ��ȹ ����', '���������� ������ ��ȹ�� �����ϴ� �������� �������� â�Ǽ��� �󸶳� �����ϰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '��������', null,
        'ķ���� �� ���θ�� ����', '���������� ������ ķ���� �� ���θ���� ȿ���� �󸶳� ȿ�������� �����ϰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '��������', null,
        '�� ���� �� Ŀ�´����̼�', '���������� ������ ���踦 �����ϰ� �����ϱ� ���� ���������� ����ϰ� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '��������', null,
        '�귣�� �� ���� �м�', '���������� �귣�� �� ���� �м��� ���� ������� Ȯ���ϰ� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '��������', null,
        '���� �� ROI �м�', '���������� ������ Ȱ���� ������ �����ϰ� �м��ϰ� ROI�� ���ϴ� �ɷ��� ���');        
--checkLists(���޺�)
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '���� �� ������', '����� ������ ������ �����ϰ� ������ ��ǥ�� �̷�� ���� ��ȹ�� ����� �� �󸶳� ȿ�������� �⿩�ϰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '�� ���� �� ����', '����� ������ �������� �����ϰ� �����ϴ� �� ��� ���� ������ ���̰� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '�ǻ���� �� ����', '����� ������ �μ� �� ���°� �ǻ������ ��Ȱ�ϰ� �̲���� �� ��� ���� �ɷ��� �����ְ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '��� �� ����', '����� ������ ���� ���� ����� ������ ������ ��ǥ �޼��� �󸶳� �⿩�ϰ� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '������ �� ���� ����', '����� ������ �ڽ��� ���� �о߿� ���� ���İ� ������ �󸶳� �����ϰ� �����Ű�� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '��ǥ ���� �� ���� ����', '����� ������ ��ǥ�� �����ϰ� ������ �����ϴ� �������� �󸶳� ȿ�������� �⿩�ϰ� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '�� ���� �� ������', '����� ������ ���� �����ϰ� �����ϴ� �� ��� ���� ������ ���̰� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '�ǻ���� �� ����', '����� ������ ������ ���� �ǻ����� ������ ��Ȱ�ϰ� �̲���� �� ��� ���� �ɷ��� �����ְ� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '���� �� ��� ����', '����� ������ ���� ���� ����� ������ ���� ��ǥ �޼��� �󸶳� �⿩�ϰ� �ִ°�');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '����',
        '���� �� ���� ���� ����', '����� ������ ���ΰ� �������� ������ ���������� �����ϰ� ������Ű�� �� ��� ���� ����ϰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '�븮',
        '���� ���� �� ����ɷ�', '�븮�� ������ ���� ������ ȿ�������� �����ϰ� �����ϰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '�븮',
        '�� ���� �� ����', '�븮�� ������ ��������� ������ ��Ȱ�ϰ� �̲���� �����ϴ� �� ����ϰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '�븮',
        '���� �ذ� �� �̽� ����', '�븮�� ������ �߻��� ������ �̽��� �����ϰ� �ذ��ϴ� �ɷ��� ���');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '�븮',
        '�ڱ��� �� ���� ��ȭ', '�븮�� ������ �ڱ����� ���� ����ϰ� ������ ��ȭ�ϰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '�븮',
        '�ǻ���� �� ������', '�븮�� ������ �� �� �ǻ������ ��Ȱ�� �̲���� �������� �����ϴ� �ɷ��� ���');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '���',
        '���� ���� �� ����', '����� ������ ���� ������ ȿ�������� �����ϰ� ������ ��� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '���',
        '���� �� �ǻ����', '����� ������ �� �� ������ �ǻ���뿡 ���������� �����ϰ� �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '���',
        '���� �ذ� �� ������', '����� ������ ������ �ذ��ϰ� ���ο� ��Ȳ�� ������ �����ϴ� �ɷ��� ���');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '���',
        '�ڱⰳ�� �� ���� Ȯ��', '����� ������ �ڱⰳ���� ���� ����ϰ� ������ Ȯ���ϴ� �� ������ �ִ°�');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '���',
        'Ÿ�� ���� �� ����ũ', '����� ������ ���Ḧ �����ϰ� ����ũ�� �⿩�ϰ� �ִ°�');
----------------------------------------------------------------------
select admin_id, employee_pw from employees where admin_id = 1 and employee_pw = 19830424;
select * from employees where employee_id = 101;

select * from employees;
select * from checklists;
select * from selfchecklists;
select * from performances;