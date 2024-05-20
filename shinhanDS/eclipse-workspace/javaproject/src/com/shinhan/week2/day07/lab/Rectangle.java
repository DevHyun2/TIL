package com.shinhan.week2.day07.lab;

public class Rectangle extends Shape implements Resizable {
	double width;
	double height;
	
	public Rectangle(double width, double height) {
		super(4);
		this.width = width;
		this.height = height;
	}

	@Override
	public void resizable(double s) {
		// 크기 조정
		width = width * s;
		height *= s;
	}

	@Override
	double getArea() {
		// 넓이
		return width * height;
	}

	@Override
	double getPermieter() {
		// 둘레
		return (width+ height)*2;
	}
}
