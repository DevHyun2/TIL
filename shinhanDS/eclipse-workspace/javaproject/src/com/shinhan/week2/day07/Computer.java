package com.shinhan.week2.day07;

public class Computer {
	
	public static double staticMethod(double x, double y) {
		System.out.println("=======static method========");
		return x+y;
	}
	public double instanceMethod(double x, double y) {
		System.out.println("=======instance method========");
		return x*y;
			
	}
}
