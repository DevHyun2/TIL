package com.shinhan.week3.day14;

public class Prob2 {
	String str; 		//변환하려는 문자열
	int size; 			//변환될 문자열의 길이
	char fillChar;		//빈 공백을 채울 문자
	
	public static void main(String[] args) {
		System.out.println(leftPad("Samsung",10,'#'));
		System.out.println(leftPad("SDS",5,'*'));
		System.out.println(leftPad("Multicampus",5,'@'));
		
	}

	 

	private static String leftPad(String str, int size, char fillChar) {
		int fillCharNum = size - str.length();
		try {
			if(fillCharNum < 0) {
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");			
		}
		}catch(IllegalSizeException e){
			result = aa.getMessage();
		}
		return null;
	}



	public static String leftPad2(String str, int size, char fillChar){
		//구현하시오.....return값 수정할것 
		String newStr = "";
		while(str.length() != size) {
			if(str.length()<size) {
				newStr += fillChar;
				continue;
			}else {
				newStr = "문자열의 길이보다 size가 큽니다.";
			}
		}
		return newStr;
	}

	
	
}

//구현하시오.
class IllegalSizeException  {
	public IllegalSizeException() {
		
	}
	public IllegalSizeException() {
		super(message);
	}
}
