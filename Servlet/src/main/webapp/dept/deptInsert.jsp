<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서등록</h1>
	<form action="deptInsert.do" method="post">
	부서번호: <input type="number" name="department_id" value="300"><br>
	부서이름: <input type="text" name="department_name" value="개발부"><br>
	매니저: <input type="number" name="manager_id" value="100"><br>
	지역코드: <input type="number" name="location_id" value="1700"><br>
	<input type="submit" value="부서저장">
	</form>
</body>
</html>