<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름충돌 방지를 위한 uri --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JobAll</title>
</head>
<body>
<h1>직책목록</h1>
<select name="job_id">
	<c:forEach var="job" items="${j_datas }">
		<option value="${jab.jab_id }">${job.job_title }</option>
	</c:forEach>
</select>
</body>
</html>