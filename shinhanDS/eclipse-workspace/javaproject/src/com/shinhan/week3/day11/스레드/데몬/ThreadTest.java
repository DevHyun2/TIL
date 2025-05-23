package com.shinhan.week3.day11.스레드.데몬;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

	public static void main(String[] args) {
		f4();
		System.out.println("main END");

	}
	
	//return 없을 때 : Runnable, 있을 때 : Callable
	private static void f4() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(int i=1 ; i<=100 ; i++) {
			int end = i;
			Future<Integer> result = service.submit(new Callable<Integer>() {

				public Integer call() throws Exception {
					
					int sum = 0;
					for(int j=1 ; j<=end ; j++) {
						sum += j;
					}
					System.out.println(Thread.currentThread().getName()
							+ ":" + end + "까지 합 ==>" + sum);
					return sum;
				}
			});
			try {
				Integer a = result.get();
				System.out.println("a= " + a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdown();
	}

	private static void f3() {
		
		String s = "JAVA"; //final
		final int score = 100;
		
		class LocalClass{
			
			void method1() {
				//score = 200;
				System.out.println(s);
			}
		}
		//score = 200;
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				//System.out.println(score);
				System.out.println(s);
				
			}
		};
	}

	private static void f2() {
		String[][] mails = new String[1000][3];
		int i = 1;
		
		for(String[] arr : mails) {
			arr[0] = "admin@my.com"; //누가
			arr[1] = "member"+i+"@my.com"; //누구에게
			arr[2] = "신상품이 입고 되었습니다."; //내용
			i++;
		}
		//MultiThread(5개)로 1000명의 이메일을 보내기
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		//내부class에서 지역변수에 접근(지역변수는 무조건 final)
		for(int index=1; index<1000 ; index++) {
			
			int seq = index; //기본형 - 값을 복사
			service.execute(new Runnable() {
				
				@Override
				public void run() {
					String message = 
							"쓰레드 이름: " + Thread.currentThread().getName()
							+ "\n from: " + mails[seq][0] 
							+ "\n To: " + mails[seq][1] 
							+ "\n 내용: " + mails[seq][2] 
							+ "\n------------------------";
					System.out.println(message);
				}
			});
		}
	}

	private static void f1() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true); //main끝 나면 같이 끝난다
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	