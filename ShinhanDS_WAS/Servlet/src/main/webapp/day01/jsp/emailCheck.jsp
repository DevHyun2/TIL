<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
EmpService service = new EmpService();
String email = request.getParameter("email);
int result = service.selectByEmail(email);
out.print(result);
%>
