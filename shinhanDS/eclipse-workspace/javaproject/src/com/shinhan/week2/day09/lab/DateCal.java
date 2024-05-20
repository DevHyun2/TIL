package com.shinhan.week2.day09.lab;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

//올해 12월 31일까지 며칠 남았는지 구하기
public class DateCal {
	public static void main(String[] args) {
		LocalDateTime startDateTime = LocalDateTime.now();

		LocalDateTime endDateTime = LocalDateTime.of(startDateTime.getYear(), 12, 31, 0, 0, 0);
		
		LocalDateTime happyNew = LocalDateTime.of(startDateTime.getYear(), 1, 1, 0, 0, 0);

		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		
		long remainDay2 = startDateTime.until(happyNew, ChronoUnit.DAYS);
		
		System.out.println("남은 일자: " + remainDay);
		System.out.println("남은 일자: " + remainDay2);
	}
}
