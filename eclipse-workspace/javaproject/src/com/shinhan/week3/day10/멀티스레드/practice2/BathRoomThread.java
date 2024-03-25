package com.shinhan.week3.day10.멀티스레드.practice2;

public class BathRoomThread extends Thread {

	BathRoom room;
	String name;
	
	BathRoomThread(BathRoom room, String name){
		this.room = room;
		this.name = name;
	}
	
	public void run() {
		
		for(int i=1 ; i<=3 ; i++) {
			room.use(name);
		}
	}
	
}
