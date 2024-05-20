package com.shinhan.boardcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.shinhan.dto.BoardDTO;
import com.shinhan.model.BoardService;

/**
 * Servlet implementation class AjaxJsonServlet
 */
@WebServlet("/json2")
public class AjaxJsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BoardDTO> blist = new BoardService().selectAll();
		
		JSONObject boardlist = new JSONObject();
		JSONArray arr = new JSONArray();
		for(BoardDTO board:blist) {
			JSONObject obj = new JSONObject();
			obj.put("bno", board.getBno());
			obj.put("title", board.getTitle());
			obj.put("content", board.getContent());
			arr.add(obj);	
		}
		boardlist.put("boardlist", arr); //{"boardlist":[{},{},{}]}
		String json = boardlist.toJSONString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(json);
	}
    //Java가 data를 JAvaScript로 보내기 
	//JSON으로 보내면 JavaScript에서 파싱하여 data추출 
	 
}






