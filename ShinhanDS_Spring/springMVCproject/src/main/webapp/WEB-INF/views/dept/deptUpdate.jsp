<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input[readonly] {
		background-color: lightgray;
	}
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<h1>부서 상세보기</h1>
<!-- EL(Expression Langueage(표기법 -->
<!-- HTML주석: ${deptInfo} -->
<!-- JSP가 해석되어 HTML이 만들어진다. -->
<%-- JSP 주석: ${deptInfo} --%>
<form action="${path}/dept/deptDetail.do" method="post">
부서번호: <input type="number" name="department_id" value="${dept.department_id}" readonly><br>
부서이름: <input type="text" name="department_name" value="${dept.department_name}" readonly><br>
매니저 : <input type="number" name="manager_id" value="${dept.manager_id}" readonly><br>
지역코드: <input type="number" name="location_id" value="${dept.location_id}" readonly><br>
<input type="submit" value="수정하러가기">
</form>
</body>
</html>