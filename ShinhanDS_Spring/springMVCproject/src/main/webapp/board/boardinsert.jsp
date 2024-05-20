<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 등록</h1>
<%-- <form action="${pageContext.request.servletContext.contextPath }/board/boardInsert.do" enctype="multipart/form-data" method="post"> --%> 
title: <input type="text" name="title" ><br>
content: <input type="text" name="content" ><br>
pic: <input type="file" name="pic" ><br>
<input type="submit" value="입력">
</form>
</body>
</html>