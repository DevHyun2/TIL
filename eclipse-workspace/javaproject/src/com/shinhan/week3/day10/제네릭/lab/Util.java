package com.shinhan.week3.day10.제네릭.lab;

public class Util {

	public static <P extends Pair<K,V> K, V> V getValue(P pair, K k) {

		if (pair.getKey().equals(k))
			return pair.getValue();
		return null;
	}

	public static Integer getValue2(Pair<String, Integer> pair, String str) {

		if (pair.getKey().equals(str))
			return pair.getValue();
		return null;
	}

	public static <A, B> B getValue3(Pair<A, B> pair, String str) {

		if (pair.getKey().equals(str))
			return pair.getValue();
		return null;
	}

}
