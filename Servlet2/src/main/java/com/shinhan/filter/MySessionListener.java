package com.shinhan.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
//@WebListener
public class MySessionListener implements HttpSessionListener {

	String user_id;
    String user_pw;
    public static int total_user = 0;
    
    public MySessionListener() {
        System.out.println("MySessionListener 생성");
    }
    public MySessionListener(String user_id, String user_pw) {
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	total_user++;
    	System.out.println("MySessionListener...sessionCreated:" + total_user);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	total_user--;
    	System.out.println("MySessionListener...sessionDestroyed:" + total_user);
    }
	
}
