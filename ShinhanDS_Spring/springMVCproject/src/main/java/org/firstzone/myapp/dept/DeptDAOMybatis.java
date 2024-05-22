package org.firstzone.myapp.dept;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.firstzone.myapp.emp.EmpDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.myapp.util.DateUtil;

//DAO
@Repository("deptmybatis")
public class DeptDAOMybatis implements DeptDAOInterface{
	@Autowired
	SqlSession sqlSession;
	
	Logger logger = LoggerFactory.getLogger(DeptDAOMybatis.class);
	String namespace = "com.shinhan.dept.";
	
	public List<DeptDTO> selectAll() {
		System.out.println("=====");
		logger.info("DeptDAOMybatis...selectAll() ");
		return sqlSession.selectList(namespace + "selectAll");
	}
	
	public DeptDTO selectById(int deptid) {
		logger.info("DeptDAOMybatis...selectById() ");
		sqlSession.selectOne(namespace + "selectById", deptid);
		return null;
	}
	
	public List<DeptDTO> selectByName(String deptname) {
		logger.info("DeptDAOMybatis...selectByName() ");
		return sqlSession.selectList(namespace + "selectByName", deptname);
	}
	
	public int deptUpdate(DeptDTO dept) {
		logger.info("DeptDAOMybatis...deptUpdate() ");
		return sqlSession.update(namespace + "deptUpdate", dept);
	}



	public int deptDelete(int deptid) {
		logger.info("DeptDAOMybatis...deptDelete() ");
		return sqlSession.delete(namespace + "deptDelete", deptid);
	}

	public int deptInsert(DeptDTO dept) {
		return sqlSession.insert(namespace + "deptInsert", dept);
	}

	
	 public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid,
	 int lid) {
	logger.info("DeptDAOMybatis...selectByName() "); 
	 return sqlSession.selectList(namespace + "selectByCondition", deptname); }
	 
}