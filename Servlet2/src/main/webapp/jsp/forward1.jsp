<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward1</title>
</head>
<body>
<h1>forward1</h1>
<%-- forward1.jsp를 요청하면 forward2.jsp로 위임 --%>
<%-- <jsp:forward page="forward2.jsp"></jsp:forward> --%>

<%-- forward2.jsp가 현재 페이지에 포함 --%>
<jsp:include page="forward2.jsp"></jsp:include>
<jsp:include page="forward2.jsp"></jsp:include>
</body>
</html>