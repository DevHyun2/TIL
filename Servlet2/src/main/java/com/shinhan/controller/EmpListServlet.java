package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

@WebServlet("/emp/empList.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService eService = new EmpService();
		List<EmpDTO> empAll = eService.selectAll();
		System.out.println(empAll.size() + "건 조회됨");
		
		request.setAttribute("emplist", empAll); //요청문서에 추가로 저장(저장할이름,저장할것)
		
		//Dispatcher : 위임, 요청은 서블릿이 받았는데 응답은 JSP가 한다
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
		//reponse가 전달 되었다는 것은 서블릿대신 JSP가 응답한다의 의미
	}


}
