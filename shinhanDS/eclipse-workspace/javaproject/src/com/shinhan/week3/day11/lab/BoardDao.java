package com.shinhan.week3.day11.lab;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	public List<Board> getBoardList(){
		List<Board> alist = new ArrayList<>();
		
		alist.add(new Board("제목1","내용1"));
		alist.add(new Board("제목2","내용2"));
		alist.add(new Board("제목3","내용3"));
		
		return alist;
	}
}
