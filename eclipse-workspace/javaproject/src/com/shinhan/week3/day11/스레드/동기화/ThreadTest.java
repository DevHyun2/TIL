package com.shinhan.week3.day11.스레드.동기화;

public class ThreadTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		//공유데이터 - 여러 스레드가 공유하는 데이터
		Calculater calculater = new Calculater();
		
		User1Thread t1 = new User1Thread();
		t1.setCalculator(calculater);
		
		User2Thread t2 = new User2Thread();
		t2.setCalculator(calculater);
		
		t1.start(); t2.start(); //스레드 시작 -> 실행대기상태 -> 차례가 되면 수행(우선순위 동일)
	}
		

}
