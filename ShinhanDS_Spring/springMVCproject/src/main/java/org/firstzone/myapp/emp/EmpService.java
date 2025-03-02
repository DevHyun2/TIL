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

	// type이 같으면 자동으로 Injection
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

	// 4.?듅?젙JOB?씤 吏곸썝議고쉶
	public List<EmpDTO> selectByJob(String jobid) {
		return empDAO.selectByJob(jobid);
	}

	// 3.?듅?젙遺??꽌?쓽 吏곸썝紐⑤몢議고쉶
	public List<EmpDTO> selectBydept(int deptid) {
		return empDAO.selectBydept(deptid);
	}

	// 2.?듅?젙吏곸썝?쓽 ?긽?꽭蹂닿린
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}

	// 1.吏곸썝紐⑤몢議고쉶
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 9. 吏곸썝踰덊샇瑜? ?씠?슜?빐 吏곸썝?쓽 ?씠由꾧낵 吏곸콉怨? 湲됱뿬瑜? 議고쉶?븳?떎.
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}

	// 10. 吏곸썝踰덊샇媛? ?뱾?뼱?삤硫? 吏곸썝蹂대꼫?뒪瑜? return?븯?뒗 ?븿?닔瑜? ?샇異쒗븳?떎.
	public double callFunction(int empid) {
		return empDAO.callFunction(empid);
	}
}
