<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 상세보기</title>
</head>
<body>
<h1>부서 상세보기</h1>
<!-- EL(Expression Language)표기법 -->
<!-- HTML주석: ${deptInfo} -->
<!-- JSP가 해석되어 HTML이 만들어진다 -->
<%-- JSP주석: ${deptInfo} --%>
<p>부서번호: ${deptInfo.department_id}</p>
<p>부서이름: ${deptInfo.department_name}</p>
</body>
</html>