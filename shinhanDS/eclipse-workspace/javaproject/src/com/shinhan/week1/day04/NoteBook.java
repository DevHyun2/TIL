package com.shinhan.week1.day04;

public class NoteBook {

	//1.field : object마다 다른 객체와 구별되는 값을 저장하기위함
	//필드의 종류 : non-static(instance 변수, 멤버 변수) -> 반드시 생성 후 사용가능.
	//			 static(class or 공유 변수, C언어의 share변수) -> 객체 생성과 무관하다.
	private String model;
	private int price;
	static int count;
	
//	2.consturctor : 값을 초기화 하는 목적
	public NoteBook(String model, int price) {
		super();
		this.model = model;
		this.price = price;
		count++;
		
	}
	//3. 일반메서드
	//3. getter(값을 얻기)/setter(값을 변경)

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NoteBook [model=" + model + ", price=" + price + "]";
	}
	
}
