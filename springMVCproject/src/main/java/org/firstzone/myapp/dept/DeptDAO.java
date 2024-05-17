package org.firstzone.myapp.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;
@Repository
public class DeptDAO {
	
	@Autowired
	DataSource ds;
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	// 1.遺��꽌 紐⑤몢 議고쉶
	public List<DeptDTO> selectAll(){
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * from departments";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return deptlist;
	}
	
	// 2.�듅�젙 遺��꽌 議고쉶
	public DeptDTO selectByID(int deptid) {
		DeptDTO dept = new DeptDTO();
		String sql = "select * from departments where department_id = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			rs = pst.executeQuery();
			if(rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return dept;
	}
	
	// 3.遺��꽌 �엯�젰
	public int deptInsert(DeptDTO dept) {
		int result = 0;
		String sql = "insert into departments values(?,?,?,?)";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dept.getDepartment_id());
			pst.setString(2, dept.getDepartment_name());
			pst.setInt(3, dept.getManager_id());
			pst.setInt(4, dept.getLocation_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 4.遺��꽌 �닔�젙
	public int deptUpdate(DeptDTO dept) {
		int result = 0;
		String sql = "update departments "
				+ "set department_name = ?, "
				+ "manager_id = ?, "
				+ "location_id = ? "
				+ "where department_id = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, dept.getDepartment_name());
			pst.setInt(2, dept.getManager_id());
			pst.setInt(3, dept.getLocation_id());
			pst.setInt(4, dept.getDepartment_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 5.遺��꽌 �궘�젣
	public int deptDelete(int deptid) {
		int result = 0;
		String sql = "delete departments where department_id = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	private DeptDTO makeDept(ResultSet rs2) throws SQLException {
		DeptDTO dept = new DeptDTO();
		
		dept.setDepartment_id(rs2.getInt("department_id"));
		dept.setDepartment_name(rs2.getString("department_name"));
		dept.setLocation_id(rs2.getInt("location_id"));
		dept.setManager_id(rs2.getInt("manager_id"));
		
		return dept;
	}
	
}
