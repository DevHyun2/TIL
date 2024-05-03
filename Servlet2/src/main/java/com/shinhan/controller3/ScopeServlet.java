package com.shinhan.controller3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeServlet
 */
// URL 패턴은 가상의 이름
//@WebServlet("/jsp/scope")
//@WebServlet("/jsp/scope/*") // 와일드키 사용 가능
@WebServlet("*.go")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		
		request.setAttribute("mydata", 100);
		session.setAttribute("mydata", 200);
		application.setAttribute("mydata", 300);
		
		request.setAttribute("myage1", 10);
		session.setAttribute("myage2", 20);
		application.setAttribute("myage3", 30);
		
		// 절대경로 사용하기
		String path = getServletContext().getContextPath();
		System.out.println(path); // /webshop12
		request.getRequestDispatcher("/jsp/scope.jsp").forward(request, response);
		
		// servlet의 default 경로: http://localhost:9090/webshop0
		// JSP, HTML default 경로: http://localhost:9090
	}

}
