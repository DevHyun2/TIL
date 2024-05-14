package com.shinhan.myapp.section2;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PeopleVO {
	String name;
	String phone;
	CarVO car;
	List<LicenseVO> licenseList;
	List<String> major;
	Map<String, BookVO> bookMap;
	Set<String> friend;
	Properties myprofile;
}
