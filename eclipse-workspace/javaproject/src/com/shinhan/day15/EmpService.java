package com.shinhan.day15;

import java.util.List;

// DB와 관련없는 로직을 다룸

// Controller -> Service -> DAO
//			  <- 		 <-
// Service : 비지니스 로직을 수행한다.
public class EmpService {
	
	EmpDAO empDAO = new EmpDAO();
	
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
}
