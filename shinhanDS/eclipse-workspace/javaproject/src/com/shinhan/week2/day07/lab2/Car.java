package com.shinhan.week2.day07.lab2;

public class Car {
	class Tire{}
	static class Engine{}
	
	void mothod() {
		class Chair{
			void f1() {
				
			}
			Chair cc = new Chair();
			cc.f1();
		}
	}
}

class CarExample{
	
	public static void main(String[] args) {
		Car myCar = new Car();
		//instance inner class
		Car.Tire tire = myCar.new Tire();
		//static inner class
		Car.Engine engine = new Car.Engine();
		
		//local class는 method내에서 접근, 외부접근불가
		mycar.method();
	}
}