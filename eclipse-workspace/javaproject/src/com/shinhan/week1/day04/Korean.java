package com.shinhan.week1.day04;

//class : 틀, 공통된 특징과 행위를 정한다.
//object : 각각의 다른 object와 구별되는 독립된 특징을 부여한다.
public class Korean {

	//1.feild
	private String nation = "대한민국";
	private String name;
	private String ssn;
	
	//2.constructor(생성자) : 초기화가 목적
	Korean(String name, String ssn){
		this.name = name;
		this.ssn = ssn;
	}
	//3.메서드(기능) : return type 필수, 없다면 void
		void print() {
			System.out.println(nation);
			System.out.println(name);
			System.out.println(ssn);
	}
		@Override
		public String toString() {
			return
		}
		
}
