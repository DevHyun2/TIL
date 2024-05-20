<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Binding Set</title>
</head>
<body>
<h1>get.jsp</h1>
<h1>request: ${myinfo}</h1>
<h1>session: ${myinfo2}</h1>
<h1>ServletContext: ${myinfo3}</h1>
<h1>menu_member : ${initParam['menu_member']}</h1>
<h1>menu_order : ${initParam['menu_order']}</h1>
<ul>
	<c:forTokens items="${initParam['menu_member']}" delims=" " var="member">
		<li>${member}</li>
	</c:forTokens>
</ul>
<ul>
	<c:forTokens items="${initParam['menu_order']}" delims=" " var="order">
		<li>${order}</li>
	</c:forTokens>
</ul>
<p>은행이름 : ${initParam['bank_name']}</p>
</body>
</html>