package com.shinhan.week2.day08.lab;

import java.util.Objects;

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}
	/* 조건1 */
	@Override
	public String toString() {
		return String.valueOf(first+second);
	}
	/* 조건2 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySum other = (MySum) obj;
		return first == other.first && second == other.second;
	}

}
