package com.shinhan.week1.day01;

public class 기본형변수타입 {
	
	public static void main(String[] args) {
		String str = "이것이 \n \"자바\" '자바' 다";
		System.out.println(str);
		
		String str2 = "aaaaaaaaaaa "
				+ "bbbbbbbbbbb "
				+ "ccccccccccc";
		System.out.println(str2);
		
		//17버전 이상에서 사용 가능
		String str3 = """
				json타입의 값 저장할 때 유용하다.
				{
				 "키1" : "값",
				 "키2" : "값",
				 "키3" : "값",
				 "키4" : "값"
				}
				""";
		System.out.println(str3);
	}
	
	public static void f10(String[] args) {
		//데이터 타입(데이터의 성격)
		//1.기본형(8가지) : 값을 저장, 연산, 비교
		//2.객체 참조형 : 기능을 가진다.
		//Wrapper class : 기본형 + 기능
		//byte + 기능 => Byte
		//short + 기능 => Short
		//char + 기능 => Character
		//int + 기능 => Integer
		//long + 기능 => Long
		//float + 기능 => Float
		//double + 기능 => Double
		//boolean + 기능 => Boolean
		Integer score = 65;
		double d = score.doubleValue();
		System.out.println("double바꿈" + d);
		System.out.println(Integer.toBinaryString(score));
	}
	
	public static void f9(String[] args) {
		//문자열을 저장하고자 한다. (String class를 사용한다.)
		//1. 객체 참조 변수 선언
		String str1, str2, str3, str4;
		//2. 객체 생성
		//str1 = new String("자바 언어의 문법 배우기");
		str1 = "자바 언어의 문법 배우기"; // 컴파일타임에 저장된다.
		str2 = "자바 언어의 문법 배우기"; // 이미 저장된 값을 사용한다.
		str3 = new String("자바 언어의 문법 배우기"); // 실행시 생성
		str4 = new String("자바 언어의 문법 배우기"); // 실행시 생성
		System.out.println(System.identityHashCode(str1)); 
		System.out.println(System.identityHashCode(str2)); //str1, str2 주소가 같음
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4)); //str3, str4 주소가 다름
		System.out.println(str1 == str2); // ==은 주소비교, 주소가 같다
		System.out.println(str3 == str4); // ==은 주소비교, 주소가 다르다
		System.out.println(str1.equals(str4)); //.equlas는 내용을 비교
	}
	
	public static void f8(String[] args) {
		boolean var1 = true;
		boolean var2 = false;
		boolean var3 = 20 > 10;
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
	}
	
	public static void f7(String[] args) {
		double var1 = 3.14;
		System.out.println(var1);
		
	}
	
	public static void f6(String[] args) {
		//실수의 기본값은 double이다.
		float var1 = 3.14F;//F, f 상관없음
		System.out.println(var1);
	}
	
	public static void f5(String[] args) {
		//정수의 기본은 int이다.
		//선언 + 할당
		long var1 = 2147483648L; //L, l 상관없음
		//사용
		var1++;
		System.out.println(var1);
	}
	
	
	public static void f4(String[] args) {
		//선언 + 할당
		int var1 = Integer.MAX_VALUE;
		int var2 = 2147483647;
		//사용
		var2++;
		System.out.println("var1=" + var1);
		System.out.println("var2=" + var2);
	}
	
	
	public static void f3(String[] args) {
		//선언 + 할당
		char a = 'A';  // 0 ~ 32767*2
		char b = 65;
		char c = 0x0041;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
	}
	
	
	public static void f2(String[] args) {
		//1.변수선언
		short a;  //-32768 ~ 32767
		
		//2.초기화
		a = 32767;
		a++;
		
		//3.사용
		System.out.println("short타입값:" + a);
	}
	
	
	public static void f1(String[] args) {
		//변수 : 하나의 값을 저장하기 위한 기억장소 이름
		//선언 후 사용한다.
		
		//1.선언
		byte a; //a변수는 byte 값을 담을 수 있다.
		
		//2.할당(초기화)
		a = 127;
		a++; a++; a++; //범위를 벗어난 결과 -126
		
		//지역변수(메서드 내의 변수)는 반드시 초기화 하고 사용한다.
		System.out.println(a);

	}

}
