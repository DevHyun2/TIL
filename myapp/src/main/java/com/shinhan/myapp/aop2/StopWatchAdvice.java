package com.shinhan.myapp.aop2;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//보조업무(Advice)...스프링이 보조업무를 주업무에 넣어준다.
@Component
@Aspect
public class StopWatchAdvice {
	//com.shinhan.myapp.aop2.Calculator 클래스 내의 모든 메서드에 StopWatchAdvice 보조업무가 적용된다.
	//주업무 전후에 StopWatch기능이 들어간다
	@Pointcut("execution(* d*(int, int))")
	public void targetMethod() {
		
	}
	
	@Around("targetMethod()")
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		
		//보조업무
		System.out.println("******" + jp.getSignature().getName() + "메서드 호출 전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();
		
		//주업무를 수행한다. 
		Object object = jp.proceed();
		
		//보조업무
		System.out.println("*****" + jp.getSignature().getName() + "메서드 호출 후");
		watch.stop();
		System.out.println("주업무 수행 시간:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;
	}
}
