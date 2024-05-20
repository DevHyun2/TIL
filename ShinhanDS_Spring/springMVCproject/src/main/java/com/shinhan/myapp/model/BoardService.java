package com.shinhan.myapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bService2") //== @Component + Service ?ó≠?ï†
public class BoardService {
	//BoardDAO boardDao = new BoardDAO();
	
	//???ûÖ?ù¥ Í∞ôÏúºÎ©? Í∞ùÏ≤¥Î•? Injection?ïú?ã§
	@Autowired
	BoardDAO boardDao;
	
	//?†ÑÏ≤¥Ï°∞?öå
	public List<BoardDTO> selectAll() {
		return boardDao.selectAll();
	}
	
	//?ïúÍ±¥Ï°∞?öå
	public BoardDTO selectById(int bno) {
		return boardDao.selectById(bno);
	}
	//?ûÖ?†•
	public int insertBoard(BoardDTO board) {
		return boardDao.insertBoard(board);
	}
	
	//?àò?†ï
	public int updateBoard(BoardDTO board) {
		return boardDao.updateBoard(board);
	}
	
	//?Ç≠?†ú
	public int deleteBoard(int bno) {
		return boardDao.deleteBoard(bno);
	}
}
