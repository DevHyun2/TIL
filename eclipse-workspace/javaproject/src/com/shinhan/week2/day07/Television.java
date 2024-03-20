package com.shinhan.day07.C8_1_Interface1;

import com.shinhan.day07.C8_1_Interface1.RemoteController;

// interface를 구현한 구현 class
// 추상 메서드를 구현할 의무가 있다.

public class Television implements RemoteController {

	@Override
	public void method1() {
		System.out.println(getClass().getSimpleName() + " method1");
	}

	@Override
	public void method2() {
		System.out.println(getClass().getSimpleName() + " method2");
	}

	@Override
	public void turnOn() {
		System.out.println(getClass().getSimpleName() + " turnOn");
	}

	@Override
	public void turnOff() {
		System.out.println(getClass().getSimpleName() + " turnOff");
	}

	// defualt 메서드는 재정의가 가능하다.
	@Override
	public void method3() {
		RemoteController.super.method3();
		System.out.println("default 메서드 재정의함");
	}

	void method4() {
		RemoteController.method4();
		System.out.println("매서드 추가 method4");
	}

}
