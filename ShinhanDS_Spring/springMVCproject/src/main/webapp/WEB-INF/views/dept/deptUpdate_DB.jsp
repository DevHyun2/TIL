<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.deptTitle {
		background-color: aqua;
	}
	input[readonly] {
		background-color: lightgray;
	}
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<h1 class="deptTitle">부서정보 수정</h1>
<!-- EL(Expression Langueage(표기법 -->
<!-- HTML주석: ${deptInfo} -->
<!-- JSP가 해석되어 HTML이 만들어진다. -->
<%-- JSP 주석: ${deptInfo} --%>
<form action="${path}/dept/deptDBUpdate.do" method="post">
부서번호: <input type="number" name="department_id" value="${dept.department_id}" readonly><br>
부서이름: <input type="text" name="department_name" value="${dept.department_name}"><br>
현재 매니저 : ${dept.manager_id}<br>
매니저 : 
<select name="manager_id" >
	<c:forEach var="manager" items="${mlist}">
		<option value="${manager.employee_id}" 
			${dept.manager_id==manager.employee_id?"selected" : ""}>
			${manager.fullname}/${manager.employee_id}
		</option>
	</c:forEach>
</select><br>
지역코드: <input type="number" name="location_id" value="${dept.location_id}"><br>
<input type="submit" value="DB저장">
</form>
</body>
</html>