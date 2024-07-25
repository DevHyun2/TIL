package com.shinhan.firstzone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.firstzone.service.GuestBookService;
import com.shinhan.firstzone.vo2.GuestBookDTO;

import lombok.RequiredArgsConstructor;

@RestController //Controller + Response
@RequestMapping("/guest")
@RequiredArgsConstructor
public class GuestBookRestController {

	final GuestBookService gService;
	
	@GetMapping("/search")
	List<GuestBookDTO> search(String type, String keyword){
		return gService.getSearch(type, keyword);
	}
	
	@GetMapping("/list")
	List<GuestBookDTO> list() {
		return gService.readAll();
	}
	
	@GetMapping("/get/{gno}")
	GuestBookDTO read(@PathVariable Long gno) {
		return gService.readById(gno);
	}
	
	@PostMapping("/insert")
	String insert(@RequestBody GuestBookDTO dto) {
		gService.create(dto);
		return "입력작업";
	}
	
	@PutMapping("/update")
	String update(@RequestBody GuestBookDTO dto) {
		gService.update(dto);
		return "수정작업";
	}
	
	@DeleteMapping("/delete/{gno}")
	String delete(@PathVariable Long gno) {
		gService.delete(gno);
		return "삭제작업";
	}
	
}
