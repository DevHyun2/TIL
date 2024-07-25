package com.shinhan.firstzone.service2;

import java.util.List;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.shinhan.firstzone.vo2.MemberEntity;
import com.shinhan.firstzone.vo4.QWebBoardEntity;
import com.shinhan.firstzone.vo4.WebBoardDTO;
import com.shinhan.firstzone.vo4.WebBoardEntity;

public interface WebBoardService {

	//CRUD 작업 제공
	//1.입력
	Long register(WebBoardDTO dto);
	
	//2.조회
	List<WebBoardDTO> getList();
	WebBoardDTO selectById(Long bno);
	
	//3.수정
	void modify(WebBoardDTO dto);
	
	//4.삭제
	void delete(Long bno);
	
	//동적 SQL 만들기(Querydsl)
	//t->title, c->content, w->writer
	public default Predicate makePredicate(String type, String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		QWebBoardEntity board = QWebBoardEntity.webBoardEntity;
		builder.and(board.bno.gt(0));
		//검색조건처리
		if(type==null) return builder;
		
		BooleanBuilder builder2 = new BooleanBuilder();
		if(type.contains("t")) builder2.or(board.title.like("%" + keyword + "%"));
		if(type.contains("c")) builder2.or(board.content.like("%" + keyword + "%"));
		if(type.contains("2")) builder2.or(board.writer.mname.like("%" + keyword + "%"));
		builder.and(builder2);
		return builder;
		}
	
	//DTO -> Entity (DB에 반영하기 위함)
	default WebBoardEntity dtoToEntity(WebBoardDTO dto) {
		MemberEntity member = MemberEntity.builder().mid(dto.getMid()).build();
		WebBoardEntity entity = WebBoardEntity.builder()
				.bno(dto.getBno())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member)
				.build();
		return entity;
	}
	
	//Entity -> DTO (Data 전송을 위함, controller, service, view에서 작업)
	default WebBoardDTO entityToDTO(WebBoardEntity entity) {
		WebBoardDTO dto = WebBoardDTO.builder()
				.bno(entity.getBno())
				.title(entity.getTitle())
				.mid(entity.getWriter().getMid())
				.mname(entity.getWriter().getMname())
				.content(entity.getContent())
				.regdate(entity.getRegdate())
				.updatedate(entity.getUpdatedate())
				.replyCount(entity.getReplies().size())
				.build();
		return dto;
	}
	
	
}
