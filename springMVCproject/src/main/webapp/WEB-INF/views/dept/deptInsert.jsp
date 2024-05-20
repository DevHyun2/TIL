<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 등록</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<h1>부서등록</h1>
<form action="${path}/dept/deptInsert.do" method="post">
	<label>부서번호</label>
	<input type="number" name="department_id" value=""><br>
	<label>부서이름</label>
	<input name="department_name" value=""><br>
	<label>매니저</label>
	<input type="number" name="manager_id" value=""><br>
	<select name="manager_id">
		<c:forEach var="manager" items="${mlist}">
			<option value="${manager.employee_id}">${manager.fullname}</option>
		</c:forEach>
	</select>
	<label>지역코드</label>
	<input type="number" name="location_id" value=""><br>
	<input type="submit" value="부서저장">
</form>
</body>
</html>