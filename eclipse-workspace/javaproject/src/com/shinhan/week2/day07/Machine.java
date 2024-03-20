package com.shinhan.week2.day07;

public interface Machine {
	
	void powerOn(String title);
}

//사용방법
//1.interface 구현 class를 만든다....만약에 만들어야 하는 경우가 많다면 좋은 방법이 아님
//2.익명 구현 class를 만든다....필요시 마다 만들고 제거된다.
//3.특별히 interface내에 method가 하나밖에 없다면 람다표현식을 이용한다.