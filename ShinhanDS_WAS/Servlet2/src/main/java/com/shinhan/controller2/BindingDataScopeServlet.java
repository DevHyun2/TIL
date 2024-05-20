package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BindingDataScopeServlet
 */
@WebServlet("/jsp/binding.do")
public class BindingDataScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.application 영역에 저장 (서버가 stop 될 때까지 유효, 모든 Servlet이 JSP 사용 가능)
		ServletContext app = request.getServletContext();
		app.setAttribute("appData", request.getParameter("myname"));
		
		// 2.session 영역에 저장 (하나의 Browser를 의미, Browser를 이용해서 이동되는 모든 페이지에서 접근 가능, Browser 종료 시 제거)
		HttpSession session = request.getSession();
		session.setAttribute("sessionData", request.getParameter("myname"));
		
		// 3.request 영역에 저장 (요청과 응답이 종료되면 사라짐)
		request.setAttribute("requestData", request.getParameter("myname"));
		
		request.getRequestDispatcher("binding.jsp").forward(request, response);
	}

}
