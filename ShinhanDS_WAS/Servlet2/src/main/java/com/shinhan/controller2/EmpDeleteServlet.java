package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/empDelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService eService = new EmpService();
		int result = eService.empDelete(empid);
		
		// 1) 새로운 요청으로 보내기: 주소창의 주소가 바뀜
		// 브라우저로 내려갔다가 다시 서버에 새로운 요청을 한다.
//		response.sendRedirect("emplist.do");
		
		// 2)
//		response.addHeader("Refresh", "1;emplist.do"); // =<meta http-equiv="refresh" content="1;emplist.do">
		
		// 3) forward는 받은 요청을 다른 페이지에 위임: 주소창의 주소가 바뀌지 않음
//		request.setAttribute("message", result + "건 삭제");
//		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
