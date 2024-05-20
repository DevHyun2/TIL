package com.shinhan.frontpattern;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.filter.MySessionListener;

public class LoginController implements CommonControllerInterface{

	@Override
	public String execute(Map<String, Object> dataMap) {
		String page = "auth/login.jsp";
		String method = (String)dataMap.get("method");
				
		if(method.equals("get")) return page;
		
		EmpService service = new EmpService();
		String email = (String)dataMap.get("email");
		String phone = (String)dataMap.get("pswd");
		EmpDTO emp = service.loginChk(email, phone);
		if(emp==null || emp.getEmployee_id()==-1) {			
			//존재하지않는 직원
			dataMap.put("message", "존재하지않는 직원");
		}else if(emp.getEmployee_id()==-2) {
			//비밀번호오류 
			dataMap.put("message", "비밀번호오류 ");
		}else {
			//로그인성공
			dataMap.put("loginEmp", emp);
			return "redirect:";
			}
		return "result.jsp";
	}
	
}
