package com.shinhan.emp;

import java.sql.CallableStatement;
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

import com.shinhan.util.DBUtil;

// DAO(Data Access하는 비즈니스 로직을 처리하는 Object)
public class EmpDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst; // Statement를 상속 받음, 바인딩 변수 지원, 가변 sql문을 받을 때 더 효율적
	ResultSet rs;

	// 1.직원 모두 조회
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees order by 1";
		conn = DBUtil.dbConnection2();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	// 2. 특정 직원 상세 보기
	public EmpDTO selectById(int empid) {
		EmpDTO emp = null;
		String sql = "select * from employees where employee_id = ";
		conn = DBUtil.dbConnection2();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql + empid);
			if (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	// 3. 특정 부서의 근무하는 직원들 조회
	public List<EmpDTO> selectByDept(int dept) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where department_id = ?";
		conn = DBUtil.dbConnection2();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dept);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	// 4. 특정 Job인 직원들 조회
	public List<EmpDTO> selectByJob(String job) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where job_id = ?";
		conn = DBUtil.dbConnection2();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, job); // 첫번째 물음표에 job을 넣음
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return emplist;
	}
	
	// String에 +를 반복하는 것은 비효율적
	public List<EmpDTO> selectByJob2(String job) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where job_id = '"
				+ job
				+ "'";
		conn = DBUtil.dbConnection2();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}
	
	// 5. 다양한 조건으로 조회
	// 부서별(=), 직책별(=), 입사일별(>=), 급여(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * "
				+ "from employees "
				+ "where department_id = ? "
				+ "and job_id = ? "
				+ "and hire_date >= ? "
				+ "and salary >= ?";
		conn = DBUtil.dbConnection2();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid); // 첫번째 ?에 deptid를 넣어라
			pst.setString(2, jobid); // 두번째 ?에 jobid를 넣어라
			pst.setDate(3, hdate); // 세번째 ?에 hdate를 넣어라
			pst.setInt(4, salary); // 네번째 ?에 salary를 넣어라
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return emplist;
	}
	
	// 6. 입력
	public int empInsert(EmpDTO emp) {
		int result = 0;
		String sql = "insert into employees values (?,?,?,?,?,?,?,?,?,?,?)";
		conn = DBUtil.dbConnection2(); // setAutoCommit(true)로 되어있음
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setInt(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			
			result = pst.executeUpdate(); // DML 문은 executeUpdate, Select 문은 executeQuery
			// result는 업데이트된 건수, 에러는 -1
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 7.수정
	public int empUpdate(EmpDTO emp) {
		int result = 0;
		String sql = "update employees "
				+ "set first_name = ?,"
				+ "last_name = ?, "
				+ "email = ?, "
				+ "phone_number = ?, "
				+ "hire_date = ?, "
				+ "job_id = ?, "
				+ "salary = ?, "
				+ "commission_pct = ?, "
				+ "manager_id = ?, "
				+ "department_id = ? "
				+ "where employee_id = ?";
		conn = DBUtil.dbConnection2(); 
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setInt(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());
			pst.setInt(11, emp.getEmployee_id());
			
			result = pst.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	// 8.삭제
	public int empDelete(int empid) {
		int result = 0;
		String sql = "delete employees "
				+ "where employee_id = ?";
		conn = DBUtil.dbConnection2(); 
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			result = pst.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 9. 직원 번호를 입력받아, 직원정보(이름, 직책, 급여) return
	public Map<String, Object> empInfo(int empid) {
		Map<String, Object> empMap = new HashMap<>();
		
		String fname = null, job = null;
		int salary = 0;
		
		conn = DBUtil.dbConnection2();
		String sql = "{call SP_EMPINFO(?,?,?,?)}";
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			
			boolean result = cstmt.execute();
			
			fname = cstmt.getString(2);
			job = cstmt.getString(3);
			salary = cstmt.getInt(4);
			
			empMap.put("fname", fname);
			empMap.put("job", job);
			empMap.put("salary", salary);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, cstmt, rs);
		}
		return empMap;
	}
	
	// 10. 직원 번호가 들어오면 직원 보너스를 return 하는 함수를 호출
	public double callFunction(int empid) {
		double bonus = 0;
		conn = DBUtil.dbConnection2();
		String sql = "select f_bonus(?) from dual";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			if (rs.next()) {
				bonus = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return bonus;
	}
	
	// 이메일 중복 체크
	public int selectByEmail(String email) {
		String sql = "select * from employees where email = ?";
		conn = DBUtil.dbConnection2();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return 0;
	}
	
	// 매니저 모두 조회
	public List<HashMap<String, Object>> selectAllManager() {
		List<HashMap<String, Object>> emplist = new ArrayList<>();
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME ||' '|| LAST_NAME FULLNAME "
				+ "FROM EMPLOYEES "
				+ "WHERE EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID "
				+ "                     FROM EMPLOYEES "
				+ "                    WHERE MANAGER_ID IS NOT NULL)";
		conn = DBUtil.dbConnection2();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				HashMap<String, Object> data = new HashMap<>();
				data.put("employee_id", rs.getInt(1));
				data.put("fullname", rs.getString(2));
				emplist.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}
		
	// 로그인
	public EmpDTO loginChk(String email, String phone) {
		EmpDTO emp = null;
		String sql = "select employee_id, first_name, phone_number from employees where email = ?";
		conn = DBUtil.dbConnection2();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("phone_number").equals(phone)) {
					emp = new EmpDTO();
					emp.setEmployee_id(rs.getInt("employee_id"));
					emp.setFirst_name(rs.getString("first_name"));
				}else {
					emp = new EmpDTO();
					emp.setEmployee_id(-2); // 비밀번호 오류
				}
			}else {
				emp = new EmpDTO();
				emp.setEmployee_id(-1); // 존재하지 않는 직원
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}		
		
	private EmpDTO makeEmp(ResultSet rs2) throws SQLException {
		EmpDTO emp = new EmpDTO();

		emp.setCommission_pct(rs2.getDouble("commission_pct"));
		emp.setDepartment_id(rs2.getInt("Department_id"));
		emp.setEmail(rs2.getString("email"));
		emp.setEmployee_id(rs2.getInt("employee_id"));
		emp.setFirst_name(rs2.getString("first_name"));
		emp.setHire_date(rs2.getDate("hire_date"));
		emp.setJob_id(rs2.getString("job_id"));
		emp.setLast_name(rs2.getString("last_name"));
		emp.setManager_id(rs2.getInt("manager_id"));
		emp.setPhone_number(rs2.getString("phone_number"));
		emp.setSalary(rs2.getInt("salary"));

		return emp;
	}

}
