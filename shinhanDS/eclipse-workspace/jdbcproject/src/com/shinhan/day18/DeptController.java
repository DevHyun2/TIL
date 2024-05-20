package com.shinhan.day18;

import java.util.List;
import java.util.Scanner;

public class DeptController {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean isStop = false;
		DeptService deptService = new DeptService();
		
		while(!isStop) {
			int selectJob = menuDisplay();
			
			switch(selectJob) {
			case 0 -> {isStop = true;}
			
			case 1 -> {
				List<DeptDTO> deptlist = deptService.selectAll();
				DeptView.print(deptlist, "모든직원조회");
			}
			
			case 2 -> {
				
			}
			default -> {}
			}
		}
		System.out.println("======END=======");
	}

	private static int menuDisplay() {
		System.out.println("==============");
		System.out.println("1.모든직원조회");
		System.out.println("0.종료");
		System.out.print("작업선택 > ");
		int job = sc.nextInt();
		System.out.println("==============");
		return job;
	}
}
