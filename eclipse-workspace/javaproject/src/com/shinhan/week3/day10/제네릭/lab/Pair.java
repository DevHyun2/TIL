package com.shinhan.week3.day10.제네릭.lab;

public class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() { return key; }
	public V getValue() { return value; }

	public class ChildPair<K, V> extends Pair<K,V> {
		public ChildPair(K k, V v) {
		 super(k, v);
		}
	}
}