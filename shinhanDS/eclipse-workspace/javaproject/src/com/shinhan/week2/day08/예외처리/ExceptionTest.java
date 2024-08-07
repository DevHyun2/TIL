package com.shinhan.week2.day08.예외처리;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {

	public static void main(String[] args) {
		// method1(0);
		// method1(10);
		try {
			method7();
		} catch (FileNotFoundException|ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------메인 종료");
	}

	private static void method7() throws IOException, ClassNotFoundException {
		FileReader fi = new FileReader("src/com/shinhan/week2/day09/lombok/Book.java");
		
		int i;
		while((i = fi.read()) != -1) {
			System.out.print((char)i);
		}
		fi.close();
	}

	private static void method6() {
		try(FileReader fi = new FileReader("src/com/shinhan/week2/day09/lombok/Book.java")) {
			
			int i;
			while((i = fi.read()) != -1) {
				System.out.print((char)i);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fi.close();
	}

	private static void method5() {
		FileReader f1 = null;
		int i;

		try {
			f1 = new FileReader("src/com/shinhan/week2/day09/lombok/Book.javaaa");
			while ((i = f1.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음: " + e.getMessage());
		} // FileNotFoundException
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //에러 과정 확인
		} finally {
			try {//f1.close 파일반납 필수
				if(f1!=null)f1.close(); //if하지 않을거면 catch블럭 하나 더 추가 해서 NullPointException
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("****************");
	}

	private static void method4() {
		// 하나의 메서드에서 혹은 class에서 같은 이름의 class를 이용하는 경우
		// 같은 패키지를 먼저 검색
		// 다른 패키지는 패키지이름.class이름 으로 사용
		com.shinhan.week2.day09.lombok.Book b = new com.shinhan.week2.day09.lombok.Book();
		System.out.println(b);
		try {
			Class mybook = Class.forName("com.shinhan.week2.day09.lombok.Book");
			System.out.println(mybook.getName());
			System.out.println(mybook.getSimpleName());
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("*****************");
	}

	private static void method3() throws IOException {
		// 2.떠넘기기 throws
		InputStream input = System.in;

		int data = input.read();
		System.out.println("IO오류");

	}

	private static void method2() {
		// 2)일반 Exception...Runtime Exception이 아닌
		// 반드시 Exception 처리를 해야한다.
		// 1.직접 오류 수정 2.떠넘기기(나를 부른곳으로 떠넘기기)
		InputStream input = System.in;
		// 1.직접 오류 수정
		try {
			int data = input.read(); // IOException...컴파일시에 체크
			System.out.println((char) data);
		} catch (IOException e) {
			System.out.println("IO오류");
		}
	}

	private static void method1(int count) {
		// 예외 1)Runtime Exception...실행시 오류 발생, 자동으로 JVM이 Exceotion 객체를 생성해서 Exception발생한
		// 곳으로 준다 2)일반 Exception
		// 1)
		int score = 100;
		int[] arr = new int[10];
		String s = "백";

		// if(count==0) return;
		// 비즈니스 로직과 에러확인 로직이 섞여서 권장하지 않음.

		// try ~ catch : 오류처리로직과 비즈니스로직 을 분리할 수 있음
		try {
			System.out.println("평균: " + score / count); // ArithmeticException

			arr[9] = 99; // NullPointerException

			System.out.println(arr[9]); // ArrayIndexOutOfBoundsException

			System.out.println(Integer.parseInt(s) + 200); // NumberFormatException

		} catch (ArithmeticException ex) {
			// Exception 처리함....프로그램 중단없이 계속 진행
			System.out.println("연산오류......" + ex.getMessage()); // .getMessage() 오류 메세지 받기

		} catch (ArrayIndexOutOfBoundsException ex) {
			// Exception 처리함....프로그램 중단없이 계속 진행
			System.out.println("연산오류......" + ex.getMessage()); // .getMessage() 오류 메세지 받기

		} catch (NullPointerException ex) {
			// Exception 처리함....프로그램 중단없이 계속 진행
			System.out.println("연산오류......" + ex.getMessage()); // .getMessage() 오류 메세지 받기

		} catch (Exception ex) { // 상위에 있는 Exception은 마지막에 작성
			// Exception 처리함....프로그램 중단없이 계속 진행
			System.out.println("연산오류......" + ex.getMessage()); // .getMessage() 오류 메세지 받기

			ex.printStackTrace(); // .printStackTrace() 오류를 보여줌

		} finally {
			System.out.println("오류가 있거나 없거나 무조건 수행하는 업무(finally)");

		}
		System.out.println("--------------------------");
	}

}
