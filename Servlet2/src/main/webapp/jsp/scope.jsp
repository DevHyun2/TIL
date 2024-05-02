<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${mydata }</h1>
<h1>request: ${requestScope.mydata }</h1>
<h1>session: ${sessionScope.mydata }</h1>
<h1>application: ${applicationScope.mydata }</h1>

<h1>${myage1 }</h1>
<h1>${myage2 }</h1>
<h1>${myage3 }</h1>
</body>
</html>