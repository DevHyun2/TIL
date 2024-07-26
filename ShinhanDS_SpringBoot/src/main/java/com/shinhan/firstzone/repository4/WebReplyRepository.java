package com.shinhan.firstzone.repository4;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shinhan.firstzone.vo4.WebBoardEntity;
import com.shinhan.firstzone.vo4.WebReplyEntity;

public interface WebReplyRepository extends JpaRepository<WebReplyEntity, Long>,
							QuerydslPredicateExecutor<WebReplyEntity>{

	List<WebReplyEntity> findByBoard(WebBoardEntity board);
}
