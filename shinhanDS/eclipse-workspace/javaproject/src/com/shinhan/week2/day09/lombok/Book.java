package com.shinhan.week2.day09.lombok;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JavaBeans기술 규격 : field는 private, getter/setter, default생성자 필수
//DTO(Data Transfer object) : data를 전송하기 위해 만듦
//VO(Value Object) : 값을 저장하기 위해 만듦

@EqualsAndHashCode(exclude = {"price"}) //배제
//@EqualsAndHashCode(of = {"title","author"}) //포함
@ToString(exclude = "price")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	public Book(String string, int i, String string2) {
		// TODO Auto-generated constructor stub
	}
	String title;
	int price;
	String author;
	@Override
	public int hashCode() {
		return Objects.hash(author, price, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && price == other.price && Objects.equals(title, other.title);
	}
	
	
	
	
	/*
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
	
	*/
}
