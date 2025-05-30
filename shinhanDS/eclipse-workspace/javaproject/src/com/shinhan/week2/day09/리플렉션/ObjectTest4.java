package com.shinhan.week2.day09.리플렉션;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.URL;

import com.shinhan.week2.day09.objecttest.ComputerVO;

public class ObjectTest4 {

	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		//new FileReader("src/com/shinhan/week2/day09/objecttest/ComputerVO.java"));
		Class<?> cls = ObjectTest4.class;
		URL url = cls.getResource("스크린샷 2024-03-21 100932.png");
		
		System.out.println(url.getPath());
		
		InputStream fis = cls.getResourceAsStream("oracle.properties");
		InputStreamReader isr = new InputStreamReader(fis);
		int i;
		try {
			while((i = isr.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void f2() {
		//new FileReader("src/com/shinhan/week2/day09/objecttest/ComputerVO.java"));
		Class<?> cls = ObjectTest4.class;
		URL url = cls.getResource("스크린샷 2024-03-21 100932.png");
		
		System.out.println(url.getPath());
		
		InputStream fis = cls.getResourceAsStream("스크린샷 2024-03-21 100932.png");
		InputStreamReader isr = new InputStreamReader(fis);
		int i;
		try {
			while((i = isr.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f1() {
		//리플렉션
		Class<ComputerVO> cls = ComputerVO.class;
		Constructor<?>[] cons = cls.getDeclaredConstructors();
		
		for(Constructor<?> cc : cons) {
			System.out.println(cc.getName());
			System.out.println(cc.getParameterCount()); //파마메타 갯수
			
			for(Parameter param : cc.getParameters()) {
				System.out.println(param.getName());
			}
			
			System.out.println("----------------------");
		}
	}

}
