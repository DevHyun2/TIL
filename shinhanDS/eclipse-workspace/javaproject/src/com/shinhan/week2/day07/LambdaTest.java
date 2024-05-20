package com.shinhan.week2.day07;

public class LambdaTest {

	public static void main(String[] args) {
		
		//1.익명
		int result = (new Calculator() {
			
			@Override
			public int sum(int a, int b) {
				System.out.println("익명구현 class");
				return a+b+100;
			}
		}).sum(1, 2);
		System.out.println(result);
		
		
		//2.람다표현식
		Calculator cal = (a, b)-> {
			System.out.println("람다표현식");
			return a+b+200;
			};
		result = cal.sum(10, 20);
		System.out.println(result);
	}

}
