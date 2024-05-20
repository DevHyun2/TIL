<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든직책조회</title>
<style>
	table, tr, th, td{
		border: 1px solid black;
		border-collapse: collapse;
		padding: 10px;
	}
</style>
</head>
<body>
<h1>직책목록</h1>
<table>
	<thead>
		<tr>
			<th>job_id</th>
			<th>job_title</th>
			<th>min_salary</th>
			<th>max_salary</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${j_datas}" var="job">
			<tr>
				<td>${job.job_id}</td>
				<td>${job.job_title}</td>
				<td>${job.min_salary}</td>
				<td>${job.max_salary}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>