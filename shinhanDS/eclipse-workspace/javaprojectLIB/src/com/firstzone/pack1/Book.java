package com.firstzone.pack1;


//JavaBeans기술 규격 : field는 private, getter/setter, default생성자 필수
//DTO(Data Transfer object) : data를 전송하기 위해 만듦
//VO(Value Object) : 값을 저장하기 위해 만듦
public class Book {

	String title;
	int price;
	String author;
	
	
	
	public Book() { //default 생성자
		
	}

	public Book(String title, int price, String author) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author=" + author + "]";
	}
	
	
}
