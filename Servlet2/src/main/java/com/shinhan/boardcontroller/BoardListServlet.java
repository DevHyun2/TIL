package com.shinhan.boardcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.BoardService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/selectAll.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();	
		request.setAttribute("blist", service.selectAll());
		
		request.getRequestDispatcher("boardlist.jsp").forward(request, response);
	}
	

}
