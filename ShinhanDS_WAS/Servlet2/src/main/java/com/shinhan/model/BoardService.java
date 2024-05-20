package com.shinhan.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.BoardDTO;
import com.shinhan.util.DBUtil;

public class BoardService {
	BoardDAO boardDao = new BoardDAO();
	
	//전체조회
	public List<BoardDTO> selectAll() {
		return boardDao.selectAll();
	}
	
	//한건조회
	public BoardDTO selectById(int bno) {
		return boardDao.selectById(bno);
	}
	//입력
	public int insertBoard(BoardDTO board) {
		return boardDao.insertBoard(board);
	}
	
	//수정
	public int updateBoard(BoardDTO board) {
		return boardDao.updateBoard(board);
	}
	
	//삭제
	public int deleteBoard(int bno) {
		return boardDao.deleteBoard(bno);
	}
}
