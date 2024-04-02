package com.shinhan.day15;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.day14.DBUtil;

//DAO(Data Access하는 비지니스로직을 작성하는 Object)
public class EmpDAO {
	//모든 작업 connection 필요
	Connection conn;
	Statement st;
	ResultSet rs;
	
	//직원 모두 조회
	public void selectAll() {
		List<
		String sql = "select * from employees";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
			}
		}catch(SQLException e) {
			
		}finally {
			DBUtil.dbDisconnection(conn, st, rs);			
		}
		
	}
	
	//특정 직원 1명 조회
	
	//특정 부서 직원들 조회
	
	//입력
	
	//수정
	
	//삭제
}
