package com.shinhan.week1.day04;

public class Car {
	
	//1.field(특징, 변수, data저장, 멤버변수)
	//접근 지정자가(MOdifier) private인 경우 외부에서 접근이 불가능 하다.
	//접근 하고자 한다면 기능이 추가되어야 한다.
	//읽기 기능 : getter
	//쓰기 기능 : setter
	//JavaBeans기술의 규칙 : set대문자로시작, get대문자로시작
	
	private String company = "현대자동차";
	private String model;
	private String color;
	private int maxSpeed;
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	String getCompany() {
		return company;
	}
	
	
	//2.constructor(생성자)...생성자는 여러가지 방법을 정의(Overloading)
	Car() {
		System.out.println("default생성자...arg없음");
	}
	Car(String model, String color, int maxSpeed) {
		//super(); 부모 생성된다. 부모는 하나만
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	Car(String model, int maxSpeed, String color) {
		this(model, color, maxSpeed);//생성자 호출 (첫번째 줄에서만 가능), super() 부분이 수행안함
		System.out.println("-----------");
	}
	Car(int maxSpeed, String color) {
		this(null, color, maxSpeed);
	}
	Car(String model) {
		this(model, null, 0);
	}
	
	String first; // 필드, 멤버변수...new시에 자동으로 초기화
	
	//메서드(기능, 동작) 문장들의 묶음, return type 반드시 필요, return값 X -> void
	String carInfoPrint(String title) {
		String second = null; // 지역변수...반드시 초기화 하고 사용
		
		System.out.println(title);
		
		System.out.println("=======Car의 정보========");
		System.out.println("회사:" + company);
		System.out.println("모델:" + model);
		System.out.println("색상:" + color);
		System.out.println("최대속도:" + maxSpeed);
		System.out.println("first:" + first);
		System.out.println("second:" + second);
		
		powerOn();
		return "##########";
	}
	
	
	//우클릭 source -> generate get and set
	void powerOn() {
		System.out.println("=====powerOn=====");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}
	
}
