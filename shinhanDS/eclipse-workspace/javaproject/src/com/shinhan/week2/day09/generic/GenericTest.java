package com.shinhan.week2.day09.generic;

import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		//ArrayList는 동적배열 갯수를 정하지 않아도 됨
		//List특징 : 순서가 있음, 중복 가능
		ArrayList<String> alist = new ArrayList<>();
		alist.add("월");
		alist.add("화");
		alist.add("수");
		alist.add("목");
		alist.add("목");
		for(String str : alist) {
			System.out.println(str);
		}
		/*
		ArrayList alist = new ArrayList<>();
		alist.add("월");
		alist.add("화");
		alist.add("수");
		alist.add("목");
		alist.add("목");
		for(Object str : alist) {
			System.out.println((String)str);
		}*/
	}

	private static void f1() {
		//객체만 가능(기본형은 래퍼클래스로)
		Box<String, Integer> box1 = new Box</*생략가능*/>("컴퓨터1", 100);
		
		System.out.println(box1);
		
		Box<Integer, String> box2 = new Box<>(123,"Large");
		
		System.out.println(box2);
		
	}

}
