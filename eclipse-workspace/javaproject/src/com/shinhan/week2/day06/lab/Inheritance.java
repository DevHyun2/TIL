package com.shinhan.week2.day06.lab;

class C extends B{
	int meth() {
		return 100;
	}

	static int sMeth() {
		return 100;
	}
}

class B extends A {
	int meth() {
		return 10;
	}

	static int sMeth() {
		return 10;
	}
}

class A {
	int meth() {
		return 1;
	}

	static int sMeth() {
		return 1;
	}
}

public class Inheritance {
	//객체생성은 C, 자식생성시 부모도 생성된다. 부모는 자식을 담을 수 없다.
	
	//부모 객체는 본래만들어진 instance에 타입으로만 강제 타입 변환된다.
	
	public static void main(String[] args) {
		C c = new C();
		B b = (B) c;
		A a = (A) c;

		if (a instanceof A) {
			System.out.println("a는 A의 인스턴스 이다.");
		}
		if (a instanceof B) {
			System.out.println("a는 B의 인스턴스 이다.");
		}
		if (a instanceof C) {
			System.out.println("a는 C의 인스턴스 이다.");
		}

		System.out.println(a.meth() + " " + b.meth() + " " + c.meth() + " " + a.sMeth() + " " + b.sMeth() + " " + c.sMeth());
	}
}
/*
<< 출력 결과 >>
a는 A의 인스턴스 이다.
a는 B의 인스턴스 이다.
a는 C의 인스턴스 이다.
100  100   100  1  10   100 
*/

