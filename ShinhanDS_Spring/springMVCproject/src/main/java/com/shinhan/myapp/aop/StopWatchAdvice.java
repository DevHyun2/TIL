package com.shinhan.myapp.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//λ³΄μ‘°?λ¬?(Advice)...?€?λ§μ΄ λ³΄μ‘°?λ¬΄λ?? μ£Όμλ¬΄μ ?£?΄μ€??€.
@Component
//@Aspect
public class StopWatchAdvice {
	//com.shinhan.myapp.aop2.Calculator ?΄??€ ?΄? λͺ¨λ  λ©μ?? StopWatchAdvice λ³΄μ‘°?λ¬΄κ? ? ?©??€.
	//μ£Όμλ¬? ? ?? StopWatchκΈ°λ₯?΄ ?€?΄κ°λ€
	@Pointcut("within(com.shinhan.myapp.controller.BoardController)")
	public void targetMethod() {
		
	}
	
	@Around("targetMethod()")
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		
		String methodname = jp.getSignature().getName();
		
		//λ³΄μ‘°?λ¬?
		System.out.println("******" + methodname + "λ©μ? ?ΈμΆ? ? ");
		StopWatch watch = new StopWatch("κ³μ°?κ°?");
		watch.start();
		
		//μ£Όμλ¬΄λ?? ????€. 
		Object object = jp.proceed();
		
		//λ³΄μ‘°?λ¬?
		System.out.println("*****" + methodname + "λ©μ? ?ΈμΆ? ?");
		watch.stop();
		System.out.println("μ£Όμλ¬? ?? ?κ°?:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;
	}
}
