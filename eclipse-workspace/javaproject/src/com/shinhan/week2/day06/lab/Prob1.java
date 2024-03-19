package com.shinhan.week2.day06.lab;

public class Prob1 {
	
	public static void main(String[] args) {
		Entry e1=new Directory("tetD");
		e1.print();
		Entry e2=new File("testF",1000);
		e2.print();
		
	}

}
//abstract class : 추상메서드가 1개 이상 있는 class이다.
//자식은 반드시 추상메서드를 구현할 의무가 있다.
abstract class Entry{
	private String name;
	private int size;
	public Entry() {
		super();
	
	}
	public Entry(String name) {
		super();
		this.name = name;
	}
	public Entry(int size) {
		super();
		this.size = size;
	}
	public Entry(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	//추상메서드 : 정의는 있고, 구현은 없는 메서드
	public abstract void print();
	

}
class Directory extends Entry{
	Directory(String name){
		super(name);
	}

	@Override
	public void print (getName());
	
}

class File extends Entry{
	File(String name, int size) {
		super(name, size);
	}
	
	@Override
	public void print() {
		System.out.println(getName() + "(" + getSize() + ")");
		
	}
	
}


