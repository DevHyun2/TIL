<%@page import="com.shinhan.day15.EmpDTO"%>
<%@page import="com.shinhan.day15.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String empid = request.getParameter("empid");
if(empid==null) return;
int i_empid = Integer.parseInt(empid);
EmpService service = new EmpService();
EmpDTO emp = service.selectById(i_empid);
%>
<ul>
	<li><%=emp.getEmployee_id() %></li>
	<li><%=emp.getFirst_name() %></li>
</ul>