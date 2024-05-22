package com.shinhan.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.myapp.model.AccountServiceImpl;

@Controller
public class AccountController {
	
	@Autowired
	AccountServiceImpl accService;
	
	@RequestMapping("/account/trans.do")
	@ResponseBody //응답의 문자는 response.getWriter().append("문자")
				 //@responseBody가 없으면 JSP페이지로 forward된다
	public void f1() {
		accService.update();
		return "Account Transaction Test";
	}
}
