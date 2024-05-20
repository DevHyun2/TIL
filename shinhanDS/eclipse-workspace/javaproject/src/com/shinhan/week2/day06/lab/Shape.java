package com.shinhan.week2.day06.lab;

//abstract class : abstract메서드가 1개이상 있다를 의미한다.
//abstract 메서드 : 정의는 있고 구현은 없는 메서드를 의미한다.

public abstract class Shape {

	private String color;
	private String type;

	public Shape() {
	}

	public Shape(String color, String type) {
		this.color = color;
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	//컴파일러가 해석을 하는 주석이다.(Annotation)
	@Override
	public String toString() {
		return color + " " + type;
	}

}

	
	