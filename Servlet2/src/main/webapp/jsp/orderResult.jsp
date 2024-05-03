<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문결과</title>
</head>
<body>
<h1>장바구니 결과</h1>
<table border="1">
	<thead>
		<tr>
			<th>메뉴</th>
			<th>수량</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${cart}" var="menu">
		<tr>
			<td>${menu.key}</td>
			<td>${menu.value}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<a href="order.go">주문추가</a>
<form action="orderRemove.go">
	<input type="submit" value="장바구니비우기">
</form>
</body>
</html>