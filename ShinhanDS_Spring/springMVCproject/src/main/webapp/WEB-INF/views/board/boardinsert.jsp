<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
	<h1>게시글 등록</h1>
	<form action="${path}/board/boardInsert.do" 
	method="post">
		title : <input type="text" name="title"><br>
		content : <input type="text" name="content"><br>
		pic : 
		<input type="text" name="pic">
		
		<br>
		<input type="submit" value="입력">
	</form>
</body>
</html>