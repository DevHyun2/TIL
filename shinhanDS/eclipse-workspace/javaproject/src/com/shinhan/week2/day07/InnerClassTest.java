package com.shinhan.week2.day07;

class OuterClass {// 외부 class
	int a = 100; // 1.instance변수
	int score = 99;

	static int b = 200;// 2.class변수

	void method1() {
	}// 3.instance method

	static void method2() {
	}// 4.static method

	class InnerClass {// instance inner class

		int a2 = 100; // 1.instance변수
		String score = "A학점";

		static int b2 = 200;// 2.class변수

		void method3() {// 3.instance method
			System.out.println("inner class의 method3: " + (a + b + a2 + b2));
			System.out.println("inner class의 field: " + score); // inner
			System.out.println("outer class의 field: " + OuterClass.this.score); // outer 호출
		}

		static void method4() {// 4.static method
			System.out.println("inner class의 static method3: " + (b + b2)); // static이 아니면 쓸 수 없음...instance변수 사용불가
		}
	}

	static class InnerClass2 { // instance inner class

		int a2 = 100; // 1.instance변수
		String score = "A학점";

		static int b2 = 200;// 2.class변수

		void method3() {// 3.instance method
			System.out.println("inner class의 method3: " + (b + a2 + b2));
			System.out.println("inner class의 field: " + score); // inner
//			System.out.println("outer class의 field: " + OuterClass.this.score); // outer 호출 오류로 사용 불가
		}

		static void method4() {// 4.static method
			System.out.println("inner class의 static method3: " + (b + b2)); // static이 아니면 쓸 수 없음...instance변수 사용불가
		}

	}

	void call() {
		// 지역변수 : 내부 class에서 접근하면 무조건 변경불가(final) but, 내부에서 사용 안하면 값 바꿀 수 있음.
		int price = 1000;
		// method 내에있는 class, method내에서만 접근이 가능
		class LocalClass {
			// 1.field
			int price2 = 2000;
			static int price3 = 3000;

			// 2.method
			void show() {
				System.out.println("LocalClass instance method");
				//price=9999;
				System.out.println("지역변수를 local class에서 사용 price= " + price);
			}

			static void show2() {
				System.out.println("LocalClass class method");
			}
		}
		//price = 8888;
		System.out.println(price);
		
		//static
		System.out.println(LocalClass.price3);
		LocalClass.show2();
		//instance
		LocalClass local = new LocalClass();
		System.out.println(local.price2);
		local.show();
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.call();
		
	}

	public static void f2(String[] args) {

		System.out.println(OuterClass.InnerClass2.b2);
		OuterClass.InnerClass2.method4();

		OuterClass.InnerClass2 inner = new OuterClass.InnerClass2();
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();
	}

	public static void f1(String[] args) {
		// instance
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();

		System.out.println(OuterClass.InnerClass.b2); // static 사용방법
		OuterClass.InnerClass.method4(); // static 사용방법

		// instance 사용방법
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();
	}

}
