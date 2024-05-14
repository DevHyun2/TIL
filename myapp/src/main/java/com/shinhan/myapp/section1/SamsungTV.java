package com.shinhan.myapp.section1;

public class SamsungTV implements TV{
	public SamsungTV() {}
	
	public SamsungTV(String model){
		System.out.println("SamsungTV 모델 " + model);
	}
	
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + " 전원을 켠다");
	}
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + " 전원을 끈다");
	}	
}
