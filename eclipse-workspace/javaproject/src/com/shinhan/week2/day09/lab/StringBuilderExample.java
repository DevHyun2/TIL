package com.shinhan.week2.day09.lab;

import java.util.StringTokenizer;

public class StringBuilderExample {

	public static void main(String[] args) {
		String str = "아이디, 이름,패스워드";
		
		StringTokenizer st = new StringTokenizer(str,",| ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	
	public static void f2(String[] args) {
		 StringBuilder str = new StringBuilder();
		 for(int i=1; i<= 100; i++) {
			 str.append(String.valueOf(i));
		 }
		 System.out.print(str);
		}

	public static void f(String[] args) {
		String str = "";
		for (int i = 1; i <= 100; i++) {
			str += i;
		}
		System.out.println(str);
	}
}
