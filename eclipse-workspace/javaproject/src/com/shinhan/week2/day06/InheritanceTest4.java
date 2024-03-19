package com.shinhan.week2.day06;

class Vehicle {
	abstract void run();//run 함수 구현 { } : 
		//추상(abstract) : 정의는 있고 구현은 없다 { }가 없다, 구현은 자식class에서 한다.
		//abstract method : 정의는 있고 구현은 없다.
		//abstract class : class안에 추상메서드가 하나라도 있다. //객체생성 불가
		//System.out.println("부모의 run메서드");
		//추상메서드를 상속받은 자식은 반드시 추상메서드를 구현할 의무가 있다.
	void print() {
		System.out.println("부모...일반메서드");
	}
}

abstract class Truck extends Vehicle {
	abstract void run(); //추상메서드
	void print2() {
		System.out.println("구현한 메서드");
	}
}

class Truck2 extends Truck{
	void run() {
		System.out.println("추상메서드는 반드시 자식이 구현할 의무가 있다.");
	}
}


class Bus extends Vehicle {
	void run() {//run 함수 구현 재정의 { } : 
		System.out.println("(Bus)자식override... run메서드");
	}
}

class Taxi extends Vehicle {
	void run() {
		System.out.println("(Taxi)자식override... run메서드");
	}
}

class Driver {
	void drive(Vehicle vv) {
		vv.run();
	}
}

class Tire {
	void roll() {
		System.out.println("부모가 정의 roll");
	}
}

class HankookTire extends Tire {
	void roll() {
		System.out.println("HankookTire가 정의 roll");
	}
}

class KumhoTire extends Tire {
	void roll() {
		System.out.println("KumhoTire가 정의 roll");
	}
}

class Car {
	Tire tire;
	Car(Tire tire) {
		this.tire = tire;
	}
	void go() {
		tire.roll();
	}
}

public class InheritanceTest4 {
	
	public static void main(String[] args) {
		System.out.println("---------매개변수의 다형성");
		Driver driver = new Driver();
		//매개변수 다형성
		driver.drive(new Bus());
		driver.drive(new Taxi());
		driver.drive(new Vehicle());

		
		System.out.println("---------field의 다형성");
		Car car1 = new Car(new HankookTire());
		Car car2 = new Car(new KumhoTire());
		car1.go();
		car2.go();
	}
}
