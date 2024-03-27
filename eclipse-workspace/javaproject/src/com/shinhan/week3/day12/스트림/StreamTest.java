package com.shinhan.week3.day12.스트림;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import com.shinhan.week3.da12.Product;
import com.shinhan.week3.da12.Student;

public class StreamTest {

	public static void main(String[] args) throws URISyntaxException, IOException {
		f8();

	}
	
	//현재 클래스에서 파일 읽기 및 파일로부터 스트림 얻기
	private static void f8() throws URISyntaxException, IOException {
		//같은 경로에 있는 파일 불러오기
		URI uri = StreamTest.class.getResource("data.txt").toURI();
		//Path로 변환
		Path path = Paths.get(uri);
		//stream 
		Files.lines(path).forEach(line->{System.out.println(line);});
		
	}

	private static void f7() {
		IntStream.range(1,6).forEach(i->System.out.println(i)); //1~5까지 i가 들어감
		System.out.println("------------------");
		IntStream.rangeClosed(1,6).forEach(i->System.out.println(i)); //1~6까지 i가 들어감
		
	}

	private static void f6() {
		String[] arr = {"홍길동","심은정","정민교"};
		int[] scores = {100,99,88,66};
		
		Arrays.stream(arr).forEach(name->System.out.println(name));
		double avg = Arrays.stream(scores).average().getAsDouble();
		
		System.out.println(avg);
	}

	private static void f5() {
		List<Product> list = new ArrayList<>();
		//		  	1<= x <6
		IntStream.range(1, 6).forEach(i->{
			Product p = new Product(i, "상품"+i, "멋진회사",(int)(Math.random()*10000));
			list.add(p);
		});;
		//내부 반복자 이용 출력
		list.stream().forEach(p->System.out.println(p));
		//내부 반복자 이용 가격합계 구하기
		int total = list.stream().mapToInt(p->p.getPrice()).sum();
		System.out.println(total);
	}

	private static void f4() {
		List<Student> data = new ArrayList<>();
		
		data.add(new Student("A", 100));
		data.add(new Student("C", 400));
		data.add(new Student("A", 100));
		data.add(new Student("D", 200));
		data.add(new Student("B", 100));
		
		//map : 변형하다
		double avg = data.stream().mapToInt(s->s.getScore()).average().getAsDouble();
		System.out.println(avg);
		System.out.println(900/5.0);
	}

	private static void f3() {
		List<String> data = new ArrayList<>();
		
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		
		//내부 반복자(Stream)
		System.out.println("***내부***");
		data.stream().forEach(a->System.out.println(a)); //.forEach(consumer)(들어가는거 O 나오는거 X)
		
		//**병렬처리
		//List에서 Multi Thread 수행...
		System.out.println("**병렬***");
		data.parallelStream().forEach(b->{System.out.println(b + "====== Thread이름: " + Thread.currentThread().getName());});
	}
	
	private static void f2() {
		Set<String> data = new HashSet<>();
		
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		
		//내부 반복자(Stream)
		System.out.println("***내부***");
		data.stream().forEach(a->System.out.println(a)); //.forEach(consumer)(들어가는거 O 나오는거 X)
		
		//**병렬처리
		//Set에서는 main에서 한번에 처리함...
		System.out.println("**병렬***");
		data.parallelStream().forEach(b->{System.out.println(b + "====== Thread이름: " + Thread.currentThread().getName());});
	}
	
	private static void f1() {
		Set<String> data = new HashSet<>();
		
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		
		//외부 반복자(Iterator)
		for(String s : data) {
			System.out.println(s);
		}
		
	}

}
