package com.shinhan.controller;

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

/**
 * Servlet implementation class DeptListServlet
 */
@WebServlet("/dept/deptList.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();
		System.out.println(deptlist.size() + "건 조회됨");
		request.setAttribute("deptlist", deptlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("deptList.jsp");
		rd.forward(request, response);
	}

}
