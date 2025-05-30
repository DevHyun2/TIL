package com.shinhan.week1.day02;

import java.util.Scanner;

public class OperaterTest {

	public static void main(String[] args) {
		System.out.println("-----------------------");
		method9();
	}

	private static void method9() {
		Scanner sc;
		sc = new Scanner(System.in);
		String message;
		
		System.out.println("1.예금:2.출금:3.잔고:4.종료");
		System.out.println("-----------------------");
		
		System.out.print("선택>");
		int num = sc.nextInt();
		
		switch(num) {
		case 1 : message = "예금액>10000"; break;
		case 2 : message = "출금액>2000"; break;
		case 3 : message = "잔고>8000"; break;
		case 4 : message = "프로그램 종료"; break;
		}
		
		
	}

	private static void method8() {
//		int x = 10;
//		int y = 20;
//		int z = (++x) + (y--);
//		System.out.println(z);
		
//		int a = 5;
//		int b = 10;
//		int c = 7;
//		double x = (double)((a + b)*c/2;
//		System.out.println(x);
		
		int score = 85;
		String result = (!(score>90))? "가":"나";
		System.out.println(result);
	}

	private static void method7() {
		int var1 = 100;
		int var2 = 100;
		
		//비교연산자(>)가 논리연산자(&&)보다 우선순위가 높다
		
		//&&(단축)앞이 거짓이면 뒤를 수행안함
		//&앞의 결과와 무관하게 모두 수행
		
		//||는 앞의 결과가 참이면 뒤를 수행 안함(앞이 참이면 뒤에도 참이라고 판단)
		//|는 앞의 결과와 무관하게 모두 수행
		boolean result = var1 >= var2 && ++var1 > 100;
		boolean result2 = var1 >= var2 || ++var1 > 100;
		
		System.out.println(result);
		System.out.println(var1);
		System.out.println(result2);
		System.out.println(!result2);
	}

	private static void method6() {
		int var1 = 100;
		int var2 = 100;
		String str1 = "자바"; //컴파일 시점에 할당
		String str2 = "자바";
		String str3 = new String("자바"); //기본형은 값을 비교
		String str4 = new String("자바");
		
		//문자열은 값 변경불가, 주소가 달라짐
		str1 = str1 + "프로그램";
		str2 = str2 + "프로그램"; //메모리 낭비로 좋은 코드가 아님
		
		System.out.println(var1 == var2); //비교연산자는 주소, 값은 함수사용 해야 비교가능(equlas(), !equlas())
		System.out.println(str1 == str2); //true 객체는 주소비교
		System.out.println(str3 == str4); //false
		System.out.println(str3.equals(str4)); //값(내용)비교
		System.out.println(str1.equals(str4)); //값(내용)비교
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
	}

	private static void method5() {
		int i = 100;
		int j = 0;
		//정수는 0으로 나누기 불가(Exception발생, 프로그램 중단)
		//프로그램 중단을 막으려면? : 1.값이 0이면 수행안하기 2.Exception처리
		if(j!=0){
			System.out.println(100/j);
		}
		
		System.out.print(j!=0?100/j:""); //삼항연산자
		System.out.println(j==0?"0으로 나눌 수 없음":"나누기가능");
		
//		System.out.println(100/0);
//		System.out.println(100/j);
		System.out.println(100/0.0); //Infinity(무한대)
		System.out.println(100%0.0); //NaN(Not a Number)
		System.out.println("==================="); //앞에서 중단되어 출력되지 않음
	}

	private static void method4() {
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		double result = apple - pieceUnit * number;
		System.out.println(result);
		
	}

	private static void method3() {
		int a = Integer.MAX_VALUE; //2147483647
		int b = Integer.MIN_VALUE; //-247483648
		a++; a++; a++; //오버플로우 -> 값이 최솟값으로 돌아감
		b--; b--; b--; //언더플로우 -> 값이 최댓값으로 돌아감
		System.out.println(a);
		System.out.println(b);
		
	}

	private static void method2() {
		int a = 10;
		int b = 3;
		System.out.println("더하기 = " + (a + b)); //+,- 경우 연산자 우선순위 주의
		System.out.println("빼기 = " + (a - b));
		System.out.println("곱하기 = " + a * b);
		System.out.println("몫 = " + a / b); //몫
		System.out.println("나머지 = " + a % b); //나머지
		
	}

	private static void method1() {
		int var1 = 100;
		System.out.println(++var1); //연산 후 출력
		System.out.println(var1++); //출력 후 연산, 다음 출력에 102
		System.out.println(var1); //출력
	}

}
