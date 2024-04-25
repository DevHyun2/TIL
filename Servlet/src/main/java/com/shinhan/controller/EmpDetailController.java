package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

/*
 * http://ip:post/contextpath/emp/empDetail
 */
@WebServlet("/emp/empDetail.do")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=======get요청======");
		
		EmpService eService = new EmpService();
		String empid = request.getParameter("empid");
		if(empid == null) return;
		
		int i_empid = Integer.parseInt(empid);
		EmpDTO emp = eService.selectById(i_empid);
		System.out.println(emp);
		
		request.setAttribute("empInfo", emp); //요청문서에 데이터 저장 (내가정함, 저장할것)
		
		//Java code는 Servlet담당 ... 비지니스 로직을 수행한 후 넘긴다
		//View(HTML)는 JSP담당 ... JSP가 받는다
		
		//넘겨주는 메소드
		//Browser가 요청 -> 서블릿이 받음 -> JSP에게 위임 : forward
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response); //요청과 응답
	}
	

}
