package com.shinhan.day14;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.JDBC dirver를 class path 추가
		//jdbc드라이버를 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1.oracle driver load성공");
		
		//2.DB연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe", userid = "hr", password = "hr";
		Connection conn = DriverManager.getConnection(url, userid, password);
		System.out.println("2.DB연결성공");
		
		String sql = "select first_name, last_name, salary, department_id\r\n"
				+ "from employees\r\n"
				+ "where salary >= 15000";
		//3.Statement : 자바와 DB의 대화 통로
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {//data가 있을때 까지
			String fname = rs.getString(1);
			int salary = rs.getInt(3);
			int deptid = rs.getInt(4);
			System.out.printf("%20s\t%d\t%d\n",fname, salary, deptid);
		}
		rs.close();
		st.close();
		conn.close();
	}

}
