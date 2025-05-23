package com.firstzone.pack2;

public class Car {
	
	String model;
	int price;
	
	public Car() {
	
	}

	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() { //다른패키지 적용을 위해 get/set
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

	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
	
	
}
