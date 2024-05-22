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

	// typeÀÌ °°À¸¸é ÀÚµ¿À¸·Î Injection
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

	// 4.?Š¹? •JOB?¸ ì§ì›ì¡°íšŒ
	public List<EmpDTO> selectByJob(String jobid) {
		return empDAO.selectByJob(jobid);
	}

	// 3.?Š¹? •ë¶??„œ?˜ ì§ì›ëª¨ë‘ì¡°íšŒ
	public List<EmpDTO> selectBydept(int deptid) {
		return empDAO.selectBydept(deptid);
	}

	// 2.?Š¹? •ì§ì›?˜ ?ƒ?„¸ë³´ê¸°
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}

	// 1.ì§ì›ëª¨ë‘ì¡°íšŒ
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 9. ì§ì›ë²ˆí˜¸ë¥? ?´?š©?•´ ì§ì›?˜ ?´ë¦„ê³¼ ì§ì±…ê³? ê¸‰ì—¬ë¥? ì¡°íšŒ?•œ?‹¤.
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}

	// 10. ì§ì›ë²ˆí˜¸ê°? ?“¤?–´?˜¤ë©? ì§ì›ë³´ë„ˆ?Š¤ë¥? return?•˜?Š” ?•¨?ˆ˜ë¥? ?˜¸ì¶œí•œ?‹¤.
	public double callFunction(int empid) {
		return empDAO.callFunction(empid);
	}
}
