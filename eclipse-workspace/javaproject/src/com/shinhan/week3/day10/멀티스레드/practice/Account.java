package com.shinhan.week3.day10.멀티스레드.practice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {

	String accountNo;
	String ownerName;
	int balance;
	
	void deposit(int amount) {
		balance +=  amount;
	}
	int withdraw(int amount) {
		if(balance >= amount) {
			balance -=  amount;
			return amount;			
		}else {
			System.out.println("잔고부족");
			return 0;
		}
	}
}
