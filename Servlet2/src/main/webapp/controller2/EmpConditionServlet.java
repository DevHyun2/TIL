package com.shinhan.controller2;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class JobListServlet
 */
@WebServlet("/emp/retrieve.do")
public class EmpConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpConditionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 Job조회
		//1.객체생성 why? : 인스턴스 메서드 호출하기 위해 객체 생성
		//				  static메서드 였으면 생성없이 호출
		//비지니스 로직 수행하기
		EmpService eService = new EmpService();
		List<JobDTO> joblist = eService.selectAllJob();
		
		//모든 부서조회
		DeptService deptService = new DeptService();
		List<DeptDTO> deptlist = deptService.selectAll();
		
		//요청문서에 data저장. JSP가 사용하기 위해서
		request.setAttribute("job_datas", joblist);
		request.setAttribute("dept_datas", deptlist);
		
		//Servlet받은 요청과 응답을 JSP(View담당)에 위임하기
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
