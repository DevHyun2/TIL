<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 상세보기</title>
<style>
.deptTitle{
	background-color: yellow;
}
input[readonly]{
	background-color: black;
	color: white;
}
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<h1 class="deptTitle">부서 상세보기(수정)</h1>
<form action="${path}/dept/deptDBUpdate.do" method="post">
	<label>부서번호</label>
	<input type="number" name="department_id" value="${dept.department_id}" readonly><br>
	<label>부서이름</label>
	<input name="department_name" value="${dept.department_name}"><br>
	<label>매니저</label>
	<%-- <input type="number" name="manager_id" value="${dept.manager_id}"><br> --%> 
	<select name="manager_id">
		<c:forEach var="manager" items="${mlist}">
			<option value="${manager.employee_id}"${dept.manager_id==manager.employee_id?"selected":""}>
			${manager.fullname}/${manager.employee_id}
			</option>
		</c:forEach>
	</select>
	<label>지역코드</label>
	<input type="number" name="location_id" value="${dept.location_id}"><br>
	<input type="submit" value="DB에저장">
</form>
</body>
</html>