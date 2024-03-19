package com.shinhan.week1.day03;

public class 배열테스트2 {

	public static void main(String[] args) {
		System.out.println("문자열에 특정문자 변경하는 테스트");
		System.out.println("-------------Sample 1 --------------");
		String str1=myReplace("hello world",'l','*');
		System.out.println(str1);
		
		System.out.println("-------------Sample 2 --------------");
		String str2=myReplace("hello world",' ','-');
		System.out.println(str2);
		
		System.out.println("-------------Sample 3 --------------");
		String str3=myReplace("hello world",'a','*');
		System.out.println(str3);

	}
	
	public static String myReplace(String str, char oldChar, char newChar){
		
		String temp = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == oldChar) {
				temp += newChar;

			} else {
				temp += str.charAt(i);
			}
		}
		return temp;
	}

}
