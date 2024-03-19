package com.shinhan.week2.day05;

public class Member {
	private String name;
	private String id;
	private String password;
	private int age;
	
	public Member(String name, String id, String password, int age) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}
	
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public void setName(String name) {
		
	}
	
	public static void main(String[] args) {
		Member user1 = new Member("홍길동","hong");
	}
}
