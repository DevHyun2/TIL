package com.shinhan.controller2;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.job.JobDTO;
import com.shinhan.job.JobService;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class EmpConditionServlet
 */
@WebServlet("/emp/retrieve.do")
public class EmpConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 job 조회
		// 1.객체 생성: 인스턴스 메서드를 호출하기 위해 객체 생성, static method라면 생성 없이 호출 가능
		// 비즈니스 로직을 수행
		JobService jService = new JobService();
		List<JobDTO> joblist = jService.selectAll();
		
		// 모든 부서 조회
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();
		
		// 요청 문서에 data를 저장한다. JSP가 사용하기 위해
		request.setAttribute("job_datas", joblist);
		request.setAttribute("dept_datas", deptlist);
		
		// Servlet이 받은 요청과 응답을 JSP(View 담당)에 위임
		RequestDispatcher rd = request.getRequestDispatcher("retrieve.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobid = request.getParameter("jobid");
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		Date hiredate = DateUtil.getSQLDate(request.getParameter("hiredate"));
		
		EmpService eService = new EmpService();
		List<EmpDTO> emplist = eService.selectByCondition(deptid, jobid, hiredate, salary);
		request.setAttribute("emplist", emplist);
		
		RequestDispatcher rd = request.getRequestDispatcher("emplist2.jsp");
		rd.forward(request, response);
	}

}
