package com.shinhan.firstzone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.firstzone.repository.BoardRepository;
import com.shinhan.firstzone.vo.BoardEntity;
import com.shinhan.firstzone.vo.CarVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/sample")
public class SampleRestController {
	
	@Autowired
	BoardRepository bRepo;
	
	
	@DeleteMapping("/restdelete/{bno}")
	public String delete(@PathVariable("bno") Long bno) {
		bRepo.deleteById(bno);
		return "삭제성공";
	}
	
	@PutMapping("/update/restcntl")
	public String update(@RequestBody BoardEntity board) {
		bRepo.findById(board.getBno()).ifPresent(b->{
			log.info("before: "+ board);
			b.setContent("~~~수정~~~");
			b.setTitle("springboot");
			b.setWriter("manager");
			BoardEntity updateBoard = bRepo.save(b);
			log.info("after: " + updateBoard);
		});
		
		return "수정성공";
	}
	
	@PostMapping("/restinsert")
	public Long insert(@RequestBody BoardEntity board) {
		BoardEntity newBoard = bRepo.save(board);
		return newBoard.getBno();
	}
	
	@GetMapping("/restdetail/{bno}")
	public BoardEntity detail(@PathVariable("bno") Long bno){
		return bRepo.findById(bno).orElse(null);
	}
	
	@GetMapping("/restlist")
	public List<BoardEntity> list(){
		return (List<BoardEntity>)bRepo.findAll();
	}
	
	@GetMapping("test1")
	public String f1() {
		return "Hello~ 반갑습니다";
	}
	
	@GetMapping("test2")
	public CarVO f2() {
		CarVO car = CarVO.builder()
				.model("ABC")
				.price(2000)
				.build();
		return car;
	}
	
	@GetMapping("test3")
	public List<CarVO> f3(){
		List<CarVO> carList = new ArrayList<>();
		
		IntStream.rangeClosed(1,5).forEach(i->{
			CarVO car = CarVO.builder()	
					.model("ABC-"+i)
					.price(2000*i)
					.build();
			carList.add(car);
		});
		
		return carList;
	}
	
	
}
