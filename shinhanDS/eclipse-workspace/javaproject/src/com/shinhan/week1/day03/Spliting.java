package com.shinhan.week1.day03;

public class Spliting {

	public static void main(String[] args) {
		Spliting p = new Spliting();
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스";
		String[] addrArr = p.split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for(int i=0; i<addrArr.length; i++){
			System.out.print(addrArr[i] + " ");
		}		
	}

	public String[] split(String str, char separator){
		
		return null;		
	}
}
