package com.shinhan.week1.day02;

import java.util.Scanner;

public class LABFive {

	public static void main(String[] args) {
		method5();

	}

	private static void method5() {
		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.print("짖각 역삼각형을 출력할 줄 수: ");
		int su = sc.nextInt();
		
		for(int row=1 ; row<=su ; row++) {
			for(int col=1 ; col<=su+1-row ; col++) {
				System.out.print("*");
			}
			System.out.println();//줄 바꿈
		}
		sc.close();
	}
}
