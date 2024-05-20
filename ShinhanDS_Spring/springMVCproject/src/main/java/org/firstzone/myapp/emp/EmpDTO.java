package org.firstzone.myapp.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//DTO(Data Transfer Object) = VO(Value Object)
//JavaBeans 湲곗?���뿉�꽌 �씠�슜(Spring, JSP, Mybatis�뒗 JavaBeans 湲곗?�� �씠�슜)

@AllArgsConstructor
@NoArgsConstructor // �븘�닔
@Getter@Setter // �븘�닔
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
