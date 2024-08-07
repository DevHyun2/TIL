package com.shinhan.firstzone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.shinhan.firstzone.repository.BoardRepository;
import com.shinhan.firstzone.vo.BoardEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest		//Junit(단위test)으로 test
public class BoardCRUDTest {

	@Autowired
	BoardRepository bRepo;
	
	@Test
	void f9() {
		//bRepo.jpqlTest1("요일", "짝수").forEach(b->{log.info(b);});
		//bRepo.jpqlTest2("요일", "짝수").forEach(b->{log.info(b);});
		//bRepo.jpqlTest3("요일", "짝수").forEach(b->{log.info(b);});
		//bRepo.jpqlTest4("요일", "짝수").forEach(b->{log.info(Arrays.toString(b));});
		bRepo.jpqlTest5("%요일%", "%짝수%").forEach(b->{log.info(b);});
	}
	
	//@Test
	void f8() {
		//Pageable pageable = PageRequest.of(0, 5);
		//Pageable pageable = PageRequest.of(0, 5, Sort.by("bno").descending());
		//Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "bno");
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, new String[]{"writer", "bno"});
		// order by writer desc, bno desc limit 0,5
		Page<BoardEntity> result = bRepo.findAll(pageable);
		
		List<BoardEntity> blist = result.getContent();
		
		log.info("getNumber:" + result.getNumber());
		log.info("getSize:" + result.getSize());
		log.info("getTotalElements:" + result.getTotalElements());
		log.info("getTotalPages:" + result.getTotalPages());
		
		blist.forEach(board -> {log.info(board);});
	}
	
	//@Test
	void f7() {
		Pageable pageable = PageRequest.of(1, 5); //PageRequest.of(PageNumber, PageSize): PageNumber는 0부터 시작
		bRepo.findByBnoGreaterThanOrderByBnoDesc(5L, pageable).forEach(b->{
			log.info(b);
		});
	}
	
	//@Test
	void f6() {
		bRepo.findByContentLikeAndBnoBetweenOrderByBnoDesc("%짝수%", 1L, 11L)
			.forEach(b->{
				log.info(b);
			});
	}
	
	//@Test
	void f5() {
		bRepo.findByBnoBetween(1L, 11L).forEach(b->{
			log.info(b);
		});
	}
	
	//@Test
	void f4() {
		bRepo.findByTitleContaining("1").forEach(b->{
			log.info(b);
		});
	}
	
	//@Test
	void f3() {
		bRepo.findByTitleEndingWith("1").forEach(b->{
			log.info(b);
		});
	}
	
	//@Test
	void f2() {
		bRepo.findByTitleStartingWith("월").forEach(b->{
			log.info(b);
		});
	}
	
	//@Test
	void f1() {
		bRepo.findByWriter("user1").forEach(b->{
			log.info(b);
		});
	}
	
	//건수확인
	//@Test
	void boardCount() {
		Long cnt = bRepo.count(); // select count(*) from table
		log.info(cnt + "건");
	}
	
	//삭제
	//@Test
	void delete() {
		bRepo.deleteById(2L);
		bRepo.findById(2L).ifPresentOrElse(board->{
			log.info(board);
		}, ()->{
			log.info("Not Found");
		});
	}
	
	//수정
	//@Test
	void update() {
		bRepo.findById(1L).ifPresent(board->{
			log.info("before: "+ board);
			board.setContent("~~~수정~~~");
			board.setTitle("springboot");
			board.setWriter("manager");
			BoardEntity updateBoard = bRepo.save(board);
			log.info("after: " + updateBoard);
		});
	}
	
	//@Test
	void detail() {
		bRepo.findById(50L).ifPresentOrElse(board->{
			log.info(board);
		}, ()->{
			log.info("해당 데이터가 존재하지 않습니다.");
		});
	}
	
	//@Test
	void select() {
		bRepo.findAll().forEach(board->{
			log.info(board);
		});
	}
	
	//@Test
	void insert() {
		IntStream.rangeClosed(11, 20).forEach(i->{
			BoardEntity entity = BoardEntity.builder()
					.title("토요일 " + i)
					.content("맑음. " + (i%2==0?"짝수":"홀수"))
					.writer("user" + i%5)
					.build();
			bRepo.save(entity);
		});
	}
}
