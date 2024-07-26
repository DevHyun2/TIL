package com.shinhan.firstzone.service2;

import java.util.List;

import com.shinhan.firstzone.vo4.WebBoardEntity;
import com.shinhan.firstzone.vo4.WebReplyDTO;
import com.shinhan.firstzone.vo4.WebReplyEntity;

public interface WebReplyService {
	
	//CRUD
	//Create
	Long register(WebReplyDTO dto);
	
	//Read
	List<WebReplyDTO> getList(Long bno);
	
	//Update
	void modify(WebReplyDTO dto);
	
	//Delete
	void delete(Long rno);
	
	//DTO -> Entity
	default WebReplyEntity dtoToEntity(WebReplyDTO dto){
		WebBoardEntity board = WebBoardEntity.builder().bno(dto.getBoardBno()).build();
		WebReplyEntity entity = WebReplyEntity.builder()
				.rno(dto.getRno())
				.reply(dto.getReply())
				.replyer(dto.getReplyer())
				.board(board)
				.build();
		return entity;
	}
	
	//Entity -> DTO
	default WebReplyDTO entityToDTO(WebReplyEntity entity) {
		WebReplyDTO dto = WebReplyDTO.builder()
				.rno(entity.getRno())
				.reply(entity.getReply())
				.replyer(entity.getReplyer())
				.boardBno(entity.getBoard().getBno())
				.regdate(entity.getRegdate())
				.updatedate(entity.getUpdatedate())
				.build();
		return dto;
	}
}
