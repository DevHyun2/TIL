package com.shinhan.week2.day07;

public class Person {

	double su1, su2;
	Person(double su1, double su2){
		this.su1 = su1;
		this.su2 = su2;
	}
	
	//로직은 사용하는 쪽에서 결정한다.
	public void action(ComputreInterface compute) {
		double result = compute.calc(10,4);
		System.out.println(result);
	}
}
