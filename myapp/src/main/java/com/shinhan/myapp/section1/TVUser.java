package com.shinhan.myapp.section1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {
	
	public static void main(String[] args) {
		/*f1(); f2(); f3(); f4();*/
		f5();
	}
	//인터페이스 패턴을 사용하면 구현객체가 변경되어도 사용법 같음
	private static void f1() {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
	}
	
	private static void f2() {
		LGTV tv = new LGTV();
		tv.powerOn();
		tv.powerOff();
	}
	
	//Factory pattern : 생성은 Factory가 함
	private static void f3() {
		new SamsungTV("ABC");
		
		TV tv = TVFactory.makeTV("s");
		
		tv.powerOn();
		tv.powerOff();
	}
	
	private static void f4() {
		Resource resource = new ClassPathResource("di1.xml"); //ClassPath로 지정된 파일 찾기
		BeanFactory factory = new XmlBeanFactory(resource); //모바일관련 개발에서 좋음
		
		TV tv = (TV)factory.getBean("samsung1");
		TV tv2 = factory.getBean("samsung2", TV.class); //형변환
		TV tv3 = (TV)factory.getBean("lg");
		
		tv.powerOn();
		tv.powerOff();
		tv2.powerOn();
		tv2.powerOff();
		tv3.powerOn();
		tv3.powerOff();
	}
	
	private static void f5() {
		ApplicationContext context = new ClassPathXmlApplicationContext("di1.xml"); 
		//여기서 실행시 : SamsungTV 모델: ABC 출력됨 *생성자 출력이 됨* <getBean 전>
		
		TV tv = (TV)context.getBean("samsung1");
		TV tv2 = context.getBean("samsung2", TV.class); //형변환
		TV tv3 = (TV)context.getBean("lg");
		
		tv.powerOn();
		tv.powerOff();
		tv2.powerOn();
		tv2.powerOff();
		tv3.powerOn();
		tv3.powerOff();
	}
}
