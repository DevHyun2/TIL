package com.shinhan.week3.day10.멀티스레드.practice2;

public class MultiThreadTest5 {
	
	public static void main(String[] args) {
		BathRoom room = new BathRoom();
		BathRoomThread t1 = new BathRoomThread(room, "김");
		BathRoomThread t2 = new BathRoomThread(room, "박");
		BathRoomThread t3 = new BathRoomThread(room, "양");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
