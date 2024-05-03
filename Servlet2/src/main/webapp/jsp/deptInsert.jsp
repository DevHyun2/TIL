<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 등록</title>
</head>
<body>
<h1>부서등록</h1>
<form action="javaBeansTest.jsp" method="get">
	<label>부서번호</label>
	<input type="number" name="department_id" value="300"><br>
	<label>부서이름</label>
	<input name="department_name" value="aa"><br>
	<label>매니저</label>
	<input type="number" name="manager_id" value="100"><br>
	<label>지역코드</label>
	<input type="number" name="location_id" value="1700"><br>
	<input type="submit" value="부서저장">
</form>
</body>
</html>