package com.shinhan.week1.day01;

import java.util.Scanner;

public class 표준입력 {

	public static void main(String[] args) {
		f4();

	}
	private static void f4() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("계속?");
			String work = sc.nextLine();
			if(work.equals("q")) break; //loop빠지기
			
			System.out.print("입력1>>");
			int a =Integer.parseInt(sc.nextLine());
			System.out.print("입력2>>");
			int b = Integer.parseInt(sc.nextLine());
			System.out.printf("결과는 %d\n", a+b);
		}
		System.out.println("=======END=======");
		sc.close();
	}
	private static void f3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력>>");
		String name = sc.nextLine();
		System.out.print("나이을 입력>>");
		int age = Integer.parseInt(sc.nextLine());
		sc.nextLine(); //enter버리기
		System.out.print("자기소개>>");
		String intro = sc.nextLine(); //1라인
		System.out.printf("당신의 이름은 %s \n", name);
		System.out.printf("당신의 나이는 %d \n", age);
		System.out.printf("자기소개.... %s \n", intro);
		sc.close();
		
	}
	
	private static void f2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름과 나이를 입력>>");
		String name = sc.next();
		int age = sc.nextInt();
		sc.nextLine(); //enter버리기
		System.out.println("자기소개>>");
		String intro = sc.nextLine(); //1라인
		System.out.printf("당신의 이름은 %s \n", name);
		System.out.printf("당신의 나이는 %d \n", age);
		System.out.printf("자기소개.... %s \n", intro);
		sc.close();
		
	}

	private static void f1() {
		//표준입력(키보드):System.in
		//표준출력(모니터):System.out
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력>>");
		String name = sc.next();
		System.out.print("나이를 입력>>");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("자기소개>>");
		String intro = sc.nextLine(); //1라인
		System.out.printf("당신의 이름은 %s \n", name);
		System.out.printf("당신의 나이는 %d \n", age);
		System.out.printf("자기소개.... %s \n", intro);
		sc.close();
	}

}
