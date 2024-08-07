package com.shinhan.week2.day09.정규표현식;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		f2();

	}

	private static void f2() {
		//이메일 패턴
		String regExp = "(\\w+)@(\\w+\\.\\w+)";
		String data = "aaaa wed0406@daum.net bbbb   zzzz@naver.com";
		
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		Pattern patt = Pattern.compile(regExp);
		Matcher mat = patt.matcher(data);
		while(mat.find()) {
			System.out.println(mat.group()); // == System.out.println(mat.group(0))
			System.out.println(mat.group(1));// 1번 괄호
			System.out.println(mat.group(2));// 2번 괄호
			System.out.println("------------");
		}
		
	}
	//+ : 1개이상
	//* : 0개이상
	//[] : 선택
	//[-] : 범위
	//{3} : 횟수
	//\\d : [0-9]같은 의미
	//\\w : [0-9A-Za-z]같은 의미
	//. : 임의의 문자1자
	private static void f1() {
		
		//제어문자 : \t \n \" ... 정해져 있음 .....\\는 \한개를 의미
		String regExp = "[01]{3}-[0-9]{3,4}-\\d{4}"; //전화번호 패턴
		String data = "010-1234-5678";
		
		Boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		String data2 = "자장면집 111-124-5678 "
				+ "스시집 010-2344-5234 "
				+ "dasdqwe 012-1424-5343  "
				+ "njqwer 010-5453-2341";
		Pattern patt = Pattern.compile(regExp);
		Matcher mat =patt.matcher(data2);
		while(mat.find()) { 
			System.out.println(mat.group());
		}
	}

}
