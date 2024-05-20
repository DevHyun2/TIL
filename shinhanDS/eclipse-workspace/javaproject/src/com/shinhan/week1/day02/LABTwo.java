package com.shinhan.week1.day02;

import java.util.Scanner;

//문제2. 문자열을 입력 받아서 아래와 같은 실행결과가 나타나도록 
//ForTest클래스의 main 메쏘드를 완성하십시오. 
//입력 받은 문자열을 한 글자씩 증가시키며 출력하는 프로그램입니다. 
//(단, 대문자로 출력해야 합니다.)
public class LABTwo {

	public static void main(String[] args) {
		method2();

	}

	private static void method2() {
		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요. :");
		String strLine = sc.nextLine().toUpperCase();
		
		for(int i = 1;i<=strLine.length();i++) {
			System.out.println(strLine.substring(0, i));
		}
		sc.close();
	}

}
