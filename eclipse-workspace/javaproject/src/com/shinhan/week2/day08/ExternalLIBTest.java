package com.shinhan.week2.day08;

import org.json.JSONObject;

import com.firstzone.pack1.Book;
import com.firstzone.pack2.Car;

public class ExternalLIBTest {

	public static void main(String[] args) {
		
		Book b = new Book("자바", 50000, "신용권");
		System.out.println(b);
		
		Car c = new Car("ABC", 2000);
		System.out.println(c);
		
		//json : javascript object notation : 자바스크립트 객체의 문자열
		String json = """
				{"name":"길동", age:20}
				""";
		JSONObject obj =new JSONObject(json);
		System.out.println(obj.get("name"));
		System.out.println(obj.get("age"));
	}

}
