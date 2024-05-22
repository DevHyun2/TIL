package org.firstzone.myapp.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//VO(Value Object)
//DTO(Data Transfer Object)
//JavaBeans기술?��?�� ?��?��(JSp,Spring,Mybatis?�� javabeans기술?�� ?��?��?��?��. )
@AllArgsConstructor // ?��?��
@NoArgsConstructor // ?��?��
@Getter@Setter@ToString
public class EmpDTO {
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private Integer salary;
	private double commission_pct;
	private Integer manager_id;
	private Integer department_id;
}





