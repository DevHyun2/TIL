package com.shinhan.firstzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.firstzone.repository.BoardRepository;
import com.shinhan.firstzone.vo.BoardEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	BoardRepository bRepo;
	
	@GetMapping("/list")
	public List<BoardEntity> list() {
		return (List<BoardEntity>)bRepo.findAll();
	}
	
	@GetMapping("/detail/{bno}")
	public BoardEntity detail(@PathVariable("bno") Long bno) {
		return bRepo.findById(bno).orElse(null);
	}
	
	@PostMapping("/insert")
	public Long insert(@RequestBody BoardEntity board) {
		BoardEntity newBoard =  bRepo.save(board);
		return newBoard.getBno();
	}
	
	@PutMapping("/update")
	public Long update(@RequestBody BoardEntity board) {
		bRepo.findById(board.getBno()).ifPresent(b -> {
			log.info("board:" + board);
			board.setContent("수정");
			board.setTitle("springboot");
			board.setWriter("manager");
			BoardEntity updateBoard = bRepo.save(b);
			log.info("after:" + updateBoard);
		});
		return board.getBno();
	}
	
	@DeleteMapping("/delete/{bno}")
	public String delete(@PathVariable("bno") Long bno) {
		bRepo.deleteById(bno);
		return "삭제성공";
	}
}
