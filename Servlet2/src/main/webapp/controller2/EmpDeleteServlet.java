package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/empdelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService eService = new EmpService();
		int result = eService.empDelete(empid);
		
		//새로운 요청으로 보내기
		//브라우저로 내려갔다가 다시 서버에 새로운 요청하기
		response.sendRedirect("emplist.do");
		
		//주소를 다시 바꾸지 않은 코드 - 주소가 엉망이 됨
		//request.getRequestDispatcher("emplist.do").forward(request, response);
		
		//forward는 받은 요청을 다른 페이지에 위임한다. 주소가 바뀌지 않는다.
		
		//삭제 요청으로 보내기
		//request.setAttribute("message", result + "건 삭제됨");
		//request.getRequestDispatcher("result.jsp").forward(request, response);
	}
	
	//get : 상세보기에 사용
	//post : 수정하기에 사용
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
