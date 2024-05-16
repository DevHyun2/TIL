package com.shinhan.myapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bService2") //== @Component + Service ?��?��
public class BoardService {
	//BoardDAO boardDao = new BoardDAO();
	
	//???��?�� 같으�? 객체�? Injection?��?��
	@Autowired
	BoardDAO boardDao;
	
	//?��체조?��
	public List<BoardDTO> selectAll() {
		return boardDao.selectAll();
	}
	
	//?��건조?��
	public BoardDTO selectById(int bno) {
		return boardDao.selectById(bno);
	}
	//?��?��
	public int insertBoard(BoardDTO board) {
		return boardDao.insertBoard(board);
	}
	
	//?��?��
	public int updateBoard(BoardDTO board) {
		return boardDao.updateBoard(board);
	}
	
	//?��?��
	public int deleteBoard(int bno) {
		return boardDao.deleteBoard(bno);
	}
}
