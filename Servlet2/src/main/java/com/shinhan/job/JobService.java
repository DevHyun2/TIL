package com.shinhan.job;

import java.util.List;

public class JobService {

	JobDAO jobDAO = new JobDAO();

	public List<JobDTO> selectAll() {
		return jobDAO.selectAll();
	}
}
