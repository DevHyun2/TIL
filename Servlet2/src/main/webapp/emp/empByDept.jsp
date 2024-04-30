<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#container, #deptlist, #emplist{border:1px solid gray;}
 #container{width:960px;}
 #deptlist{width:33%; float: left;}
 #emplist{width:66%;float: right;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function call(deptid) {
		$.ajax({
			url:"empByDept.do",
			type:"post",
			data:{"deptid":deptid},
			success:function(responseHTML){
				$("#emplist").html(responseHTML);
			}
		});
	}
</script>
<body>
	<div id="container">
		<div id="deptlist">
			<table border="1">
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서이름</th>
						<th>매니저</th>
						<th>지역</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dept" items="${deptlist}">
						<tr>
							<td>
								<a href="javascript:call(${dept.department_id})">
								${dept.department_id }
								</a>
							</td>
							<td>${dept.department_name }</td>
							<td>${dept.manager_id }</td>
							<td>${dept.location_id }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="emplist">
		</div>
	</div>
</body>
</html>