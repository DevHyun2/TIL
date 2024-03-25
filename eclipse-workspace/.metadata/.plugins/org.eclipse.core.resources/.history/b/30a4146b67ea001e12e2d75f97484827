package com.shinhan.day10.c13_6_wildcardParameter;

public class Course {

	// <?> 와일드카드. 어떤것이든 들어올 수 있다.
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}

	// Student, HighStudent, MiddleStudent 가능
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}

	// Student, Person, Object
	public static void registerCourse3(Applicant<? super Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}

	// Worker, Person, Object
	public static void registerCourse4(Applicant<? super Worker> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
}
