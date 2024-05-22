package com.shinhan.myapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// 요청주소연습
@Controller
// 공통적인 path는 class level에서 정의, 각각은 method level에 작성한다. 
@RequestMapping("/sample")
public class SampleController {
	@RequestMapping("hello.do")
	public String test1() {
		return "jsp/hello";
	}
	
	@RequestMapping("/hello1.do")
	public String test2() {
		return "jsp/hello";
	}
	
	@RequestMapping(value = {"/hello2.do","/hello3.do"},
			method=RequestMethod.GET)
	public String test3() {
		return "jsp/hello";
	}
	
	@GetMapping("/hello4.do")
	public String test4(Model data) {
		data.addAttribute("myname","신한DS");
		data.addAttribute("myscore",100);
		return "jsp/hello";
	}
	
	@GetMapping("/hello5.do")
	public ModelAndView test5() {
		ModelAndView data = new ModelAndView("jsp/hello");
		data.setViewName("jsp/hello");
		data.addObject("myname","신한DS....");
		data.addObject("myscore",99);
		return data;
	}
	
	@RequestMapping(value = "/hello6.do",
			method = RequestMethod.GET,
			params = {"email", "pwd=1234", "!address"})
	public String test6(Model model, 
			@RequestParam("email") String email2,
			String pwd, 
			String phone) {
		// @RequestParam는 생략가능 ==> request.getParameter("email")
		System.out.println("======/hello6.do요청=======");
		System.out.println(email2);
		System.out.println(pwd);
		System.out.println(phone);
		model.addAttribute("lunch", "오늘 메뉴는? 삼겹살");
		return "jsp/hello6"; // forward(request, response)
	}
	
	//@RequestMapping(value = "/hello6.do", method=RequestMethod.POST)
	@PostMapping("/hello6.do") // 위와 동일
	public void test7(
			@RequestParam("email") String email,
			@RequestParam(value="pwd", required = false) String pwd,
			String phone) { // required = false가 기본값이다.
		//default => 접두사 + "/sample/hello6" + 접미사
		System.out.println(email);
		System.out.println(pwd);
		System.out.println(phone);
	}
}
















