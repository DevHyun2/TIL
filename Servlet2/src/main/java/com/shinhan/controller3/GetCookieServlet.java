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
@WebServlet("/jsp/cookieGet")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cs = request.getCookies();
		
		for(Cookie c: cs) {
			String cookieValue = null;
			if(c.getName().equals("myinfo")) {
				cookieValue = URLDecoder.decode(c.getValue(), "utf-8");
			}else {
				cookieValue = c.getValue();
			}
			System.out.println(c.getName() + " ==> " + cookieValue);
		}
		response.sendRedirect("../emp/emplist.do");
	}
}
