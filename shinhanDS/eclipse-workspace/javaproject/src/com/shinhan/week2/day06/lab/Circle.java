package com.shinhan.week2.day06.lab;

public class Circle extends Shape {
	double radius;
	double circumference;

	public Circle(String color, double radius) {
		super(color, "Circle");
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	
	public double calculateArea() {
		return radius*radius*Math.PI;
	}
	
	public double calculatePerimeter() {
		return 2*radius*Math.PI;
	}
}
