package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetSessionServlet
 */
@WebServlet("/jsp/getSession")
public class GetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // =request.getSession(true)
		
		String a = (String)session.getAttribute("memberId");
		String b = (String)session.getAttribute("memberPass");
		
		System.out.println("세선읽기 id: " + a);
		System.out.println("세선읽기 pass: " + b);
	}
}
