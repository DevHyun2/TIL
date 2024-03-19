package com.shinhan.week2.day06;

//Object는 최상위 class
class Parent2 extends Object{
	int score = 100;
	void show() {
		System.out.println("부모에에서 score접근: " + score);
	}
}

class Child2 extends Parent2{
	//Overloading : 이름은 같고 매개변수(argument) 사양이 다르다. - 추가
	@Override //이름, 매개변수, return, modifier - 덮어쓰기
	protected void show() {
		System.out.println("!!!!자식에서 score접근: " + score);
		show(); //자신의 class에 재정의 되어있는 method 수행
		super.show(); // super는 부모를 의미
	}
	
	String score = "A학점"; //재정의
	void print() {
		System.out.println("자식이 score접근: " + score);
		show();
	}
}

public class InheritenceTest2 {

	public static void main(String[] args) {
		Child2 aa = new Child2(); //Object생성, Parent2생성, Child2생성
		System.out.println(aa.score);
		aa.print();
		aa.show();
	}
	
}
