package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.controller2.JobDTO;
import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class EmpInsertServlet
 * 404에러 : page가 존재하지 않는다. 주소확인하기
 * 405에러 : 요청방식을 지원하지 않는다. get/post 확인
 * 500에러 : 서버오류. 프로그램실행오류이므로 서버의 console 창 확인
 * 200 : 연결성공
 * get, post 코드가 같다면 service()메서드에서 코드한다
 */
@WebServlet("/emp/empInsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		DeptService service = new DeptService();
   		List<DeptDTO> dlist = service.selectAll();
   		request.setAttribute("deptlist", dlist);
   		
   		EmpService eService = new EmpService();
   		List<HashMap<String,Object>>mlist = eService.selectAllManager();
   		request.setAttribute("mlist", mlist);
   		
   		List<JobDTO> joblist = eService.selectAllJob();
		request.setAttribute("joblist", joblist);
   		
   		RequestDispatcher rd = 
   				request.getRequestDispatcher("empInsert.jsp");
   	    rd.forward(request, response);
   	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청문서에 내용을 담아서 온다. 자동 encoding안됨 
		request.setCharacterEncoding("utf-8");//1문자가 3byte임을 설정 
		EmpDTO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empInsert(emp);
		System.out.println(result + "건 입력됨");
		request.setAttribute("message", result + "건 입력됨");
		
		//1)JSP에 응답을 위임하는 경우
		RequestDispatcher rd = 
   				request.getRequestDispatcher("result.jsp");
   	    rd.forward(request, response);
   	    
//   	    //2)서블릿이 직접 응답을 하는 경우
//		response.setContentType("text/html;charset=utf-8");
//   	    PrintWriter out = response.getWriter();
//   	    out.write("<h1>서블릿이 직접 응답을 하는 경우<h1>");
	}
	private EmpDTO makeEmp(HttpServletRequest request) {
		//Enumeration : 한정된 값의 나열을 의미
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "==>" + request.getParameter(col));
		}
		
		EmpDTO emp = new EmpDTO();
		int empid = convertInt(request.getParameter("employee_id"));
		int mid = convertInt(request.getParameter("manager_id"));
		int did = convertInt(request.getParameter("department_id"));
		int salary = convertInt(request.getParameter("salary"));
		double commission = convertDouble(request.getParameter("commission_pct"));
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		Date hdate = DateUtil.getSQLDate(request.getParameter("hire_date"));
		
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setLast_name(lname);
		emp.setEmail(email);
		emp.setPhone_number(phone);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setSalary(salary);
		emp.setCommission_pct(commission);
		emp.setManager_id(mid);
		emp.setDepartment_id(did);
		System.out.println(emp);
		return emp;
	}
	private double convertDouble(String parameter) {
		if(parameter=="") return 0;
		return Double.parseDouble(parameter);
	}
	private int convertInt(String parameter) {
		if(parameter=="") return 0;
		return Integer.parseInt(parameter);
	}
	

}