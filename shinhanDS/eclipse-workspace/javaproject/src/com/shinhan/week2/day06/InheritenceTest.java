package com.shinhan.week2.day06;

class Parent extends Object{
	String title = "부모에서 정의함";
	private String title2 = "부모에서 정의함";
	Parent (){
		//super(); 자동으로 부모의 default생성자를 호출한다.
		System.out.println("부모의 default생성자");
	}
	void show() {
		System.out.println("부모에서 정의한 show메서드...title2" + title2);
		print();
	}
	private void print() {
		System.out.println("부모에서 정의한 show메서드...title2" + title2);
	}
}

class Child extends Parent{
	int title = 200;
	int score = 100;
	
	Child() {
		//super(); 자동으로 부모의 default생성자를 호출한다.
		System.out.println("자식의 default생성자");
	}
	void show2() {
		System.out.println("자식에서 정의한 show2메서드");
		System.out.println("title:" + title);
		//System.out.println("private로 정의된 feild 접근불가:" + title2);
		show(); //print(); private여서 호출 불가능
	}
}


public class InheritenceTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		Child ch1 = new Child();
		System.out.println(ch1.score);
		System.out.println(ch1.title);
		ch1.show();
		ch1.show2();
	}

}
