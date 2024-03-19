package com.shinhan.week1.day04.lab;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		
		p1.selfIntroduce();
		System.out.println("전체 인구수: " + p1.getPopulation());
	}

}
