package com.shinhan.dept;

import java.util.List;

public class DeptService {
	DeptDAO deptDAO = new DeptDAO();
	
	// 1.부서 모두 조회
	public List<DeptDTO> selectAll(){
		return deptDAO.selectAll();
	}
	
	// 2.특정 부서 조회
	public DeptDTO selectByID(int deptid) {
		return deptDAO.selectByID(deptid);
	}
	
	// 3.부서 입력
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}
	
	// 4.부서 수정
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}
	
	// 5.부서 삭제
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);
	}
	
}
