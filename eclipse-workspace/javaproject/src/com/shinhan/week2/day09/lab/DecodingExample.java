package com.shinhan.week2.day09.lab;

public class DecodingExample {

	public static void main(String[] args) throws Exception {
		byte[] bytes = { -20, -107, -120, -21, -123, -107 };
		String str = new String(bytes, "utf-8");
		String str2 = new String(bytes, "euc-kr");
		System.out.println("str: " + str);
		System.out.println("str2: " + str2);
	}
}
