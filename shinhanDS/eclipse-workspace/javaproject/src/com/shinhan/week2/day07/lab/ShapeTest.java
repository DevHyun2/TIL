package com.shinhan.week2.day07.lab;

public class ShapeTest {

	public static void main(String[] args) {
		
		//interface는 instance생성 불가
		//Resizable aa = new Resizable();
		//Shape aa = new Shape();
		
		Shape[] arr = new Shape[2];
		
		arr[0] = new Rectangle(5, 6);
		arr[1] = new RectTriangle(6, 2);

		for(Shape shape : arr) {
			System.out.println("area: " + shape.getArea());
			System.out.println("permieter: " + shape.getPermieter());
			if(shape instanceof Resizable rr) {
				rr.resizable(0.5);
				System.out.println("new area: " + shape.getArea());
				System.out.println("new permieter: " + shape.getPermieter());
			}
		}
	}

}

1 3 4