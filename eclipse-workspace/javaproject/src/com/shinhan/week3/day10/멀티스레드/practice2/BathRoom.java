package com.shinhan.week3.day10.멀티스레드.practice2;

//공유영역
public class BathRoom {
	
	//synchronized : 하나의 Thread가 이 메서드 수행중 Lock건다
	//즉, 다른 Thread가 접근불가, 하나의 Thread가 메서드 벗어나면 대기하고 있는 Thread가 들어온다.
	synchronized void use(String name) {
		System.out.println(name + "입장");
		System.out.println(name + "사용중");
		System.out.println(name + "퇴장");
		System.out.println("-----------");
	}
	
}
