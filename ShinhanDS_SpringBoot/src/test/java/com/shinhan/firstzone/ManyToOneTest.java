package com.shinhan.firstzone;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository.MemberRepository;
import com.shinhan.firstzone.repository.ProfileRepository;
import com.shinhan.firstzone.vo2.MemberEntity;
import com.shinhan.firstzone.vo2.MemberRole;
import com.shinhan.firstzone.vo2.ProfileEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class ManyToOneTest {

	@Autowired
	MemberRepository mRepo;
	
	@Autowired
	ProfileRepository pRepo;
	
	//8.멤버별 프로필 개수 조회
	@Test
	void countProfileByMember() {
		pRepo.getProfileCount().forEach(arr->{
			log.info(Arrays.toString(arr));
			log.info("아이디: " + arr[0] + ", 프로필 개수: " + arr[1]);
			log.info("-----------------------");
		});
	}
	
	//7.사용 중인 프로필 조회
	//@Test
	void selectProfileActive() {
		pRepo.findByCurrentYnTrue().forEach(p->log.info(p));
	}
	
	//6.특정 멤버(user5)의 프로필 정보 조회
	//@Test
	void selectProfileByMember() {
		MemberEntity member = MemberEntity.builder().mid("user5").build();
		pRepo.findByMemberAndCurrentYnTrue(member).forEach(p->log.info(p));
	}
	
	//@Test
	void selectProfileByMember2() {
		pRepo.getProfile("user5").forEach(arr->{
			log.info(Arrays.toString(arr));
			log.info("이름: " + arr[0] + ", 파일이름: " + arr[1]);
			log.info("----------------------------");
		});
	}
	
	//5.프로필로 멤버 조회
	//@Test
	void selectMemberByFno() {
		pRepo.findById(1L).ifPresentOrElse(p->{
			System.out.println("파일이름: " + p.getFname());
			System.out.println(p.isCurrentYn()?"현재프로필임":"과거프로필임");
			System.out.println("이름: " + p.getMember().getMname());
			System.out.println("권한: " + p.getMember().getMrole().name());
		}, ()->{
			System.out.println("존재하지 않는 Profile입니다.");
		});
	}
	
	//4.프로필 전부 조회
	//@Test
	void selectProfile() {
		pRepo.findAll().forEach(p->{
			log.info(p);
		});
	}
	
	//3.특정 멤버 조회
	//@Test
	void selectByMid() {
		mRepo.findById("user5").ifPresentOrElse(m->{
			log.info(m);
		}, ()->{
			log.info("존재하지 않는 Member입니다.");
		});
	}
	
	//2.Profile insert
	//@Test
	void profileInsert() {
		MemberEntity member = MemberEntity.builder().mid("user5").build();
		IntStream.rangeClosed(1, 10).forEach(i->{
			ProfileEntity profile = ProfileEntity.builder()
					.fname("computer-" + i)
					.currentYn(i==3?true:false)
					.member(member)
					.build();
			pRepo.save(profile);
		});
	}
	
	//1.Member insert
	//@Test
	void memberInsert() {
		IntStream.rangeClosed(1, 2).forEach(i->{
			MemberEntity member = MemberEntity.builder()
					.mid("admin" + i)
					.mname("신윤철" + i)
					.mpassword("1234")
					.mrole(MemberRole.ADMIN)
					.build();
			mRepo.save(member);
		});
	}
}
