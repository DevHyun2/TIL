package com.shinhan.firstzone.controller2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.firstzone.service2.WebReplyService;
import com.shinhan.firstzone.vo4.WebReplyDTO;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor //final인 field들 @Autowired
public class WebReplyRestController {
	
	final WebReplyService replyService;
	
	@GetMapping("/list{bno}")
	List<WebReplyDTO> list(@PathVariable("bno") Long bno) {
		return replyService.getList(bno);
	}
	
	@PostMapping("/register")
	Long insert(@RequestBody WebReplyDTO dto) {
		return replyService.register(dto);
	}
	
	@PutMapping("/modify")
	void update(@RequestBody WebReplyDTO dto) {
		replyService.register(dto);
	}
	
	@DeleteMapping("/delete/{rno}")
	void delete(@PathVariable("rno") Long rno) {
		replyService.delete(rno);
	}
}
