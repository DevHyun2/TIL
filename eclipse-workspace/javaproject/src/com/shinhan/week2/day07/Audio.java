package com.shinhan.day07.C8_1_Interface1;

import com.shinhan.day07.C8_1_Interface1.RemoteController;

public class Audio implements RemoteController {

	int a = 100;
	static int b = 200;
	
	public Audio() {
		System.out.println("default 생성자");
	}
	
	void show() {
		System.out.println("Audio의 show 메서드");
	}

	@Override
	public void method1() {
		System.out.println("Audio method1");
	}

	@Override
	public void method2() {
		System.out.println("Audio method2");
	}

	@Override
	public void turnOn() {
		System.out.println("Audio turnOn");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio turnOff");
	}

}
