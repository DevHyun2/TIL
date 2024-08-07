package com.shinhan.week2.day05;

//class : object를 만들기 위한 틀(template), 설계도
//object : class를 이용해서 만든 독립된 개체
//instance == object, new로 만든 실체
public class Car {
	//1. field(목적 : 다른 개체와 구별되는 특징, data 값 저장, 변수) 
	     //: static(class변수, object들의 공통 변수), non-static(instance변수, 멤버 변수) - new시에 자동으로 초기화 된다.
	static String company = "현대자동차"; //처음부터 값을 저장, class가 load시에 값이 할당된다.
	static int carCount;
	private String mode;
	int price;
	
	//2. constructor (method)...컴파일시에 정의가 없으면 자동으로 default 생성자(argument 없음)를 만들어준다.
		//객체 생성시 자동으로 호출된다. new Car();
		//생성자는 생성시 값 초기화가 목적이다.
		//매개변수 이름과 메머변수 이름이 충돌발생 -> 이를 구분하기 위해 현재객체를 this. 라고 사용한다.
		//생성자의 오버로딩(이름 같고 매개변수 사양이 다르다.) - 여러개 만듦
	Car(String mode, int price){ //파라미터 안 변수는 지역변수는 은닉으로 private 필요없음
		//함수이름(변수타입 매개변수) : 매개변수 = 지역(block)변수
		this.mode = mode;
		this.price = price;
		carCount++;
		System.out.println(carCount + "번째 자동차가 만들어 집니다.");
	}
	
	Car(String mode){ //파라미터 안 변수는 지역변수는 은닉으로 private 필요없음
		//함수이름(변수타입 매개변수) : 매개변수 = 지역(block)변수
		this(mode, 1000);
		
		/* this.mode = mode; 
		 * this.price = 1000; 
		 * carCount++; */
	}
	
	Car(int price){ //파라미터 안 변수는 지역변수는 은닉으로 private 필요없음
		//함수이름(변수타입 매개변수) : 매개변수 = 지역(block)변수
		this("모델명 미정", price);
		
		/*this.mode = "이름 미정";
		this.price = price;
		carCount++;*/
	}
	
	//3. 일반method - 기능구현{}, 문장들의 묶음 -> 반드시 return값의 타입을 정의한다. return값이 없으면 void
	void carInfoPrint(String title){
		System.out.println(title);
		System.out.println("company: " + company);
		System.out.println("carCount: " + carCount);
		System.out.println("model: " + mode);
		System.out.println("price: " + price);
	}
	
	//getter/setter는 이름규칙을 지킨다. 자바기술에 JavaBeans기술에서 사용하기 때문
	public String getModel() {
		return mode;
	}
	public int getPrice() {
		return price;
	}
	public void setModel(String mode) {
		this.mode = mode;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static String getCompany() {
		return company;
	}
	public static void setCompany() {
		Car.company = company;
	}
	static void carInfoPrint2(String title){
		System.out.println(title);
		System.out.println("company: " + company);
		System.out.println("carCount: " + carCount);
		//***사용 불가능(static method에서 non-staitc(instance변수) 사용불가
		//System.out.println("model: " + mode); //사용 불가능
		//System.out.println("price: " + price);// 사용 불가능
	}
	
	
	//4. block - 생성자 보다 우선
	{
		System.out.println("----instance block(객체생성시마다 수행)----");
	}
	static {
		System.out.println("----class load시 1회 수행----");
		//class load시 static변수 로직이 필요한 초기화시 사용가능
	}
	//5. inner class
	class Tier{
		//1.field
		String color;
		//2.constructor
		//3.method
		//4.block
		//5.inner class
	}
}
