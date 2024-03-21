package com.shinhan.week2.day08.예외처리;

//예외 정의하기
public class ScoreException extends Exception{
	String message;
	ScoreException(String message){
//		this.message = message;
		super(message);
	}
	void print() {
		System.out.println("score는 70이상");
	}
}
