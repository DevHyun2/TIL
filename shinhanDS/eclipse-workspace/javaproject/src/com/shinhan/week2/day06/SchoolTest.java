package com.shinhan.week2.day06;

//패키지내에 class가 존재하는지 찾는다.
//Modifier에 쓸 수 있는 것
//1.접근지정자 1개: public > protected > 생략 > private
//2.활용방법 여러개 가능: static, final, abstract, synchronized,...
public class SchoolTest {
	public static void main(String[] args) {
		Student a = new Student("홍길동", 20, 200201);
		String s = a.getName();
		a.setName("aaaa");

		new Teacher("이순신", 30, "JAVA");
		new Employee("유관순", 40, "교무과");
	}

}

//--------------------------------------------------------------------------------
class Student {
	// instance변수, 객체 생성시 자동으로 초기화된다.
	private String name;
	private int age;
	private int id;

	Student(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
		print();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	void print() {
		System.out.println("이름:" + name + " 나이:" + age + " 학번:" + id);
	}
}
//-------------------------------------------------------------------------------

class Teacher {
	private String name;
	private int age;
	private String subject;

	Teacher(String name, int age, String subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
		print();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	private void print() {
		System.out.println("이름:" + name + " 나이:" + age + " 담당과목:" + subject);
	}
}
//-----------------------------------------------------------------------------------------------
class Employee {
	String name;
	int age;
	String dept;
	
	Employee(String name, int age, String dept){
		this.name = name;
		this.age = age;
		this.dept = dept;
		print();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	void print() {
		System.out.println("이름:"+ name+ " 나이:"	+ age+ " 부서:"+ dept);
	}
}