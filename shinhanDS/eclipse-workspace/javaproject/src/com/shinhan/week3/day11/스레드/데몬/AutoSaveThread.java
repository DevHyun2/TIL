package com.shinhan.week3.day11.스레드.데몬;

//데몬(Daemon)
//주Thread를 도와주는 Thread
//주가 끝나면 같이 끝난다.
public class AutoSaveThread extends Thread {

	public void save() {
		System.out.println("작업내용을 저장한다.");
	}
	
	public void run() {
		
		while(true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save();
		}
	}
}
