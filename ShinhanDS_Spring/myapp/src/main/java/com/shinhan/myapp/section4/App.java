package com.shinhan.myapp.section4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di4.xml");
		BoardService service = ctx.getBean("boardService", BoardService.class);
		
		for(BoardDTO board:service.selectAll()) {
			System.out.println(board);
		}
	}

}
