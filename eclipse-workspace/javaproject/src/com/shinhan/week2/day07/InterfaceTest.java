package com.shinhan.day07;

interface AInterface {
	void method1();
}

interface BInterface extends AInterface {
	void method2();
}
class Myclass implements BInterface {

	@Override
	public void method1() {
	}

	@Override
	public void method2() {
	}
	
}

public class InterfaceTest {

}
