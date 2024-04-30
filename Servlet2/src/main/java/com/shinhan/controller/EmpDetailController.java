package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
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
 * http://ip:post/path/emp/empDetail
 */
@WebServlet("/emp/empDetail.do")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========get요청===========");
		
		EmpService eService = new EmpService();
		String empid = request.getParameter("empid");
		if(empid == null) return;
		
		int i_empid = Integer.parseInt(empid);
		//로컬변수 emp
		EmpDTO emp = eService.selectById(i_empid);
		System.out.println(emp);
		//emp도 request에 저장해놔야 jsp에 넘길수있음
		request.setAttribute("empInfo", emp); //요청문서에 data를 "empInfo"이름으로 저장
		//.setAttribute() : set 저장
		//jsp에서 ${empInfo.dto변수이름 } => getAttribute() : get
		
		//Java code는 Servlet담당 ... 비지니스 로직을 수행 후
		//View(HTML)는 JSP담당 ...... JSP에 넘긴다.
		
		DeptService service = new DeptService();
		List<DeptDTO> dlist = service.selectAll();
		System.out.println(dlist.size() + "건");
		request.setAttribute("deptlist", dlist);
		
		
		List<HashMap<String,Object>> mlist = eService.selectAllManager();
		request.setAttribute("mlist", mlist);
		
		List<JobDTO> joblist = eService.selectAllJob();
		request.setAttribute("joblist", joblist);
		
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response); //요청과 응답을 empDetail.jsp로 넘겨줌
		//.forward() : Browser가 요청 -> 서블릿이 받아서 -> JSP에게 위임함
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========post요청========");
		request.setCharacterEncoding("utf-8"); //1문자가 3byte임을 설정 - 한글꺠짐방지
		EmpDTO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empUpdate(emp);
		System.out.println(result + "건 수정됨.");
		request.setAttribute("message", result + "건 수정됨.");
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	private EmpDTO makeEmp(HttpServletRequest request) {
		
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
		
		emp.setCommission_pct(commission);
		emp.setDepartment_id(did);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(salary);
		System.out.println(emp);
		return emp;
	}
	private double convertDouble(String parameter) {
		if(parameter == "") return 0;
		return Double.parseDouble(parameter);
	}
	private int convertInt(String parameter) {
		if(parameter == "") return 0;
		return Integer.parseInt(parameter);
	}

}
