package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet : 주소창에서 요청시 Mapping 주소  nnnnnnn
 */
@WebServlet({ "/FirstServlet", "/first","/first2"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		System.out.println("FirstServlet 생성자");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init(초기화)");
	}

	public void destroy() {
		System.out.println("FirstServlet (소멸자)");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String addr = request.getRemoteAddr();
		System.out.println("FirstServlet get요청" + addr);
		System.out.println("userid: " + request.getParameter("userid"));
		response.getWriter().append("<h1>Served at: ").append(request.getContextPath() + "</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String addr = request.getRemoteAddr();
		System.out.println("FirstServlet post요청" + addr);
		System.out.println("userid: " + request.getParameter("userid"));
		doGet(request, response);
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("==============service================");
//		System.out.println(req.getMethod()); //get인지 post인지 알아내는 메소드
//		//**doGet, doPost 코드를 모두 해야하는 경우
//	}

}