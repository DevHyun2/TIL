package com.shinhan.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.job.JobDTO;
import com.shinhan.job.JobService;

/**
 * Servlet implementation class JobListServlet
 */
@WebServlet("/job/joblist.do")
public class JobListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobService jService = new JobService();
		List<JobDTO> joblist = jService.selectAll();
		
		request.setAttribute("j_datas", joblist);
		
		RequestDispatcher rd = request.getRequestDispatcher("jobAll.jsp");
		rd.forward(request, response);
	}

}
