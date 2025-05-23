package com.shinhan.week2.day08;

//interface 규격서
@FunctionalInterface //람다표현식이 가능한지 체크하는 어노테이션
interface JDBCInterface {
	//1.상수
	//2.추상메서드...구현 class가 반드시 구현할 의무가 있다.
	public abstract void connection();  //public abstract는 생략가능
	//3.default method : 구현 가능, 구현 class가 공통적으로 사용하는 기능, 재정의 가능
	//4.static method: 구현 가능, 구현 class가 공통적으로 사용하는 기능 , 재정의 불가능
	//5.private method : default method에서만 호출가능
}
//구현class 만들기
class OracleDB implements JDBCInterface{ 
	public void connection() { //추상메서드 반드시 구현
		System.out.println("Oracle DB 연결");
	}
}

class MySQLDB implements JDBCInterface {
	public void connection() { //추상메서드 반드시 구현
		System.out.println("MySQL 연결");
	}
}
public class Review {

	public static void main(String[] args) {
		work(new OracleDB());
		work(new MySQLDB());
		
		work(new JDBCInterface() {
			//익명 class로 재정의 하기
			
			@Override
			public void connection() {
				System.out.println("익명구현 class로 재정의");
				method();
				
			}
			void method() {
				System.out.println("메서드 추가함 호출안됨");
			}
		});
		work(()->System.out.println("람다표현식으로 메서드 재정의"));
	}

	private static void work(JDBCInterface db) {
		//implements한 class들 모두 부르기
		db.connection();
		
	}
}
