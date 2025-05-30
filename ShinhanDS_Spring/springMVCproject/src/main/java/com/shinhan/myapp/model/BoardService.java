package com.shinhan.myapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("bService2") //== @Component + Service ?­? 
public class BoardService {
	//BoardDAO boardDao = new BoardDAO();
	
	//????΄ κ°μΌλ©? κ°μ²΄λ₯? Injection??€
	@Autowired
	@Qualifier("bDAO")
	BoardDAO boardDao;
	
	//? μ²΄μ‘°?
	public List<BoardDTO> selectAll() {
		return boardDao.selectAll();
	}
	
	//?κ±΄μ‘°?
	public BoardDTO selectById(int bno) {
		return boardDao.selectById(bno);
	}
	//?? ₯
	public int insertBoard(BoardDTO board) {
		return boardDao.insertBoard(board);
	}
	
	//?? 
	public int updateBoard(BoardDTO board) {
		return boardDao.updateBoard(board);
	}
	
	//?­? 
	public int deleteBoard(int bno) {
		return boardDao.deleteBoard(bno);
	}
	
	public int deleteBoardArray(Integer[] checkBno) {
		return boardDao.deleteBoardArray(checkBno);
	}
}
