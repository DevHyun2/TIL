package com.shinhan.emp;

import java.sql.Date;
import java.util.List;
import java.util.Map;

// DB와 관련없는 로직을 다룸

// Controller -> Service -> DAO
//			  <- 		 <-
// Service : 비지니스 로직을 수행한다.
public class EmpService {
	
	EmpDAO empDAO = new EmpDAO();
	
	// 삭제(Delete)
		public int empDelete(int empid) {
			return empDAO.empDelete(empid);
		}
	
	// 수정(Update)
		public int empUpdate(EmpDTO emp) {
			return empDAO.empUpdate(emp);
		}
	
	// 입력(Insert)
		public int empInsert(EmpDTO emp) {
			return empDAO.empInsert(emp);
		}
	
	//5.다양한 조건으로 조회하기
		//부서별, 직책별, 입사일별(>=), 급여(>=)
		public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
			return empDAO.selectByCondition(deptid, jobid, hdate, salary);
		}
	
	// 4.특정 JOB인 직원 조회
	public List<EmpDTO> selectByJobId(String jobid) {
		return empDAO.selectByJobId(jobid);
	}
	
	// 3. 특정 부서의 직원들 조회
	public List<EmpDTO> selectByDepId(int depid) {
		return empDAO.selectByDepId(depid);
	}
	
	
	
	// 2.특정 직원의 상세보기
		public EmpDTO selectById(int empid) {
			return empDAO.selectById(empid);
		}
	
	
	//1.직원 모두 조회
	public List<EmpDTO> selectAll() {
		
		return empDAO.selectAll();
	}
	
	//직원 번호를 이용해서 직원의 이름, 직책, 급여를 조회
	public Map<String, Object> empInfo(int empid) {
		// TODO Auto-generated method stub
		return empDAO.empInfo(empid);
	}
	
	//직원 번호가 들어오면 직원보너스를 return하는 함수를 호출한다.
		public double callFunction(int empid) {
			return empDAO.callFunction(empid);
		}
	//email중복체크
	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}
}
