package com.shinhan.week3.day12;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable{
	private int pno;
	private String name;
	private String company;
	private int price;
	
	public Product(int pno, String name, String company, int price) {
		this.pno = pno;
		this.name = name;
		this.company = company;
		this.price = price;
	}

	public int getPno() { return pno; }
	public String getName() { return name; }
	public String getCompany() { return company; }
	public int getPrice() { return price; }
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("{")
				.append("pno:" + pno + ", ")
				.append("name:" + name + ", ")
				.append("company:" + company + ", ")
				.append("price:" + price)
				.append("}")
				.toString();
	}

	@Override
	public int compareTo(Product obj) {
		//1)상품 가격 desc, 2)이름 asc, 3)아이디 desc
		int a = obj.getPrice() - price;
		if(a==0) {
			int b = name.compareTo(obj.name);
			if(b==0) return obj.pno - pno;
			return b;
		}
		return a;
	}
}