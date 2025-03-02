package com.shinhan.week2.day07;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		OkButtonListener ok1 = new OkButtonListener();
		OkButtonListener2 ok2 = new OkButtonListener2();

		Button button = new Button();
		button.setListener(ok2); // ok1 or ok2, 리스너가 달라질 때 마다 동작이 달라짐
		button.click();

		// 이름이 없는 구현 class 만들기
		Button.ClickListener ok3 = new Button.ClickListener() {

			@Override
			public void onClick() {
				System.out.println("익명 구현class 만들기");

			}
		};

		// 익명 구현class만들기2
		button.setListener(new Button.ClickListener() {

			@Override
			public void onClick() {
				System.out.println("익명 구현class 만들기2");

			}
		});

		
		//람다식(interface에 메서드가 1개있을 때만 가능)
		button.setListener(()->System.out.println("익명 구현 class만들기3 "));
		
		
		button.setListener(ok3);
		button.click();
	}

}
