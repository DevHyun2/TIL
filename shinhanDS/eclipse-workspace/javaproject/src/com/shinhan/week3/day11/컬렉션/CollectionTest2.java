package com.shinhan.week3.day11.컬렉션;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest2 {

	public static void main(String[] args) {
		// Map(Key와 Value의 쌍) *키중복 불가, hashcode(), equals() 재정의: HashMap
		 														//	  TreeMap(순서있음,*Comparable구현), HashTable
		 														//	  HashTable(동기화(싱크로)가능)
		f4();
	}

	private static void f4() {
		TreeMap<String, Integer> treeMap = new TreeMap<>(); //기본 asc
		treeMap.put("apple1", 10);
		treeMap.put("apple4", 50);
		treeMap.put("apple2", 20);
		treeMap.put("apple5", 30);
		treeMap.put("apple3", 40);
		
		//print(treeMap, "original");
		//print2(treeMap, "original");
		print3(treeMap, "찾기");	
		System.out.println("-------------key디센딩");
		print2(treeMap.descendingMap(), "디센딩 Map");
		/*
		 * NavigableMap<String, Integer> datas = treeMap.descendingMap(); for(String key
		 * : datas.keySet()) { System.out.println(key + "==>" + treeMap.get(key));
		 }
		 */
	}

	private static void print3(TreeMap<String, Integer> treeMap, String title) {
		System.out.println("====" + title);
		System.out.println(treeMap.firstKey());
		System.out.println(treeMap.firstEntry());
		}
	
	private static void print2(NavigableMap<String, Integer> treeMap, String title) {
		System.out.println("====" + title);
		for(Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry + "==>" + entry.getValue());
		}
		
	}

	private static void print(TreeMap<String, Integer> treeMap, String title) {
		for(String key : treeMap.keySet()) {
			System.out.println(key + "==>" + treeMap.get(key));
		}
		
	}

	private static void f3() {
		TreeSet<Integer> scores = new TreeSet<>(); //기본 sort
		
		scores.add(87);
		scores.add(98);
		scores.add(76);
		scores.add(95);
		scores.add(80);
		
		print(scores, "Ascending");
		//print2(scores);
		
//		NavigableSet<Integer> descScoreSet = scores.descendingSet();
//		System.out.println("---- descending Sort");
//		for(Integer data : descScoreSet) {
//			System.out.println(data);
//		}
		
		print(scores.descendingSet(), "Descending");
		
		print(scores.tailSet(80,true), "TailSet"); //<=80
		
		print(scores.subSet(80, true, 90, true), "SubSet"); // 80<= ~ <=90
	}

	private static void print(Set<Integer> scores, String title) {
		System.out.println(title + "---- Sort");
		for(Integer data : scores) {
			System.out.println(data);
		}
		
	}

	
	private static void print2(TreeSet<Integer> scores) {
		//점수가 가장 낮은사람, 높은사람
		System.out.println("가장 낮은 점수: " + scores.first());
		System.out.println("가장 높은 점수: " + scores.last());
		
		//누구보다 낮은 점수
		System.out.println("95점 이하"+ scores.lower(95));
		System.out.println("95점 이상"+ scores.higher(95));
		System.out.println("94점 있으면 95 없으면 낮은애"+ scores.floor(94));
		System.out.println("96점 있으면 95 없으면 높은애"+ scores.ceiling(96));
		
	}

	private static void f2() {
		//파일 읽기 위한 변수 생성
		Properties pro = new Properties();

		//파일 읽기
		try {
			pro.load(CollectionTest2.class.getResourceAsStream("oracleDB.properties"));
			
			String driver =pro.getProperty("driver");
			String url =pro.getProperty("url");
			String username =pro.getProperty("username");
			String password =pro.getProperty("password");
			String myname =pro.getProperty("myname");
			String myname2 =pro.getProperty("myname2", "AAA");
			
			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(myname);
			System.out.println(myname2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void f1() {
		
		Map<String, Integer> map = new Hashtable<>();
		Thread t1 = new Thread() {
			public void run(){
				for(int i=1 ; i<=1000 ; i++) {
					System.out.println(getName() + " !!!! " + i);
					map.put(String.valueOf(i), i); //{"1":1,"2":2 ...}
				}
				
			}
		};
		Thread t2 = new Thread() {
			public void run(){
				for(int i=1 ; i<=1000 ; i++) {
					System.out.println(getName() + " #### " + i);
					map.put(String.valueOf(i), i); //{"1":1,"2":2 ...}
				}
				
			}

		};
		t1.start(); t2.start();
		try {
		t1.join(); //t1이 종료될 때 까지 기다림
		t2.join(); //t2이 종료될 때 까지 기다림
		}catch(InterruptedException e){
			
		}
		System.out.println("entry개수: " + map.size());
	}
}