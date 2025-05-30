package com.shinhan.week3.day11;

import com.shinhan.week3.day10.멀티스레드.practice.Account;

//제네릭 : 구체적인 타입은 사용할 때 결정, 컴파일시에 강한 타입체크
		//object사용한다면 강제 형변환 필요

class Box<T>{
	T content;
	
	
	public Box(){
		
	}
	
	public Box(T content) {
		this.content = content;
	}
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [getClass()=").append(getClass()).append(", hashCode()=").append(hashCode())
				.append(", toString()=").append(super.toString()).append("]");
		return builder.toString();
	}
}


class BigBox<T, E> extends Box<T> {
	
}

class AccountChild extends Account{
	
}


public class Review {
	
	

	public static void main(String[] args) {
		f5();
	}

	private static void f5() {
		//배열은 실행시 만들어진다.
		//int[] arr = {1,2,3,4,5};
		String[] arr = {"A","B","C"};
		Object[] arr2;
		arr2 = arr;
		arr2[0] = 10;
		//실행시에 오류가 난다.
		//제네릭 -> 배열 생성불가
		//Box<Account>[] b3 = new Box<Account>[10];
	}

	private static void f4() {
		//Box<Account> box1 = call3(3.14);
		Box<Account> box2 = call3(new AccountChild());
		Box<Account> box3 = call3(new Account("234", "k", 1000));
		
		//System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3);
		
	}
	
	private static <T extends Account> Box<T> call3(T t) {
		return new Box<T>(t);
	}
	
	
	private static void f3() {
		Box<Double> box1 = call2(3.14);
		Box<Integer> box2 = call2(1234);
		Box<Long> box3 = call2(123456789000L);
		
		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3);
		
	}
	
	private static <T extends Number> Box<T> call2(T t) {
		return new Box<T>(t);
	}
	
	private static void f2() {
		Box<String> box1 = call("문자");
		Box<Integer> box2 = call(1234);
		Box<Account> box3 = call(new Account("234", "k", 1000));
		
		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3);
		
	}
	
	private static <T> Box<T> call(T t) {
		return new Box<T>(t);
	}

	private static void f1() {
		Box<String> box1 = new Box<>();
		Box<String> box2 = new Box<String>();
		Box<Integer> box3 = new Box<>();
		Box<Account> box4 = new Box<>();
		
		box1.content = "String";
		box2.content = "String";
		box3.content = 1234;
		Integer a = box3.content;
		Account acc = box4.content;
		
		new Account(null, null, 0).deposit(0);
	}
}
