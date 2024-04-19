<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String uid = request.getParameter("userid");
String upass = request.getParameter("userpw");
String remember = request.getParameter("remember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전송받은 값</h1>
<p>아이디 <%=uid %></p>
<p>비밀번호 <%=upass %></p>
<p>기억하기 <%=remember %></p>
</body>
</html>