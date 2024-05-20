package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	EmpService eService;
	
	@GetMapping("/auth/login.do")
	public void loginDisplay() {
		
	}
	
	@PostMapping("/auth/login.do")
	public String loginCheck(@RequestParam("email")String eamil, @RequestParam("pswd") String phone,
			HttpSession session, HttpServletRequest request) {
	
		EmpDTO emp = eService.loginChk(eamil, phone);
		if(emp.getEmployee_id() == -1) {
			session.setAttribute("loginResult", "존재하지 않은 ID");
			return "redirect:login.do";
		}else if(emp.getEmployee_id() == -2) {
			session.setAttribute("loginResult", "알맞지 않은 password");
			return "redirect:login.do";
		}else {
			//로그인 성공
			session.setAttribute("loginResult", "로그인성공");
			session.setAttribute("emp", emp);
			
			String lastRequest = (String)session.getAttribute("lastRequest");
			String goPage;
			if(lastRequest == null) {
				goPage = "../dept/deptList.do";
			}else {
				goPage = lastRequest.substring(request.getContextPath().length());
			}
			
			return "redirect:" + goPage;
		}
	}
}
