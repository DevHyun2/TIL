package com.shinhan.firstzone.repository4;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shinhan.firstzone.vo2.MemberEntity;
import com.shinhan.firstzone.vo4.WebBoardEntity;

//interface설계
//1.JpaRepository, QuerydslPredicateExecutor 상속 : 기본제공함수들을 사용 가능
//2.규칙있는 함수정의 : findBy
//3.JPQL : select -> query DML -> @Modyfying @Query
//4.
public interface WebBoardRepository extends JpaRepository<WebBoardEntity, Long>,
						QuerydslPredicateExecutor<WebBoardEntity>{
	
	Page<WebBoardEntity> findByWriter(MemberEntity member, Pageable paging);
	//Page<WebBoardEntity> List<WebBoardDTO>
}
