package com.shinhan.week2.day06.lab;

class Tire {
	public void run() { 
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}

class SnowTire extends Tire {

	@Override
	public void run() {
		System.out.println("스노우 타이어가 굴러갑니다");
	} 
	
}


public class SnowTireExample {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = new Tire();
		
		snowTire.run();
		tire.run();
	
	}

}
