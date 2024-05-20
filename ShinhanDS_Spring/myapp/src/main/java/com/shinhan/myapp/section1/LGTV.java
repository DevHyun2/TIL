package com.shinhan.myapp.section1;

public class LGTV implements TV{
	public LGTV() {
		System.out.println("LGTV 생성자");
	}
	
	
	public void powerOn() {
		System.out.println("******LGTV*****");
		System.out.println(getClass().getSimpleName() + " 전원을 켠다");
	}
	public void powerOff() {
		System.out.println("******LGTV*****");
		System.out.println(getClass().getSimpleName() + " 전원을 끈다");
	}	
}
