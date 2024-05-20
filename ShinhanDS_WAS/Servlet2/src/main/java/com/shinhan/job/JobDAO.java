package com.shinhan.job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class JobDAO {

	Connection conn;
	Statement st;
	ResultSet rs;

	// 직무 모두 조회
	public List<JobDTO> selectAll() {
		List<JobDTO> joblist = new ArrayList<JobDTO>();
		String sql = "select * from jobs";
		conn = DBUtil.dbConnection2();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				JobDTO job = makeJob(rs);
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

	private JobDTO makeJob(ResultSet rs2) throws SQLException {
		JobDTO job = new JobDTO();

		job.setJob_id(rs2.getString("job_id"));
		job.setJob_title(rs2.getString("job_title"));
		job.setMin_salary(rs2.getInt("min_salary"));
		job.setMax_salary(rs2.getInt("max_salary"));

		return job;
	}
	
}
