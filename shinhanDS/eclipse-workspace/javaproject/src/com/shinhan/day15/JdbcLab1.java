package com.shinhan.day15;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class JdbcLab1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;

		while (!isStop) {
			int selection = menu();
			String sql = null;

			switch (selection) {
			case 1 -> {
				sql = "select first_name, salary, hire_date\r\n" + "from employees\r\n"
						+ "where first_name = initcap('adam')";
				method1(sql, new String[] { "first_name", "salary", "hire_date" });
			}
			case 2 -> {
				sql = "select region_id\r\n" + "from countries\r\n"
						+ "where lower(country_name) = 'united states of america'";
				method1(sql, new String[] { "region_id" });
			}
			case 3 -> {
				sql = "select first_name || '의 입사일은 ' || hire_date || ' 이고, 급여는 ' || salary || ' 입니다.' 직원정보\r\n"
						+ "from employees";
				method1(sql, new String[] { "직원정보" });
			}
			case 4 -> {
				sql = "select first_name, salary, hire_date\r\n" + "from employees\r\n"
						+ "where length(first_name) <= 5";
				method1(sql, new String[] { "first_name", "salary", "hire_date" });
			}
			case 5 -> {
				sql = "select first_name, hire_date\r\n" + "from employees\r\n"
						+ "where to_char(hire_date, 'yyyy') = 2006";
				method1(sql, new String[] { "first_name", "hire_date" });
			}
			case 6 -> {
				sql = "select first_name, hire_date, salary, floor(months_between(sysdate, hire_date)/12) 근무년차\r\n"
						+ "from employees\r\n" + "where months_between(sysdate, hire_date)/12 >= 7";
				method1(sql, new String[] { "first_name", "hire_date", "salary", "근무년차" });
			}
			case 7 -> isStop = true;
			default -> System.out.println("해당 작업은 지원되지 않습니다.");

			}
		}
		System.out.println("======== 종료 ========");
	}

	private static void method1(String sql, String[] cols) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ResultSetMetaData metaData = rs.getMetaData();
				ArrayList<Object> datas = new ArrayList<Object>();

				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					Object obj = rs.getObject(i);
					datas.add(obj);
					System.out.print(obj + "\t");
				}
				System.out.println();
			}
			System.out.println();
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void dbDisconnect(Connection conn, Statement st, ResultSet rs) throws SQLException {
		rs.close();
		st.close();
		conn.close();
	}

	private static Connection dbConnection() {
		// 1. JDBC Driver load
		// 2. Connection 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr";
		String password = "hr";
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC Driver load 성공");

			conn = DriverManager.getConnection(url, userid, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static int menu() {
		System.out.println("===========================");
		System.out.println("1.initcap  2.lower  3.concat  4.length");
		System.out.println("5.to_char  6.months_between  7.end");
		System.out.println("===========================");
		System.out.print("선택> ");
		int job = sc.nextInt();

		return job;
	}
}
