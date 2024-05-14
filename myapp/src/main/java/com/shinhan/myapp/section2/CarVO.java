package com.shinhan.myapp.section2;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
@AllArgsConstructor
@ToString
public class CarVO {
	String model;
	int price;
	
	public CarVO() {
		System.out.println("CarVO의 default생성자");
	}

	public String getModel() {
		System.out.println("getModel 생성자");
		return model;
	}

	public void setModel(String model) {
		System.out.println("setModel 생성자");
		this.model = model;
	}

	public int getPrice() {
		System.out.println("getPrice 생성자");
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setPrice 생성자");
		this.price = price;
	}
	
	
}
