package com.shinhan.day15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// DB와 업무를 보는 역할
// DAO (Data Access하는 비지니스 로직을 처리하는 Object)
public class EmpDAO {

	Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst; // Statement를 상속받음, 바인딩변수 지원

	// 직원 모두 조회
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(rs.getDouble("commission_pct"));
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("phone_number"));
		emp.setSalary(rs.getInt("salary"));

		return emp;
	}

	// 특정 직원 1명 조회
	// 2.특정 직원의 상세보기
	public EmpDTO selectById(int empid) {
		EmpDTO emp = null;
		String sql = "select * from employees where employee_id = " + empid;
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	// 특정 부서의 직원들 조회
	public List<EmpDTO> selectByDepId(int depid) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where department_id = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, depid);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	// 4.특정 JOB인 직원 조회
	public List<EmpDTO> selectByJobId(String jobid) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where job_id = ?||'%'";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, jobid);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	// 입력

	// 수정

	// 삭제
}
