package perfornance_evaluation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class empDAO {
	
	Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	
	//사원 로그인
	public Map<Integer, String> emplogin(int empNum) {
		Map<Integer, String> empMap = new HashMap<Integer, String>();
		Integer empid = 0;
		String emppw = null;
		String sql = "{select employee_id, employee_pw "
					+ "from employees "
					+ "where employee_id = ? "
					+ "and employee_pw = ? }";
		CallableStatement cstmt = null;
		conn = DBUtil.dbConnection();
		return null;
	}
	
	//관리자 로그인
	public Map<Integer, String> adminlogin(int empNum) {
		Map<Integer, String> empMap = new HashMap<Integer, String>();
		Integer empid = 0;
		String emppw = null;
		String sql = "{select admin_id, employee_pw "
					+ "from employees "
					+ "where admin_id = ? "
					+ "and employee_pw = ? }";
		CallableStatement cstmt = null;
		conn = DBUtil.dbConnection();
		return null;
	}
}
