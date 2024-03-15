package com.shinhan.day04;

public class Account {
	//1.field
	String accNo;
	int balance;
	
	Account(String accNo, int balance){
		this.accNo = accNo;
		this.balance = balance;
		System.out.println(accNo + " 계좌가 개설되었습니다.");
		System.out.println(accNo + " 계좌의 잔고는 " + balance + "원입니다.");
	}
	
	void deposit(int save){
		balance += save;
		System.out.println(accNo + "계좌에 " + save + "원이 입금되었습니다.");
		System.out.println(accNo + "계좌의 잔고는 " + balance + "원입니다.");
	}
	
	void withdraw(int save) {
		balance -= save;
		System.out.println(accNo + " 계좌에 " + save + "원이 출금되었습니다.");
		System.out.println(accNo + "계좌의 잔고는 " + balance + "원입니다.");
	}

	@Override
	public String toString() {
		return "Account [accNo = " + accNo, "balance = " + balance + "]";
	}
	
}
