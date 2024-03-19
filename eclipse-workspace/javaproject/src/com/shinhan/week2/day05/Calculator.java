package com.shinhan.week2.day05;

public class Calculator {
	//static field
	static double pi = 3.141592;
	static String company = "퍼스트존"; //선언 + 초기화
	static String company2; //선언
	
	String color;
	
	//static block
	static {
		System.out.println("class load시에 1회 수행된다.");
		company2 = "상공회의소";//초기화
		//color = "red";
	}
	//static method
	static double plus(int a, int b) {
		Calculator cal = new Calculator();
		cal.color = "red";
		return a+b+pi;
	}		
	double minus(int a, int b) {
		return a-b+pi;	
	}
}