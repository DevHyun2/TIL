package com.shinhan.week1.day04;

public class ParameterTest {

	public static void main(String[] args) {
		ParameterTest aa = new ParameterTest();
		aa.sum(10,20);
		sum(10,20,30);
		sum(10,20,30,40);
		sum(10,20,30,40,50);
		sum(1,2,3,4,5,6,7,8,9,10);
		int[] values = {1,2,3,4,5,6,7,8,9,10};
		sum(values);
		sum(new int[]{1,2,3,4,5,6,7,8,9,10});
		sum("자바","프로그램");
		sum(3.14, 10.5, 20.5);

	}
	//자동 형변환, 정수3 -> 실수3
	private static void sum(double d, double e, double f) {
		System.out.println("실수3:" + (d + e + f));
		
	}

	private static void sum(String s1, String s2) {
		System.out.println("문자2:" + s1 + s2);
		
	}

	//메서드Overloading : 메서드 이름은 같고 매개변수 사양이 다르다(타입, 개수)
	private static void sum(int...datas) {
		int total = 0;
		for(int data : datas) {
			total += data;
		}
		System.out.println("가변길이 매개변수:" + total);
	}
/* 자동 형변환 실수3으로
	private static void sum(int i, int j, int k) {
		System.out.println("정수합3:" + (i+j+k));
	*/	
	}

	//멤버메서드(non-static) : 객체생성 후 호출 가능하다.
	//객체생성 없을 때 static은 static에서만 호출 가능
	 void sum(int i, int j) {
		System.out.println("정수합2:" + (i+j));
		
	}
	 void print() {
		 sum(1,2);
	 }
}
