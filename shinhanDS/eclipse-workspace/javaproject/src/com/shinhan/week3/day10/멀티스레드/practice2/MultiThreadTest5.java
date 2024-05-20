package com.shinhan.week3.day10.멀티스레드.practice2;

public class MultiThreadTest5 {
	
	public static void main(String[] args) {
		//공유데이터
		BathRoom room = new BathRoom();
		
		//흐름3개 만듦
		BathRoomThread t1 = new BathRoomThread(room, "김");
		BathRoomThread t2 = new BathRoomThread(room, "박");
		BathRoomThread t3 = new BathRoomThread(room, "양");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
