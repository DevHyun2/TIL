package org.firstzone.myapp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
	
	@Autowired
	DeptDAO deptDAO;
	
	// 1.遺��꽌 紐⑤몢 議고쉶
	public List<DeptDTO> selectAll(){
		return deptDAO.selectAll();
	}
	
	// 2.�듅�젙 遺��꽌 議고쉶
	public DeptDTO selectByID(int deptid) {
		return deptDAO.selectByID(deptid);
	}
	
	// 3.遺��꽌 �엯�젰
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}
	
	// 4.遺��꽌 �닔�젙
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}
	
	// 5.遺��꽌 �궘�젣
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);
	}
	
}
