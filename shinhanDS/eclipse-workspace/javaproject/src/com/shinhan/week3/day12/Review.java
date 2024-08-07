package com.shinhan.week3.day12;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

//Collection(상위)

//List : add한 순서 있음, index가능, 중복가능 
//=> ArrayList(중간 삽입 및 삭제시 비효율적, 맨앞, 뒤 추가는 효율), 
//=> LinkedList(전, 후 데이터 주소가짐, 공간차지, 중간 삽입 및 삭제 효율적)
//=> Vector(동기화 지원, 멀테스레드 환경에 안정적)

//Set : 순서없음, 중복불가 =>HashSet(hashcode(), equals()), 
					 //=>TreeSet(add시 sort => compareTo and implements comparable  필요)

//Map : 키와 값의 쌍(entry), 키는 set이다. =>HashMap, HashTable, TreeMap, Properties
public class Review {

	public static void main(String[] args) {
		f6();

	}
	
	//Map
	private static void f6() {
		Map<Student, Product> map = new Hashtable<>();
		
		map.put(new Student("A", 300), new Product(1, "노트북1", "삼성", 200));
		map.put(new Student("A", 300), new Product(2, "노트북2", "삼성", 200));
		map.put(new Student("B", 200), new Product(3, "노트북3", "삼성", 200));
		map.put(new Student("C", 100), new Product(4, "노트북4", "삼성", 200));
		map.put(new Student("D", 400), new Product(5, "노트북5", "삼성", 200));
		
		print(map, "Key가 Student");
	}
	
	//메서드 이름, 매개변수 개수와 타입이 같으면 OverLoading아니다.
	private static void print(Map<Student, Product> map, String title) {
		System.out.println("======" + title);
		for(Student key : map.keySet()) {
			System.out.println(key + "==>" + map.get(key));
		}
		
		System.out.println("===========entryset");
		for(Entry<Student, Product> entry: map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void print(Map<String, Integer> map) {
		System.out.println("===========keyset");
		for(String s : map.keySet()) {
			System.out.println(s);
		}
		
		System.out.println("===========entryset");
		for(Entry<String, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}
	
	//Map
	private static void f5() {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("A", 100);
		map.put("A", 200); //덮어쓰기
		map.put("B", 100);
		map.put("C", 100);
		map.put("D", 100);
		
		print(map.keySet());
		print(map);
		
	}

	

	//Set
		private static void f4() {
			//comparable 필요
			Set<Student> data = new TreeSet<>();
			
			data.add(new Student("A", 70));
			data.add(new Student("A", 70));
			data.add(new Student("B", 80));
			data.add(new Student("C", 70));
			data.add(new Student("B", 80));
			
			print(data);
		}
	
	//Set
	private static void f3() {
		Set<Student> data = new HashSet<>();
		
		data.add(new Student("A", 70));
		data.add(new Student("A", 70));
		data.add(new Student("B", 80));
		data.add(new Student("C", 60));
		data.add(new Student("B", 80));
		
		print(data);
	}

	private static void print(Set<Student> data) {
		for(Student st : data) {
			System.out.println(st);
		}
		
	}

	//Set
	private static void f2() {
		Set<String> data = new HashSet<>();

		data.add("월");
		data.add("월");
		data.add("수");
		data.add("수");

		print(data);

	}

	//List
	private static void f1() {
//		List<String> data = new ArrayList<>();
//		List<String> data = new LinkedList<>();
		List<String> data = new Vector<>();

		data.add("월");
		data.add("월");
		data.add("수");
		data.add("수");

		print(data);
	}

	private static void print(Collection<String> data) {
		System.out.println("===========Collection<String>");
		for (String s : data) {
			System.out.println(s);
		}

	}

}
