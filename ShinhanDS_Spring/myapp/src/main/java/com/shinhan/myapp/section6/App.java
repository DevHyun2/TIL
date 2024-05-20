package com.shinhan.myapp.section6;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di6.xml");
		
//		CompanyVO a = ctx.getBean("companyVO", CompanyVO.class);
//		System.out.println(a);
		
		BoardService service = ctx.getBean("bService", BoardService.class);
		
		List<BoardDTO> blist = service.selectAll();
		blist.stream().forEach(board -> System.out.println(blist));
	}

}
