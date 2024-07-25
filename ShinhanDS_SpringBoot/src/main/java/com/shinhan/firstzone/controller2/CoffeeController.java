package com.shinhan.firstzone.controller2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shinhan.firstzone.vo2.MemberEntity;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/coffee")
@RequiredArgsConstructor
public class CoffeeController {
	
	
	//final FreeBoardRepository boardRepo;
	
	@GetMapping("/list")
	void f3(@RequestParam("keyword") String keyword2, Model model , HttpSession session) {
		//model.addAttribute("blist", boardRepo.findAll());
		MemberEntity member = MemberEntity.builder()
				.mid("zz")
				.mname("admin")
				.build();
		
		session.setAttribute("loginUser", member);
	}
	
	@GetMapping("/page2")
	public String f2(Model model) {
		model.addAttribute("menu","카페라떼");
		MemberEntity member = MemberEntity.builder()
				.mid("abc")
				.mname("찐")
				.build();
		model.addAttribute("member",member);
		return "coffee/page1";
	}
	
	@GetMapping("/page1")
	public void f1(Model model) {
		model.addAttribute("menu","아메리카노");
		MemberEntity member = MemberEntity.builder()
				.mid("abc")
				.mname("찐")
				.build();
		model.addAttribute("member",member);
		
	}
}
