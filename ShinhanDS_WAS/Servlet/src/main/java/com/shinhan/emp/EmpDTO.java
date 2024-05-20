package com.shinhan.emp;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


// VO(Value Object)
// 데이터를 전달하는 역할
// DTO(Data Transfer Object)
// JavaBeans기술에서 이용(JSP, Spring, Mybatis)
@Getter@Setter@ToString
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
