package com.shinhan.day05;

public class CarTest {

	public static void main(String[] args) {
		method3();

	}

	private static void method3() {
		System.out.println("Car 대수: " + Car.carCount);
		System.out.println("Car company: " + Car.company);
		//배열 변수 선언 + 생성
		Car[] arr = new Car[5];
	
		//1.객체사용시 객체 참조변수 선언 + 객체 생성 + 사용
		arr[0] = new Car("A모델", 1000);
		arr[1] = new Car("B모델", 2000);
		arr[2] = new Car("C모델", 3000);
		arr[3] = new Car("D모델");
		arr[4] = new Car(5000);
		System.out.println("생성후 Car 대수: " + Car.carCount);
		
		for(Car cc : arr) {
			cc.carInfoPrint("------------");
		}
	}

	private static void method1() {
		//static은 class소유 이므로 object생성과 관계없다.
		System.out.println("Car 대수: " + Car.carCount);
		System.out.println("Car company: " + Car.company);
		Car.carInfoPrint2("*********");
		int a = 100;
		method2();
	}
	private static void method2() {
		System.out.println("------------");
	}
}
