package com.shinhan.week2.day09.math;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Mathtest {
	public static void main(String[] args) {
		f3();
	}

	private static void f6() {
		java.util.Date d1 = new java.util.Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(sdf.format(d1));
		
		//--------------------------------------
		
		//문자 -> 날짜
		String s = "2024/03/22"; 
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		try {
			java.util.Date d2 = sdf2.parse(s);
			java.sql.Date d3 = new java.sql.Date(d2.getTime());
			System.out.println(d2);
			System.out.println(d3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Dateutil.getUtilDate(s));
		System.out.println(Dateutil.getSQLDate(s));
	}

	private static void f5() {
		int a = 1234567890;
		DecimalFormat format = new DecimalFormat("###,###,###");
		
		System.out.println(format.format(a));
	}

	private static void f4() {
		LocalDateTime d = LocalDateTime.now();
		LocalDate d2 = LocalDate.now();
		System.out.println(d);
		System.out.println(d2);
		
		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		System.out.println(d.getDayOfMonth());
		System.out.println(d.getHour());
		System.out.println(d.getDayOfWeek());
	}

	private static void f3() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.HOUR));
		
	}

	private static void f2() {
		DateTo d1 = new DateTo();
		java.util.Date d2 = new java.util.Date(); //원래있는 유틸과 class이름이 같을 때 유틸사용법
		System.out.println(d2);
		System.out.println(1900 + d2.getYear()); //잘 쓰지 않음
		System.out.println(d2.getTime());
		
		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		java.sql.Date d4 = new java.sql.Date(124,2,22);//defricate
		
		System.out.println(d3);
		System.out.println(d4);
	}

	private static void f1() {
		double a = 5.9;
		
		System.out.println(java.lang.Math.ceil(a));
		System.out.println(java.lang.Math.floor(a));
	}
}
