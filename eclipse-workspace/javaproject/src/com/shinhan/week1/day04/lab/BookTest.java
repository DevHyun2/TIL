package com.shinhan.week1.day04.lab;

public class BookTest {
	
	public static void main(String[] args) {
	    Book[] b = new Book[5];
		b[0] = new Book("Java Program",30000);
		b[1] = new Book("JSP Program",25000);
		b[2] = new Book("SQL Fundamentals",20000);
		b[3] = new Book("JDBC Program",32000);
		b[4] = new Book("EJB Program",25000);
		
		BookMgr bm = new BookMgr(b);
		bm.printBookList();
		bm.printTotalPrice();
	}
}

