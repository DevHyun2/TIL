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
--checkList(부서별)
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
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT개발팀', null,
        '프로젝트 관리 및 실행', '팀의 기술 역량과 전문성이 프로젝트의 진행에 어느 정도 기여하고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT개발팀', null,
        '협업과 의사소통', '팀원들 간의 협업과 의사소통이 프로젝트의 효율성에 어떤 영향을 미치고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT개발팀', null,
        '기술 역량 및 품질 관리', '팀의 기술 역량이 프로젝트의 결과물 품질에 어떤 영향을 미치고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT개발팀', null,
        '문제 해결 및 혁신', '팀이 기술적인 문제를 해결하는데 얼마나 능숙하게 대응하고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        'IT개발팀', null,
        '개인 및 팀 성장', '팀원들의 기술적 성장과 전문성 향상을 지원하는 데 팀이 제공하는 프로그램 및 활동에 대해 어떻게 평가하는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '마케팅팀', null,
        '전략 및 계획 수립', '마케팅팀이 전략과 계획을 수립하는 과정에서 전문성과 창의성을 얼마나 발휘하고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '마케팅팀', null,
        '캠페인 및 프로모션 실행', '마케팅팀이 실행한 캠페인 및 프로모션의 효과를 얼마나 효과적으로 측정하고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '마케팅팀', null,
        '고객 관계 및 커뮤니케이션', '마케팅팀이 고객과의 관계를 유지하고 개선하기 위해 적극적으로 노력하고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '마케팅팀', null,
        '브랜딩 및 시장 분석', '마케팅팀이 브랜딩 및 시장 분석을 통해 경쟁력을 확보하고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        '마케팅팀', null,
        '성과 및 ROI 분석', '마케팅팀이 수행한 활동의 성과를 적절하게 분석하고 ROI를 평가하는 능력은 어떤가');        
--checkLists(직급별)
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '부장',
        '전략 및 리더십', '부장급 직원이 전략을 개발하고 조직의 목표를 이루기 위한 계획을 세우는 데 얼마나 효과적으로 기여하고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '부장',
        '팀 관리 및 개발', '부장급 직원이 팀원들을 관리하고 개발하는 데 어느 정도 성과를 보이고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '부장',
        '의사소통 및 협력', '부장급 직원이 부서 간 협력과 의사소통을 원활하게 이끌어내는 데 어느 정도 능력을 보여주고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '부장',
        '결과 및 성과', '부장급 직원의 업무 수행 결과와 성과가 조직의 목표 달성에 얼마나 기여하고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '부장',
        '전문성 및 개인 성장', '부장급 직원이 자신의 전문 분야에 대한 지식과 역량을 얼마나 개발하고 성장시키고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '팀장',
        '목표 설정 및 전략 구상', '팀장급 직원이 목표를 설정하고 전략을 구상하는 과정에서 얼마나 효과적으로 기여하고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '팀장',
        '팀 조직 및 리더십', '팀장급 직원이 팀을 조직하고 리드하는 데 어느 정도 성과를 보이고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '팀장',
        '의사소통 및 협력', '팀장급 직원이 팀원들 간의 의사소통과 협력을 원활하게 이끌어내는 데 어느 정도 능력을 보여주고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '팀장',
        '성과 및 결과 도출', '팀장급 직원의 업무 수행 결과와 성과가 팀의 목표 달성에 얼마나 기여하고 있는가');        
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '팀장',
        '개인 및 팀원 성장 지원', '팀장급 직원이 개인과 팀원들의 성장을 적극적으로 지원하고 발전시키는 데 어느 정도 노력하고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '대리',
        '업무 수행 및 실행능력', '대리급 직원이 맡은 업무를 효과적으로 수행하고 실행하고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '대리',
        '팀 협업 및 지원', '대리급 직원이 팀원들과의 협업을 원활하게 이끌어내고 지원하는 데 노력하고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '대리',
        '문제 해결 및 이슈 대응', '대리급 직원이 발생한 문제나 이슈에 대응하고 해결하는 능력은 어떤가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '대리',
        '자기계발 및 역량 강화', '대리급 직원이 자기계발을 위해 노력하고 역량을 강화하고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '대리',
        '의사소통 및 리더십', '대리급 직원이 팀 내 의사소통을 원활히 이끌어내고 리더십을 발휘하는 능력은 어떤가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '사원',
        '업무 수행 및 성과', '사원급 직원이 맡은 업무를 효과적으로 수행하고 성과를 얻고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '사원',
        '협업 및 의사소통', '사원급 직원이 팀 내 협업과 의사소통에 적극적으로 참여하고 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '사원',
        '문제 해결 및 적응력', '사원급 직원이 문제를 해결하고 새로운 상황에 빠르게 적응하는 능력은 어떤가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '사원',
        '자기개발 및 업무 확장', '사원급 직원이 자기개발을 위해 노력하고 업무를 확장하는 데 관심이 있는가');
INSERT INTO checkLists (check_id, department, rank, check_name, description)
VALUES(
        (SELECT NVL(MAX(check_id), 0) + 1 FROM checkLists),
        null, '사원',
        '타인 존중 및 팀워크', '사원급 직원이 동료를 존중하고 팀워크에 기여하고 있는가');
----------------------------------------------------------------------
select admin_id, employee_pw from employees where admin_id = 1 and employee_pw = 19830424;
select * from employees where employee_id = 101;

select * from employees;
select * from checklists;
select * from selfchecklists;
select * from performances;