package com.shinhan.week2.day07;

//추상 method가 반드시 한개만 가능

//case1 - return 없음
@FunctionalInterface // lambda 표현식 가능한지 check
interface Calculable {
	void calculate(int x, int y);
}

//case2 - return 있음
@FunctionalInterface
interface Calculable2 {
	int calculate(int x, int y);
}

public class LambdaTest2 {

	public static void main(String[] args) {
		f2();
	}

	private static void f2() {
		call2(new Calculable2() {

			@Override
			public int calculate(int x, int y) {
				return x + y;
			}
		});

		call2((x, y) -> x - y);
		call2((x, y) -> {
			System.out.println("============");
			return x - y;
		});

		call2((left, right) -> left > right ? left : right);
		call2((left, right) -> Math.max(left, right));

		// static method를 사용하는 경우
		call2(Math::max);
		
		// instance method를 사용하는 경우
		Integer a = 100;
		
	}

	private static void call2(Calculable2 cal) {
		int result = cal.calculate(10, 6);
		System.out.println(result);
	}

	private static void f1() {
		call(new Calculable() {

			@Override
			public void calculate(int x, int y) {
				System.out.println("익명 구현 class - x + y =" + (x + y));
			}

		});

		call((x, y) -> System.out.println("lambda fuction - x + y =" + (x + y)));
		call((a, b) -> {
			System.out.println("----------------------");
			System.out.println("lambda fuction - a + b =" + (a + b));
		});
	}

	private static void call(Calculable cal) {
		cal.calculate(1, 2);
	}
}