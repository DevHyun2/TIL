<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>binding 연습</title>
</head>
<body>
<h1>binding 연습1</h1>
<p>1.ServletContext:${applicatonScope.appData}</p>
<p>2.HttpSession:${sessionScope.sessionData}</p>
<p>3.HttpServletRequest:${requestScope.requestData}</p>
</body>
</html>