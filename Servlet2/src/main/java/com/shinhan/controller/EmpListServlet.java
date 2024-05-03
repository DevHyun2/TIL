package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmpDTO emp = (EmpDTO) session.getAttribute("loginEmp");
		if(emp==null) {
			// 로그인 되어 있지 않으면, 브라우저로 내려가서 로그인 재요청
			response.sendRedirect("../auth/login.do");
			return;
		}
		
		EmpService eService = new EmpService();
		List<EmpDTO> empAll = eService.selectAll();
		System.out.println(empAll.size() + "건 조회됨");
		request.setAttribute("emplist", empAll); // 요청 문서에 추가로 저장
		
		// Dispatcher: 위임. 요청은 서블릿이 받았는데 응답은 JSP가 한다.
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}

}
