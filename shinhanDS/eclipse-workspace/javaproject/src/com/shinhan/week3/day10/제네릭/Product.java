package com.shinhan.week3.day10.제네릭;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//롬복으로 반복작업 최소화
//DTO(Data Transfer Object, 데이터를 전송목적)
//VO(Value Object)
//JavaBeans(JspServlet, Spring, Mybatis) : @NoArgsConstructor 와 get/set 반드시 필요
@ToString
@Setter@Getter //노아규먼트와 세트
@NoArgsConstructor //세터필요
@AllArgsConstructor
public class Product<K, V> {
	private K kind;
	private V model;
}
