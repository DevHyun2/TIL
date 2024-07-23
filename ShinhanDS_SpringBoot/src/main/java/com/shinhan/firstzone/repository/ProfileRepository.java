package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shinhan.firstzone.vo2.MemberEntity;
import com.shinhan.firstzone.vo2.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>{
	
	//1.기본적인 CRUD 기본 제공: findAll, findById
	//2.규칙에 맞는 함수 정의
	List<ProfileEntity> findByMemberAndCurrentYnTrue(MemberEntity member);
	
	//3.query이용 -- 특정Member의 profile가져오기
	@Query("select p from ProfileEntity p right outer join MemberEntity m on (m = p.member) where m.mid = ?1")
	List<ProfileEntity> getProfile(String mid);
}
