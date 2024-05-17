package com.shinhan.myapp.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//ë³´ì¡°?—…ë¬?(Advice)...?Š¤?”„ë§ì´ ë³´ì¡°?—…ë¬´ë?? ì£¼ì—…ë¬´ì— ?„£?–´ì¤??‹¤.
@Component
//@Aspect
public class StopWatchAdvice {
	//com.shinhan.myapp.aop2.Calculator ?´?˜?Š¤ ?‚´?˜ ëª¨ë“  ë©”ì„œ?“œ?— StopWatchAdvice ë³´ì¡°?—…ë¬´ê? ? ?š©?œ?‹¤.
	//ì£¼ì—…ë¬? ? „?›„?— StopWatchê¸°ëŠ¥?´ ?“¤?–´ê°„ë‹¤
	@Pointcut("within(com.shinhan.myapp.controller.BoardController)")
	public void targetMethod() {
		
	}
	
	@Around("targetMethod()")
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		
		String methodname = jp.getSignature().getName();
		
		//ë³´ì¡°?—…ë¬?
		System.out.println("******" + methodname + "ë©”ì„œ?“œ ?˜¸ì¶? ? „");
		StopWatch watch = new StopWatch("ê³„ì‚°?‹œê°?");
		watch.start();
		
		//ì£¼ì—…ë¬´ë?? ?ˆ˜?–‰?•œ?‹¤. 
		Object object = jp.proceed();
		
		//ë³´ì¡°?—…ë¬?
		System.out.println("*****" + methodname + "ë©”ì„œ?“œ ?˜¸ì¶? ?›„");
		watch.stop();
		System.out.println("ì£¼ì—…ë¬? ?ˆ˜?–‰ ?‹œê°?:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;
	}
}
