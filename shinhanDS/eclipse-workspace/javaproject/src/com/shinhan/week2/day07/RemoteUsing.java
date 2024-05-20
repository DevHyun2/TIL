package com.shinhan.day07.C8_1_Interface1;

public class RemoteUsing {

	public static void main(String[] args) {
		f6();
	}

	private static void f6() {
		// String, Integer class는 Comparable interface 구현
		// Comparable interface : 추상 메서드
		// String class가 Comparable interface 구현 - compareTo 재정의
		String s1 = "A";
		String s2 = "C";
		Integer i1 = 100;
		Integer i2 = 105;
		
		int result = s1.compareTo(s2);
		System.out.println(result);
		
		result = i1.compareTo(i2);  // -1, 0, 1
		System.out.println(result);
		
	}

	private static void f5() {
		SmartTelevision a = new SmartTelevision();
		RemoteController b = new SmartTelevision();
		Searchable c = new SmartTelevision();
		Object d = new SmartTelevision();
		
		f4(a);
		f4(b);
		f4(c);
		f4(d);
		
		f4(new Audio());
	}
	
	private static void f4(Object smart) {
//		((SmartTelevision)smart).search("https:// ");
		if (smart instanceof SmartTelevision ss) ss.search("https:// ");
	}

	private static void f3() {
		// TODO Auto-generated method stub
		action(new Television());
		action(new Audio());
	}

	private static void action(RemoteController remote) {
		// 사용할 변수, 메서드는 타입을 따른다.
		// 상수
		System.out.println(remote.CHANNEL);
		
		// abstract
		remote.turnOn();
		remote.turnOff();
		remote.method1();
		remote.method2();
		
		// default
		remote.method3();
		
		// static
		RemoteController.method4();
		
	}

	private static void f2() {
		Audio audio = new Audio();
		audio.method1();
		audio.method2();
		audio.method3(); // RemoteController의 method3 실행됨.
		audio.turnOn();
		audio.turnOff();
		RemoteController.method4();
	}

	private static void f1() {
//		RemoteController a = new RemoteController();  // interface는 생성할수 없음

		Television t1 = new Television();
		t1.method1(); // 추상 구현
		t1.method2(); // 추상 구현
		t1.method3(); // default 재정
		t1.method4(); // class에서 추가한 메서드

		RemoteController.method4();
		System.out.println(RemoteController.CHANEL2);

	}
}
