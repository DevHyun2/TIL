package com.shinhan.week3.day10.제네릭;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Comparable<Car>{
	
	String model;
	int price;
	String color;

	public void run() {
		System.out.println("자동차가 달립니다.");
	}

	@Override
	//값이 같으면 자리이동 없음
	//asc : 나의값 - 들어온값
	//desc : 들어온값 - 나의값
	public int compareTo(Car c) {
		
		//이름으로 asc, 가격으로 desc, 색으로 asc
		int result = c.price - price;
		if(result == 0) {
			int result2 = model.compareTo(c.model);
			if(result2 == 0) return color.compareTo(c.color);
			return result2;
		}
		
		return result;
	}
	
	
}
