package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShareArea {

	Account lee;
	Account sung;
	
	synchronized void transfer() {
		int amount = lee.withdraw(100);
		System.out.println("이몽룡계좌에 출금:" + amount);
		System.out.println("성춘향계좌로 입금:" + amount);
		sung.deposit(amount);
	}
	synchronized void print() {
		int b1 = lee.balance;
		int b2 = sung.balance;
		System.out.println("잔고합:" + (b1+b2));
	}
}




