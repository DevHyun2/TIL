package com.shinhan.week2.day07;

public class MachineUsing {
	
	//field
	Machine v1 = new Machine() {
		
		@Override
		public void powerOn(String title) {
			// TODO Auto-generated method stub
			
		}
	};
	public static void main(String[] args) {
		
		//**구현class 사용
		Machine v3 = new MachineImple();
		call(v3);
		
		//local 변수
		Machine v2 = new Machine() {
			
			@Override
			public void powerOn(String title) {
				System.out.println("2.익명 구현 class를 만든다");
				
			}
		};
		call(v2);
		
		call((s)->System.out.println(s+" 람다표현식"));
		
		//함수의 매개변수 이용
		call(new Machine() {
			
			@Override
			public void powerOn(String title) {
				System.out.println("2.익명 구현 class를 만든다");
				
			}
		});
		
	}
	private static void call(Machine machine) {
		machine.powerOn("******");
	}

}
