package com.shinhan.week2.day05;

//외부(다른 패키지)에 있는 class를 이용하는 경우 반드시 import하고 사용한다.
//java.lang 아래에 있는 class는 import없이 사용 가능
//그 외는 반드시 import하고 사용

public class BookFinalTest {

	public static void main(String[] args) {
		method3();

	}

	private static void method3() {
		int a = Integer.MAX_VALUE;
		
		System.out.println(a);
		
		int b = Integer.compare(10, 3);//앞이 크다 1, 둘이 같다 0, 앞이 작다 -1
		System.err.println(b);
		
		int c = Integer.max(10, 20); //큰 값을 출력
		System.out.println(c);
		
		int score1 = 10, score2 = 20;
		System.out.println(score1>score2? score1:score2);
	}

	private static void method2() {
		//Book.ISBN2 = "8888"; //상수 수정불가
		System.out.println(Book.ISBN);
		System.out.println(Book.ISBN2);
		
		Book b1 = new Book();
		//올바른 사용이 아니다
		System.out.println(b1.ISBN);
		System.out.println(b1.ISBN2);
	}

	private static void method1() {
		System.out.println(Book.bookCount);
		
		Book b1 = new Book();
		System.out.println(b1.title);
		System.out.println(b1.price);
		System.out.println(b1.publish);
		System.out.println(b1.publish2);
		System.out.println(b1.publish3);
	}

}
