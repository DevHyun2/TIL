package com.shinhan.week2.day07.lab2;

interface Action {
	public void work();
}

public class ActionExample {

	public static void main(String[] args) {
		Action action = new Action() {

			@Override
			public void work() {
				System.out.println("익명구현객체");
			}
		};
		Action action2 = () -> {
				System.out.println("람다표현식");	};
				
		action.work();
		action2.work();
	}

}
