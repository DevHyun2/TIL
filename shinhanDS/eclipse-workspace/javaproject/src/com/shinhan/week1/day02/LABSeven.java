package com.shinhan.week1.day02;

import java.util.Scanner;

/*문제2. 소수란 자신과 1외의 다른 수로는 나누어 떨어지지 않는 정수입니다. 
아래와 같이 2~100 사이의 숫자를 입력하면 소수인지 여부를 판별하는 프로그램을 작성하십시오.
*/
public class LABSeven {

	public static void main(String[] args) {
			method2();
	}

	private static void method2() {
		//1~100사이 소수를 출력하기
		for(int su=2;su<=100;su++) {
			boolean isPrime = true;
			for (int i=2;i<su;i++) {
				isPrime = false;
				break;
			}
		}
		System.out.println(isPrime? su + "는(은) 소수입니다." : su + "는(은)소수가 아닙니다.");
	}

	private static void method1() {

		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.print("2 ~ 100사이의 정수를 입력하세요. :");
		int su = sc.nextInt();
		
		for(int i=2 ; i<=su ; i++ ) {
			if(su/i == 1) {
				System.out.printf(" %d는(은) 소수입니다.", su);
				break;
			}else {
				System.out.printf(" %d는(은) 소수가 아닙니다.", su);
				break;
			}
		}
		
		sc.close();
	
		
	}
}

/* int su = sc.nextInt():
boolean isPrime = true;
for(int1=2 ; i<su ; i++){
if(su%i==0){
isPrime = false; break;
}
syso
}
*/