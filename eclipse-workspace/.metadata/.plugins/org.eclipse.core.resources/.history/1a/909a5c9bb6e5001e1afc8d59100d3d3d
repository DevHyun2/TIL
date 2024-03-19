package com.shinhan.day05;

//싱글톤 만들기

public class ShopService {
	
	private static ShopService shop;
	
	//생성자의 접근지정자를 private로 만든다.
	private ShopService(){
		
	}
	public ShopService getInstance() {
		
		if(shop == null)
			shop = new ShopService();
		return shop;
	}
}
