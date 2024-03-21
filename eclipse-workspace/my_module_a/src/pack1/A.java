package pack1;

import pack2.B;
import pack3.C;

public class A {
	
	
	//메소드
	public void method() {
		System.out.println("A-method 실행");
		
		//B 클래스 사용
		B b = new B();
		b.method();
	}
	
	//메소드
	public C getC() {
		C c = new C();
		return c;
	}
}