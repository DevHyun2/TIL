package com.shinhan.week2.day05.test;

import java.util.Scanner;

public class Account {
	public String accNo;
	public String owner;
	public int balance;
	
	public Account(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	//입급
	public void save(int amount) {
		balance += amount;
	}
	//출금
	public int withdraw(int amount) {
		if(balance>=amount) {
			balance -= amount;
			System.out.println("결과: 출금이 성공되었습니다.");
			return amount;
		} else {
			System.out.println("잔고부족");
			return 0;
		}
	}
	
}
