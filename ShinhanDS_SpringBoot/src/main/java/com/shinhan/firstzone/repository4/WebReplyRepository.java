package com.shinhan.firstzone.repository4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shinhan.firstzone.vo4.WebReplyEntity;

public interface WebReplyRepository extends JpaRepository<WebReplyEntity, Long>,
							QuerydslPredicateExecutor<WebReplyEntity>{

}
