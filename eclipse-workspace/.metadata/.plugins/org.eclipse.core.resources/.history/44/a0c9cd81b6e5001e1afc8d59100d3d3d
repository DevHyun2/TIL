package com.shinhan.day03;

import java.util.Arrays;

//try , catch 사용

public class ReferenceTest {
	
	public static void main(String[] args) {
		//call(null);
		//call2();
		//call3();
		call4();
	}

	private static void call4() {
		String subject = "이것이 자바다 저자는 신용권, 임경균@최재명";
		System.out.println("replace:" + subject.replace("자바", "JAVA")); //문자열 바꾸기 - 일시적
		System.out.println("원본불변:" + subject); //원본 불변
		System.out.println("replace:" + subject.indexOf("자바")); //특정 문자열 index 찾기 .indexOf
		
		String[] arr = subject.split(",|@| "); //" "공백으로 문자열 나누기 .split
		System.out.println(Arrays.toString(arr)); //배열 출력 방법 import 필요
	}

	private static void call3() {
		String subject = "이것이 자바다";
		
		System.out.println("length:"+ subject.length());
		System.out.println("substring:"+ subject.substring(4)); //문자열 자르기 .substring
		System.out.println("substring:"+ subject.substring(4,6)); //문자열 자르기 (시작,끝)
		System.out.println("chatAt:" + subject.charAt(0)); //문자열 추출 .charAt
		
		for(int i=0;i<subject.length();i++) {
			System.out.println("chatAt:" + subject.charAt(i)); // 한글자씩 추출
		}
		
	}

	private static void call2() {
		String s1 = "자바";
		String s2 = "자바";
		String s3 = new String ("자바");
		String s4 = new String ("자바");
		
		//String은 고정문자열이다.
		s1 += "프로그램";
		s2 += "프로그램"; // 주소가 달라진다.
		
		System.out.println(s1==s2?"주소같다":"주소다르다");
		System.out.println(s3==s4?"주소같다":"주소다르다");
		System.out.println(s1.equals(s2)? "내용같다":"내용다르다");
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
	}

	private static void call(String s) {
		
		int a = 10; //지역 변수 초기화 -> int a; (X)
		//String s = null; //null은 정의된 값이 없다를 의미한다.
		//String s = "자바";
		
		System.out.println("기본형연습: " + a); //지역변수 초기화 후 사용가능
		System.out.println("참조형연습: " + s); 
		
		try {
			//Exceoption 발생 가능성이 있는 문장들
			System.out.println("참조형연습: " + s.length()); //Null Pointer Exception
		}catch(NullPointerException aa) {
			System.out.println(aa.getMessage());
			System.out.println("null은 정의된 값이 없다를 의미한다. null은 length 불가");
		}
		System.out.println("Exception발생시 프로그램 중단된다. 복구가능");
	}
}
