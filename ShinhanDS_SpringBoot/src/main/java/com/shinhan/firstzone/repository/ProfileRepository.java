package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shinhan.firstzone.vo2.MemberEntity;
import com.shinhan.firstzone.vo2.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>{
	//규칙에 맞는 함수 정의
	List<ProfileEntity> findByMemberAndCurrentYnTrue(MemberEntity member);
	List<ProfileEntity> findByCurrentYnTrue();
	
	//@Query 이용
	@Query("select m.mname, p.fname from ProfileEntity p"
			+ " right outer join MemberEntity m on (m = p.member) where m.mid = ?1")
	List<Object[]> getProfile(String mid);
	
	//멤버별 profile의 count
	@Query("select m.mid, count(p) from MemberEntity m"
			+ " left outer join ProfileEntity p on (m = p.member) group by m.mid")
	List<Object[]> getProfileCount();
}
