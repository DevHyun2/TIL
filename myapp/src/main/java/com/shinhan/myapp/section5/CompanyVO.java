package com.shinhan.myapp.section5;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("company1")
@Data
public class CompanyVO {
	
	String compName;
	String address;
	List<ComputerVO> computerList;
}
