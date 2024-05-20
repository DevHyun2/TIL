package com.shinhan.week2.day07;

public class VolTest {
	public static void main(String args[]) {
		//Volume은 interface이거나 추상 class로 만들 수 있다.
		//추상class였다면, 상속받아서 Speaker, Radio, TV
		//interface였다면, implements
		Volume[] v = new Volume[3];
		v[0] = new Speaker();
		v[1] = new Radio();
		v[2] = new TV();
		for (int i = 0; i < v.length; i++) {
			for (int j = 1; j <= 3; j++) {
				v[i].volumeUp(200);
			}
			for (int j = 1; j <= 3; j++) {
				v[i].volumeDown(300);
			}
			
		}
		
	}
	
}
