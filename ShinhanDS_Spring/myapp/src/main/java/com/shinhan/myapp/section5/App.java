package com.shinhan.myapp.section5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di5.xml");
		
		ComputerVO com1 = ctx.getBean("com1", ComputerVO.class);
		System.out.println(com1);
		
		CompanyVO comp1 = ctx.getBean("comp1", CompanyVO.class);
		System.out.println(comp1);
	}

}
