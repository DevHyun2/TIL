<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력확인</h1>
<p>사원번호:<%=request.getParameter("employee_id") %></p>
<p>사원명:<%=request.getParameter("name") %></p>
<p>생년월일:<%=request.getParameter("birthdate") %></p>
<p>사원PW:<%=request.getParameter("employee_pw") %></p>
<p>부서명:<%=request.getParameter("department") %></p>
<p>직급:<%=request.getParameter("rank") %></p>
<p>입사일:<%=request.getParameter("join_date") %></p>
</body>
</html>