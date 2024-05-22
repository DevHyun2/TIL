<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<!-- 표준 action은 각각 컴파일해서 합친다. -->
<%-- <jsp:include page="../common/header.jsp"></jsp:include> --%>
<!-- include 지시자는 합쳐서 컴파일한다. -->
<%@ include file="../common/header.jsp" %>
<a href="${path}/dept/deptInsert.do">신규 부서 등록</a>
<h1>부서목록</h1>
<p>${deptResult}</p>
<table border="1">
	<thead>
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>매니저</th>
			<th>지역코드</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dept" items="${deptlist}">
			<tr>
				<td>
					<a href="${path}/dept/deptUpdate.do?deptid=${dept.department_id}">${dept.department_id}</a>
				</td>
				<td>${dept.department_name}</td>
				<td>${dept.manager_id}</td>
				<td>${dept.location_id}</td>
				<td><button onclick="location.href='${path}/dept/deptDelete.do?deptid=${dept.department_id}'">삭제</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	setTimeout(() => {
		var message = "${deptResult}";
		if(message!="") {
			alert(message);
		}
	}, 1000);

	/*  */
</script>
</body>
</html>