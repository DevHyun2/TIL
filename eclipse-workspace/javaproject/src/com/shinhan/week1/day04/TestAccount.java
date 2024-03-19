package com.shinhan.week1.day04;

public class TestAccount {

	public static void main(String[] args) {
		Account acc = new Account("078-3762-293", 1000000);
		acc.deposit(2000000);
		acc.withdraw(500000);

		System.out.println(acc);
	}

}
