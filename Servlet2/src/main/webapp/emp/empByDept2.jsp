<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
	<thead>
		<tr>
			<th>id</th>
			<th>first name</th>
			<th>last name</th>
			<th>email</th>
			<th>salary</th>
			<th>hire date</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${emplist}" var="emp">
			<tr>
				<td>${emp.employee_id}</td>
				<td>${emp.first_name}</td>
				<td>${emp.last_name}</td>
				<td>${emp.email}</td>
				<td>${emp.salary}</td>
				<td>${emp.hire_date}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>