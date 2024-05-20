package com.shinhan.week3.day11.lab;

import java.util.Objects;

public class Student {
	public int studentNum;

	public String name;

	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	//여기에 코드를 작성하세요
	@Override
	public int hashCode() {
		return Objects.hash(studentNum);
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Student other = (Student) obj;
	    return studentNum == other.studentNum;
	}
	
}
