<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름충돌 방지를 위한 uri --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
<script src="${pageContext.request.servletContext.contextPath}/static/js/JQuery/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$("#btn1").on("click",f1);
});
	
	function f1() {
		var job_id = $("#job_id").val();
		var dept_id = $("#dept_id").val();
		var salary = $("#salary").val();
		var hire_date = $("#hire_date").val();
		
		//주소 바뀌지 않고 조회하기 ajax
		$.ajax({
			url:"retrieve.do",
			type:"post",
			data:{"jobid":job_id, "deptid":dept_id, "salary":salary, "hiredate":hire_date},
			success:function(responseData){
				$("#here").html(responseData);
			},
			error:function(xhr, status, error){
				alert(error); //Ajax가 실패 -> 보안, 주소 등
			}
		});
	}
	function call(empid){
		$.ajax({
			url:"empDetail.do",
			type:"get",
			data:{"empid":empid},
			success:function(responseData){
				$("#here2").html(responseData);
			}
		});
	}
</script>
</head>
<body>

<h1>조건조회</h1>

	직책선택:
	<select id="job_id">
		<c:forEach var="job" items="${job_datas }">
			<option value="${job.job_id }"${job.job_id == 'IT_PROG'?"selected":""}>${job.job_title }</option>
		</c:forEach>
	</select>
	부서선택:
	<select id="dept_id">
		<c:forEach var="dept" items="${dept_datas }">
			<option value="${dept.department_id }" ${dept.department_id == 60?"selected":""}>${dept.department_name }</option>
		</c:forEach>
	</select>
	급여(이상): <input type="number" id="salary" value=10000>
	입사일(이후): <input type="date" id="hire_date" value="2005-01-01">
	<button id="btn1">조건조회</button>
	<hr>
	<div id="here">here</div>
	<div id="here2">here</div>

</body>
</html>