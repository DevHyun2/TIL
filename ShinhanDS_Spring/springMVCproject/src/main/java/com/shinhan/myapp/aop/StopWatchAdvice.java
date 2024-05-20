package com.shinhan.myapp.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//보조?���?(Advice)...?��?��링이 보조?��무�?? 주업무에 ?��?���??��.
@Component
//@Aspect
public class StopWatchAdvice {
	//com.shinhan.myapp.aop2.Calculator ?��?��?�� ?��?�� 모든 메서?��?�� StopWatchAdvice 보조?��무�? ?��?��?��?��.
	//주업�? ?��?��?�� StopWatch기능?�� ?��?��간다
	@Pointcut("within(com.shinhan.myapp.controller.BoardController)")
	public void targetMethod() {
		
	}
	
	@Around("targetMethod()")
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		
		String methodname = jp.getSignature().getName();
		
		//보조?���?
		System.out.println("******" + methodname + "메서?�� ?���? ?��");
		StopWatch watch = new StopWatch("계산?���?");
		watch.start();
		
		//주업무�?? ?��?��?��?��. 
		Object object = jp.proceed();
		
		//보조?���?
		System.out.println("*****" + methodname + "메서?�� ?���? ?��");
		watch.stop();
		System.out.println("주업�? ?��?�� ?���?:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;
	}
}
