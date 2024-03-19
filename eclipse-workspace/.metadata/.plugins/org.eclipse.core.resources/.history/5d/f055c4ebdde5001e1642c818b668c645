package com.shinhan.day02;

import java.util.Scanner;

/*문제1. 초기 값, 마지막 값, 증가분을 입력 받아서, 
 * 초기값부터 마지막 값까지, 증가분씩 값을 증가시키면서 
 * 각 값들의 총합을 구하는 프로그램을 작성하세요. 
 * 단, 합을 구한 결과가 1000을 넘으면, 결과에 2000을 한번 더 더하여 출력합니다.*/
public class LABOne {
	public static void main(String[] args) {
		method1();
		
	}

	private static void method1() {
		//java.lang패키지 아래에 있는 class들은 import없이 사용가능
		Scanner sc; //import Scanner
		
		sc = new Scanner(System.in);
		
		System.out.print("초기값 값을 정수로 입력하세요. :");
		int start = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요. :");
		int end = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요. :");
		int step = sc.nextInt();
		
		int total = 0;
		for(int i = start ; i<=end ; i+=step) {
			total +=i;
		}
		if(total>1000) total += 2000;
		//결과출력
		System.out.printf("총합은 %d 입니다.", total);
		//Scanner 닫기
		sc.close();
	}
}
