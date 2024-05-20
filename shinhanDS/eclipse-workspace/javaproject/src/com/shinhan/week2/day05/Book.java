package com.shinhan.week2.day05;

public class Book {
	//1.field
		//class변수
	static int bookCount;
		//instance변수
	String title;
	int price;
		//final(최종)변수 : 1회만 값을 할당하고 수정 불가능
		//1)선언시 초기화, 2)생성자로 초기화, 3){instance block}으로 초기화
	final String publish = "한빛미디어"; //선언시 초기화
	final String publish2;
	final String publish3;
	
		//상수(불변), 대문자로 선언한다
		//1)선언시 초기화, 2)static block으로 초기화
	static final String ISBN = "1234-5678";
	static final String ISBN2;
	static {
		ISBN2 = "8888-9999";
	}
	//2.constructor
	Book(){
		System.out.println("default 생성자를 정의함");
		this.publish2 = "default 생성자에서 초기화";
	}
	Book(String pub){ //생성자로 초기화
		this.publish2 = pub;
	}
	
	{//instance block으로 초기화
		publish3 = "한빛미디어3";
	}
	//3.method
	void test1() {
		//publish = "한빛미디어2"; 수정 불가능
	}
	
	//4.block
	//5.inner class
}
