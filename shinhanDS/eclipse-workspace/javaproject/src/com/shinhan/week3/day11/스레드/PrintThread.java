package com.shinhan.week3.day11.스레드;

//1. 조건문 이용하여 안전하게 스레드 종료 
public class PrintThread extends Thread {

	private boolean stop; //default = false
	
	void setStop(boolean stop) {
		this.stop = stop;
	}
	
	//2.interrupt()메서드로 Exception발생시켜서 안전하게 스레드 종료
	public void run() {
		
		try {
		while(true) {
			System.out.println("실행 중....");
			sleep(1);
			}
		}catch(InterruptedException e){
			//e.printStackTrace();
		}
		System.out.println("리소스 정리----");
		System.out.println("정상적으로 스레드 종료");
	}
	
	public void run2() {
		while(!stop) {
			System.out.println("실행 중....");
		}
		System.out.println("리소스 정리----");
		System.out.println("정상적으로 스레드 종료");
	}
}
