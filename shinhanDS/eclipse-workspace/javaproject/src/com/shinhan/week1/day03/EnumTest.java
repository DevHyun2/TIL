package com.shinhan.week1.day03;

public class EnumTest {

	//상수 : 변하지 않는 값 - final static
	final static int SUCCES = 1;
	final static int FAIL = 0;
	final static int PLAY = 2;
	
	public static void main(String[] args) {
		f2();
	}
	
	private static void f2() {
		Week[] arr = Week.values(); // 배열로 리턴 .values()
		for(Week week : arr) {
			System.out.println(week + "--" + week.ordinal() + "--" + week.name()); // .ordinal 순서를 찍음
		}
		call2(Week.FRIDAY);
		call2(Week.SUNDAY);
	}

	private static void call2(Week aa) {
		switch (aa) {
		case FRIDAY:
			System.out.println("금요일입니다."); break;
		case SATURDAY:
			System.out.println("토요일입니다."); break;
		case SUNDAY:
			System.out.println("일요일입니다."); break;
		case MONDAY:
			System.out.println("월요일입니다."); break;
		case TUESDAY:
			System.out.println("화요일입니다."); break;
		case WEDNESDAY:
			System.out.println("수요일입니다."); break;
		case THURSDAY:
			System.out.println("목요일입니다."); break;
		default : break;

		}
		
	}

	public static void f1(String[] args) {
		int score = 100;
		Work result;
		
		if (score>=90) {
			result = Work.SUCCES;
		}else {
			result = Work.FAIL;
		}
		System.out.println(result);
	}

}
