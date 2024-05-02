package com.shinhan.controller3;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/jsp/cookieget")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	//------여려페이지로 이동시 특정정보를 유지하기 위함
    //쿠키를 만들어서 응답문서에 실어서 보낸다
	//브라우저에 저장
	//재요청시 request에 담아서 간다
	//쿠키를 확인할 수 있다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cs = request.getCookies();
		
		for(Cookie c : cs) {
			String cookieValue = null;
			if(c.getName().equals("myinfo")) {
				cookieValue = URLDecoder.decode(cookieValue, "utf-8");
			}else {
				cookieValue = c.getValue();
			}
			System.out.println(c.getName() + " ==> " + cookieValue+ " : " + c.getValue());
		}
		//response.sendRedirect("../emp/empList.do");
	}
}
