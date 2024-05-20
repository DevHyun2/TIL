<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBeans Test 2</title>
</head>
<body>
<h1>JavaBeans 이용(getting)</h1>
<jsp:useBean id="dept2" class="com.shinhan.dept.DeptDTO" scope="request"></jsp:useBean>
부서번호: <jsp:getProperty property="department_id" name="dept2"/><br>
부서이름: <jsp:getProperty property="department_name" name="dept2"/><br>
지역번호: <jsp:getProperty property="location_id" name="dept2"/><br>
매니저: <jsp:getProperty property="manager_id" name="dept2"/>
</body>
</html>