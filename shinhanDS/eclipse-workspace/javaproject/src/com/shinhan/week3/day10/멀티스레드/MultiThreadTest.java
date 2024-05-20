package com.shinhan.week3.day10.멀티스레드;

//process : 실행중인 하나의 프로그램
//thread : 하나의 process내의 프로그램의 흐름
//Thread class이용 -> MultiThread프로그램 이용 가능
public class MultiThreadTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " thread시작------");
		
		//1.영문자 대문자 출력
//		for(char i='A' ; i<='Z' ; i++) {
//			System.out.println(Thread.currentThread().getName() + "i= " + i);
//		}
		//구현class로 만들기 (extends Thread)
		//3)Runnable interface를 구현하기 (implements Runnable)
		Thread t1 = new Thread (new UpperCaseThread());
		
		//익명 구현 class로 만들기
		Thread t2 = new Thread() {

			public void run() {
				for(char j='a' ; j<='z' ; j++) {
					System.out.println(Thread.currentThread().getName() + " j= " + j);
				}
			}
			
		};
		
		//4)interface로 익명 구현 class 만들기
		Thread t3 = new Thread(new Runnable() {

			public void run() {
				for(char j='a' ; j<='z' ; j++) {
					System.out.println(Thread.currentThread().getName() + " j= " + j);
				}
			}
			
		});
		//람다표현식
		Thread t4 = new Thread(()->{

				for(char j='a' ; j<='z' ; j++) {
					System.out.println(Thread.currentThread().getName() + " j= " + j);
				}
			
		});
		//시작
				t1.start(); //실행 흐름을 만들고 run()호출
				t2.start();
				//t1.run(); 멀티스레드X
				t3.start();
				t4.start();
		
		//2.영문자 소문자 출력
//		for(char j='a' ; j<='z' ; j++) {
//			System.out.println(Thread.currentThread().getName() + "j= " + j);
//		}
		
		//3.숫자 1~26출력
		for(int k=1 ; k<=26 ; k++) {
			System.out.println(Thread.currentThread().getName() + " k= " + k);
		}
		
		System.out.println(Thread.currentThread().getName() + " thread끝------");
	}
	
		
}
