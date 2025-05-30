package com.shinhan.week2.day09;

import java.util.Properties;
import java.util.StringTokenizer;

public class ObjectTest2 {

	public static void main(String[] args) {
		//System.out.println("1.main시작");
		f6();
		//System.out.println("4.main끝");
	}

	private static void f6() {
		String str = "컴퓨터 커피@지갑, 마이크"; 
		String[] arr = str.split("@|,| "); //공백도 한글자로 포함
		
		System.out.println("배열개수: " + arr.length);
		for(String s : arr) {
			System.out.println(s);
		}
		System.out.println("---------------------");
		
		StringTokenizer st = new StringTokenizer(str, "@|,| "); //공백은 토큰으로 안침
		System.out.println("토큰개수: " + st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f5() {
		//StringBuilder, StringBuffer는 직접문자열 할당 불가
//		StringBuilder s1 = "자바"; 
		StringBuilder s1 = new StringBuilder("자바");
		StringBuffer s2 = new StringBuffer("자바");
		
		System.out.println(System.identityHashCode(s1));//주소그대로
		
		s1.append("!!!!!");//맨뒤에 추가
		s1.insert(0, "####");//어떤 자리에 추가
		
		System.out.println(s1);
		System.out.println(System.identityHashCode(s1));//주소그대로
	}

	private static void f4() {
		String s1 = "자바";
		String s2 = new String("자바");
		
		byte[] arr = {65, 66, 67, 97, 98, 99}; //ABCcabc
		String s3 = new String(arr);
		
		char[] arr2 = {'가','나','다'};
		String s4 = new String(arr2);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(System.identityHashCode(s4));//주소
		s4 += "!!!!";
		System.out.println(System.identityHashCode(s4));//주소바뀜 -> 메모리 낭비로 모바일프로그램에선 String 쓰지않음 -> Stringbuilder나 StringBuffer 사용
	}

	private static void f3() {
		
		//System.out.println(System.getProperty("java.version"));
		
		//Properties는 Map을 구현 = (key, value)를 가짐  //.keyset() 키 들을 얻어라
		//Properties key는 Set으로 만들어짐
		//Set<Object>
		//key가 Stirng이었음 -> Properties(키가 Object)
		//				   <-
		Properties ps = System.getProperties();
		for(Object key : ps.keySet()) {
			String value = System.getProperty((String)key);
			System.out.println(key + "-->" + value);
		}
		
	}

	private static void f2() {
		
		long startTime = System.nanoTime();
		int total = 0;
		for(int i=1;i<10000;i++) {
			total += i;
		}
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime + "ns");
		
	}

	private static void f1(int j) {
		System.out.println("2.f1시작");
		
		//if(j == 0 ) return; //함수 빠지기
		//if(j==0) System.exit(0); //일반적으로 0은 정상종료, -1은 오류를 의미, 아무곳에 exit는 바람직하지 않다.
		
		try {
		int i = 10/j;
		} catch(Exception e) {
			System.out.println("에러" + e.getMessage());
		}
		System.out.println("3.f1끝");
		
	}

}
