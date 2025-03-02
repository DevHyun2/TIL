package com.shinhan.week2.day09.어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) //field에 쓰려면 field로 교체
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation {
	String value() default"-";
	int number() default 7;
	String subject() default "자바";
}