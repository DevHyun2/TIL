package com.shinhan.dept;

import java.util.List;

//Controller->Service->DAO
//			<-		 <-
//Service : 비지니스 로직을 수행한다. (DB와 관련없는 로직 있을때 유용)
public class DeptService {
	DeptDAO deptDAO = new DeptDAO();

	// 이름 달라도 되는데, 같으면 알아보기 쉽다.
	

	//8. 삭제(Delete)
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);

	}

	// 7. 수정(Update)
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}

	// 6. 입력(Insert)
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}

	// 5. 다양한 조건으로 조회하기
	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid) {
		return deptDAO.selectByCondition(deptid, deptname, mid, lid);
	}

//	// 4. 특정JOB인 직원조회
//	public List<DeptDTO> selectByJob(String jobid) {
//		return empDAO.selectByJob(jobid);
//	}
//
//	// 3. 특정직원의 직원조회
//	public List<DeptDTO> selectByDept(int deptid) {
//		return empDAO.selectByDept(deptid);
//	}

	// 2. 특정부서의 상세보기
	public DeptDTO selectById(int deptid) {
		return deptDAO.selectById(deptid);
	}

	// 1. 직원모두조회
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}
}