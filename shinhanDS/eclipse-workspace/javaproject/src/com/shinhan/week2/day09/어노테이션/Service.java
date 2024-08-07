package com.shinhan.week2.day09.어노테이션;

public class Service {
	
	@PrintAnnotation
	public void method1() {
		System.out.println("실행 내용1");
	}

	@PrintAnnotation("*")
	public void method2() {
		System.out.println("실행 내용2");
	}

	@PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("실행 내용3");
	}
	
	@PrintAnnotation(value = "#", number = 20, subject = "web")
	public void method4() {
		System.out.println("실행 내용4");
	}
}
