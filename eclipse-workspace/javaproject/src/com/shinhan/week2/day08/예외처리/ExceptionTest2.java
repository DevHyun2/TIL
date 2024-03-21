package com.shinhan.week2.day08.예외처리;

public class ExceptionTest2 {

	public static void main(String[] args) {
		method2(60);
		
	}
	
	
	
	//사용자가 예외 처리
	private static void method2(int score) {
		try {
		if(score<=70) throw new ScoreException("70초과만 가능");
		double avg = score/3;
		}catch(ScoreException e) {
			System.out.println(e.getMessage());
		}
	}




	public static void f(String[] args) {
		method1(70);

	}

	private static void method1(int score) {
		
		//thorws = 던진다 , throw new = 발생시킨다 or 일으킨다
		//조건에 맞지 않으면 강제로 에외를 발생하고자 한다.(raise)
//		if(score <= 70) throw new RuntimeException();
		try {
		if(score <= 70) throw new Exception();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("------------------------");
	}

}
