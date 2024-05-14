package com.shinhan.myapp.section2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeopleApp {

	public static void main(String[] args) {
		f3();

	}

	private static void f1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2.xml");
		PeopleVO p2 = ctx.getBean("people2", PeopleVO.class);
		PeopleVO p3 = ctx.getBean("people3", PeopleVO.class);
		
		System.out.println(p2.getName() + "==>" + p2.getCar());
		System.out.println(p3);
		System.out.println("=============================");
		
		System.out.println(p2.getMajor());
		System.out.println(p2.getLicenseList());
		
		System.out.println(p3.getMajor());
		System.out.println(p3.getLicenseList());
		
		System.out.println(p2.getBookMap());
		System.out.println(p3.getBookMap());
		
		System.out.println(p2.getFriend());
		System.out.println(p2.getMyprofile());
	}
	//byName
	private static void f2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2.xml");
		PeopleVO p = ctx.getBean("people5", PeopleVO.class);
		System.out.println(p);
	}
	//byType
	private static void f3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2_1.xml");
		
		//기본적으로 컨테이너에 한개의 bean 객체를 생성한다(singleton)
		PeopleVO p1 = ctx.getBean("people5", PeopleVO.class);
		PeopleVO p2 = ctx.getBean("people5", PeopleVO.class);
		System.out.println(p1 == p2); //주소비교
		System.out.println(System.identityHashCode(p1));
		System.out.println(System.identityHashCode(p2));
	}
}
