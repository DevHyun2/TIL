package com.shinhan.week1.day01;

public class PrintfExample {
	public static void main(String[] args) {
		f4();
		
	}


	private static void f4() {
		int a = 100;
		String b = "자바";
		System.out.printf("a = %d\n",a);
		System.out.printf("b = %s ",b);
		
	}

	private static void f3() {
		System.out.println("One");
		System.out.println("Two");
		System.out.println("Three");
		
	}

	private static void f2() {
		System.out.println("One\t");
		System.out.println("Two\t");
		System.out.println("Three\t");
		
	
	}
	private static void f1() {
		int value = 123;
		System.out.printf("상품의 가격:%d원\n", value);
		System.out.printf("상품의 가격:%6d원\n", value);
		System.out.printf("상품의 가격:%-6d원\n", value);//-: 왼쪽정렬
		System.out.printf("상품의 가격:%06d원\n", value);

		double area = 3.14159 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n", 10, area);
		System.out.printf("반지름이 %d인 원의 넓이:%-10.2f\n", 10, area); //-: 왼쪽정렬

		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
	}
	
}	