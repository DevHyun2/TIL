package com.shinhan.week3.day10.제네릭;

public class HomeAgency implements Rentable<Home>{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Home rent() {
		// TODO Auto-generated method stub
		return new Home();
	}

}
