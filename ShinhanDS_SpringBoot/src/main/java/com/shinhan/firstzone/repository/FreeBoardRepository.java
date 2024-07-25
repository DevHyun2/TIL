package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shinhan.firstzone.vo3.FreeBoardEntity;

//join: N+1 문제 발생
//join fetch: N+1 문제 해결
public interface FreeBoardRepository extends JpaRepository<FreeBoardEntity, Long>
								, QuerydslPredicateExecutor<FreeBoardEntity>{

	Page<FreeBoardEntity> findByBnoBetween(Long start, Long end, Pageable pageable);
	
	@Query(value = "select b.title, count(reply)"
			+ " from #{#entityName} b "
			+ " left outer join b.replies reply"
			+ " group by b.title order by b.title")
	public List<Object[]> getBoardReplyCount();
	
	@Query("select b from #{#entityName} b join b.replies")
	List<FreeBoardEntity> findAllWithReplyUsingJoin();
	
	@Query("select b from #{#entityName} b join fetch b.replies")
	List<FreeBoardEntity> findAllWithReplyUsingJoinFetch();
}
