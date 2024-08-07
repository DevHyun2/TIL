package com.shinhan.week3.day13.챕터18;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOTest {

	public static void main(String[] args) throws IOException {
		f7();

	}

	private static void f8() {
		
		
		
	}

	private static void f7() throws IOException {
		String fileName = "./src/com/shinhan/week3/day13/review/Lab2.java";

		FileReader fis;
		BufferedReader br; //속도를 높이기 위한 버퍼

		fis = new FileReader(fileName);// 파일열기 ....2byte씩 처리한다.
		br = new BufferedReader(fis);
		
		String i;
		while ((i = br.readLine()) != null) {
			System.out.println(i);
		}

		fis.close();
		
	}

	private static void f6() throws IOException {
		// 파일 출력
		//보조스트림 : DataOutputStream, DataInputStream
		String fileName = "AA2.txt";
		FileOutputStream fos = new FileOutputStream(fileName);
		DataOutputStream dos = new DataOutputStream(fos); // 보조스트림 : 다른 타입도 읽기

		dos.write(10);
		dos.write(20);
		dos.writeDouble(10.5);
		dos.writeDouble(20.5);
		dos.writeUTF("문자");
		fos.flush();
		fos.close();

		// 파일 읽기
		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream dis = new DataInputStream(fis);

		int a = dis.read();
		int b = dis.read();
		double c = dis.readDouble();
		double d = dis.readDouble();
		String s = dis.readUTF();

		System.out.println(a + b + c + d);
		fis.close();

	}

	private static void f5() throws IOException {
		// 파일에 출력
		String fileName = "AA2.txt";
		FileWriter fw = new FileWriter(fileName);
		fw.write("java\n");
		fw.write("자바끝");
		// 자원을 반납(close)하지 않으면 다른곳에서 이 파일을 사용할 수 없다.
		fw.close();

	}

	private static void f4() {
		// 모니터에 출력
		PrintStream moniter = System.out;
		moniter.println("모니터 출력");
	}

	private static void f3() throws IOException {
		// 글
		// 파일입력(읽기)
		String fileName = "./src/com/shinhan/week3/day13/review/Lab2.java";

		FileReader fis;

		fis = new FileReader(fileName);// 파일열기

		int i;
		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}

		fis.close();
	}

	private static void f2() throws IOException {
		// 이미지
		// 파일입력(읽기)
		String fileName = "./src/com/shinhan/week3/day13/review/Lab2.java";

		FileInputStream fis;

		fis = new FileInputStream(fileName);// 파일열기

		int i;
		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}

		fis.close();

	}

	private static void f1() throws IOException {

		// 키보드 입력
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);// 보조스트림 : 한글 깨짐을 방지 하기 위함
		int i;
		// read = 1byte = 한글깨짐
		while ((i = isr.read()) != 13) {// 아스키코드 값 : 13 = enter == 엔터하면 끝
			System.out.print((char) i);
		}

	}

}
