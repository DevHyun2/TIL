<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 페이지:500</title>
</head>
<body>
<h1>오류 페이지</h1>
<h2>원인: <%=exception.getMessage() %></h2>
</body>
</html>