package com.shinhan.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
//@WebListener
public class MyServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ServletContextListener 소멸(마지막에 소멸)");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("ServletContextListener 초기화(처음으로초기화)");
    }
	
}
