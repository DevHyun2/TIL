<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서별직원목록</title>
<style>
#container {
	width:960px;
}

#deptlist {
	width: 33%;
	float: left;
}

#emplist {
	width: 66%;
	float: left;
}

table, tr, th, td{
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px;
}

thead {
	background-color: navy;
	color: white;
}
</style>
<script src="../static/js/jquery-3.7.1.min.js"></script>
<script>
function call(deptid){
	$.ajax({
		type:"post",
		url:"empByDept.do",
		data:{"deptid":deptid},
		success:function(responseHTML){
			$("#emplist").html(responseHTML);
		}
	});
}
</script>
</head>
<body>

<h1>binding 연습2</h1>
<p>1.ServletContext:${appData}</p>
<p>2.HttpSession:${sessionData}</p>
<p>3.HttpServletRequest:${requestData}</p>

<h1>부서별직원조회</h1>
<div id="container">
	<div id="deptlist">
		<table>
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dlist}" var="dept">
					<tr>
						<td><a href="javascript:call(${dept.department_id})">${dept.department_id}</a></td>
						<td>${dept.department_name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="emplist"></div>
</div>
</body>
</html>