package com.shinhan.week3.day13.챕터19;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		try {
			InetAddress a = InetAddress.getLocalHost();
			System.out.println(a.getHostName());
			System.out.println(a.getHostAddress());
			
			InetAddress[] arr = InetAddress.getAllByName("www.google.com");
			for(InetAddress addr : arr) {
				System.out.println(addr.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
