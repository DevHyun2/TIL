<%@page import="com.shinhan.day15.EmpDTO"%>
<%@page import="com.shinhan.day15.EmpService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- jsp의 실행결과가 HTML, TEXT, JSON, XML...--%>
<%
EmpService eservice = new EmpService();
List<EmpDTO> emplist = eservice.selectAll();
for(EmpDTO emp:emplist) {
%>
<tr>
  <td><%=emp.getEmployee_id() %></td>
  <td><%=emp.getFirst_name() %></td>
  <td><%=emp.getEmail() %></td>
  <td><%=emp.getSalary() %></td>
</tr>
<%} %>