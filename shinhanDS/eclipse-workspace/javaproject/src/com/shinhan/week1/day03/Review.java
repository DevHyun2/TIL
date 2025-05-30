package com.shinhan.week1.day03;

public class Review {

	public static void main(String[] args) {
		call(100);
		call(55);
		call2(10);
		call3(10);
		call4(10);
		call5(10);
	}
	
	//-----------------------------------------------------------call5
	private static void call5(int a) {
		//반복문 do while : 1 ~ a까지 합 구하기
		//while 자리 do while문 블럭 아래로
		
		int total = 0;
		int i=1 ;
		do {
			if(i==1) break;
			total += i;
			i++;
		}while(i<=a); 
		System.out.println("do while합계 : " + total); //55
	}
	
	//-----------------------------------------------------------call4
		private static void call4(int a) {
			//반복문 while : 1 ~ a까지 합 구하기
			//초기값 밖으로, 조건 안으로, 괄호안 범위만
			
			int total = 0;
			int i=1 ;
			while(i<=a) {
				total += i;
				i++;
			}
			System.out.println("while합계 : " + total); //55
		}
	
	//-----------------------------------------------------------call3
	private static void call3(int a) {
		//반복문 for : 1 ~ a까지 합 구하기
		
		int total = 0;
		for(int i=1 ; i<=a ; i++) {
			total += i;
		}
		System.out.println("for합계 : " + total); //55
	}

	//-----------------------------------------------------------call2
	private static void call2(int a) {
		//조건문 switch
		
		switch(a%2) {
		case 0 : System.out.println(a + " 짝수"); break;
		case 1 : System.out.println(a + " 홀수");
		}
	}
	
	//-----------------------------------------------------------call
	//반복사용 하기 위해 메서드를 만듦
	private static void call(int a) {
		//조건문 if
		
		if(a%2==0) {
			System.out.println(a + " 짝수");
		}else {
			System.out.println(a + " 홀수");
		}
		System.out.println(a%2==0? a+" 짝수": a+" 홀수"); //삼항 연산자
	}

}
