package com.shinhan.week2.day09.boxing;

public class ObjectTest3 {

	public static void main(String[] args) {
		f2();
	}

	//Parse
	private static void f2() {
		String s = "100";
		String s2 = "100.456";
		
		int b = Integer.parseInt(s);
		double d = Double.parseDouble(s2);
	}

	//Boxing
	private static void f1() {
		Integer a = 100; //Auto Boxing
		//Integer a = new Interger(100); //deprecated
		
		//int b = a.intValue() + 200; //UnBoxing
		int b = a + 200;
	}

}
