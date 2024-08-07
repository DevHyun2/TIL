package com.shinhan.week2.day08.lab;

public class CellPhone {

	String model; 				//핸드폰 모델 번호
	double battery; 			//남은 배터리 양
	
	CellPhone(String model){	//모델 번호를 인자로 받는 생성자
		this.model = model;
	}
	
	void call(int time) {
		if(time<0) throw new IllegalArgumentException("통화시간입력오류");
		System.out.printf("통화 시간 : %d분\n", time);
		battery -= time *0.5;
		if(battery<0) battery = 0;
		
	}
	
	void charge(int time) {
		if(time<0) throw new IllegalArgumentException("충전시간입력오류");
		System.out.printf("충전 시간 : %d분\n", time);
		battery += time * 3;
		if(battery>100) battery = 100;
	}
	
	void printBattery() {
		System.out.printf("남은 배터리 양 : %4.1f\n", battery);
	}
	
	@Override
	public boolean  equals(Object otherObject) {
		if(!(otherObject instanceof CellPhone)) return false;
		CellPhone phone = (CellPhone)otherObject;
		return model.equals(phone.model);
	}
}
