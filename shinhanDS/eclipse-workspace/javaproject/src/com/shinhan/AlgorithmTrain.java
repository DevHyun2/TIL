package com.shinhan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorithmTrain {

	public static void main(String[] args) {
		solution(5, 555);

	}

	private static int[] solution(int l, int r) {

		List<Integer> alist = new ArrayList<>();

		for (int i = 5; i <= r; i += 5) {
			for (char ch : String.valueOf(i).toCharArray()) {
				if (ch != '0' && ch != '5') {
					continue; // 0,5가 아니면 다음숫자 넘어가기
				}
			}
			alist.add(i);// 0,5 숫자들만 리스트에 추가
		}
		if (alist.isEmpty()) {
			alist.add(-1);
		}
		int[] result = new int[alist.size()];
		for(int k=0 ; k<alist.size() ; k++) {
			result[k] = alist.get(k);
		}
		return result;
	}
}