package com.shinhan.week1.day04.lab;

public class Employee {
	
	private String name;
	private String title;
	private String id;
	private int baseSalary;
	private int totalSalary;
	
	public Employee(String name, String title, int baseSalary) {
		super();
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		this.id = id;
		getTotalSalary();
	}

	public int getTotalSalary() {
			if(title.equals("부장")) {
				totalSalary = (int)(baseSalary + baseSalary * 0.25);
			}else if(title.equals("과장")) {
				totalSalary = (int)(baseSalary + baseSalary * 0.15);
			}else {
				totalSalary = (int)(baseSalary + baseSalary * 0.05);
			}
			return totalSalary;
		}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double getSalary(double bonus) {
		double salary = baseSalary + baseSalary * bonus;
		return salary;
	}

	public void print() {
		System.out.println(
				title 
				+ " 직급의 " 
				+ name 
				+ "씨의 본봉은 " 
				+ baseSalary 
	            + "원이고 총급여는 " 
	            + totalSalary 
	            + " 원입니다");
	}
	//부모가 물려준 함수를 재정의 : Override라고 한다.
	//이름같고 매개변수 같고 return같고 접근제한자가 같거나 더 넓어진다.
	//우클릭 -> source -> Override
	@Override
	public String toString() {
		return name + "(" + id + ") 사원의 기본급은 " + baseSalary + "원 입니다.";
	}
	
}
