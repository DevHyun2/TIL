package com.shinhan.week3.day10.제네릭;

import java.util.Arrays;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
class Student implements Comparable<Student>{
	String name;
	int score;
	
	@Override
	public int compareTo(Student obj) {
		//return name.compareTo(obj.name);//어센딩
		//return name.compareTo(obj.name)*-1
		
		//return score - obj.score; //어센딩 sort
		//return obj.score - score; //디센딩 sort
		
		//점수로 desc, 같은점수는 이름으로 asc
		if(obj.score == score) return name.compareTo(obj.name);
		return obj.score - score;
	}
}

public class GenericTest2 {
	
	
	
	public static void main(String[] args) {
		f5();

	}

	private static void f5() {
		Car[] arr = {
				new Car("A",100,"black"),
				new Car("C",200,"white"),
				new Car("C",100,"blue"),
				new Car("D",200,"black"),
				new Car("D",500,"pink"),
		};
		
		print(arr, "original");
		
		//Comparable interface 구현
		Arrays.sort(arr);
		print(arr, "이름으로 asc, 가격으로 desc, 색으로 asc");
		
		Arrays.sort(arr, (Car c1, Car c2)->{
			int result = c2.price - c1.price;
			if(result == 0) {
				int result2 = c1.model.compareTo(c2.model);
				if(result2 == 0) return c1.color.compareTo(c2.color);
				return result2;
			}
			return result;
		});
	}

	private static void f4() {
		Student[] arr = {
				new Student("A", 10),
				new Student("E", 50),
				new Student("E", 20),
				new Student("D", 20),
				new Student("B", 30)
		};
		//System.out.println("orginal: " + Arrays.toString(arr));
		print(arr, "original");
		//Comparable interface를 구현해야 Sort가능
		Arrays.sort(arr);
		print(arr, "Score Descending");
		//이미 구현된 sort기준을 변경
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				//이름으로 desc, 점수로 asc
				int result = o2.name.compareTo(o1.name);
				if(result == 0) return o1.score - o2.score;
				return result;
			}
		});
		print(arr, "이름으로 desc, 점수로 asc");
		
		//람다표현식
		Arrays.sort(arr,(o1, o2)-> {

				int result = o1.name.compareTo(o2.name);
				if(result == 0) return o2.score - o1.score;
				return result;
		});
		print(arr, "이름으로 asc, 점수로 desc");
	}
	
	static void print(Car[] arr, String title) {
		System.out.println("=========" + title + "==========");
		for(Car car : arr) {
			System.out.println(car);
		}
	}

	private static void f2() {
		//문자열 비교는 compareTo
		String[] arr = {"Hello", "Coffee", "java", "Dev"};
		System.out.println("orginal: " + Arrays.toString(arr));
		
		//정렬 아스키 코드값 : A(65), a(97)
		Arrays.sort(arr);
		System.out.println("Ascending Sort: " + Arrays.toString(arr));
		
		//2.익명class
		/*
		 * Arrays.sort(arr, new Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { // TODO Auto-generated
		 * method stub return o2.compareTo(o1); } });
		 */
		
		//3.람다표현식
		Arrays.sort(arr,(o1, o2)-> o2.compareTo(o1));
		
		//출력
		System.out.println("Descending Sort: " + Arrays.toString(arr));
	}

	private static void f1() {
		Integer[] arr = {100, 55, 20 ,50 ,30, 66};
		System.out.println("orginal: " + Arrays.toString(arr));
		
		//정렬
		Arrays.sort(arr);
		System.out.println("Ascending Sort: " + Arrays.toString(arr));
		
		//descending sort(super는 상위 extends는 하위만 사용가능)

		//1.구현class
//		Arrays.sort(arr, new MyDescendingSort());
		
		//2.익명class
		/*
		 * Arrays.sort(arr, new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { // TODO Auto-generated
		 * method stub return o2 - o1; } });
		 */
		//3.람다표현식
		Arrays.sort(arr,(o1, o2)-> o2-o1);
		
		
		//결과
		System.out.println("Descending sort: " + Arrays.toString(arr));
	}

}
