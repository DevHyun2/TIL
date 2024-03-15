package com.shinhan.day02;

//자바 프로그램은 class들로 이루어짐
//하나의 .java파일에 여러개의 class가 가능
//public class이면 반드시 독립적 파일로 저장한다. - 하나의 .java 안에는 하나의 public만 존재
public class Review {

	// 사용가능한 것
	// 1.멤버변수
	// 2.생성자
	// 3.메서드
	// 4.block
	// 5.inner class
	public static void main(String[] args) { //main메서드
		System.out.println("1.main시작");
		
		f1();
		f2();
		
		System.out.println("4.main끝");
	}

	private static void f2(Object println) {
		//method내에 있는 변수는 지역변수
		//변수 scope : { }내에서만 유효하다.
		{
			int score = 100;
			System.out.println(score);
		}
//		System.out.println(score); 블럭 밖이라 유효하지 않음
		
		int v1 = 1;
		System.out.println("v1: " + v1);
		if (true) {
			int v2 = 2;
			if (true) {
				int v3 = 2;
				System.out.println("v1: " + v1); //ctrl + shift + f : 줄(들여쓰기) 맞춤
				System.out.println("v2: " + v2);
				System.out.println("v3: " + v3);
			}
			System.out.println("v1: " + v1);
			System.out.println("v2: " + v2);
//			System.out.println("v3: " + v3); 
		}
		System.out.println("v1: " + v1);
//		System.out.println("v2: " + v2);

	}

	// 호출하려면 static 필요 -> main메서드에 static 존재하기 때문
	private static void f1() { // 함수는 return필요, void = return없애줌
		System.out.println("2.f1함수 시작");
		// 변수 : 하나의 값을 저장하기 위한 기억장소 이름(휘발성)
		// 1.변수선언 : data의 성격에 따라 기본형과 참조형
		// 기본형(8가지) : byte(1), short(2), char(2)음수x, int(4), long(4),
		// float(4), double(8), boolean(1)-true, false자바의 예약어는 소문자
		// 기본형 : 값 저장, 연산, 비교만 가능, 기능은 없음
		// Wrapper class -> 기본형 + 기능 추가 (기본형에서 대문자로 시작)
		// Byte, Short, Character, Integer, Long, Float, Double, Boolean
		int var1; // var1변수는 int를 저장하고자 한다. - 선언
		Integer var2 = 100;
		// 2.변수초기화
		var1 = Integer.MAX_VALUE; // =은 할당 연산자
		// 3.변수사용 - 반드시 초기화 후 사용
		System.out.println(var1);
		System.out.println(var2.floatValue());
		System.out.println("3.f1함수 끝");

	}

}

class Review2 {

}