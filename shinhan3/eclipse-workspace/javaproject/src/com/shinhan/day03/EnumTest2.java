package com.shinhan.day03;

import java.util.Calendar;
import java.util.Scanner;

public class EnumTest2 {
	
	final static String SUCCESS = "성공";
	final static String FAIL = "실패";
	final static String BOOK = "이것이 자바다";
			
	public static void main(String[] args) {
		//loginCheck();
		getWeek();
	}

	private static void getWeek() {
		Calendar cal = Calendar.getInstance(); // 날짜 - 객체생성을 얻기
		//System.out.println(cal);
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1; // 0 ~ 11 +1
		int ww = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("년도 : " + yy);
		System.out.println("월 : " + mm);
		System.out.println("주 : " + ww);		
		
		Week week = null;
		
		switch(ww) {
		case 1 : week = Week.SUNDAY; break;
		case 2 : week = Week.MONDAY; break;
		case 3 : week = Week.TUESDAY; break;
		case 4 : week = Week.WEDNESDAY; break;
		case 5 : week = Week.THURSDAY; break;
		case 6 : week = Week.FRIDAY; break;
		case 7 : week = Week.SATURDAY; break;
		default : break;
		}
		System.out.println(week);
	}

	private static void loginCheck() {
		Scanner sc = new Scanner(System.in);
		
		Work result;
		
		System.out.print("ID PASS>>");
		String id = sc.next(); //.next() 단어기준
		String pass = sc.next();
		
		if(id.equals("firstzone") && pass.equals("1234")) {
			result = Work.SUCCES;
		}else {
			result = Work.FAIL;
		}
		System.out.println(result);
		sc.close();
	}

}
