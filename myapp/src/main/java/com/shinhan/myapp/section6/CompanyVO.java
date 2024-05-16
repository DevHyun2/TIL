package com.shinhan.myapp.section6;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("compnay2")
@Data
public class CompanyVO {
	
	String compName;
	String address;
	List<CompanyVO> computerList;
}
