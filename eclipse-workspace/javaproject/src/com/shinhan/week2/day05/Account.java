package com.shinhan.week2.day05;

public class Account {
	
	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance<MIN_BALANCE || balance>MAX_BALANCE) return;
		this.balance = balance;
		
		//= if(balance>=MIN_BALANCE && balance<=MAX_BALANCE)
	}
	
	
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());
		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance());
		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance());
		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance());
	}
}
