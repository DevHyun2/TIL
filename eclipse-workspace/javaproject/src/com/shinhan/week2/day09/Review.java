package com.shinhan.week2.day09;

import java.io.FileNotFoundException;

//@FunctionalInterface//함수가 하나를 넘어서 람다식 불가
//정의만 있고 구현은 없음(추상메서드)
interface MyInterface {
	public abstract void method1(); //모두 public abstract 생략
	void method2() throws FileNotFoundException;
	void method3() throws Exception;
	
}
//구현class
class MyClassImpl implements MyInterface{

	//1.부모의 throw Exception이 존재하지 않은 경우 : 없거나 RuntimeException가능(하위에 있는것 가능)
	public void method1() throws NullPointerException {
		System.out.println("method1");
	}

	//2.자식은 부모의 Exception보다 하위 이어야 한다.
	public void method2() throws FileNotFoundException {
		System.out.println("method2");
	}
	
	public void method3() throws Exception {
		System.out.println("method3");
	}
	
}


public class Review {
	//1.field 멤버변수
	MyInterface a = new MyClassImpl();
	
	//익명구현class
	MyInterface a2 = new MyInterface() {
		public void method1() {}
		public void method2() {}
		public void method3() {}
		
	};
	
	public static void main(String[] args) {
		//2.local변수
		MyInterface b = new MyClassImpl();
		
		MyInterface b2 = new MyInterface() {
			public void method1() {}
			public void method2() {}
			public void method3() {}
			
		};
		
		call(new MyClassImpl());
		call(new MyInterface() {
			public void method1() {}
			public void method2() {}
			public void method3() {}
			
		});
	}

	private static void call(MyInterface c) {
		
		
	}
}
