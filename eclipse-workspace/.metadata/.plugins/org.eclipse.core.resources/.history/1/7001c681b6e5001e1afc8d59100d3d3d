package com.shinhan.day03;

import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;

public class 배열테스트 {

	public static void main(String[] args) {
		test2();

	}

	private static void test2() {
		
		/*문제2. 2차원 배열을 이용하여 두 행렬에 대한 차를 구할 수 있는 sub() 메소드와 
		 * 결과를 출력하는 prn() 메소드를 ArrayTest 클래스 내에 구현하십시오.
		 */
		
		int[][] a = {{30, 30, 30, 30}, {40, 40, 40, 40}, {50, 50, 50, 50}};
		int[][]	b = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		//int[][] c = {{29, 28, 27, 26}, {35, 34, 33, 32}, {41, 40, 39, 38}};
		int[][] c = new int[a.length][a[0].length];
		test2_1(a, b, c);
		
		
	}
		
	private static void test2_1(int[][] a, int[][] b, int[][] c) {
		for(int i=0 ; i<a.length ; i++) {
			for(int j=0 ; j<a[i].length ; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		for(int i=0 ; i<c.length ; i++) {
			for(int j=0 ; j<c[i].length ; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void test1() {
		
		/*문제1. 주어진 일차원 배열의 내용을 오름차순으로 정렬하는 로직을 작성하시오.
		(단, 로직은 main() 메서드에 작성하고 반드시 이중 for문을 사용하여 구현해야 한다.) 
		 */
		/*
		System.out.println("[배열의 내용]");
		
		int[] arr = {3, 24, 1, 55, 17, 43 ,5};
		//System.out.println(Arrays.toString(arr));
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]);
			for(int )
		}
		
		System.out.println("[클래스 실행결과]");
		
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr.length ; j++) {
				
			}
		}
       */	
		int[] arr = {3, 24, 1, 55, 17, 43 ,5};
		//selection sort, Ascending(오름차순) 작 -> 큰
		
		System.out.println("origin:" + Arrays.toString(arr));
		
		//i는 *다음* 값과 비교하여 결정할 값
		for(int i=0 ; i<arr.length - 1 ; i++) {
			for(int j=i ; j<arr.length ; j++) {
				if(arr[i] > arr[j]) {
					//자리이동(바꾸기)    Arrays.sort(arr)가능
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("asc sort:" + Arrays.toString(arr));
		
		
		
		
	}

}
