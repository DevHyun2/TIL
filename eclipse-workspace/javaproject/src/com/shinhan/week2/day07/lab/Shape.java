package com.shinhan.week2.day07.lab;

public abstract class Shape {
	int numSides; //변의 수
	
	Shape(int numSides){ 
		this.numSides = numSides;
	}

	 int getNumSides() {
		return numSides;
	}

	 abstract double getArea() { //넓이
	}

	 abstract double getPermieter() { //둘레 길이
	}
	
	
}
