package com.shinhan.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Dateutil {
	
	public static Date getUtilDate(String d) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date result = null;
		
		try {
			result = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
public static Date getSQLDate(String d) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date result = null;
		
		try {
			java.util.Date d2 = sdf.parse(d);
		result = new java.sql.Date(d2.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}
