package com.shinhan.dept;

import java.util.List;
import java.util.Scanner;

public class DeptController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;
		DeptService deptService = new DeptService();
		while (!isStop) {
			int selectJob = menuDisplay();
			switch(selectJob) {
			case 0 -> {
				isStop = true;
			}
			case 1 -> {
				List<DeptDTO> deptlist = deptService.selectAll();
				DeptView.print(deptlist, "모든 부서 조회");
			}
			case 2 -> {
				System.out.print("조회할 부서 ID>> ");
				int deptid = sc.nextInt();
				DeptDTO dept = deptService.selectByID(deptid);
				DeptView.print(dept, "특정 부서 조회");
			}
			case 3 -> {
				DeptDTO dept = insertMenu();
				int result = deptService.deptInsert(dept);
				DeptView.print(result>0?"입력성공":"입력실패");
			}
			case 4 -> {
				DeptDTO dept = insertMenu();
				int result = deptService.deptUpdate(dept);
				DeptView.print(result>0?"수정성공":"수정실패");
			}
			case 5 -> {
				System.out.print("삭제할 부서 ID>> ");
				int deptid = sc.nextInt();
				int result = deptService.deptDelete(deptid);
				DeptView.print(result>0?"삭제성공":"삭제실패");
			}
			default -> {
				DeptView.print("다시 입력해주세요");
			}
			}
		}
		System.out.println("종료");
	}

	private static DeptDTO insertMenu() {
		System.out.print("DEPARTMENT_ID>> ");
		int deptid = sc.nextInt();
		System.out.print("DEPARTMENT_NAME>> ");
		String deptname = sc.next();
		System.out.print("MANAGER_ID>> ");
		int mgrid = sc.nextInt();
		System.out.print("LOCATION_ID>> ");
		int locid = sc.nextInt();
		
		DeptDTO dept = new DeptDTO();
		dept.setDepartment_id(deptid);
		dept.setDepartment_name(deptname);
		dept.setManager_id(mgrid);
		dept.setLocation_id(locid);
		
		return dept;
	}
	
	private static int menuDisplay() {
		System.out.println("=====================");
		System.out.println("1.모든 부서 조회");
		System.out.println("2.특정 부서 조회");
		System.out.println("3.부서 입력");
		System.out.println("4.부서 수정");
		System.out.println("5.부서 삭제");
		System.out.println("0.종료");
		System.out.println("=====================");
		System.out.print("작업선택>> ");
		int job = sc.nextInt();
		return job;
	}
}
