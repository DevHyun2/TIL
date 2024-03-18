package com.shinhan.day05;

public class SingleToneTest {

	public static void main(String[] args) {
		SingleToneClass a = SingleToneClass.getInstance();
		SingleToneClass b = SingleToneClass.getInstance();

		System.out.println(a==b);
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
	}

}
