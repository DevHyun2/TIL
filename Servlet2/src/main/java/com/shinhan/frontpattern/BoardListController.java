package com.shinhan.frontpattern;

import java.util.Map;

import com.shinhan.model.BoardService;

public class BoardListController implements CommonControllerInterface{

	@Override
	public String execute(Map<String, Object> dataMap) {
		BoardService service = new BoardService();	
		dataMap.put("blist", service.selectAll());
		return "/board/boardlist.jsp";
	}

}
