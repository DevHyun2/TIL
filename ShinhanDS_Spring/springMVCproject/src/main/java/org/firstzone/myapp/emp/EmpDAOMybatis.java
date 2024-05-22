package org.firstzone.myapp.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.shinhan.myapp.util.DBUtil;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.firstzone.myapp.dept.DeptDAOMybatis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOMybatis {
	@Autowired
	SqlSession sqlSession;

	String namespace = "com.shinhan.emp.";
	Logger logger = LoggerFactory.getLogger(DeptDAOMybatis.class);

	public EmpDTO loginChk(String email, String phone) {
		EmpDTO emp = sqlSession.selectOne(namespace + "loginChk", email);
		logger.info(emp.toString());
		return emp;
	}

	public int empDelete(int empid) {
		int result = sqlSession.delete(namespace + "empDelete", empid);
		logger.info(result + "�� ������");
		return result;
	}

	public int empUpdate(EmpDTO emp) {
		int result = sqlSession.update(namespace + "empUpdate", emp);
		logger.info(result + "�� update��");
		return result;
	}

	public int empInsert(EmpDTO emp) {
		int result = sqlSession.update(namespace + "empInsert", emp);
		logger.info(result + "�� insert��");
		return result;
	}

	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		Map<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("deptid", deptid);
		conditionMap.put("jobid", jobid);
		conditionMap.put("hdate", hdate);
		conditionMap.put("salary", salary);
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByCondition", conditionMap);
		logger.info(emplist.toString());
		logger.info(emplist.size() + "�� ���� ��ȸ��");
		return emplist;
	}

	public List<EmpDTO> selectByJob(String jobid) {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByJob", "%" + jobid + "%");
		logger.info(emplist.toString());
		logger.info(emplist.size() + "�� job���� ��ȸ��");
		return emplist;
	}

	public List<EmpDTO> selectByJob2(String jobid) {
		return null;
	}

	public List<EmpDTO> selectBydept(int deptid) {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectBydept", "%" + deptid + "%");
		logger.info(emplist.toString());
		logger.info(emplist.size() + "�� dept���� ��ȸ��");
		return emplist;
	}

	public EmpDTO selectById(int empid) {
		EmpDTO emp = sqlSession.selectOne(namespace + "selectById", empid);
		logger.info(emp != null ? emp.toString() : "data����");
		return emp;
	}

	/*
	 * public EmpDTO EmpDTO(int empid) {
	 * 
	 * }
	 */

	public int selectByEmail(String email) {
		Integer emp = sqlSession.selectOne(namespace + "selectByEmail", email);
		logger.info(emp.toString());
		return emp;
	}

	// 1.직원모두조회
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectAll");
		logger.info(emplist.toString());
		logger.info(emplist.size() + "�� ��ȸ��");
		return emplist;
	}

	// 모든 job 조회
	public List<JobDTO> selectAllJob() {
		List<JobDTO> jlist = sqlSession.selectList(namespace + "selectAllJob");
		logger.info(jlist.toString());
		logger.info(jlist.size() + "�� ��ȸ��");
		return jlist;
	}

	// 매니?? 모두조회
	public List<HashMap<String, Object>> selectAllManager() {
		List<HashMap<String, Object>> mlist = sqlSession.selectList(namespace + "selectAllManager");
		logger.info(mlist.toString());
		logger.info(mlist.size() + "�� AllManager ��ȸ��");
		return mlist;
	}

	// 9.직원번호�? ?��?��받아?�� 직원?���?(?���?, 직책, 급여)�? return
	public Map<String, Object> empInfo(int empid) {
		return null;
	}

	// 10. 직원번호�? ?��?��?���? 직원보너?���? return?��?�� ?��?���? ?��출한?��.
	public double callFunction(int empid) {
		return 0;
	}

}
