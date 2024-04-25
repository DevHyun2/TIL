<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- EL(Expression Language)표기법 --%>
<%-- HTML주석 : ${deptInfo} --%>
<%-- JSP주석 : ${} --%>
<body>
	<h1>부서 상세보기</h1>
	<p>부서번호:${deptInfo.department_id}</p>
	<p>부서명:${deptInfo.department_name}</p>
</html>