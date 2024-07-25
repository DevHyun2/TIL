package com.shinhan.firstzone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository.MemberRepository;
import com.shinhan.firstzone.repository.PDSBoardRepository;
import com.shinhan.firstzone.repository.PDSFileRepository;
import com.shinhan.firstzone.repository.ProfileRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class Review {

	//ManyToOne Test
	@Autowired
	MemberRepository mRepo;
	@Autowired
	ProfileRepository pRepo;
	
	//OneToMany Test
	@Autowired
	PDSBoardRepository boardRepo;
	@Autowired
	PDSFileRepository fileRepo;
	
	//OneToMany Test
	//select test
	@Transactional //lazy여도 같은 transaction으로 묶음, fetch가 즉시 로딩으로 수행됨
	@Test
	void f2() {
		boardRepo.findAll().forEach(board->{
			System.out.println(board); // 즉시 로딩(EAGER), 지연 로딩(LAZY) default
		});
	}
	
	//ManyToOne Test
	//select test
	//@Test
	void f1() {
		pRepo.findAll().forEach(profile->{
			System.out.println(profile); // 즉시 로딩(EAGER), 지연 로딩(LAZY)
		});
	}
}
