package com.shinhan.myapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.myapp.model.BoardDTO;
import com.shinhan.myapp.model.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	 // 적용
	@Autowired
	BoardService bService; 
	
	@RequestMapping("/selectAll.do")
	public String test1(Model model, HttpServletRequest request) {
		System.out.println("/board/selectAll.do요청");
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		String message = "";
		if(flashMap != null) {
			message = (String)flashMap.get("resultMessage");
		}
		
		List<BoardDTO> blist = bService.selectAll();
		model.addAttribute("blist",blist);
		model.addAttribute("resultMessage",message);
		return "board/boardlist"; // forward됨=>접두사+"board/boardlist" + 접미사
	}
	
	
	
	@GetMapping("/boardinsert.do")
	public String test2() {
		// forward : 접두사 + "board/boardinsert" + 접미사
		return "board/boardinsert";
	}	
	
	@PostMapping("/boardInsert.do")
	//public String test3(String title, String content, String pic) {
	public String test3(BoardDTO board, RedirectAttributes attr, HttpSession session) {
		EmpDTO emp =(EmpDTO)session.getAttribute("emp");
		String writer = emp.getFirst_name() + emp.getLast_name();
		board.setWriter(writer);
		
		int result = bService.insertBoard(board);
		String message;
		if(result > 0) {
			message = "insert success";
		}else {
			message = "insert fail";
		}
		attr.addFlashAttribute("resultMessage", message);
		//forward: 요청을 위임
		//redirect: 재요청
		return "redirect:selectAll.do";
		//response.sendRedirect("selectAll.do")
	}
	
	
	
	
	
	@GetMapping("/boardDetail.do")
	public String detail(@RequestParam("bno") Integer bno, Model model) {
		model.addAttribute("board",bService.selectById(bno));
		return "board/boarddetail"; // 페이지 주소 같으면 안줘도 됌
	}
	@PostMapping("/boardDetail.do")
	public String update(BoardDTO board, RedirectAttributes attr) {
		int result = bService.updateBoard(board);
		String message;
		if(result > 0) {
			message = "insert success";
		}else {
			message = "insert fail";
		}
		attr.addFlashAttribute("resultMessage", message);
		return "redirect:selectAll.do";
	}
	
	
	
	
	
	//@RequestMapping(value = "/boardDelete.do", method = RequestMethod.GET)
	@GetMapping("/boardDelete.do")
	public String delete(Integer bno, RedirectAttributes attr) {
		System.out.println("/board/boardDelete.do요청");
		int result = bService.deleteBoard(bno);
		String message;
		if(result > 0) {
			message = "insert success";
		}else {
			message = "insert fail";
		}
		attr.addFlashAttribute("resultMessage", message);
		return "redirect:selectAll.do";
	}
	
	@GetMapping("/selectDelete.do")
	public String selectDelete(Integer[] checkBno) {
		System.out.println(Arrays.toString(checkBno));
		
		int result = bService.deleteBoardArray(checkBno);
		return "redirect:selectAll.do";
	}
}









