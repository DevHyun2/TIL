package com.shinhan.week3.day11.lab;

public class Student2 implements Comparable<Student2> {
	public String id;
	public int score;
	
	public Student2(String id, int score) { 
		this.id = id;
		this.score = score;
		}

	@Override
	public int compareTo(Student2 obj) {
		return score - obj.score;
	}

}
