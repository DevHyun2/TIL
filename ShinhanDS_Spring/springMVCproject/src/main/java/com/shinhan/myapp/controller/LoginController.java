package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class LoginController {
	@Autowired
	EmpService eService;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/login.do")
	public void loginDisplay() {
		logger.debug("login.do��û(debug)");
		logger.info("login.do��û(info)");
		logger.warn("login.do��û(warn)");		
		logger.error("login.do��û(error)");		
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}
	
	
	@PostMapping("/login.do")
	public String loginCheck(@RequestParam("email") String email, 
						   @RequestParam("pswd") String phone,
						   HttpSession session,
						   HttpServletRequest request
			) {
		EmpDTO emp = eService.loginChk(email, phone);
		if(emp.getEmployee_id() == -1) {
			session.setAttribute("loginResult", "�������� ���� ID�Դϴ�.");
			return "redirect:login.do";
		}else if(emp.getEmployee_id() == -2){
			session.setAttribute("loginResult", "password�����Դϴ�.");
			return "redirect:login.do";
		}else {
			// �α��� ����
			session.setAttribute("loginResult", "login ����");
			session.setAttribute("emp", emp);
			
			String lastRequest = (String)session.getAttribute("lastRequest");
			String goPage;
			if(lastRequest == null) {
				// ó������ �α��� ��û
				goPage = "../index.do";
			}else {
				// �α��ξ��� �ٸ� �������� ��û
				int length = request.getContextPath().length();
				goPage = lastRequest.substring(length);
			}
			return "redirect:" + goPage;
		}
	}
}



