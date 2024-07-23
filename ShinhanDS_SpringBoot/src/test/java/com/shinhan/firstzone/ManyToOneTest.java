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
	
	//특정 Member의 profile정보조회
	@Test
	void getProfile() {
		pRepo.getProfile("user5").forEach(arr->{
			log.info(Arrays.toString(arr));
			log.info("이름:"+arr[0] + ",파일이름:" + arr[1]);
		});
	}
	
	//PK fno=1인 profile의 정보조회
	//@Test
	void selectByFno() {
		pRepo.findById(1L).ifPresentOrElse(profile->{
			System.out.println("파일이름: " + profile.getFname());
			System.out.println(profile.isCurrentYn()?"현재프로파일임":"과거프로파일임");
			System.out.println(profile.getMember().getMname());
			System.out.println(profile.getMember().getMrole().name());
		},()->{
				System.out.println("존재하지않음");
		});;
	}
	
	//조회
	//@Test
	void selectProfile() {
		pRepo.findAll().forEach(p->{
			log.info(p);
		});
	}
	
	//@Test
	void selectByMid() {
		mRepo.findById("user5").ifPresentOrElse(m->{
			log.info(m);
		}, ()->{
			log.info("존재하지 않는 Member입니다.");
		});
	}
	
	//@Test
	void profileInsert3() {
		MemberEntity member = MemberEntity.builder().mid("user5").build();
		IntStream.rangeClosed(1, 10).forEach(i->{
			ProfileEntity profile = ProfileEntity.builder()
					.fname("face-" + i)
					.currentYn(i==3?true:false)
					.member(member)
					.build();
			pRepo.save(profile);
		});
	}
	//@Test
	void profileInsert2() {
		MemberEntity member = MemberEntity.builder().mid("user3").build();
		IntStream.rangeClosed(1, 5).forEach(i->{
			ProfileEntity profile = ProfileEntity.builder()
					.fname("face-" + i)
					.currentYn(i==3?true:false)
					.member(member)
					.build();
			pRepo.save(profile);
		});
	}
	//@Test
	void profileInsert() {
		MemberEntity member = MemberEntity.builder().mid("admin1").build();
		IntStream.rangeClosed(1, 5).forEach(i->{
			ProfileEntity profile = ProfileEntity.builder()
					.fname("face-" + i)
					.currentYn(i==5?true:false)
					.member(member)
					.build();
			pRepo.save(profile);
		});
	}
	
	//1. Member insert
	//@Test
	void memberInsert2() {
		IntStream.rangeClosed(1, 5).forEach(i->{
			MemberEntity member = MemberEntity.builder()
					.mid(i==1?"king":"user"+i)
					.mname("김민영"+i)
					.mpassword("1234")
					.mrole(i==1?MemberRole.MANAGER:MemberRole.USER)
					.build(); 
			mRepo.save(member);
		});
	}

	//@Test 
	void memberInsert() { 
		IntStream.rangeClosed(1, 2).forEach(i->{
			MemberEntity member = MemberEntity.builder() 
					.mid("admin"+i) 
					.mname("신윤철"+i)
					.mpassword("1234") 
					.mrole(i==1?MemberRole.ADMIN:MemberRole.USER) 
					.build();
			mRepo.save(member); 
		}); 
	}
	 
	

}

