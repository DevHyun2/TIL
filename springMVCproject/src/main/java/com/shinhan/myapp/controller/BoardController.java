package com.shinhan.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/board/selectAll.do")
	public String test1(Model model) {
		System.out.println("/board/selectAll.do");
		model.addAttribute("myname","º¸µå");
		return "board/boardlist";
	}
}
