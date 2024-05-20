package com.shinhan.week2.day06.lab;

public class Rectangle extends Shape {
	double length;
	double width;
	public Rectangle(String color, double length, double width) {
		super(color, "Rectangle");
		this.length = length;
		this.width = width;
	}
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return length*width;
	}
	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2*(length+width);
	}
	
	
}