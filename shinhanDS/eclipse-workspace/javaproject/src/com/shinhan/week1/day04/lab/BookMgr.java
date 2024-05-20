package com.shinhan.week1.day04.lab;

public class BookMgr {
	Book[] booklist;
	
	BookMgr(Book[] booklist){
		this.booklist = booklist;
		
	}
	
	void printBookList() {
		System.out.println("=== 책 목록 ===");
		for(Book b : booklist) {
			System.out.println(b.getTitle());
		}
	}
	
	void printTotalPrice() {
		System.out.println("\n=== 책 가격의 총합 ===");
		int total = 0;
		for(Book b : booklist) {
			total += b.getPrice();
		}
		System.out.println("전체 책 가격의 합 :" + total);
	}
}
