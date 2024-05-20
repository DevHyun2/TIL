package com.shinhan.week1.day01;

//1. 하나의 .java 파일에 여러개의 class가 올 수 있다.
public class 변수범위 {
	//1) 멤버변수 : 자동초기화된다.
	//static메서드에서 non-static변수를 사용불가(메모리에 올라오지 않음)
	static String model; //기본형이 아니면 무조건 null 정의된 값이 없음을 의미
	static int price; //정수는 0으로 초기화 된다.
	
	public static void main(String[] args) {
		f2();
		System.out.println(model);
		System.out.println(price);

	}

	private static void f2() {
		//1.변수선언
		int a; // a는 int를 담을 수 있다.
		Car c1, c2; // c1은 Car를 담을 수 있다.
		
		//2.객체생성, 값을 할당
		a = 100; // 기본형은 100을 a에 저장한다.
		c1 = new Car(); // Car를 만든다.
		c2 = new Car();
		c2.model = "ABC";
		c2.price = 2000;
		
		//3.객체사용
		System.out.println(a);
		System.out.println(c1.model);
		System.out.println(c1.price);
		System.out.println(c2.model);
		System.out.println(c2.price);
		
		c1.drive();
		c2.drive();
	}

	private static void f1() {
		//함수 내의 변수는 지역변수이다(stack에 저장됨). 반드시 초기화 후 사용한다.
		int a = 100;
		System.out.println("a = " + a);
		System.out.println("멤버변수접근 model = " + model);
		System.out.println("멤버변수접근 price = " + price);
		
	}
}
//class : 변수(data 저장) + 메서드(기능)
//class : object를 만들기 위한 template(틀)
class Car {
	String model;
	int price;
	
	void drive( ) {
		System.out.println(model + " : " + price);
	}
}