package com.shinhan.week3.day10.멀티스레드;

public class MultiThreadTest2 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "시작");
		
		Thread t1 = new UpperCaseThread2();
		Thread t2 = new Thread(new UpperCaseThread());
		Thread t3 = new UpperCaseThread2();
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(Thread.currentThread().getName() + "끝");

	}

}
