<%@page import="java.util.List"%>
<%@page import="com.shinhan.day15.EmpDTO"%>
<%@page import="com.shinhan.day15.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전직원목록</h1>
<a href="empInsert.jsp">신규직원 등록</a>
<table border="1">
	<caption>직원목록 전부조회</caption>
	<thead>
		<tr>
			<th>직원번호</th>
			<th>First_name</th>
			<th>Last_name</th>
			<th>Email</th>
			<th>Commission_pct</th>
			<th>Department_id</th>
			<th>Phone_number</th>
			<th>Salary</th>
			<th>Hire_date</th>
			<th>Manager_id</th>
			<th>Job_id</th>
		</tr>
	</thead>
	<tbody>
		<%
		EmpService eservice = new EmpService();
		List<EmpDTO> emplist = eservice.selectAll();
		%>
		<%for(EmpDTO emp:emplist) {%>
		<tr>
			<td>
			<a href="empDetail.jsp?empid=<%=emp.getEmployee_id()%>">
			<%=emp.getEmployee_id()%>
			</a>
			</td>
			<td><%=emp.getFirst_name() %></td>
			<td><%=emp.getLast_name() %></td>
			<td><%=emp.getEmail() %></td>
			<td><%=emp.getCommission_pct() %></td>
			<td><%=emp.getDepartment_id()%></td>
			<td><%=emp.getPhone_number()%></td>
			<td><%=emp.getSalary()%></td>
			<td><%=emp.getHire_date()%></td>
			<td><%=emp.getManager_id()%></td>
			<td><%=emp.getJob_id()%></</td>
		</tr>
		<%} %>
			
	</tbody>
</table>
</body>
</html>