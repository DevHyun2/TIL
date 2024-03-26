package com.shinhan.week3.day11.스레드;

public class WorkThread extends Thread {
	
	boolean work = true;
	
	WorkThread(String name){
		//setName(name);
		super(name);
		
	}

	@Override
	public void run() {
		while(true) {
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(work) {
				System.out.println(getName() + " : 작업처리");
			}else {
				Thread.yield();
			}
		}
	}
	
	
}
