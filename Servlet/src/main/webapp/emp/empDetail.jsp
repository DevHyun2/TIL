<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원상세보기</h1>
	<p>${empInfo.employee_id}</p><%-- ${ } : getAttribute --%>
	<p>${empInfo.first_name}</p>
	<p>${empInfo.salary}</p>
</body>
</html>