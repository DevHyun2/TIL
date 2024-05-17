package org.firstzone.myapp.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Controller -> Service -> DAO
//            <-         <-
// Service: ?��꾩쫰�땲�뒪 濡쒖쭅�?�� �닔�뻾, DB�� ?����?�� �뾾�뒗 濡쒖쭅��? �뿬湲곗�? �닔�뻾
@Service
public class EmpService {
	
	//type이 같으면 자동으로 Injection
	@Autowired
	EmpDAO empDAO;
	
	//EmpDAO empDAO = new EmpDAO();

	// 1.吏곸?�� 紐⑤�? 議고?��
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2.�듅�젙 吏곸?�� �긽�꽭 蹂닿�?
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}

	// 3.�듅�젙 ?�����? 吏곸?�� �긽�꽭 議고?��
	public List<EmpDTO> selectByDept(int dept) {
		return empDAO.selectByDept(dept);
	}

	// 4.�듅�젙 Job�씤 吏곸?�� �긽�꽭 議고?��
	public List<EmpDTO> selectByJob(String job) {
		return empDAO.selectByJob(job);
	}

	// 5.�떎�뼇�븳 議곌굔�?��濡� 議고?��
	// ?����꽌蹂�?(=), 吏곸콉蹂�?(=), �엯�궗�씪蹂�(>=), 湲됱�?(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 6.�엯�젰
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	
	// 7.�닔�젙
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	
	// 8.�궘�젣
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

	// 9.吏곸?�� 踰덊?��?���? �씠�슜�빐 吏곸?���쓽 �씠?��꾧낵 吏곸�?, 湲됱뿬瑜�? 議고?��
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}
	
	// 10. 吏곸?�� 踰덊?��媛� �뱾�뼱�삤硫� 吏곸?�� 蹂�?꼫�?��?���? return �븯�뒗 �븿�닔?���? �샇?���?
	public double callFunction(int empid) {
		return empDAO.callFunction(empid);
	}
	
	// �씠硫붿?�� 以묐?�� 泥댄�?
	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}
	
	// 留ㅻ?���� �쟾?���? 議고?��
	public List<HashMap<String, Object>> selectAllManager() {
		return empDAO.selectAllManager();
	}
	
	// 濡쒓?���씤
	public EmpDTO loginChk(String email, String phone) {
		return empDAO.loginChk(email, phone);
	}
	public List<JobDTO> selectAllJob() {
		return empDAO.selectAllJob();
	}
}
