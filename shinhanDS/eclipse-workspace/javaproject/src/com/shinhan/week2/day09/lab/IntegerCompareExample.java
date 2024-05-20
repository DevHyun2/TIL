package com.shinhan.week2.day09.lab;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

public class IntegerCompareExample {
	
	public static void main(String[] args) {
		
		//^(캐럿) : 시작 
		//[^] : 제외
		//$ : 끝
		 String id = "5Angel1004z";
//		 String regExp = "^[0-9][0-9A-Za-z]{8,12}";
		 String regExp = "^[0-9]\\w{8,12}z$";
		 boolean isMatch = Pattern.matches(regExp, id);
		 if(isMatch) {
		 System.out.println("ID로 사용할 수 있습니다.");
		 } else {
		 System.out.println("ID로 사용할 수 없습니다.");
		 }
		}
	
	
	
	
	public static void f4(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		Date d = new Date();
		System.out.println(sdf.format(d));
	}
	
	
	
	public static void f3(String[] args) {
		double d = Math.random();
		System.out.println(d);
		
		Random r = new Random();
		double d2 = r.nextDouble(10); //(10): 0~10 사이 double
		System.out.println(d2);
		
		int i = r.nextInt(10); //(10): 0~10 사이 int
		System.out.println(i);
	}
	
	
	public static void f2(String[] args) {
		 Integer obj1 = 100;
		 Integer obj2 = 100;
		 Integer obj3 = 128;
		 Integer obj4 = 128;
		 
		 //값의 범위가 -128~127이면 ==은 값을 비교하면 그 이외에는 번지를 비교하기 때문
		 
		 System.out.println( obj1 == obj2 );
		 System.out.println( obj3 == obj4 );
		 System.out.println(obj1.equals(obj2));
		}
}
