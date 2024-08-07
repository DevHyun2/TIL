package com.shinhan.week3.day11.스레드;

public class ThreadTest {

	public static void main(String[] args) {
		f2();

	}

	private static void f2() {
		PrintThread t1 = new PrintThread();
		t1.start();
//		t1.stop(); //비정상 종료, 자원 정리할 시간을 주지 않음
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//t1.setStop(true);
		t1.interrupt();//강제 인터럽트 리소스정리 함
		
	}

	private static void f1() {
		WorkThread t1 = new WorkThread("WorkThread1");
		WorkThread t2 = new WorkThread("WorkThread2");
		
		t1.start();t2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.work = false;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.work = true;
	}

}
