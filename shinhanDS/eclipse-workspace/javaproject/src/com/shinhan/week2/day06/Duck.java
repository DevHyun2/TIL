package com.shinhan.week2.day06;

public class Duck {
	private String name;
	private int legs;
	private int length;

	Duck(String name, int legs, int length) {
		this.name = name;
		this.legs = legs;
		this.length = length;
	}

	public void fly() {
		System.out.println(getClass().getSimpleName() +  "(" + name + ")는 날지 않습니다.");
	}

	public void sing() {
		System.out.println(getClass().getSimpleName() +  "(" + name + ")가 소리 내어 웁니다.");
	}

	public void setName(String name) {
		this.name = name;
	}
	//재정의 조건 : 함수이름, 매개변수, returnType이 같아야 한다.
	//			Modifier는 같거나 더 넓어져야 한다.
	@Override
	public String toString() {
		return getClass().getSimpleName() + "의 이름은 " + name + " 입니다. 다리는 " + legs + "개이고 길이는 " + length + "입니다.";
	}
}

//--------------------------------------------------------------------------------------------------
class Sparrow {
	private String name;
	private int legs;
	private int length;

	Sparrow(int legs, int length) {
		this.legs = legs;
		this.length = length;
	}

	void fly() {
		System.out.println(getClass().getSimpleName() +  "(" + name + ")가 날아다닙니다.");
	}

	void sing() {
		System.out.println(getClass().getSimpleName() +  "(" + name + ")가 소리 내어 웁니다.");
	}

	void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() +  "의 이름은 " + name + " 입니다. 다리는 " + legs + "개이고 길이는 " + length + "입니다.";
	}
}
