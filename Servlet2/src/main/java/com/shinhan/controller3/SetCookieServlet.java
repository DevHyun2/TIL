package com.shinhan.controller3;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/jsp/cookieSet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//-----여러 페이지로 이동 시, 특정 정보를 유지하기 위함
	// 쿠키를 만들어서 응답문에 실어서 보낸다.
	// 브라우저에 저장된다.
	// 재요청 시, request에 담아서 간다.
	// 쿠키를 확인할 수 있다.
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		
		Cookie c1 = new Cookie("myid", id);
		Cookie c2 = new Cookie("mypass", pass);
		Cookie c3 = new Cookie("myinfo", URLEncoder.encode("신한금융SW아카데미", "utf-8"));
		
		c1.setMaxAge(24*60*60); // 하루 유효
		c2.setMaxAge(60); // 1분 유효
		// c3는 유효시간을 설정하지 않아서 브라우저가 종료되면 사라짐
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		
		request.getRequestDispatcher("cookie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
