package com.shinhan.myapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// ��û�ּҿ���
@Controller
// �������� path�� class level���� ����, ������ method level�� �ۼ��Ѵ�. 
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
		data.addAttribute("myname","����DS");
		data.addAttribute("myscore",100);
		return "jsp/hello";
	}
	
	@GetMapping("/hello5.do")
	public ModelAndView test5() {
		ModelAndView data = new ModelAndView("jsp/hello");
		data.setViewName("jsp/hello");
		data.addObject("myname","����DS....");
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
		// @RequestParam�� �������� ==> request.getParameter("email")
		System.out.println("======/hello6.do��û=======");
		System.out.println(email2);
		System.out.println(pwd);
		System.out.println(phone);
		model.addAttribute("lunch", "���� �޴���? ����");
		return "jsp/hello6"; // forward(request, response)
	}
	
	//@RequestMapping(value = "/hello6.do", method=RequestMethod.POST)
	@PostMapping("/hello6.do") // ���� ����
	public void test7(
			@RequestParam("email") String email,
			@RequestParam(value="pwd", required = false) String pwd,
			String phone) { // required = false�� �⺻���̴�.
		//default => ���λ� + "/sample/hello6" + ���̻�
		System.out.println(email);
		System.out.println(pwd);
		System.out.println(phone);
	}
}
















