package com.shinhan.week2.day07;

public class LambdaTest3 {

	public static void main(String[] args) {
		Person person = new Person(10, 20);
		person.action(new ComputreInterface() {
			
			@Override
			public double calc(double x, double y) {
				System.out.println("----1.익명구현class(-)");
				return x-y;
			}
		});
		person.action((a, b)->{
			System.out.println("2.람다표현식 구현");
			return a+b;
			});
		//이미 만들어진 메서드가 static인 경우 사용하기
		person.action(Computer::staticMethod);
		//이미 만들어진 instance메서드를 사용하기
		Computer com = new Computer();
		person.action(com::instanceMethod);
	}

}
