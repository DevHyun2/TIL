package com.shinhan.myapp.section1;

public class TVFactory {
	
	public static TV makeTV(String brand) {
		TV tv = null;
		
		if(brand.equals("s")) {
			tv = new SamsungTV("ddd1234");
		}else if(brand.equals("lg")){
			tv = new LGTV();
		}else {
			
		}
		return tv;
	}
}
