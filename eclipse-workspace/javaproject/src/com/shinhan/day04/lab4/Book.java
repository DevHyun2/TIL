package com.shinhan.day04.lab4;

public class Book {
	
	private String title;
	private int price;
	
	Book(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	
	//생성자 우클릭 -> source -> constructor field
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}



	//getter, setter
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	
	void bookInfo()	{
		
	}

}
