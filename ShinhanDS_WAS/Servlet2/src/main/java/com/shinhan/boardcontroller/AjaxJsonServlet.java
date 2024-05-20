package com.shinhan.boardcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.shinhan.dto.BoardDTO;
import com.shinhan.model.BoardService;

/**
 * Servlet implementation class AjaxJsonServlet
 */
@WebServlet("/json")
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String jsonInfo =  request.getParameter("jsonInfo");
       System.out.println(jsonInfo);
       
       JSONParser parser = new JSONParser();
       try {
		JSONObject jsonObj = (JSONObject) parser.parse(jsonInfo);
		Long bno = (Long)jsonObj.get("bno");
		int i_bno = bno.intValue();
		String title = (String)jsonObj.get("title");
		String content = (String)jsonObj.get("content");
		String writer = (String)jsonObj.get("writer");
		BoardDTO board = new BoardDTO(i_bno, title, content, writer, "watch.jpg", null);
		int result = new BoardService().insertBoard(board);
		response.sendRedirect("selectAll.do");
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	 
}
