package com.shinhan.week1.day04;

import java.util.Scanner;

public class Review {

	public static void main(String[] args) {
		metho8();
		System.out.println("main END");

	}

	private static void metho8() {
		int count = 0;
		int[] scores = null;
		boolean isStop = false; //5.종료를 누르면 while문 빠지기
		
		Scanner sc = new Scanner(System.in);
		
		while(!isStop) {
			menuPrint();
			System.out.print("선택> ");
			int job = sc.nextInt();
			switch(job) {
			case 1 ->{System.out.print("학생수> ");
				count = sc.nextInt();
				scores = new int[count];}
			
			case 2 ->{if(scores == null) {
				System.out.println("아직 학생수가 입력되지않았다. (점수입력불가)");
				break; //switch 빠지기
			}
				for (int i=0 ; i<count ; i++) {
				System.out.printf("scores[%d]> ", i);
				scores[i] = sc.nextInt();
			}
				;}
			
			case 3 ->{
				int i = 0;
				for(int socre : scores) {
					System.out.printf("scores[%d]: %d", i++, socre);
				}
			}
			
			case 4 ->{
				int max = Integer.MIN_VALUE;
				int total = 0;
				for(int score : scores) {
					if(score > max) max = score;
					total += score;
				}
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + (double)total/count);
			}
			
			case 5 ->{isStop = true;}
			}
		}
		sc.close();
	}

	private static void menuPrint() {
		System.out.println("----------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("----------------------------------------------");
		
	}

	private static void method7() {
		int[][] arr = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88} };
		int total = 0, count = 0;
		
		for(int[] datas : arr) {
			for(int data : datas) {
				total += data; count++;
			}
		}
		System.out.println(total);
		System.out.println(count);		
		System.out.println((double)total/count);
	}

	private static void method6() {
		int[] arr = {1,5,3,8,2};
		int max = Integer.MIN_VALUE;
		
		for(int data : arr) {
			if(data>max) max = data;
		}
		System.out.println(max);
	}

	private static void method5() {
		int[][] arr = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88} };
		
		
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr[i].length ; j++) {
				System.out.print(arr[i][j] + " ");
				}
			System.out.println();
		}
		
	}

	private static void method4() {
		int a = 10; //기본형 null초기화 안됨
		Integer b = null; //객체형 null초기화 가능
		System.out.println(a);
		System.out.println(b);
		
		//String은 고정문자열
		String s = "자바";
		s += "프로그램";
		s = s + "프로그램"	 //StringBuffer .append (자동삭제) -> String
		
	}

	private static void method3() {
		int[][]	arr = new int[3][4];
		int[][]	arr2 = new int[3][];
		int[] arr3[] = new int[3][];
		int arr4[][] = new int[3][4];
		
		for(int i=0 ; i<arr4.length ; i++) {
			arr4[i] = new int[i+2]; // i=0 일때 2, i=1 일때 3, i=2 일때 4
			
			for(int j=0 ; j<arr4[i].length ; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void method2() {
		//배열선언 + 배열생성 + 자동초기화
		int[] arr = new int[3];
		
		//배열선언 + 배열생성 + 내가초기화
		int[] arr2 = {1,10,100,1000};
		int[] arr3 = {1,10,100,1000};
		
		//배열선언 후 생성 + 초기화
		int[] arr4;
		arr4 = new int[] {1,10,100,1000};
		
		for(int index=0 ; index<arr4.length ; index++) {
			System.out.println(arr4[index]);
		}
		
	}

	private static void method1() {
		//배열 : 같은 타입의 여러개의 값을 저장하기 위한 자료구조 
		//heap 영역에 연속공간을 만든다.
		//개수를 알아야 생성가능
		
		//1.배열선언
		int[] arr = null;
		
		//2.배열생성
		arr = new int[3]; //자동으로 초기화 된다. 정수 -> 0
		
		//3.배열사용
		arr[0] = 100;
		System.out.println(arr[0]); //배열 생성없이 사용 불가
		System.out.println(arr[1]); //배열 생성없이 사용 불가
		System.out.println(arr[2]); //배열 생성없이 사용 불가
		System.out.println(arr[3]); //배열 생성없이 사용 불가 java.lang.ArrayIndexOutOfBoundsException 인덱스 범위 벗어남
	}

}
