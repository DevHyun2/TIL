package com.shinhan.firstzone.controller2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.firstzone.service2.WebBoardService;
import com.shinhan.firstzone.vo4.WebBoardDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/webboard")
@RequiredArgsConstructor
@Log4j2
public class WebBoardController {

	final WebBoardService boardService;
	
	@GetMapping("/register")
	void registerForm() {
		
	}
	
	@PostMapping("/register")
	String register(WebBoardDTO dto) {
		log.info("입력 before: ", dto);
		Long bno = boardService.register(dto);
		log.info(bno + "번 게시글이 등록됨");
		return "redirect:list";
	}
	
	@GetMapping("/list")
	String getList(Model model) {
		List<WebBoardDTO> blist = boardService.getList();
		model.addAttribute("blist", blist);
		return "webboard/boardlist";
	}
	
	@GetMapping("/detail")
	void detail(Long bno, Model model) {
		model.addAttribute("board", boardService.selectById(bno));
	}
	
	@PostMapping("/modify")
	String modify(WebBoardDTO dto) {
		boardService.modify(dto);
		return "redirect:list";
	}
	
	@PostMapping("/delete")
	String delete(Long bno) {
		boardService.delete(bno);
		return "redirect:list";
	}
}
