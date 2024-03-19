package com.shinhan.week2.day06;

//extends Object 생략되어있음
//javaBeans 기술 규격서 : feild는 접근제한자를 private, 외부에서 getter/setter로 접근
public class Account {
	
	//final : 최종을 의미한다.
	//final class :  상속불가
	//final field : 1회만 할당(선언시), 수정불가
	//final static field : 상수(1회할당, 선언시 또는 static block에서)
	//final method : 재정의불가
	private final String name = "우리은행";
	private final String name2;
	private final static String NAME3 = "우리은행3";
	private final static String NAME4;
	static {
		NAME4 = "우리은행4";
	}
	
	final void method1() {
		System.out.println("자식이 재정의 불가");
	}
	
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() { //default생성자 있으면 오류 안남
		
	}
	//생성자 : 정의하지않으면 컴파일러가 default생성자를 만든다.
		//정의하면 만들어주지 않는다.
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		name2 = "우리은행2";
	}
	//입금
	void deposit(int amount) {
		balance += amount;
	}
	//출금
	int withdraw(int amount){
		if (balance < amount) {
			System.out.println("잔고부족. 출금불가");
			return 0;
			}
			
		balance -= amount;
		return amount;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	//field 추가
	protected String title = "protected field 연습";
	//메서드 추가
	protected void print() {
		System.err.println("protected 접근제한자 연습");
	}
	}
	
}
