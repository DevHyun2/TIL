package com.shinhan.week3.day13;

import java.util.stream.IntStream;

//@FunctionalInterface
interface Makeable {
	public Student makeStudent(String name, int score);
}

class StudentMakeClass implements Makeable {
	public Student makeStudent(String name, int score) {
		return new Student(name, score);
	}
}

class MyButton implements Button.ClickListener {
	public void onClick() {
	}
}

class Button {
	// 정적 멤버 인터페이스(함수형 인터페이스)
	@FunctionalInterface
	public static interface ClickListener {
		void onClick();
	}

	private ClickListener clickListener;

	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public void click() {
		this.clickListener.onClick();
	}
}

interface Function {
	public double apply(double a, double b);
}

@FunctionalInterface
interface Operator {
	public int apply(int x, int y);
}

@FunctionalInterface
interface Function2<T> {
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

public class Review {
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(Operator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.apply(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		f6();
	}

	private static void f6() {
		Student2[] students = { new Student2("홍길동", 90, 96), new Student2("신용권", 95, 93) };
		//double englishAvg = avg(s -> s.getEnglishScore(), students);
		//람다식 메서드 참조
		double englishAvg = avg(Student2::getEnglishScore, students);
		System.out.println("영어 평균 점수: " + englishAvg);

		//double mathAvg = avg(s -> s.getMathScore(), students);
		//람다식 메서드 참조
		double mathAvg = avg(Student2::getMathScore, students);
		System.out.println("수학 평균 점수: " + mathAvg);

	}

	private static double avg(Function2<Student2> func, Student2[] students) {
		int total = 0;
		for (Student2 st : students) {
			total += func.apply(st);
		}

		return (double) total / students.length;
	}

	private static void f5() {
		// 최대값 얻기
		int max = maxOrMin((a, b) -> a >= b ? a : b);
		System.out.println("최대값: " + max);

		// 최소값 얻기
		int min = maxOrMin((a, b) -> a >= b ? b : a);
		System.out.println("최소값: " + min);

	}

	private static void f4() {
		double result = calc((x, y) -> (x / y));
		System.out.println("result: " + result);

		double result2 = calc((x, y) -> x + y);
		System.out.println("result: " + result2);
	}

	public static double calc(Function fun) {
		double x = 10;
		double y = 4;
		return fun.apply(x, y);
	}

	private static void f3() {
		Button btnOk = new Button();
		// 1.구현class사용
		// btnOk.setClickListener( new MyButton() );
		// 2.익명
		// btnOk.setClickListener( new Button.ClickListener() {
		// public void onClick() {}
		// } );
		// 3.람다식
		btnOk.setClickListener(() -> {
			System.out.println("Ok 버튼을 클릭했습니다.");
		});
		btnOk.click();

		Button btnCancel = new Button();
		btnCancel.setClickListener(() -> System.out.println("Cancel 버튼을 클릭했습니다"));
		btnCancel.click();

	}

	private static void f2() {
		Thread thread = new Thread(
				() -> IntStream.rangeClosed(1, 3).forEach(i -> System.out.println("작업 스레드가 실행됩니다.")));
		thread.start();

	}

	private static void f1() {
		Makeable make1 = (n, s) -> new Student(n, s);// 3.람다식
		Makeable make2 = Student::new;// 4.람다식 생성자 참조
		Makeable make3 = new Makeable() {
			public Student makeStudent(String name, int score) {
				return new Student(name, score);
			}
		}; // 2.익명class
		Makeable make4 = new StudentMakeClass();// 1.구현class

		Student s1 = make1.makeStudent("상호", 100);
		Student s2 = make2.makeStudent("상호2", 200);

		System.out.println(s1);
		System.out.println(s2);
	}

}