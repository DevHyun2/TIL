package com.shinhan.week3.day10.멀티스레드;

//2)이미 상속받은 부모가 있다면 자바는 멀티 상속불가 하므로 Runnable interface 구현
class Parent{
	
}


//Multihread : 1)Thread상속 2)run()메서드 재정의 3)new객체생성후 start()..run()수행됨
public class UpperCaseThread extends Parent implements Runnable{

	@Override
	public void run() {
		
		for(char i='A' ; i<='Z' ; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " i= " + i);
		}

	}
}
