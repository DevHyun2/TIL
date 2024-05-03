package com.shinhan.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import lombok.Getter;
import lombok.Setter;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@Getter@Setter
//@WebListener
public class LoginImpl implements HttpSessionBindingListener {

    String user_id;
    String user_pw;
    int total_user = 0;
    
    public LoginImpl() {
    	
    }
    
    public LoginImpl(String user_id, String user_pw) {
        this.user_id = user_id;
        this.user_pw = user_pw;
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)  { 
         System.out.println("사용자접속!!!");
         ++total_user;
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	System.out.println("사용자접속해제!!!");
        total_user--;
    }
	
}
