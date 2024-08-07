package com.shinhan.week2.day09.objecttest;
//class : 틀(templete), object를 만들기 위해 사용
//object : 실체(instance)

import java.util.Objects;

//Vo(Value Object) : 여러개의 field data를 저장, C언어의 스트럭처와 비슷
//DTO(Data Transfer Object) : 데이터 전송목적
//JavaBeans기술 : default 생성자 반드시 있어야 한다.
public class ComputerVO {
	//1.field : 데이터 저장이 목적
	String model;
	int price;
	String company;
	
	public ComputerVO() {} //디폴트 생성자는 *필수
	public ComputerVO(String model, int price, String company) {
		this.model = model;
		this.price = price;
		this.company = company;
	}
	
	//get/set
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	/*
	 * //toString public String toString() { return "ComputerVO [model=" + model +
	 * ", price=" + price + ", company=" + company + "]"; }
	 */
	
	//buffer 재정의
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComputerVO [model=")
		.append(model)
		.append(", price=")
		.append(price)
		.append(", company=")
		.append(company)
		.append("]");
		return builder.toString();
	}
	
	
	//hash 재정의
	public int hashCode() {
		return Objects.hash(company, model, price);
	}
	
	//equals재정의
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputerVO other = (ComputerVO) obj;
		return Objects.equals(company, other.company) && Objects.equals(model, other.model) && price == other.price;
	}
	
}
