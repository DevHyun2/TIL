package com.shinhan.week3.day10;

//변수(data) + 기능(method)
class Machine extends Object{
	Machine(){
		super();//숨겨져 있음
		System.out.println("Machine 기본생성자");
	}
	
}

//규격서 : 상수 + 추상메서드 + default, static, private
interface MyInterFace{
	public abstract void method1();
}

//상속(부모의 private를 제외한 모든 변수, 메서드 접근 가능. 
//수정(Override)과 추가(이름같고 매개변수가 다르다면 Overloading),추가(이름다름) 가능.
class CoffeeMachine extends Machine implements MyInterFace, AutoCloseable/*자동닫기 기능*/{
	
	CoffeeMachine(){
		super();//숨겨져 있음
		System.out.println("CoffeMachine 기본생성자");
	}

	public void close() throws Exception/*부모보다 더 작아지면 안됨*/ {
		System.out.println("AutoCloseable interface의 close() 재정의");
		
	}

	//추상메서드 구현
	public void method1() {
		System.out.println("method1.....구현class가 interface에서 정의한 추상메서드 구현");
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoffeeMachine [.....].....fiedl가 있다면 이용해서 정보를 문자열로 만들기");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return "Coffee".hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return "Coffee".equals("Coffee");
	}
	
}

public class Review {
	
	public static void main(String[] args) {
		
		try(CoffeeMachine coffee1 = new CoffeeMachine();/*자동 close*/
			CoffeeMachine coffee2 = new CoffeeMachine();) {
			coffee1.method1();
			coffee2.method1();
			
			System.out.println(coffee1); //toString 호출 
			System.out.println(coffee2); //toString 호출, 재정의 가능
			System.out.println(coffee1 == coffee2); //주소비교
			System.out.println(coffee1.equals(coffee2)); //주소비교 ,재정의 가능
			//coffee1.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
