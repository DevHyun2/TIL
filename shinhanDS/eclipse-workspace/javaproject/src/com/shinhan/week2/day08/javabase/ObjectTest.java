package com.shinhan.week2.day08.javabase;

import java.util.HashSet;

import com.shinhan.week2.day09.lombok.Book;

public class ObjectTest {

	public static void main(String[] args) {
		f8();

	}

	private static void f8() {
		
		
		
		// 제네릭스 : type을 제한한다.
		HashSet<Book> datas = new HashSet<Book>(); // 임포트 후 사용가능
		// datas.add(100);
		// datas.add("자바");
		// datas.add(new Book());
		datas.add(new Book("월",100,"r"));
		datas.add(new Book("월",100,"r"));
		datas.add(new Book("월",100,"r"));
		datas.add(new Book("월",100,"r"));
				
		System.out.println(datas.size()); // 중복은 들어가지 않음

		for (Book s : datas) {
			System.out.println(s); // 월 화 수
		}

	}

	private static void f7() {
		// 제네릭스 : type을 제한한다.
		HashSet<String> datas = new HashSet<String>(); // 임포트 후 사용가능
		// datas.add(100);
		// datas.add("자바");
		// datas.add(new Book());
		datas.add("월");
		datas.add("화");
		datas.add("수");
		datas.add("수");
		System.out.println(datas.size()); // 중복은 들어가지 않음

		for (String s : datas) {
			System.out.println(s); // 월 화 수
		}

	}

	private static void f6() {
		//HashSet(같은값이 들어오면 같은 바구니에 넣음): 순서가 없음, 중복이 안됨. - 주로 Key로 사용된다 
		HashSet datas = new HashSet(); //임포트 후 사용가능
		datas.add(100);
		datas.add("자바");
		datas.add(new Book());
		
		//코드가 좋지 않음
		for(Object obj : datas) {
			if(obj instanceof Integer) {
				
			}else if(obj instaceof String) {
				
			}else if(obj instanceof Book) {
				
			}
		}
		
	}

	private static void f5() {
		// Object를 상속받아서 만든 Dice
		Book obj1 = new Book("java", 100, "sin");
		Book obj2 = new Book("java", 100, "sin");
		System.out.println(obj1 == obj2); // 주소비교 false
		System.out.println(obj1.equals(obj2)); // 주소비교 false
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));

	}

	private static void f4() {
		// Object를 상속받아서 만든 Dice
		Dice obj1 = new Dice(100);
		Dice obj2 = new Dice(100);
		System.out.println(obj1 == obj2); // 주소비교 false
		System.out.println(obj1.equals(obj2)); // 주소비교 false
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));

	}

	private static void f3() {
		// Object를 상속받아서 만든 Integer
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer(100);
		System.out.println(obj1 == obj2); // 주소비교 false
		System.out.println(obj1.equals(obj2)); // 주소비교 내용비교로 Override함 true
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));

	}

	private static void f2() {
		// Object를 상속받아서 만든 Stirng
		String obj1 = new String("자바");
		String obj2 = new String("자바");
		System.out.println(obj1 == obj2); // 주소비교 false
		System.out.println(obj1.equals(obj2)); // 주소비교를 내용비교로 Override함 true
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));

	}

	private static void f1() {
		// Object는 모든 Object의 부모 class
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1 == obj2); // 주소비교 false
		System.out.println(obj1.equals(obj2)); // 주소비교 false
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));

	}

}
