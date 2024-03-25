package com.shinhan.week3.day10.멀티스레드.practice;

public class MultiThreadTest5 {
	
	public static void main(String[] args) {
		ShareArea shareArea = new ShareArea(
				new Account("112","이몽룡",2000),
				new Account("113","성춘향",1000)
				);
		Thread t1 =new TransferThread(shareArea);
		Thread t2 =new Thread(new TransferThread(shareArea));
		
		t1.start();
		t2.start();
	}

}
