package com.shinhan.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

//요청주소 연습
@Controller
@RequestMapping("/sample") //공통적인 path는 class레벨에서 정의, 각각의 path는 method레벨에서 정의
public class SampleController {
	
	@RequestMapping("hello.do")
	public String test1() {
		return "jsp/hello";
	}
	
	@RequestMapping("/hello1.do")
	public String test2() {
		return "jsp/hello";
	}
	
	@RequestMapping(value={"/hello2.do","/hello3.do"}, method = RequestMethod.GET)
	public String test3() {
		return "jsp/hello";
	}
	
	//method를 get으로 request매핑
	@GetMapping("/hello4.do")
	public String test4(Model data) {
		data.addAttribute("myname", "신한DS");
		data.addAttribute("myscore", 1215212);
		
		return "jsp/hello";
	}
	
	//method를 get으로 request매핑
	@GetMapping("/hello5.do")
	public ModelAndView test5() {
		//data.setViewName("jsp/hello");
		ModelAndView data = new ModelAndView("jsp/hello");
		
		data.addObject("myname", "우리");
		data.addObject("myscore", 231);
		
		return data;
	}
	
	@RequestMapping(
					value = "/hello6.do", 
					method = RequestMethod.GET, 
					params = {"email", "pwd=1234", "!address"}
					)
	public String test6(Model model, String email, String pwd, String phone) {
		
		System.out.println("=========/hello6.do get요청========");
		
		//@RequestParam은 생략가능 --> request.getParameter("email")
		System.out.println(email);
		System.out.println(pwd);
		System.out.println(phone);
		model.addAttribute("lunch","오늘메뉴는? 삼겹살");
		return "jsp/hello6"; //forward(request, response)
	}
	
	//@RequestMapping(value="/hello6.do", method=RequestMethod.POST)
	@PostMapping("/hello6.do")
	public void test7(
					@RequestParam("email") String email, 
					@RequestParam(value="pwd",required = false) String pwd, //required = false => 필수아님 null가능 (default 상태)
					String phone
					) {
		//default -> 접두사 + "/sample/hello6.do" + 접미사
		System.out.println("=========/hello6.do post요청========");
		
		System.out.println(email);
		System.out.println(pwd);
		System.out.println(phone);
	}
}
