package com.shinhan.week3.day11.스레드.동기화;

public class User2Thread extends Thread{
	
	private Calculater calculator;
	
	public User2Thread() {
		setName("User2Thread");
	}

	public void setCalculator(Calculater calculator) {
		this.calculator = calculator;
		
	}

	@Override
	public void run() {
		calculator.setMemory(50);
	}
	
	
}
