package com.shinhan.week2.day07;

import java.awt.print.Printable;

public class CupUsing {

	public static void main(String[] args) {
		//CoffeeCup cup = new CoffeeCup();
		//WaterCup cup2 = new WaterCup();
		print(new CoffeeCup());
		print(new WaterCup());
		
		print(new Cup() {
			System.out.println();
		});
		
		print(()->System.out.println("람다표현식으로 구현class 만들기");)
		
		
		}
	static void print(Cup cup) {
		cup.use();

	}

}
