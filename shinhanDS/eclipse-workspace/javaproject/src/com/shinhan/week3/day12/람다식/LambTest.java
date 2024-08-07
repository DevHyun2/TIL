package com.shinhan.week3.day12.람다식;

import com.shinhan.week3.da12.Student;

@FunctionalInterface
interface Calculable {
	double calc(double x, double y);
}

//구현class 
class MyCalculator implements Calculable{
	public double calc(double x, double y) {
		return x+y;
	}
}

class Computer {
	public static double staticMethod(double x, double y) {
		return x+y+100;
	}
	
	public static double instanceMethod(double x, double y) {
		return x+y+200;
	}
}

@FunctionalInterface
interface Comparable2{
	public abstract int compare(String a, String b);
}

interface Creatable{
	public Student create(String name, int score);
}

class Person {
	public Student getStudent(Creatable creatable, String name, int score) {
		return creatable.create("김",100);
	}
}


public class LambTest {

	public static void main(String[] args) {
		f5();

	}

	private static void f5() {
		Person p1 = new Person();
		
		Creatable creatable2 = new Creatable() {
			public Student create(String name, int score) {
				return new Student(name, score);
			}
		};
		
		
		Student s = p1.getStudent(creatable2, "홍길동1", 200);
		System.out.println(s);
	}

	private static void f4() {
		Student s = new Student("홍길동", 100);
		Student s2 = makeStudent("홍길동", 100);
		
	}

	private static Student makeStudent(String name, int score) {
		return new Student(name, score);
	}

	private static void f3() {
		String s1 = "b";
		String s2 = "a";
		
		//Comparable2 comp = (String a, String b) -> a.length() - b.length();
		//Comparable2 comp = (a,b) -> a.length() - b.length();
		Comparable2 comp = String::compareToIgnoreCase;//대소문자 상관없이 타입값 비교
		
		int result = comp.compare(s1, s2);
		System.out.println(result);
	}

	private static void f2() {
		System.out.println("1.구현class이용");
		MyCalculator a = new MyCalculator();
		System.out.println("result = " + a.calc(1, 2));
		
		System.out.println("2.익명 구현class이용");
		Calculable b = new Calculable() {
			public double calc(double x, double y) {
				return x-y;
			}
		};
		System.out.println("result = " + b.calc(1, 2));
		
		System.out.println("3.람다 표현식 이용");
		//Calculable c = (double x, double y) -> x*y;
		//Calculable c = (x,y) ->{return x*y;};
		//Calculable c = Computer::staticMethod;
		Computer computer = new Computer();
		//Calculable c = computer::instanceMethod;
		
		//System.out.println("result = " + c.calc(1, 2));
		
		
	}

	private static void f1() {
		Thread t1 = new Thread() {
			public void run() {System.out.println("Thread 구현");}
		};
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread구현....Runnable interface구현");
			}
		});
		//람다식
		Thread t3 = new Thread(() -> {
				System.out.println("Thread구현....Runnable interface구현");
		});
	}

}
