package org.firstzone.myapp.emp;

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

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

@Repository
// DAO(Data Access�븯�뒗 ?��꾩쫰�땲�뒪 濡쒖쭅�?�� 泥섎?���븯�뒗 Object)
public class EmpDAO {
	
	//1.field?��?��?���?
	@Autowired
	DataSource ds;
	
	//2.?��?��?��?��?��?���?
	//@Autowired
//	public EmpDAO(DataSource ds) {
//		this.ds = ds;
//	}
	
	//3.setter?���?
//	@Autowired
//	public void setDs(DataSource ds) {
//		this.ds = ds;
//	}
	
	Connection conn;
	Statement st;
	PreparedStatement pst; // Statement?���? �긽�냽 諛쏆?��, 諛붿?���뵫 蹂��닔 吏��썝, 媛�蹂� sql?��몄쓣 諛쏆?�� �븣 �뜑 �슚�쑉�쟻
	ResultSet rs;

	// 1.吏곸?�� 紐⑤�? 議고?��
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees order by 1";
		try {
			conn = ds.getConnection();
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
	
	// 2. �듅�젙 吏곸?�� �긽�꽭 蹂닿�?
	public EmpDTO selectById(int empid) {
		EmpDTO emp = null;
		String sql = "select * from employees where employee_id = ";
		try {
			conn = ds.getConnection();
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

	// 3. �듅�젙 ?����꽌�?�� 洹쇰Т�븯�뒗 吏곸?���뱾 議고?��
	public List<EmpDTO> selectByDept(int dept) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where department_id = ?";
		try {
			conn = ds.getConnection();
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
	
	public List<JobDTO> selectAllJob() {
        List<JobDTO> joblist = new ArrayList<JobDTO>();
        String sql = "select * from jobs";
        try {
            conn = ds.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                JobDTO job = new JobDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                joblist.add(job);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, rs);
        }
        return joblist;
        
    }
	
	// 4. �듅�젙 Job�씤 吏곸?���뱾 議고?��
	public List<EmpDTO> selectByJob(String job) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where job_id = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, job); // 泥ル쾲吏�? ?��?��?���몴�뿉 job�쓣 �꽔�쓬
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
	
	// String�뿉 +?���? 諛섎?���븯�뒗 寃껋�? ?��꾪슚�쑉�쟻
	public List<EmpDTO> selectByJob2(String job) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where job_id = '"
				+ job
				+ "'";
		try {
			conn = ds.getConnection();
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
	
	// 5. �떎�뼇�븳 議곌굔�?��濡� 議고?��
	// ?����꽌蹂�?(=), 吏곸콉蹂�?(=), �엯�궗�씪蹂�(>=), 湲됱�?(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * "
				+ "from employees "
				+ "where department_id = ? "
				+ "and job_id = ? "
				+ "and hire_date >= ? "
				+ "and salary >= ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid); // 泥ル쾲吏�? ?�뿉 deptid?���? �꽔�뼱�씪
			pst.setString(2, jobid); // �몢踰덉?�� ?�뿉 jobid?���? �꽔�뼱�씪
			pst.setDate(3, hdate); // �꽭踰덉?�� ?�뿉 hdate?���? �꽔�뼱�씪
			pst.setInt(4, salary); // �꽕踰덉?�� ?�뿉 salary?���? �꽔�뼱�씪
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
	
	// 6. �엯�젰
	public int empInsert(EmpDTO emp) {
		int result = 0;
		String sql = "insert into employees values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ds.getConnection(); // setAutoCommit(true)濡� �릺�뼱�엳�쓬
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
			
			result = pst.executeUpdate(); // DML ?��몄� executeUpdate, Select ?��몄� executeQuery
			// result�뒗 �뾽�뜲�씠�듃�맂 嫄댁?��, �뿉�윭�뒗 -1
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 7.�닔�젙
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
		try {
			conn = ds.getConnection(); 
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
	// 8.�궘�젣
	public int empDelete(int empid) {
		int result = 0;
		String sql = "delete employees "
				+ "where employee_id = ?";
		try {
			conn = ds.getConnection(); 
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
	
	// 9. 吏곸?�� 踰덊?��?���? �엯�젰諛쏆�?, 吏곸?���젙蹂�(�씠?���?, 吏곸�?, 湲됱�?) return
	public Map<String, Object> empInfo(int empid) {
		Map<String, Object> empMap = new HashMap<>();
		
		String fname = null, job = null;
		int salary = 0;
		
		String sql = "{call SP_EMPINFO(?,?,?,?)}";
		CallableStatement cstmt = null;
		
		try {
			conn = ds.getConnection();
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
	
	// 10. 吏곸?�� 踰덊?��媛� �뱾�뼱�삤硫� 吏곸?�� 蹂�?꼫�?��?���? return �븯�뒗 �븿�닔?���? �샇?���?
	public double callFunction(int empid) {
		double bonus = 0;
		String sql = "select f_bonus(?) from dual";
		
		try {
			conn = ds.getConnection();
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
	
	// �씠硫붿?�� 以묐?�� 泥댄�?
	public int selectByEmail(String email) {
		String sql = "select * from employees where email = ?";
		try {
			conn = ds.getConnection();
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
	
	// 留ㅻ?���� 紐⑤�? 議고?��
	public List<HashMap<String, Object>> selectAllManager() {
		List<HashMap<String, Object>> emplist = new ArrayList<>();
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME ||' '|| LAST_NAME FULLNAME "
				+ "FROM EMPLOYEES "
				+ "WHERE EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID "
				+ "                     FROM EMPLOYEES "
				+ "                    WHERE MANAGER_ID IS NOT NULL)";
		try {
			conn = ds.getConnection();
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
		
	// 濡쒓?���씤
	public EmpDTO loginChk(String email, String phone) {
		EmpDTO emp = null;
		String sql = "select employee_id, first_name, last_name, email, phone_number from employees where email = ?";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("phone_number").equals(phone)) {
					emp = new EmpDTO();
					emp.setEmployee_id(rs.getInt("employee_id"));
					emp.setFirst_name(rs.getString("first_name"));
					emp.setLast_name(rs.getString("last_name"));
					emp.setEmail(email);
					emp.setPhone_number(phone);
				}else {
					emp = new EmpDTO();
					emp.setEmployee_id(-2); // ?��꾨�踰덊?�� �삤?���?
				}
			}else {
				emp = new EmpDTO();
				emp.setEmployee_id(-1); // 議댁?���븯吏� �븡�뒗 吏곸?��
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
