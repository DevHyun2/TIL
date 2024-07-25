package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shinhan.firstzone.vo3.FreeBoardEntity;
import com.shinhan.firstzone.vo3.FreeReplyEntity;

public interface FreeReplyRepository extends JpaRepository<FreeReplyEntity, Long>{
	List<FreeReplyEntity> findByBoard(FreeBoardEntity board2);
	
	@Query("select b from #{#entityName} b join b.board")
	List<FreeReplyEntity> findAllWithReplyUsingJoin();
	
	@Query("select b from #{#entityName} b join fetch b.board")
	List<FreeReplyEntity> findAllWithReplyUsingJoinFetch();
}
