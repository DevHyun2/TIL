package com.shinhan.day18;

import java.util.List;



public class DeptService {
		
	DeptDAO deptDAO = new DeptDAO();
	//모두 조회
		public List<DeptDTO> selectAll() {
			return deptDAO.selectAll();
		}
}
