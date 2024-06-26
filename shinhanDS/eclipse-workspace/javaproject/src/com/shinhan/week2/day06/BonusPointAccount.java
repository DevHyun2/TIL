package com.shinhan.week2.day06;

public class BonusPointAccount extends Account{
	
	//feild추가
	int bonusPoint;

	//생성자정의
	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}
	//method 재정의(Override) //마우스 우클릭 > 소스 > Override

	@Override
	void deposit(int amount) {
		
		super.deposit(amount);
		bonusPoint += amount*0.001; //복합대입 연산자는 자동 형변환 된다.
		//bonusPoint = (int)(bonusPoint + amount*0.001);
	}

	@Override
	public String toString() {
		return "BonusPointAccount"+ super.toString() + "[bonusPoint=" + bonusPoint + "]";
	}
	
}
