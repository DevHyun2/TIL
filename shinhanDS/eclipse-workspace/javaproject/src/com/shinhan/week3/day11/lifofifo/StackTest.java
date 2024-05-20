package com.shinhan.week3.day11.lifofifo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		f3();

	}
	
	//변경불가
	private static void f3() {
		String[] arr = {"자바", "디비", "웹", "프레임워크"};
		
		List<String> alist = Arrays.asList(arr);
		
		List<String> alist2 = List.of("자바", "디비", "웹", "프레임워크");
		
		Set<String> aset = Set.of("자바", "디비", "웹", "프레임워크"); //중복 데이터는 불가
		
		Map<Integer, String> map = Map.of(1, "자바", 2, "디비", 3, "웹", 4, "프레임워크"); //중복 데이터는 불가
		
		List<String> alist3 = new ArrayList<>();
		alist3.add("A1");
		alist3.add("A2");
		alist3.add("A3");
		List<String> alist4 = List.copyOf(alist3);
		
		//alist.add("AAAA"); //오류
		//alist2.add("AAAA"); //오류
		System.out.println("===================List");
		for(String data : alist) {
			System.out.println(data);
		}
		System.out.println("====================Set");
		for(String data : aset) {
			System.out.println(data);
		}
		System.out.println("====================Map");
		for(Integer key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println("===================List 복사");
		for(String data : alist4) {
			System.out.println(data);
		}
	}

	//Queue : FIFO 선입선출
	private static void f2() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(100);
		queue.offer(300);
		queue.offer(400);
		queue.offer(200);
		queue.offer(500);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}

	//Stack : LIFO 후입선출
	private static void f1() {
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
