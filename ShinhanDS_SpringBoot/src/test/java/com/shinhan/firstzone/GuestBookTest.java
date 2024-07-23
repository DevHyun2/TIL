package com.shinhan.firstzone;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository.GuestBookRepository;
import com.shinhan.firstzone.vo2.GuestBookDTO;
import com.shinhan.firstzone.vo2.GuestBookEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class GuestBookTest {
	
	@Autowired
	GuestBookRepository gRepo;
	
	//@Test
	void insert() {
		IntStream.rangeClosed(11, 15).forEach(i -> {
			GuestBookEntity entity = GuestBookEntity.builder()
					.title("목요일" + i)
					.content("졸리노")
					.writer("사용자" + i)
					.build();
			gRepo.save(entity);
		});
	}
	//@Test
	void select() {
		gRepo.findAll().forEach(entity -> {
			log.info(entity);
		});
	}
	
	//등록일이 null인 data의 조회
	//@Test
	void select2() {
		gRepo.findByRegDateIsNull().forEach(entity -> {
			log.info(entity);
		});
	}
	//@Test
	void select3() {
		gRepo.findByRegDateIsNull2().forEach(entity -> {
			log.info(entity);
		});
	}
	//@Test
	void select4() {
		gRepo.findByRegDateIsNull3().forEach(entity -> {
			log.info(entity);
		});
	}
	//@Test
	void select5() {
		gRepo.findByRegDateIsNull4(10L).forEach(entity -> {
			log.info(entity);
			});
	}
	
	//@Test
	void f2() {
		GuestBookEntity entity = gRepo.findById(1L).orElse(null);
		
		if(entity!=null) { // DB에서 1번을 가져왔다면
			// BROWSER 로 보낼 DTO 형태로 변환 후
			GuestBookDTO dto = GuestBookDTO.builder()
					.gno(entity.getGno())
					.title(entity.getTitle())
					.content(entity.getContent())
					.writer(entity.getWriter())
					.regDate(entity.getRegDate())
					.modDate(entity.getModDate())
					.build();
			// DB 정보 출력
				log.info(dto);
		}
	}
	
	// DTO -> Entity // 이걸 서비스로
	//@Test
	void f1() {
		// DTO가 BROSWER로부터 들어오면  
		GuestBookDTO dto = GuestBookDTO.builder()
				.gno(1L)
				.title("타이틀")
				.content("내용")
				.writer("작성자")
				.build();
		// ENTITY로 바꿔서 
		GuestBookEntity entity = GuestBookEntity.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();
		// DB에 저장
		gRepo.save(entity);
	}
}
