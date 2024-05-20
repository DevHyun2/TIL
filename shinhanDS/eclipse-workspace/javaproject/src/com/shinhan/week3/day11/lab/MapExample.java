package com.shinhan.week3.day11.lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);

		String name = null; // 최고 점수를 받은 아이디를 저장하는 변수
		int maxScore = 0; // 최고 점수를 저장하는 변수
		int totalScore = 0; // 점수 합계를 저장하는 변수

		// 여기에 코드를 작성하세요.
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() > maxScore) {//값이 현재까지 출력된 maxScore보다 크다면 entry의 값으로 변경
				name = entry.getKey();
				maxScore = entry.getValue();
			}
			totalScore += entry.getValue();
		}
		int avg = totalScore / 3; //3대신 map.size()를 사용하자!!
		System.out.println("평균점수 : " + avg);
		System.out.println("최고점수 : " + maxScore);
		System.out.println("최고점수 ID : " + name);
	}

}
