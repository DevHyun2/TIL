package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet : 주소 창에서 요청 시 Mapping 주소
 * 서블릿의 기본 주소: http://192.168.0.120:9090/webshop
 */
@WebServlet({ "/FirstServlet", "/first", "/first2" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        System.out.println("FirstServlet생성자");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init(초기화)");
	}

	public void destroy() {
		System.out.println("FirstServlet 소멸자");
	}

	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doGet, doPost() 코드를 모두 해야하는 경우
		System.out.println("=========service=========");
		System.out.println(req.getMethod() + " 요청");
	}
	*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getRemoteAddr();
		System.out.println("FirstServlet get요청: " + addr);
		System.out.println("userid: " + request.getParameter("userid"));
		response.getWriter().append("<h1>Served at: ")
		.append(addr)
		.append(request.getContextPath() + "</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getRemoteAddr();
		System.out.println("FirstServlet post요청: " + addr);
		System.out.println("userid: " + request.getParameter("userid"));
		response.getWriter().append("<h1>Served at(post): ")
		.append(addr)
		.append(request.getContextPath() + "</h1>");
	}

}
