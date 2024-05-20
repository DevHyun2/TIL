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

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.job.JobDTO;
import com.shinhan.job.JobService;
import com.shinhan.util.DateUtil;

/**
 * http://ip:port/contextpath/emp/empDetail
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
	 * 404: 존재하지 않는 페이지. 주소 확인 필요 405: 요청 방식을 지원하지 않음. get/post 확인 500: 서버 오류. 프로그램
	 * 실행 오류이므로 서버의 console 창을 확인 200: 성공
	 */

	// doGet(), doPost() 코드가 같다면, service() 메서드에서 코드
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====get요청=====");

		EmpService eService = new EmpService();
		String empid = request.getParameter("empid");
		if (empid == null)
			return;
		int i_empid = Integer.parseInt(empid);
		EmpDTO emp = eService.selectById(i_empid);
		System.out.println(emp);

		DeptService service = new DeptService();
		List<DeptDTO> dlist = service.selectAll();
		request.setAttribute("deptlist", dlist);

		List<HashMap<String, Object>> mlist = eService.selectAllManager();
		request.setAttribute("mlist", mlist);

		JobService jService = new JobService();
		List<JobDTO> jlist = jService.selectAll();
		request.setAttribute("jlist", jlist);

		// 요청문서에 data 저장
		request.setAttribute("empInfo", emp);
		// Java code는 Servlet 담당: 비즈니스 로직 수행 후, JSP에게 넘긴다
		// View(HTML)는 JSP 담당

		// Browser가 요청 -> 서블릿이 받음 -> JSP에게 위임 (forward)
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

	// get: 상세보기에 사용
	// post: 수정하기에 사용
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("==============post 요청==============");
    
//         request.setCharacterEncoding("utf-8"); // 1문자가 3바이트임을 설정
         // --> filter로 대체
         
         EmpDTO emp = makeEmp(request);
         EmpService service = new EmpService();
         int result = service.empUpdate(emp);
         System.out.println(result + "건 수정됨");
         request.setAttribute("message", result + "건 수정됨");
         
         // 1) JSP에 응답을 위임하는 경우 (MVC2모델)
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
        if (parameter == "")
            return 0;
        return Double.parseDouble(parameter);
    }
    private int convertInt(String parameter) {
        if (parameter == "")
            return 0;
        return Integer.parseInt(parameter);
    }
}
