package com.shinhan.week3.day12.람다식.lab;

public class Example {

	public static void main(String[] args) {
		Thread thread = new Thread();
		for(int i=0 ; i<3 ; i++) {System.out.println("작업 스레드가 실행됩니다.");}
		thread.start();
	}
}

//출력
//작업 스레드가 실행됩니다.
//작업 스레드가 실행됩니다.
//작업 스레드가 실행됩니다.