package com.shinhan.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {
	
	 private int department_id;
	 private String department_name;
	 private int manager_id;
	 private int location_id;
}
