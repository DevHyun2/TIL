package com.shinhan.week3.day10.제네릭;

public class GenericTest {
	
	public static void main(String[] args) {
		Product<Integer, Integer> p1 = makeProduct2(100,200);
		
		boolean result = compare(10, 20);
		System.out.println(result);
	}
	
	private static <T extends Number>boolean compare(T i, T j) {
		double d1 = i.doubleValue();
		double d2 = j.doubleValue();
		return d1 == d2;
	}

	//제네릭 제한된 타입 파라미터
	private static <A extends Number, B> Product<A, B> makeProduct2(A a, B b) {
		Product<A, B> p = new Product<>(a, b);
		return p;
	}

	public static void main4(String[] args) {
		Product<String, Integer> p1 = makeProduct("A",100);
		Product<Integer, String> p2 = makeProduct(200,"B");
		Product<String, String> p3 = makeProduct("C","D");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

	private static <A, B> Product<A, B> makeProduct(A a, B b) {
		Product<A, B> p = new Product<>(a, b);
		return p;
	}

	public static void main3(String[] args) {
		Box<String> result1 = makeBox("구체적타입 사용시결정");
		Box<Integer> result2 = makeBox(100);
		Box<Car> result3 = makeBox(new Car());

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}

	private static <T> Box<T> makeBox(T t) {
		Box<T> box = new Box<>(t);
		return box;
	}

	public static void main2(String[] args) {
		Box<String> s = boxing("문자");
		Box<Integer> i = boxing(100);
		Box<Tv> tv = boxing(new Tv());
		Box<Product<String, Integer>> pro = boxing(new Product<>("A", 100));
		Box<ChildProduct<String, Integer, String>> pro2 = boxing(new ChildProduct<>("B", 2340, "3만원"));

		System.out.println(s.getContent());
		System.out.println(i.getContent());
		System.out.println(tv.getContent());
		System.out.println(pro.getContent());
		System.out.println(pro2.getContent());
	}

	// <T> : T가 제네릭이다. 구체적인 타입이 아니다.
	// Box<T> : return타입, 제네릭타입인 Box를 return한다.
	private static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.setContent(t);
		return box;

	}

	private static void f5() {
		ChildProduct<String, Integer, Integer> p1 = new ChildProduct<>("ㅂㅈㄱ", 1230, 200);
		System.out.println(p1);
	}

	private static void f4() {
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();

		CarAgnecy carAgnecy = new CarAgnecy();
		Car car = carAgnecy.rent();
		car.run();
	}

	private static void f3() {
		Product<String, Integer> p1 = new Product<>();
		p1.setKind("ABC");
		p1.setModel(200);

		Product<String, Integer> p2 = new Product<>("컴퓨터", 100);

		System.out.println(p1);
		System.out.println(p2);

		Product<CoffeeMachine, String> p3 = new Product<>(new CoffeeMachine(), "DDD");
		System.out.println(p3);
	}

	private static void f2() {
		// 제네릭 사용목적컴파일시에 타입을 제한하기(잘못된 타입 입력불가, 얻을 때 형변환 필요X)
		Box<Integer> box1 = new Box<>();
		box1.setContent(100);

		int a = box1.getContent();
		System.out.println(a);

	}

	private static void f1() {
		Box box1 = new Box();
		box1.setContent(100);
		box1.setContent("80");
		box1.setContent(new CoffeeMachine());

		CoffeeMachine obj = (CoffeeMachine) box1.getContent();
		System.out.println(obj);

	}

}
