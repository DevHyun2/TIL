package com.shinhan.week3.day12.람다식.lab;

@FunctionalInterface
interface Function2<T> {
	public double apply(T t);
}

public class Student {
	private String name;
	private int englishScore;
	private int mathScore;

	public Student(String name, int englishScore, int mathScore) {
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

class Example4 {
	private static Student[] students = { new Student("홍길동", 90, 96), 
										  new Student("신용권", 95, 93) };

	// avg() 메소드 작성
	private static double avg(Function2<Student> s) {
		int sum = 0;
		for(Student st : students) {
			sum += st.getEnglishScore() + st.getMathScore();
		}
		double avg = (double)sum/students.length;
		return avg;
	}
	
	week_01/03_Binary_Search/Ps_2792_현상.java
	public static void main(String[] args) {
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("영어 평균 점수: " + englishAvg);

		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수: " + mathAvg);
	}

}