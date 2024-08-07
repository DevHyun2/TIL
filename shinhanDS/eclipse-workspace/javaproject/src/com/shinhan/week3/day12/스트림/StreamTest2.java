package com.shinhan.week3.day12.스트림;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.shinhan.week3.da12.Product;
import com.shinhan.week3.da12.Student;
public class StreamTest2 {

	static List<Student> data2 = new ArrayList<>();
	
	static {data2.add(new Student("신용권", 100));
			data2.add(new Student("정민교", 60));
			data2.add(new Student("신용권", 100));
			data2.add(new Student("심은정", 80));
			data2.add(new Student("심은지", 90));}
	
	public static void main(String[] args) {
		f18();

	}

	private static void f18() {
		List<Student> data = new ArrayList<>();
		
		data.add(new Student("신용권", 100, "남"));
		data.add(new Student("정민교", 60, "남"));
		data.add(new Student("신용권", 100,"남"));
		
		data.add(new Student("심은정", 80,"여"));
		data.add(new Student("심은지", 90,"여"));
		
		Map<String, List<Student>> map =
				data.stream().collect(Collectors.groupingBy(st -> st.getGender()));
		System.out.println(map);
		
		map.get("여").stream().forEach(st -> System.out.println(st));
		
		data.stream().collect(
				Collectors.groupingBy(
						st -> st.getGender(),
						Collectors.averagingDouble(
								st->st.getScore())));
	}

	private static void f17() {
		//List -> Map {key, value}
		//map은 key값 중복 불가
		/*
		Map<String, Integer> map = 
				data2.stream()
				.collect(Collectors.toMap(s -> s.getName(), s -> s.getScore()));
		
		System.out.println(map);
		*/
		
		//Set
		data2.stream()
		.collect(Collectors.toSet()).forEach(s -> {
			System.out.println(s);
		});
				
		
	}

	private static void f16() {
		
		//Student 점수 평균
		List<Student> data3 = new ArrayList<>();
		data2.stream()
		.mapToInt(st -> st.getScore())
		.average()
		.ifPresentOrElse(d -> {
			System.out.println("평균: " + d);
		}, () -> {
			System.out.println("값 없음");
		});
		
		//합계
		int total = data2.stream()
		.mapToInt(Student::getScore).sum();
		System.out.println("합계: " + total);
		
		data2.stream()
		.mapToInt(Student::getScore)
		.reduce((a, b) -> a+b)
		.ifPresentOrElse(i -> {
			System.out.println("있음: " + i);
		}, () -> {
			System.out.println("없음");
		});
	}

	private static void f15() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int total = Arrays.stream(arr).sum();
		long count = Arrays.stream(arr).count();
		
		OptionalDouble op = Arrays.stream(arr).average();
		op.ifPresent(a -> System.out.println(a)); //ifPresent : 없으면 안찍어짐
		double result = op.orElse(0); //orElse : default 값을 주기위해 사용
		System.out.println(result);
		
		//첫 번째 arg = 소비자, 두 번째 arg = Runnalbe
		op.ifPresentOrElse(a -> {
			System.out.println("있다:" + a);
		}, ()-> {System.out.println("없다");});
	
		System.out.println("total = " + total);
		System.out.println("count = " + count);
	}

	private static void f14() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		boolean result1 = Arrays.stream(arr).allMatch(a -> a <= 10);
		boolean result2 = Arrays.stream(arr).allMatch(a -> a < 10);
		boolean result3 = Arrays.stream(arr).anyMatch(a -> a < 10);
		boolean result4 = Arrays.stream(arr).noneMatch(a -> a <= 10);
		
		System.out.println(result1);
		System.out.println(result2);//하나라도 틀리면 false
		System.out.println(result3);//하나라도 맞는게 있으면 true
		System.out.println(result4);//하나라도 맞는게 있으면 false
	}

	private static void f13() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//forEach : 최종처리 메서드
		Arrays.stream(arr).forEach(data -> System.out.println(data));
		//둘다 같은 consumer
		//peek : 중간처리메서드, 최종처리 메서드 필요
		int result = Arrays.stream(arr).peek(data -> System.out.println(data)).sum();
		System.out.println(result);
	}

	private static void f12() {
		//Product를 이용해서 Sort연습
		List<Product> plist = new ArrayList<>();
		IntStream.rangeClosed(100, 105).forEach(pid ->{
			Product p = new Product(pid, "상품"+100, "신한", 10000);
			plist.add(p);
		});
		
		Comparator<Product> com1 = (a, b) -> a.getPno() - b.getPno();
		Comparator<Product> com2 = new Comparator<Product>() {
			
			public int compare(Product a, Product b) {
				return b.getPno() - a.getPno(); //Product의 pno로 descending
			}
		};
		
		plist.stream()
		.sorted(com2) //Product의 pno로 ascending
		.forEach(p -> System.out.println(p));
		
	}

	private static void f11() {
		//sort : score asc, name desc <= Strudent는 implements Comparable : compareTo()
		//data2.stream().sorted().forEach(st -> System.out.println(st));
		
		Comparator<Student> cp1 = (a,b) -> a.getName().compareTo(b.getName());
		Comparator<Student> cp2 = new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o2.getName().compareTo(o1.getName());
			}
		};
		Comparator<Student> cp3 = (a,b) -> a.getScore()-b.getScore(); //score asc
		
		data2.stream()
		.sorted(cp2) //cp1: 이름으로 asc , cp2 : 이름으로 desc, cp3 : 점수로 asc
		.forEach(st -> System.out.println(st));
	}

	private static void f10() {
		
//		String s = " 100 ";
//		int i = Integer.parseInt(s.trim()); //.trim() 공백제거
//		System.out.println(i+200);
		
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50", "60, 70", "80, 90, 100");
		
		double result = list2.stream()
		.flatMap(str -> {
			String[] arr = str.split(", ");
			Integer[] arr2 = new Integer[arr.length];
			for(int index=0 ; index<arr.length ; index++) {
				arr2[index] = Integer.parseInt(arr[index].trim());
			}
			return Arrays.stream(arr2);
		}).mapToInt(intData -> intData.intValue()).average().getAsDouble();
		//.forEach(w -> System.out.println(w));
		System.out.println(result);
	}

	private static void f9() {
		/*
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50", "60, 70");
		double reuslt = list2.stream()
		.flatMap(one -> {
			String[] arr = one.split(", ");
			Integer[] arr2 = new Integer[arr.length];
			
			for(int i=0; i<arr.length ; i++) {
				arr2[i] = Integer.parseInt(arr[i].trim()); //trim?
			}
			return Arrays.stream(arr2);
		}).mapToInt(i -> i.intValue().average().getAsDouble());
		//.forEach(data -> System.out.println(data));
		 */
	}

	private static void f8() {
		List<String> list1 = new ArrayList<>();
		
		list1.add("This is a java");
		list1.add("I am a best developer");
		
		String[] arr = list1.get(0).split(" ");
		Arrays.stream(arr).forEach(a -> System.out.println(a));
		//flatMap(Function<T, R> : T가 들어가고 R이 나온다
		//T : String
		//R : stream
		list1.stream()
		.flatMap(data -> Arrays.stream(data.split(" ")))//flat : 원래 데이터를 펼쳐서 출력 , split(" ") : 공백을 기준으로 자르기
		.forEach(data -> System.out.println(data));
	}

	private static void f7() {
		int[] arr = {1, 2, 3, 4, 5};
		
		Arrays.stream(arr)
		.asDoubleStream()
		.forEach(d -> System.out.println(d));
		
		Arrays.stream(arr)
		.boxed() //new Integer() 가능하면 boxing된 것
		.forEach(d -> System.out.println(d.intValue())); //boxing
	}

	private static void f6() {
		data2.stream()
		.map(st -> st.getName() + "$") //map은 들어간것과 나오는 것이 다르다.(변형)
		.forEach(name -> System.out.println(name));
		
	}

	private static void f5() {
		List<Student> data = new ArrayList<>();
		
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 60));
		data.add(new Student("신용권", 100));
		data.add(new Student("심은정", 80));
		data.add(new Student("심은지", 90));
		
		data.stream()
		.mapToInt(st -> st.getScore()) //객체가 들어가고 int(score)가 나온다 => IntStream
		//.distinct()
		.forEach(st -> System.out.println(st));
		
		IntStream scoreStream = data.stream()
									.mapToInt(st -> st.getScore());
		
		double avg = scoreStream.average().getAsDouble();
		System.out.println("평균: "+ avg);
	}

	private static void f4() {
		List<Product> list = new ArrayList<>();
		//		  	1<= x <6
		IntStream.range(1, 6).forEach(i->{
			Product p = new Product(i, "상품"+i, "멋진회사",(int)(Math.random()*10000));
			list.add(p);
		});;
		
		list.stream()
		//.filter(p -> p.getPno()>=3)
		//.filter(p -> p.getName().startsWith("상품"))
		.filter(p -> p.getPrice()>=5000)
		.forEach(p -> System.out.println(p));
		
	}

	private static void f3() {
		List<Student> data = new ArrayList<>();
		
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 60));
		data.add(new Student("신용권", 100));
		data.add(new Student("심은정", 80));
		data.add(new Student("심은지", 90));
		
		System.out.println("=========이름이 심으로 시작==========");
		data.stream()
		.distinct()
		.filter(st -> st.getName().startsWith("심"))
		.forEach(st -> System.out.println(st));
		
		System.out.println("=========score90이상==========");
		data.stream()
		.distinct()
		.filter(st -> st.getScore() >= 90)
		.forEach(st -> System.out.println(st));
		
	}

	private static void f2() {
		List<String> list = new ArrayList<>();
		
		list.add("A1");list.add("A1");list.add("A1");
		list.add("B");list.add("B");
		list.add("C3");list.add("C3");
		list.add("D");
		
		list.stream()
		.distinct()//중복삭제
		.filter(name -> name.length() >= 2) //조건걸기(길이가 2이상 true인 것만)/filter(Predicate) ()의 return이 true
		.forEach(name -> System.out.println(name));
	}

	private static void f1() {
		//하나의 문자를 몇 바이트 처리 하는가 알아보기 / UTF-8(3byte처리)
		System.out.println(Charset.defaultCharset());
		
	}

}
