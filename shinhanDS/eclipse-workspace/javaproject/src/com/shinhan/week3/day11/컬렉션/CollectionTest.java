package com.shinhan.week3.day11.컬렉션;

import java.util.* ;

import com.shinhan.week3.day10.멀티스레드.practice.Account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode //field의 객체가 같으면 같다(중복체크용)
@ToString
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
class Car implements Comparable<Car>{
	String model;
	int price;
	
	//TreeSet을 이용하기 위한 compareTo 재정의
	public int compareTo(Car obj) {
		//가격 asc, 모델 desc
		if(price - obj.price == 0) return obj.model.compareTo(model);
		return price - obj.price;
	}
	
}

public class CollectionTest {

	public static void main(String[] args) {
		f10();

	}
	
	private static void f10() {//@EqualsAndHashCode 없으면 중복체크 안함
		Map<Car, Integer> data = new TreeMap<>(); //TreeMap : 정렬함
		
		data.put(new Car("A",1000), 1);
		data.put(new Car("A",1000), 2); //같은 key로 덮어 씌움
		data.put(new Car("B",3000), 3);
		data.put(new Car("C",1000), 4);
		data.put(new Car("B",3000), 5); //같은 key로 덮어 씌움
		
		System.out.println(data.containsKey(new Car("C",1000))); //특정 key 알아보기 .containsKey() => boolean으로 출력
		System.out.println(data.containsKey(new Car("C2",1000))); //특정 key 알아보기 .containsKey() => boolean으로 출력
		
		System.out.println(data.containsValue(4)); //특정 Value 알아보기 .containsValue() => boolean으로 출력
		System.out.println(data.containsValue(44)); //특정 Value 알아보기 .containsValue() => boolean으로 출력
		
		for(Car key : data.keySet()) {
			System.out.println(key + "=>" + data.get(key));
		}
	}
	
	private static void f9() {//@EqualsAndHashCode 없으면 중복체크 안함
		Map<Car, Integer> data = new HashMap<>();
		
		data.put(new Car("A",1000), 1);
		data.put(new Car("A",1000), 2); //같은 key로 덮어 씌움
		data.put(new Car("B",3000), 3);
		data.put(new Car("C",1000), 4);
		data.put(new Car("B",3000), 5); //같은 key로 덮어 씌움
		
		for(Car key : data.keySet()) {
			System.out.println(key + "=>" + data.get(key));
		}
	}
	
	private static void f8() {
		Map<Car, Integer> data = new HashMap<>();
		
		data.put(new Car("A",1000), 1);
		data.put(new Car("A2",2000), 2); //같은 key로 덮어 씌움
		data.put(new Car("B",1000), 3);
		data.put(new Car("C",1000), 4);
		data.put(new Car("B2",3000), 5); //같은 key로 덮어 씌움
		
		for(Car key : data.keySet()) {
			System.out.println(key + "=>" + data.get(key));
		}
	}

	private static void f7() {
		//배열(연속공간, 갯수 가변이 불가능)
		//Collection(갯수 변경이 가능) : List(순서있고, 중복있음), Set(순서없고, 중복없음), Map(Key와 Value의 쌍 = entry)
		
		List<Car> alist = new ArrayList<>(); //기본으로 10개 생성
		
		alist.add(0, new Car("A", 1000)); //(넣을 값)뒤에 추가하기, (위치 index, 넣을 값)원하는 위치에 넣기
		
		for(Car car :alist) {
			System.out.println(car);
			System.out.println("------------------");
		}
		
		Set<Car> blist = new HashSet<>(); //순서를 보장하지 못함
		
		blist.add(new Car("A", 1000));
		blist.add(new Car("B", 1000));
		blist.add(new Car("A", 2000));
		blist.add(new Car("C", 3000));
		
		for(Car car :blist) {
			System.out.println(car);
		}
	}

	private static void f6() {
		//Map : key 와 Value의 쌍(map.Entry), key는 Set으로 만듦(중복불가)
		//	    구현class => HashMap, HashTable, TreeMap, Properties
		Map<String, Integer> data = new HashMap<>();
		data.put("A", 99);
		data.put("A", 88);
		data.put("B", 100);
		data.put("C", 70);
		data.put("B", 99);
		data.put("D", 99);
		
		System.out.println("개수: " + data.size());
		System.out.println(data.get("A")); //이미 존재하는 key가 있으면 덮어씌운다.
		System.out.println(data.get("B")); //이미 존재하는 key가 있으면 덮어씌운다.
		
		//1.Key의 이름을 모른다면
		System.out.println("======1.keyset======");
		for(String key :data.keySet()) {
			System.out.println(key + "==>" + data.get(key)); 
		}
		
		//2.
		System.out.println("======2.entryset======"); //한 건 = entry
		Set<Map.Entry<String, Integer>> entrySet = data.entrySet();
		for(Map.Entry<String,Integer> entry :data.entrySet()) {
			System.out.println(entry + "==>" + entry.getValue()); 
		}
		
		System.out.println("======3.iterator======");
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry + "==>" + entry.getValue()); 
		}
	}
	
	private static void f5() {
		//Set : 순서 없고, 중복이 불가능 interface => 구현class : HashSet, TreeSet(순서있음)
		Set<Car> data = new TreeSet<>(); //Set > HashSet 상위객체
		
		data.add(new Car("A",1000));
		data.add(new Car("B",2000));
		data.add(new Car("C",3000));
		data.add(new Car("B",2000));
		data.add(new Car("C",5000));
		
		System.out.println("개수: " + data.size());
		
		//향상For
		System.out.println("=====일반for 불가=====");
		System.out.println("=====향상for====");
		for(Car s : data) {
			System.out.println(s);
		}
		
		System.out.println("=====반복자이용(Iterator)=====");
		Iterator<Car> it = data.iterator();
		
		while(it.hasNext()) {
			System.err.println(it.next());
		}
	}	
	
	private static void f4() {
		//Set : 순서 없고, 중복이 불가능 interface => 구현class : HashSet, TreeSet(순서있음)
		TreeSet<String> data = new TreeSet<>(); //Set > HashSet 상위객체
		data.add("A");
		data.add("D");
		data.add("C");
		data.add("C");//add안됨(중복check)
		data.add("A");//add안됨(중복check)
		
		System.out.println("개수: " + data.size());
		
		//향상For
		System.out.println("=====일반for 불가=====");
		System.out.println("=====향상for====");
		for(String s : data) {
			System.out.println(s);
		}
		
		System.out.println("=====반복자이용(Iterator)=====");
		Iterator<String> it = data.iterator();
		
		while(it.hasNext()) {
			System.err.println(it.next());
		}
	}	
	
	private static void f3() {
		//Set : 순서 없고, 중복이 불가능 interface => 구현class : HashSet, TreeSet(순서있음)
		Set<String> data = new HashSet<>(); //Set > HashSet 상위객체
		data.add("월");
		data.add("화");
		data.add("수");
		data.add("수");//add안됨(중복check)
		data.add("월");//add안됨(중복check)
		
		System.out.println("개수: " + data.size());
		
		//향상For
		System.out.println("=====일반for 불가=====");
		System.out.println("=====향상for====");
		for(String s : data) {
			System.out.println(s);
		}
		
		System.out.println("=====반복자이용(Iterator)=====");
		Iterator<String> it = data.iterator();
		
		while(it.hasNext()) {
			System.err.println(it.next());
		}
	}

	private static void f2() {
		//List : 순서있고 중복가능 => 구현class : ArrayList, LinkedList, Vector
		//ArrayList : 연속공간 필요, 공간이 부족하면 자동증가, 중간 삽입or삭제시 비효율적(당기거나 밀거나 이동이 있음)
		//LinkedList : 연속공간 불필요, 전요소나 후요소의 주소기억(공간차지), 중간 삽입or삭제시 효율적
		//Vector : Multi Thread에서 동기처리 가능
		
		List<String> data1 = new ArrayList<>();
		List<String> data2 = new LinkedList<>();
		List<String> data3 = new Vector<>();
		
		insertData(data1);
		insertData(data2);
		insertData(data3);
		
		displayData(data1, "Array");
		displayData(data2, "Linked");
		displayData(data3, "Vector");
		//일반For
		/*
		System.out.println("=====일반for====");
		for(int i=0 ; i<data.size() ; i++) {
			System.out.println(data.get(i));
		}
		
		//향상For
		System.out.println("=====향상for====");
		for(String s : data) {
			System.out.println(s);
		}
		*/
	}
	
	private static void displayData(List<String> data, String title) {
		System.out.println(title + "=====일반for====");
		for(int i=0 ; i<data.size() ; i++) {
			System.out.println(data.get(i));
		}
		
		//향상For
		System.out.println(title + "=====향상for====");
		for(String s : data) {
			System.out.println(s);
		}
		
	}

	private static void insertData(List<String> data) {
		data.add("월");
		data.add("화");
		data.add("수");
		data.add("목");
		
	}

	private static void f1() {
		//List : 순서있고 중복가능 => 구현class ArrayList, LinkedList, Vecto
		ArrayList data = new ArrayList();
		
		data.add("문자");
		data.add(123);
		data.add(new Account());
		
		String a = (String)data.get(0);
		int b = (Integer)data.get(1);
		Account acc = (Account)data.get(2);
	}

}
