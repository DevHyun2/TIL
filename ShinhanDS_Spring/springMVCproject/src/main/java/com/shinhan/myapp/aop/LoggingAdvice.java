package com.shinhan.myapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조?���? ?��?��(cross cutting concern)
@Component
//@Aspect //�������� + Pointcut
public class LoggingAdvice {
	
	@Pointcut("execution(* selectAll())")
	public void targetMethod2() { 
		
	}
	
	@Pointcut("within(com.shinhan.myapp.model.BoardService)")
	public void targetMethod3() {}
	
	@Before("targetMethod3()")
	public void f_before() {
		System.out.println("---------@Before---------");
	}
	@After("targetMethod3()")
	public void f_after() {
		System.out.println("---------@After---------");
	}
	@AfterReturning("targetMethod3()")
	public void f_afterReturning() {
		System.out.println("---------@AfterReturning---------");
	}
	
	//target�� �־��� ���� ����
	@Around("targetMethod2()")
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		
		System.out.println("[�޼��� ȣ�� �� : LogginAdvice aroung()");
		System.out.println(jp.getSignature().getName() + "�޼��� ȣ�� ��");

		//�־����� �����Ѵ�. (*����)
		Object object = jp.proceed();

		//�־��� ������ ���ƿͼ� �����Ѵ�. 
		System.out.println("[�޼��� ȣ�� �� : loggingAdvice aound()");
		System.out.println(jp.getSignature().getName() + "�޼��� ȣ�� ��");
		return object;
	}
}
