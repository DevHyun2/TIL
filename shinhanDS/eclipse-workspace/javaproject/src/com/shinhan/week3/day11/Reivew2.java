package com.shinhan.week3.day11;

//Process : 실행중인 하나의 프로그램
//Thread : 하나의 프로그램에서 하나의 흐름
//Multi Thread : 실행중인 하나의 프로그램의 흐름이 여러개

//1)Thread class 상속
//2)Runnable interface 구현

class MyThread2 extends Object implements Runnable{
	
	String name;
	
	MyThread2(String name){
		this.name = name;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":" + name);
	}
	
}



class MyThread1 extends Thread {
	
	//String name;
	
	MyThread1(String name){
		//this.name = name;
		super(name);
	}
	
	public void run() {
		System.out.println(currentThread().getName());
	}
	
}

public class Reivew2 {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		MyThread1 t1 = new MyThread1("신한1");
		Thread t2 = new MyThread1("신한2");
		//익명
		Thread t3 = new Thread("신한3") {
		
			public void run() {
				System.out.println(currentThread().getName());
			}
			
		};
		
		MyThread2 myrunnable = new MyThread2("신한4"); //Thread가 아님, runnable구현 class
		Thread t4 = new Thread(myrunnable);
		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable의 익명 구현 class");
				
			}
		});
		//람다
		Thread t6 = new Thread(()-> {
				System.out.println("Runnable의 익명 구현 class");
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		System.out.println(Thread.currentThread().getName() + "Thread END");
	}
	
}
