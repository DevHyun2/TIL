package com.shinhan.day10.thread;



public class PrintThread implements Runnable{

	ShareArea shareArea;
	
	PrintThread(ShareArea shareArea){
		this.shareArea = shareArea;
	}
	@Override
	public void run() {
		for(int i=1;i<=3;i++) {
			
//			synchronized (shareArea) {
//				int lee = shareArea.lee.balance;
//				int sung = shareArea.sung.balance;
//				System.out.println("잔고합:" + (lee+sung));
//			}
			
			shareArea.print();
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
