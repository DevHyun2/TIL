package com.shinhan.week2.day09.objecttest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/*@EqualsAndHashCode
@ToString
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor*/
@Data
@AllArgsConstructor
public class ComputerVO3 {
	
	@NonNull
	String model;
	
	int price;
	String company;
	


}