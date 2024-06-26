package com.shinhan.week2.day07;

import com.shinhan.week2.day07.Window.Listener;

class Window {
	
	static interface Listener {
		void alert();
	}
	
	Listener listener;
	void setListener(Listener listener) {
		this.listener = listener; //필드 초기화
	}
	
	void execute() {
		listener.alert();
	}
}
//1.내부 interface를 구현한 class를 만들어야 한다.
class MyListener1 implements Window.Listener {
	
	public void alert() {
		System.out.println("구현 class에서 메서드를 재정의 한다.");
	}
	
}





public class InnerInterfaceTest2 {

	public static void main(String[] args) {
		
		Window win = new Window();
		
		//1.구현class 이용하기(단점 : 비슷한 구현 class를 계속 만들어야 함)
		MyListener1 my1 = new MyListener1();
		win.setListener(my1);
		
		//2.익명 구현class를 이용
		Window.Listener my2 = new Window.Listener() {
			public void alert() {
				System.out.println("2.익명구현class를 만든다");
			}
		};
		win.setListener(my2);
		win.execute();
		
		//3.람다표현식을 이용(메서드가 1개인 경우만 가능)
		
		win.setListener(()->System.out.println("3.람다표현식을 이용(메서드가 1개인 경우만 가능)"));
		win.execute();
	}
}
