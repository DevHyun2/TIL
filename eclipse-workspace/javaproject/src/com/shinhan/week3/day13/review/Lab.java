package com.shinhan.week3.day13.review;

@FunctionalInterface
interface Operator {
	public int apply(int x, int y);
}

@FunctionalInterface
interface Function<T> {
	public double apply(T t);
}

class Student2 {
	private String name;
	private int englishScore;
	private int mathScore;

	public Student2(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}
}

public class Lab {
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(Operator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.apply(result, score);
		}
		return result;
	}

	static Student2[] students = { new Student2("홍길동", 90, 96), 
								   new Student2("신용권", 95, 93) };

	public static void main(String[] args) {
		f4();

	}

	private static void f4() {
//		double englishAvg = avg(s -> s.getEnglishScore(), students);
		//람다식 메서드 참조
		double englishAvg = avg(Student2::getEnglishScore, students);
		System.out.println("영어 평균 점수: " + englishAvg);

//		double mathAvg = avg(s -> s.getMathScore(), students);
		//람다식 메서드 참조
		double mathAvg = avg(Student2::getMathScore, students);
		System.out.println("수학 평균 점수: " + mathAvg);

	}

	private static double avg(Function<Student2> fc, Student2[] students) {
		
		int total = 0;
		for(Student2 st : students) {
			total += fc.apply(st);
		}
		
		return (double)total/students.length;
	}

	private static void f3() {
		// 최대값 얻기
		int max = maxOrMin((a, b) -> a >= b ? a : b);
		System.out.println("최대값: " + max);

		// 최소값 얻기
		int min = maxOrMin((a, b) -> a <= b ? a : b);
		System.out.println("최소값: " + min);
	}
}
