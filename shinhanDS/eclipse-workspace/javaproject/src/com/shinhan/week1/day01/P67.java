package com.shinhan.week1.day01;

//System.out : 표준출력(모니터), PrintStream = 모니터에 출력해라
//print()
//println()
//printf()

public class P67 {

	public static void main(String[] args) {
		int v1 = 15;
		int v2; //지역변수 초기화하지 않음
		if(v1 > 10) { //조건에 맞을 경우 초기화X
			v2 = v1 - 10;
		} else { //조건에 맞지 않은 경우 초기화O
			v2 = 100;
		}
		int v3 = v1 + v2 + 5;
		System.out.println("v3 = " + v3);
	}

}
