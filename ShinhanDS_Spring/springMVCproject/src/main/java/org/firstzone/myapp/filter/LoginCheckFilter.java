package org.firstzone.myapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;


/**
 * Servlet Filter implementation class LoginCheckFilter
 */
public class LoginCheckFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//로그인하지 않으면 업무로직 수행못함
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		
		// uri: webshop12/auth/login.do
		if(!(req.getRequestURI().endsWith("login.do"))){
			session.setAttribute("lastRequest", req.getRequestURI());
			System.out.println(req.getRequestURI());
			EmpDTO emp = (org.firstzone.myapp.emp.EmpDTO) session.getAttribute("loginEmp");
			//濡쒓렇�씤�씠 �릺�뼱�엳吏� �븡�쑝硫� 釉뚮씪�슦��濡� �궡�젮媛��꽌 濡쒓렇�씤�쑝濡� �옱�슂泥�
			String path = req.getContextPath();
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

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
