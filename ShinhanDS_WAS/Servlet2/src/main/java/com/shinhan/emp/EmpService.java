package com.shinhan.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Controller -> Service -> DAO
//            <-         <-
// Service: 비즈니스 로직을 수행, DB와 관련 없는 로직은 여기서 수행
public class EmpService {

	EmpDAO empDAO = new EmpDAO();

	// 1.직원 모두 조회
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2.특정 직원 상세 보기
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}

	// 3.특정 부서 직원 상세 조회
	public List<EmpDTO> selectByDept(int dept) {
		return empDAO.selectByDept(dept);
	}

	// 4.특정 Job인 직원 상세 조회
	public List<EmpDTO> selectByJob(String job) {
		return empDAO.selectByJob(job);
	}

	// 5.다양한 조건으로 조회
	// 부서별(=), 직책별(=), 입사일별(>=), 급여(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 6.입력
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	
	// 7.수정
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	
	// 8.삭제
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

	// 9.직원 번호를 이용해 직원의 이름과 직책, 급여를 조회
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}
	
	// 10. 직원 번호가 들어오면 직원 보너스를 return 하는 함수를 호출
	public double callFunction(int empid) {
		return empDAO.callFunction(empid);
	}
	
	// 이메일 중복 체크
	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}
	
	// 매니저 전부 조회
	public List<HashMap<String, Object>> selectAllManager() {
		return empDAO.selectAllManager();
	}
	
	// 로그인
	public EmpDTO loginChk(String email, String phone) {
		return empDAO.loginChk(email, phone);
	}
}
