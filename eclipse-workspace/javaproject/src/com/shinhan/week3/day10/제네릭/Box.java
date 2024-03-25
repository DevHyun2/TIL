package com.shinhan.week3.day10.제네릭;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//롬복 어노테이션

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Box<T> {
	
	private T content;

	/*
	 * public T getContent() { return content; }
	 * 
	 * public void setContent(T content) { this.content = content; }
	 */
	
}
