package com.shinhan.controller2;

import java.io.IOException;
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

/**
 * Servlet implementation class EmpInDept
 */
@WebServlet("/emp/empByDept.do")
public class EmpByDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();
		request.setAttribute("dlist", deptlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("empByDept.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		
		EmpService eService = new EmpService();
		List<EmpDTO> emplist = eService.selectByDept(deptid);
		request.setAttribute("emplist", emplist);
		
		RequestDispatcher rd = request.getRequestDispatcher("empByDept2.jsp");
		rd.forward(request, response);
	}

}
