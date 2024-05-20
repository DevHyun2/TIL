package com.shinhan.week2.day07.lab;

public class RectTriangle extends Shape {
	double width;
	double height;
	
	RectTriangle(double width, double height){
		super(3);
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		// 넓이
		return width* height/2;
	}

	@Override
	double getPermieter() {
		// 둘레
		return width+height+Math.sqrt(height*height+width*width);
	}
}
