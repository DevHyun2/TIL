package com.shinhan.week2.day05;

//SingleTone : 객체가 1번만 생성된다.
public class SingleToneClass {

	//private static SingleToneClass single = new SingleToneClass();
	
	private static SingleToneClass single;
	
	private SingleToneClass(){
		
	}
	
	public static SingleToneClass getInstance() {
		if(single == null)
			single = new SingleToneClass();
		return single;
	}
	
}
