package com.shinhan.myapp.aop2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bService2") //== @Component + Service 역할
public class BoardService {
	//BoardDAO boardDao = new BoardDAO();
	
	//타입이 같으면 객체를 Injection한다
	@Autowired
	BoardDAO boardDao;
	
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
