package com.shinhan.week2.day09.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	
	String model;
	int price;
	
}
