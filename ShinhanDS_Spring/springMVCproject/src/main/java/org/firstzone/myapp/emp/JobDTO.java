package org.firstzone.myapp.emp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
		private String job_id;
		private String job_title;
		private int min_salary;
		private int max_salary;

}