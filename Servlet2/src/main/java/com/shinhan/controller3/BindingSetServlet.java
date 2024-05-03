package com.shinhan.controller3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BindingSetServlet
 */
@WebServlet("/jsp/set")
public class BindingSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===========setting============");
		HttpSession session = request.getSession();
		//ServletContext context = request.getServletContext();
		ServletContext context = getServletContext(); // HttpServlet 안에 getServletContext()가 이미 들어있기 때문에 request.를 안붙여도 됨
		
		String my = (String)context.getAttribute("myinfo3");
		System.out.println("ServletContext에 저장된 myinfo3: " + my);
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		System.out.println("menu_member: " + menu_member);
		System.out.println("menu_order: " + menu_order);
		
		InputStream is = context.getResourceAsStream("WEB-INF/config/init.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		
		while((line = br.readLine())!=null) {
			System.out.println(line);
		};
		
		String myname = request.getParameter("myname");
		request.setAttribute("myinfo", myname);
		session.setAttribute("myinfo2", myname);
		context.setAttribute("myinfo3", myname);
		
		RequestDispatcher rd = request.getRequestDispatcher("get.jsp");
		rd.forward(request, response);
	}

}
