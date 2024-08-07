package com.shinhan.week2.day06;

class A{ 
	int score = 100;
	void print() {}
	}

class B extends A{ 
	int score2 = 99;
	void print2() {}
	}

class C extends A{
	
}

class D extends B{}

class E extends C{}



public class InheritenceTest5 {

	public static void main(String[] args) {
		method2();
	}

	private static void method1() {
		Object obj = new A();
		A a = new A();
		
		Object b1 = new B();
		B b2 = new B();
		A b3 = new B();
		
		Object d1 = new D();
		D d2 = new D();
		B d3 = new D();
		A d4 = new D();
	}
	
	private static void method2() {
		//A타입이므로 변수의 타입을 따른다. A class를 통해만 보인다.
		A var1 = new B();
		System.out.println(var1.score);
		//System.out.println(var1.score2);
		var1.print();
		//var1.print2();
		
		//형변환
		B var2 = (B)var1;
		System.out.println(var2.score2);
		var2.print2();
		
		//형변환
		if(var1 instanceof B var2) {
			//C var2 = (C)var1;
			System.out.println(var2.score2);
			var2.print2();
		}
	}
	
}
