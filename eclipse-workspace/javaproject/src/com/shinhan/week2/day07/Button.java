package com.shinhan.week2.day07;

public class Button {
	
	public static interface ClickListener{ //클릭리스너 메서드는 반드시 온클릭함수를 이용해야 한다.
		void onClick(); //추상 메서드
		
	}
	
	//field
	ClickListener listener;
	
	//setter
	void setListener(ClickListener listener) { 
		this.listener = listener;
	}
	
	void click() {
		listener.onClick();
	}
}
