package com.shinhan.week2.day08.lab;

public class ExceptionTest3 {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		String[] strArray = { "10", "2a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스를 초과했음");
			} catch (NumberFormatException e) {dcjr
				System.out.println("숫자로 변환할 수 없음");
			} finally {
				System.out.println(value);
			}
		}

	}

}
