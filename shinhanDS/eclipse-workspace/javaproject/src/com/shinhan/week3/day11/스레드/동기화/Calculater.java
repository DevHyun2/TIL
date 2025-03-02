package com.shinhan.week3.day11.스레드.동기화;

public class Calculater {
	private int memory;

	public int getMemory() {
		return memory;
	}
	
	//동기화 메서드 이용
	public synchronized void setMemory(int memory) {

		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}

	// 동기화 블럭 사용
	public void setMemory2(int memory) {

		synchronized (this) {

			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + this.memory);
		}

	}

	// 동기화처리 안함
	public void setMemory1(int memory) {

		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}

}
