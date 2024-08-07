package com.shinhan.week2.day09.objecttest;

import java.util.HashSet;

public class ObjectTset {

	public static void main(String[] args) {
		f3();

	}

	private static void f3() {
		ComputerVO3 com1 = new ComputerVO3("A", 100, "Samsung");
		ComputerVO3 com2 = new ComputerVO3("A", 100, "Samsung");
		ComputerVO com3 = new ComputerVO(null, 100, "Samsung");
		
		
		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
		
		//System.out.println(com1.getModel());
		System.out.println(com3.getModel());
	}

	private static void f2() {
		ComputerVO2 com1 = new ComputerVO2("A", 100, "Samsung");
		ComputerVO2 com2 = new ComputerVO2("A", 100, "Samsung");
		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
		
	}

	private static void f1() {
		ComputerVO com1 = new ComputerVO("A", 100, "Samsung");
		ComputerVO com2 = new ComputerVO("A", 100, "Samsung");
		
		System.out.println(com1); //toString() 호출, *재정의 가능
		System.out.println(com2);
		
		System.out.println(com1 == com2); //주소를 비교, C++ = 재정의 가능, java는 불가
		System.out.println(com1.equals(com2)); //equals:주소비교, *재정의 가능
		
		//동일객체비교(hashcode, equals() 재정의)
		//Set : 순서없고 중복불가
		HashSet<ComputerVO> computers = new HashSet<>();
		computers.add(com1);
		computers.add(com2);
		computers.add(new ComputerVO("A", 200, "Samsung"));
		System.out.println(computers.size());
		
		
	}

}
