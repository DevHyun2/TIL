package com.shinhan.week1.day04;

public class CarTest {

	public static void main(String[] args) {
		method1();

	}

	private static void method1() {
		Car c1 = new Car("ABC모델","black", 300);
		String result = c1.carInfoPrint("***");
		
		System.out.println(result);
		
		c1.powerOn();
	}

}