<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>get.jsp</h1>
<h1>request(다른 서블릿의 request 접근불가) : ${myinfo }</h1>
<h1>session (같은 브라우저로 접근하면 session 접근가능) : ${myinfo2 }</h1>
<h1>ServletContext(모든 서블릿에서 접근가능, 모든 사용자가 공유) : ${myinfo3 }</h1>
<h1>initParamet: ${initParam['menu_member'] }</h1>
<h1>initParamet: ${initParam['menu_order'] }</h1>

<ul>
<c:forTokens var="member" items="${initParam['menu_member'] }" delims=" ">
	<li>${member }</li>
</c:forTokens>
</ul>
<ul>
<c:forTokens var="member" items="${initParam['menu_order'] }" delims=" ">
	<li>${member }</li>
</c:forTokens>
</ul>
</body>
</html>