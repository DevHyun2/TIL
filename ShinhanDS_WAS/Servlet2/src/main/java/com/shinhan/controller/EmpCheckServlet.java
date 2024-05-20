package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpCheckServlet
 */
@WebServlet("/emp/empIdCheck.do")
public class EmpCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService service = new EmpService();
		EmpDTO emp = service.selectById(empid);
		String message = "이미존재하는 ID입니다";
		
		if(emp == null) {
			message = "사용가능한 ID입니다";
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(message);
	}

}
