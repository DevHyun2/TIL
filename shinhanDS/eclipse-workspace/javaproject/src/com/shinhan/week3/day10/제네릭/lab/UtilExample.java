package com.shinhan.week3.day10.제네릭.lab;

import com.shinhan.week3.day10.제네릭.lab.Pair.ChildPair;

public class UtilExample {

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println(age);

		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer childAge = Util.getValue(childPair, "홍삼순");
		System.out.println(childAge);

		Pair<String, String> pair2 = new Pair<>("홍길동", "35");
		String age2 = Util.getValue(pair2, "홍길동");
		System.out.println(age);
		/*
		 * OtherPair<String, Integer> otherPair = new OtherPair< >("홍삼원", 20);
		 * //OtherPair는 Pair를 상속하지 않으므로 컴파일 에러가 발생 int otherAge =
		 * Util.getValue(otherPair, "홍삼원"); System.out.println(otherAge);
		 */
	}
}
