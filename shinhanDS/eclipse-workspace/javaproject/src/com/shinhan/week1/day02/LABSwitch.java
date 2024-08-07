package com.shinhan.week1.day02;

import java.util.Scanner;

/*문제1. 자신이 태어난 달을 키보드입력 받아서 어떤 계절에 태어났는지를 출력하는 printSeason() 메서드를 구현하시오. 
(단, 반드시 switch 문을 사용해야 하며 1~12월이 아닌 달을 입력했을 경우 “1~12 사이의 숫자만 입력하셔야 합니다.” 라는 문자를 출력하도록 해야 한다.
그리고 주어진 메서드의 시그니쳐는 변경하지 않는다.)
(봄: 3, 4, 5월,       여름: 6, 7, 8월,       가을: 9, 10, 11월,        겨울 12, 1, 2월)*/

public class LABSwitch {

	public static void main(String[] args) {
		printSeason4();

	}
	
	private static void printSeason4() {
		//1.자신이 태어난 달을 키보드입력 받아서
		Scanner sc = new Scanner(System.in);
		String message;
		
		System.out.print("자신이 태어난 달을 입력>>");
		int month = sc.nextInt();
		if(month == 3 ||month == 4 ||month == 5) {message = "봄";
		} else if(month == 6 ||month == 7 ||month == 8) {message = "여름";
		} else if(month == 9 ||month == 10 ||month == 11) {message = "가을";
		} else if(month == 1 ||month == 2 ||month == 12) {message = "겨울";
		} else {
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
			return; // 함수를 빠지기
		}
		System.out.println(message + "에 태어나셨네요.");
		sc.close();
		/*double month = Math.random();
		month = (month*12 + 1);
		System.out.println();*/
		
	}
	
	private static void printSeason() {
		//1.자신이 태어난 달을 키보드입력 받아서
		Scanner sc = new Scanner(System.in);
		String message;
		
		System.out.print("자신이 태어난 달을 입력>>");
		int month = sc.nextInt();
		
		switch(month) {
		case 3,4,5 : message = "봄"; break;
		case 6,7,8 : message = "여름"; break;
		case 9,10,11 : message = "가을";	 break;
		case 12,1,2 : message = "겨울"; break;
		default :
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
			return; // 함수를 빠지기
		}
		System.out.println(message + "에 태어나셨네요.");
		sc.close();
		/*double month = Math.random();
		month = (month*12 + 1);
		System.out.println();*/
		
	}

}
