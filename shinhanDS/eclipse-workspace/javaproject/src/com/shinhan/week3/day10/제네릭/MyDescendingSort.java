package com.shinhan.week3.day10.제네릭;

import java.util.Comparator;

public class MyDescendingSort implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		//앞 - 뒤 (ASC) 뒤 - 앞 (DESC)
		
		return o2 - o1;
	}

}
