package com.shinhan.day18;

import java.util.List;

public class DeptView {

public static void print(List<DeptDTO> deptlist, String title) {
		
		System.out.printf("=========%s========\n", title);
		
		deptlist.stream()
		.forEach(dept -> System.out.println(dept));
	}

//오버로딩 이름같고 매개변수 다름
	public static void print(DeptDTO dept, String title) {
		System.out.printf("=========%s========\n", title);
		if(dept==null) {
			System.out.println("존재하지 않는 직원입니다.");
		}else {
			System.out.println("부서번호 : " + dept.getDepartment_id());
			System.out.println("부서이름 : " + dept.getDepartment_name());
			System.out.println("매니저ID : " + dept.getManager_id());
			System.out.println("지역ID : " + dept.getLocation_id());
			
			
		}
		System.out.println(dept);
	}
	
	//오버로딩 이름같고 매개변수 다름
			public static void print(String message) {
				System.out.printf("=========%s========\n", message);
			}
}
