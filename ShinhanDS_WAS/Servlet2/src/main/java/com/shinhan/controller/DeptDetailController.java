package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;

/**
 * Servlet implementation class DeptDetailController
 */
@WebServlet("/dept/deptDetail.do")
public class DeptDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptid = request.getParameter("deptid");
		if(deptid==null) return;
		int i_deptid = Integer.parseInt(deptid);
		
		DeptService dService = new DeptService();
		DeptDTO dept = dService.selectByID(i_deptid);
		request.setAttribute("deptInfo", dept);
		
		System.out.println(deptid);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptUpdate.jsp");
		rd.forward(request, response);
	}


}
