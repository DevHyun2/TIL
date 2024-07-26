package com.shinhan.firstzone.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//보조업무
@Component
@Aspect
@Order(1)//낮은것이 먼저
public class StopWatchAdvice  {
	
	@Pointcut("execution(* f2(..))")
	//@Pointcut("within(com.shinhan.model.DeptService)")
	public void mypontcut1() {
		//로직없음..함수형태일때만 가능한 annotation을 사용중 
	}
	@Pointcut("execution(* select*())")
	public void mypontcut2() {
		//로직없음..함수형태일때만 가능한 annotation을 사용중 
	}
	
	
	@Around("mypontcut1()")	
	public Object invoke22(ProceedingJoinPoint jp) throws Throwable {
        String targetMethodName = jp.getSignature().toShortString();
        
		System.out.println("**StopWatch***" + targetMethodName + "메서드 호출 전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();
		//주업무를 수행한다. 
		Object object = jp.proceed();
		//보조업무
		System.out.println("*****" + targetMethodName + "메서드 호출 후");
		watch.stop();
		System.out.println("주업무 수행 시간:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;
	}
}