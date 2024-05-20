<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 상세보기</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<h1>부서 상세보기</h1>
<form action="${path}/dept/deptDetail.do" method="post">
	<label>부서번호</label>
	<input type="number" name="department_id" value="${dept.department_id}" readonly="readonly"><br>
	<label>부서이름</label>
	<input name="department_name" value="${dept.department_name}" readonly="readonly"><br>
	<label>매니저</label>
	<input type="number" name="manager_id" value="${dept.manager_id}" readonly="readonly"><br>
	<label>지역코드</label>
	<input type="number" name="location_id" value="${dept.location_id}" readonly="readonly"><br>
	<input type="submit" value="수정하기">
</form>
</body>
</html>