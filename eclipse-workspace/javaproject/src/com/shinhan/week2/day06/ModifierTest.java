package com.shinhan.week2.day06;

import com.shinhan.week2.day05.Computer;

public class ModifierTest extends Computer{

	void print() {
		System.out.println(price);
	}
	
	public static void main(String[] args) {
		method1();

	}

	private static void method1() {
		Computer com1;
		com1 = new Computer();
		com1.setModel("AA");
		//com1.price = 200;
	}
}
