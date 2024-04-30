<%@page import="com.shinhan.controller2.JobDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>empInsert</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="/webshop7/static/js/jquery-3.7.1.min.js"></script>
  <script>
  	$(function(){
  		$("form").on("submit", call);
  		
  	});
  	function call() {
  		var salary = $("#salary").val();
  		if(salary == "" || salary <= 0) {
  			alert("salary값은 0보다 큰 값이어야 한다.");
  			event.preventDefault(); //default 이벤트 취소 ( 서버 전송 취소 )
  			$("#salary").focus(); //커서를 salary칸으로 이동
  		}
  	}
  
  </script>


</head>
<body>

<div class="container mt-3">
  <a href="emplist.do">직원목록 보기</a>
  <hr>
  <h2>신규직원등록</h2>
  <form action="empInsert.do" method="post" >
    <div class="mb-3 mt-3">
      <label for="employee_id">employee_id:</label>
      <input type="number" class="form-control" id="employee_id" placeholder="Enter employee_id" name="employee_id" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="first_name">first_name:</label>
      <input type="text" class="form-control" id="first_name" placeholder="Enter first_name" name="first_name">
    </div>
    <div class="mb-3 mt-3">
      <label for="last_name">last_name:</label>
      <input type="text" class="form-control" id="last_name" placeholder="Enter last_name" name="last_name" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="phone_number">phone_number:</label>
      <input type="text" class="form-control" id="phone_number" placeholder="Enter phone_number" name="phone_number">
    </div>
    <div class="mb-3 mt-3">
      <label for="hire_date">hire_date:</label>
      <input type="date" class="form-control" id="hire_date" placeholder="Enter hire_date" name="hire_date" required>
    </div>
    
    
    <div class="mb-3 mt-3">
      <label for="job_id">job_id:</label>
      <select name="job_id">
      	<c:forEach items="${joblist}" var="job">
      		<option value="${job.job_id}">${job.job_title}</option>
      	</c:forEach>
      </select>
    </div>
    
    <div class="mb-3 mt-3">
      <label for="salary">salary:</label>
      <input type="number" class="form-control" id="salary" placeholder="Enter salary" name="salary">
    </div>
    <div class="mb-3 mt-3">
      <label for="commission_pct">commission_pct:</label>
      <input type="number" class="form-control" id="commission_pct" placeholder="Enter commission_pct" name="commission_pct">
    </div>
    
    <div class="mb-3 mt-3">
      <label for="manager_id">manager_id:</label>
      <select name="manager_id">
      	<c:forEach items="${mlist}" var="manager">
 	  			<option value="${manager.manager_id}"${empInfo.manager_id==manager.employee_id?"selected":"" }>${manager.fullname}</option>
 	  		</c:forEach>
      </select>
    </div>
    
    <div class="mb-3 mt-3">
      <label for="department_id">department_id:</label>
 	  <select name = "department_id">
 	  		<c:forEach items="${deptlist}" var="dept">
 	  			<option value="${dept.department_id}">${dept.department_name}</option>
 	  		</c:forEach>
 	  </select>     
    </div>
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>