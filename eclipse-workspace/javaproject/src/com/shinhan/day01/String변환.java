package com.shinhan.day01;

//JVM이 String변환 class의 main()메서드 호출을 위해 접근 권한이 public이다.

public class String변환 {
	public static void main(String[] args) {
		f4();
	}

	private static void f4() {
		int a = 100;
		{
			int b = 200;
			System.out.println("1." + (a + b));
		}
		if(a >= 100) {
			int b = 300;
			System.out.println("2." + (a + b));
		}
		System.out.println("3." + a);
		//오류 System.out.println(a + b);
		
	}

	private static void f3() {
		int a = 100;
		String s = String.valueOf(a); //문자를 숫자로 바꾸는 방법이 더 좋은 방법
		String s2 = a + ""; //메모리 낭비가 있어서 좋은 방법은 아님
		System.out.println(s);
		System.out.println(s2);
		
	}

	private static void f2() {
		String score = "100";
		
		//String에서 +는 연결을 의미한다. 연산X
		System.out.println(score + 200); //문자가 우선
		System.out.println(1 + 2 + score);
		System.out.println(10 - 2 + score);
	}

	private static void f1() { //private 대신 public이어도 상관없음
		String score = "100";
		
		byte a = Byte.parseByte(score);
		short b = Short.parseShort(score);
		int c = Integer.parseInt(score);
		long d = Long.parseLong(score);
		float e = Float.parseFloat(score);
		double f = Double.parseDouble(score);
		
		System.out.println(a+b+c+d+e+f);
		
	}
}
