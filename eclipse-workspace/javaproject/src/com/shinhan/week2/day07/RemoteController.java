package com.shinhan.day07.C8_1_Interface1;

// 두 객체를 연결하는 역할
// 정의는 있고 구현은 없다. (규격서)
// interface를 구현한 class를 만들어 함수를 구현

public interface RemoteController {

	// 1. 함수
	int CHANNEL = 10;
	public static final int CHANEL2 = 10; // public static final 생략 가능

	// 2. 추상메서드
	void method1();

	public abstract void method2(); // public abstract는 생략 가능
	// 일반 메서드는 사용 불가
//	void method() {}

	void turnOn();

	void turnOff();

	// 3. default 메서드 (구현 class가 공통적으로 가지는 기능을 구현, 재정의 가능)
	default void method3() {
		System.out.println("default method - 재정의 가능");
		method5();
	}

	// 4. static 메서드 (interface가 가지는 기능, 구현 class가 재정의 불가능)
	static void method4() {
		System.out.println("static method - 재정의 불가능");
	}

	// 5. private 메서드 (interface 내에서 모듈화 또는 재사용을 위해 사용)
	private void method5() {
		System.out.println("private method - 외부 접근 불가");
	}

}
