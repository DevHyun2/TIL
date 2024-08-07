package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("*.do")
public class LoginCheckFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인하지 않으면 업무 로직 수행 불가
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		
		// uri: webshop12/auth/login.do
		if(!(req.getRequestURI().endsWith("login.do"))){
			session.setAttribute("lastRequest", req.getRequestURI());
			System.out.println(req.getRequestURI());
			EmpDTO emp = (EmpDTO) session.getAttribute("loginEmp");
			//로그인이 되어있지 않으면 브라우저로 내려가서 로그인으로 재요청
			String path = req.getServletContext().getContextPath();
			if(emp == null) {
				rep.sendRedirect(path + "/auth/login.do");
				return;
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
