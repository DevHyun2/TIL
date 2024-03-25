package com.shinhan.week2.day09.generic;

//타입이 결정되면 그 타입이 들어온다
public class Box<A,B> {

	private A code;
	private B size;
	
	public Box(A code, B size) {
		
		this.code = code;
		this.size = size;
	}

	public A getCode() {
		return code;
	}

	public void setCode(A code) {
		this.code = code;
	}

	public B getSize() {
		return size;
	}

	public void setSize(B size) {
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [code=").append(code).append(", size=").append(size).append("]");
		return builder.toString();
	}
	
	
}
