package com.shinhan.week3.day10.제네릭.lab;

import java.awt.Container;

public class Container<T> {
	T data;

	void set(T data) {
		this.data = data;
	}

	T get() {
		return data;
	}
}

public class ContainerExample {

	public static void main(String[] args) {
		
		Container<String, String> container1 = new Container<String, String>();
		container1.set("홍길동", "도적");
		String name1 = container1.getKey();
		String job = container1.getValue();
		
		Container<String, Integer> container2 = new Container<String, Integer>();
		container2.set("홍길동", 35);
		String name2 = container2.getKey();
		int age = container2.getValue();
	}

	public static void f1(String[] args) {
		
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
	}
}
