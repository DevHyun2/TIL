package org.firstzone.myapp.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Controller->Service->DAO
//          <-         <- 
//Service 
@Service
public class EmpService {

	// type�� ������ �ڵ����� Injection
	@Autowired
	EmpDAO empDAO;

	public EmpDTO loginChk(String email, String phone) {
		return empDAO.loginChk(email, phone);
	}

	public List<JobDTO> selectAllJob() {
		return empDAO.selectAllJob();
	}

	public List<HashMap<String, Object>> selectAllManager() {
		return empDAO.selectAllManager();
	}

	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}

	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}

	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 4.?��?��JOB?�� 직원조회
	public List<EmpDTO> selectByJob(String jobid) {
		return empDAO.selectByJob(jobid);
	}

	// 3.?��?���??��?�� 직원모두조회
	public List<EmpDTO> selectBydept(int deptid) {
		return empDAO.selectBydept(deptid);
	}

	// 2.?��?��직원?�� ?��?��보기
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}

	// 1.직원모두조회
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 9. 직원번호�? ?��?��?�� 직원?�� ?��름과 직책�? 급여�? 조회?��?��.
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}

	// 10. 직원번호�? ?��?��?���? 직원보너?���? return?��?�� ?��?���? ?��출한?��.
	public double callFunction(int empid) {
		return empDAO.callFunction(empid);
	}
}
