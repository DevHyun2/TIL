package com.shinhan.week3.day10.멀티스레드.practice;

public class TransferThread extends Thread {

	ShareArea shareArea;
	
	TransferThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	
	public void run() {
		//12번 계좌이체 하기
		for(int i=1; i<=12 ; i++) {
			
		//synchronized block : 공유데이터를 하나의 thread가 점유하고 있을 때 다른 Thread가 접근 불가
		synchronized (shareArea) {
			
		System.out.println("이몽룡 계좌에서 출금");
		int amount = shareArea.lee.withdraw(100);
		
		System.out.println("성춘향 계좌로 입금" + amount);
		shareArea.sung.deposit(amount);
			}
		}
	}

	
}
