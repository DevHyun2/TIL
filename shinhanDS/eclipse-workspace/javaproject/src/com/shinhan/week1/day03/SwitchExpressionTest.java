package com.shinhan.week1.day03;

import java.util.Scanner;

public class SwitchExpressionTest {

	public static void main(String[] args) {
		//call();
		//call2();
		//call3();
		//call4(6);
		//call5();
		//call6(5);
		//call7();
		call8();

	}
	
	private static void call8() {
		//boolean 사용
		//7. while문과 Scanner의 nextLine() 메서드를 이용
		//키보드입력된 데이터로 예금, 출금, 조희, 종료 기능을 제공하는 코드 작성
		Scanner sc = new Scanner(System.in); // 한 줄 Scanner 작성법
		
		int amount = 0 , balance = 0;
		
		boolean isStop = false;
		
		aa:while(!isStop) {
			menu(); //새로운 메서드로 코드 보기 편하게 하기
			
			String key = sc.nextLine();
			
			switch(key) {
			case "1" :
				System.out.print("예금액>");
				amount = Integer.parseInt(sc.nextLine());
				balance += amount;
				break;
				
			case "2" :
				System.out.print("출금액>");
				amount = Integer.parseInt(sc.nextLine());
				if(amount > balance) { 								//잔고 부족시 출금 막기
					System.out.println("잔고부족. 출금불가");
					break;
				}
				System.out.println(amount + " - 정상출금됨");
				balance -= amount;
				break;
				
			case "3" :
				System.out.println("잔고는 " + balance);
				break;
				
			case "4" : System.out.println("===END==="); isStop = true; //flag를 이용하기
			
			default : break; //switch 빠지기
			}
		}
		sc.close();
		System.out.println("=====프로그램 종료=====");
	}

	private static void call7() {
		//7. while문과 Scanner의 nextLine() 메서드를 이용
		//키보드입력된 데이터로 예금, 출금, 조희, 종료 기능을 제공하는 코드 작성
		Scanner sc = new Scanner(System.in); // 한 줄 Scanner 작성법
		
		int amount = 0 , balance = 0;
		
		aa:while(true) {
			menu(); //새로운 메서드로 코드 보기 편하게 하기
			
			String key = sc.nextLine();
			
			switch(key) {
			case "1" :
				System.out.print("예금액>");
				amount = Integer.parseInt(sc.nextLine());
				balance += amount;
				break;
				
			case "2" :
				System.out.print("출금액>");
				amount = Integer.parseInt(sc.nextLine());
				if(amount > balance) { 								//잔고 부족시 출금 막기
					System.out.println("잔고부족. 출금불가");
					break;
				}
				System.out.println(amount + " - 정상출금됨");
				balance -= amount;
				break;
				
			case "3" :
				System.out.println("잔고는 " + balance);
				break;
				
			case "4" : System.out.println("===END==="); break aa; //label, while 빠지기
			
			default : break; //switch 빠지기
			}
		}
		sc.close();
		System.out.println("=====프로그램 종료=====");
	}

	private static void menu() {
		System.out.println("-------------------------------");
		System.err.println("1.예금 | 2.출금 | 3. 잔고 | 4. 종료");
		System.out.println("-------------------------------");
		System.out.print("선택>");
		
	}

	private static void call6(int count) {
		//6. for문을 이용해서 다음과 같은 실행 결과가 나오는 코드를 작성해 보세요.
		//*
		//**
		//***
		//****
		//*****
		
		for(int row=1 ; row<=count ; row++) {
			for(int col=1 ; col<=row ; col++) {
				System.out.print("*");
			}
			System.out.println(); //줄 바꿈
		}
	}

	private static void call5() {
		//5. 중첩 for문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력
		//단, x, y는 10이하의 자연수
		
		for(int x=1;x<=10;x++) {
			for(int y=1;y<=10;y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%d, %d)", x, y);
				}
			}
		}
		
	}

	private static void call4(int want) {
		//4. while 문과 Math.random() 메소드를 이용해서 두 개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출력
		//눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드 작성
		
		//무한 loop
		while(true)	{
			double su1 = (int)(Math.random() * 6) + 1; // 0 ~ 1 까지 랜덤 * 6 +1 -> 1<= <7 의 정수  
			double su2 = (int)(Math.random() * 6) + 1;
			if(su1 + su2 == want) {
				System.out.printf("(%d, %d)",su1,su2);
				break;
			}
		}
		System.out.println("=========end=========");
	}

	private static void call3() {
		//3. for 문을 이용해서 1부터 100까지의 정수 중에서
		//3의 배수의 총합을 출력하는 코드를 작성해보세요.
		
		int total = 0;
		for(int su=0;su<=100 ;su+=3) {
			total += su;
		}
		System.out.println(total);
	}

	//swtich Expression형식
	private static void call2() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A"->{score1 = 100;}
		case "B"->{int result = 100 - 20;
			score1 = result;}
		default ->{score1 = 60;}
		}
		System.out.println(score1);
	}
	
	//switchStatement형식
	private static void call() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A":
			score1 = 100;
			break;
		case "B":
			int result = 100 - 20;
			score1 = result;
			break;
		default:
			score1 = 60;
		}
		System.out.println(score1);
	}
}