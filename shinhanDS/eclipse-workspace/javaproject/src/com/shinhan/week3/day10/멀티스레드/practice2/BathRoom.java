package com.shinhan.week3.day10.멀티스레드.practice2;

//공유영역
public class BathRoom {
	
	//synchronized : 하나의 Thread가 이 메서드 수행중 Lock건다
	//즉, 다른 Thread가 접근불가, 하나의 Thread가 메서드 벗어나면 대기하고 있는 Thread가 들어온다.
	
	boolean isFirst = true;
	
	//동기화 메서드
	//**wait와 notify는 동기화 메소드 또는 블록에서만 호출할 수 있다.
	synchronized void use(String name) {
		
		if(isFirst && name.equals("김")) {
			isFirst = false;
			try {
				wait(); //다른 스레드가 들어올 수 있게 해준다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(name + "입장");
		System.out.println(name + "사용중");
		System.out.println(name + "퇴장");
		System.out.println("-----------");
		
		notifyAll(); //wait 상태의 스레드를 실행대기 상태로 돌린다.
	}
	
	//동기화 블럭
	void use2(String name) {
		
		synchronized (name) {
			System.out.println(name + "입장");
			System.out.println(name + "사용중");
			System.out.println(name + "퇴장");
			System.out.println("-----------");
		}
		
	}
	
}
