package com.shinhan.controller3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/jsp/scope")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		
		request.setAttribute("mydata", 100); //request > session > app 우선순위
		session.setAttribute("mydata", 200);
		application.setAttribute("mydata", 300);
		
		request.setAttribute("myage1", 10);
		session.setAttribute("myage2", 20);
		application.setAttribute("myage3", 30);
		
		request.getRequestDispatcher("scope.jsp").forward(request, response);
	}

}
