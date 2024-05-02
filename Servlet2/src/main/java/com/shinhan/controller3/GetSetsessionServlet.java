package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetSetsessionServlet
 */
@WebServlet("/jsp/getsession")
public class GetSetsessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String a = (String)session.getAttribute("memberId");
		String b = (String)session.getAttribute("memberPw");
		
		System.out.println("세션읽기 id: " + a);
		System.out.println("세션읽기 pw: " + b);
	}

}
