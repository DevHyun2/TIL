package com.shinhan.day15;

import java.util.List;

// View : 사용장에게 어떻게 보여줄지 담당한다. 이후 JSP로 작성할 예정
public class EmpView {

	public static void print(List<EmpDTO> emplist, String title) {
		
		System.out.printf("=========%s========\n", title);
		
		emplist.stream()
		.forEach(emp -> System.out.println(emp));
	}
	
	//오버로딩 이름같고 매개변수 다름
	public static void print(EmpDTO emp, String title) {
		System.out.printf("=========%s========\n", title);
		if(emp==null) {
			System.out.println("존재하지 않는 직원입니다.");
		}else {
			System.out.println("직원번호 : " + emp.getEmployee_id());
			System.out.println("이름 : " + emp.getFirst_name());
			System.out.println("성 : " + emp.getLast_name());
			System.out.println("급여 : " + emp.getSalary());
			System.out.println("이메일 : " + emp.getEmail());
			System.out.println("입사일 : " + emp.getHire_date());
			System.out.println("커미션 : " + emp.getCommission_pct());
			System.out.println("매니저 : " + emp.getManager_id());
			System.out.println("연락처 : " + emp.getPhone_number());
			System.out.println("부서 : " + emp.getDepartment_id());
		}
		System.out.println(emp);
	}
	
	//오버로딩 이름같고 매개변수 다름
		public static void print(String message) {
			System.out.printf("=========%s========\n", message);
		}
}
