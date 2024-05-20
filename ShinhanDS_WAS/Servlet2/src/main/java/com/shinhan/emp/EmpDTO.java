package com.shinhan.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//DTO(Data Transfer Object) = VO(Value Object)
//JavaBeans 기술에서 이용(Spring, JSP, Mybatis는 JavaBeans 기술 이용)

@AllArgsConstructor
@NoArgsConstructor // 필수
@Getter@Setter // 필수
@ToString
public class EmpDTO {
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private int salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
}
