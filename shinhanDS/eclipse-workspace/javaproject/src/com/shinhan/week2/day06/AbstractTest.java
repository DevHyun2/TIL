package com.shinhan.week2.day06;

abstract class Animal{
	abstract void sound();
	void sound2() {
		System.out.println("일반메서드도 가능");
	}
}

class Cat extends Animal{

	@Override
	void sound() {
		System.out.println("야옹");
		
	}
	
}

class Dog extends Animal{

	@Override
	void sound() {
		System.out.println("멍멍");
		
	}
	
}

public class AbstractTest {

	public static void main(String[] args) {
		
		call(new Cat());
		call(new Dog());
	
	}

	private static void call(Animal ani) {
		
		//field나 method는 타입을 따른다.
		ani.sound();
		
	}

}
