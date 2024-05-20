package com.shinhan.week3.day14;

public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		// 구현하시오 - 숫자들의 개수를 세어 저장하는 코드를 작성한다.
//		for(int count : answer) {
//			if(count == 1) {
//				counter[0]++;
//			}else if(count == 2) {
//				counter[1]++;
//			}else if(count == 3) {
//				counter[2]++;
//			}else{
//				counter[3]++;
//			}
//		}
		for(int num : answer ) {
			counter[num-1]++;
		}
		
		// 구현하시오 - 출력결과와 같이 나오도록 작성한다.
		System.out.println("1의 갯수는 " + counter[0] + "개 입니다.");
		System.out.println("2의 갯수는 " + counter[1] + "개 입니다.");
		System.out.println("3의 갯수는 " + counter[2] + "개 입니다.");
		System.out.println("4의 갯수는 " + counter[3] + "개 입니다.");
		
		

	}
}
