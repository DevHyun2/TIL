<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
하이염
<h1>이름 ${myname }</h1>
<h1>점수 ${myscore }</h1>
<h2>get방식 요청(요청주소 Param이용:동일한 값, 필드존재, 값이 존재X)</h2>
<form action="${pageContext.servletContext.contextPath}/sample/hello6.do">
	email : <input type="text" name="email" value="qwe@qwe.qwe"><br>
	password : <input type="password" name="pwd" value="1234"><br>
	phone : <input type="text" name="phone" value="010-1234-1234"><br>
	<input type="submit" value="서버전송(get)">
</form>
<hr>
<h2>post방식</h2>
<form action="${pageContext.servletContext.contextPath}/sample/hello6.do" method="post">
	email : <input type="text" name="email" value="qwe@qwe.qwe"><br>
	password : <input type="password" name="pwd" value="1234"><br>
	phone : <input type="text" name="phone" value="010-1234-1234"><br>
	<input type="submit" value="서버전송(post)">
</form>
</body>
</html>