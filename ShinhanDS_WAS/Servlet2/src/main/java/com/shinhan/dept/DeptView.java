package com.shinhan.dept;

import java.util.List;

public class DeptView {
	public static void print(List<DeptDTO> deptlist, String title) {
		System.out.printf("============%s============\n", title);
		if (deptlist.size() == 0) {
			System.out.println("조건에 해당하는 데이터가 없습니다.");
			return;
		}
		deptlist.stream().forEach(dept -> System.out.println(dept));
	}

	public static void print(DeptDTO dept, String title) {
		System.out.printf("============%s============\n", title);
		if (dept == null) {
			System.out.println("존재하지 않는 부서입니다.");
		} else {
			System.out.println("부서번호: " + dept.getDepartment_id());
			System.out.println("부서이름: " + dept.getDepartment_name());
			System.out.println("매니저번호: " + dept.getManager_id());
			System.out.println("로케이션번호: " + dept.getLocation_id());
		}
	}

	public static void print(String message) {
		System.out.printf("============%s============\n", message);
	}
}
