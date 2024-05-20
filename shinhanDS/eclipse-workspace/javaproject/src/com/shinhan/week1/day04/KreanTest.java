package com.shinhan.week1.day04;

import java.util.Calendar;
import java.util.Scanner;

public class KreanTest {

	public static void main(String[] args) {
		method1();

	}

	private static void method1() {
		
		//1.객체참조변수선언
		//2.객체생성
		Korean k1 = new Korean("신현상", "12345");
		
		//3.객체사용
//		System.out.println(k1.nation);
//		System.out.println(k1.name);
//		System.out.println(k1.ssn);
		k1.print();
		
		System.out.println(k1);
	}

}
