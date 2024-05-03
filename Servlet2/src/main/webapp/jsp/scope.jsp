<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 데이터를 찾는 범위 순서: request => session => application -->
<h1>${mydata}</h1>
<h1>request: ${requestScope.mydata}</h1>
<h1>session: ${sessionScope.mydata}</h1>
<h1>application: ${applicationScope.mydata}</h1>
<h2>${myage1}</h2>
<h2>${myage2}</h2>
<h2>${myage3}</h2>
</body>
</html>