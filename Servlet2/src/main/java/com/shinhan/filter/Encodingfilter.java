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

/**
 * Filter : 요청filter, 응답filter
 * 공통적으로 여러 서블릿에 적용하기 위한 코드들을 작성한다.
 */
@WebFilter("*.do")
public class Encodingfilter extends HttpFilter implements Filter {
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("=======요청전에 수행========");
		request.setCharacterEncoding("utf-8");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("=======응답전에 수행========");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
