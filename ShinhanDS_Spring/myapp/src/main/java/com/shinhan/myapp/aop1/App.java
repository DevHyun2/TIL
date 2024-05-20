package com.shinhan.myapp.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop1.xml");
		
		Calculator cal = (Calculator)ctx.getBean("proxyCal");
		cal.add();
		System.out.println("******************************");
		cal.add(100);
		System.out.println("******************************");
		cal.add(100, 20);
		System.out.println("******************************");
		cal.subtract(100, 20);
		System.out.println("******************************");
		cal.multiply(100, 20);
		System.out.println("******************************");
		cal.divide(100, 20);

	}

}
