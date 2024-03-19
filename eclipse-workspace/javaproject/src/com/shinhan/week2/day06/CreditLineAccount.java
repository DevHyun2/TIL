package com.shinhan.week2.day06;

public class CreditLineAccount extends Account {
	
	int creditLine; //마이너스 한도

	public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance); //이문장이 없으면 에러
		this.creditLine = creditLine;
	}
	
	//인출 메서드는 부모의 로직을 사용한다.  ....재정의를 원한다.
	//Override(재정의, 덮어쓰기)
	//이름, 매개변수타입과 개수, return모두 같아야한다. modifier는 같거나 더 넓어져야 한다.
	
	@Override //재정의
	int withdraw(int amount){
		if (getBalance() + creditLine < amount) {
			System.out.println("잔고부족. 출금불가");
			return 0;
			}
			
		setBalance(getBalance() - amount);
		//balance -= amount;
		return amount;
	}

	@Override
	public String toString() {
		return "CreditLineAccount"+ super.toString() +"[creditLine=" + creditLine + "]";
	}
	
}
