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
<h1>직원 상세 보기</h1>

<div class="container mt-3">
  <a href="emplist.do">직원목록으로 돌아가기</a>
  <hr>
 
  <form action="empDetail.do" method="post" >
    <div class="mb-3 mt-3">
      <label for="employee_id">employee_id:</label>
      <input type="number" class="form-control" id="employee_id" placeholder="Enter employee_id" name="employee_id" value="${empInfo.employee_id}">
    </div>
    <div class="mb-3 mt-3">
      <label for="first_name">first_name:</label>
      <input type="text" class="form-control" id="first_name" placeholder="Enter first_name" name="first_name" value="${empInfo.first_name}">
    </div>
    <div class="mb-3 mt-3">
      <label for="last_name">last_name:</label>
      <input type="text" class="form-control" id="last_name" placeholder="Enter last_name" name="last_name"  value="${empInfo.last_name}">
    </div>
    <div class="mb-3 mt-3">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email"  value="${empInfo.email}">
    </div>
    <div class="mb-3 mt-3">
      <label for="phone_number">phone_number:</label>
      <input type="text" class="form-control" id="phone_number" placeholder="Enter phone_number" name="phone_number" value="${empInfo.phone_number}">
    </div>
    <div class="mb-3 mt-3">
      <label for="hire_date">hire_date:</label>
      <input type="date" class="form-control" id="hire_date" placeholder="Enter hire_date" name="hire_date"  value="${empInfo.hire_date}">
    </div>
    
    
    <div class="mb-3 mt-3">
      <label for="job_id">job_id:</label>
      <select name="job_id">
      	<c:forEach items="${joblist}" var="job">
      		<option value="${job.job_id}" ${empInfo.job_id == job.job_id?"selected":""}>${job.job_id} / ${job.job_title}</option>
      	</c:forEach>
      </select>
    </div>
    
    <div class="mb-3 mt-3">
      <label for="salary">salary:</label>
      <input type="number" class="form-control" id="salary" placeholder="Enter salary" name="salary" value="${empInfo.salary}">
    </div>
    <div class="mb-3 mt-3">
      <label for="commission_pct">commission_pct:</label>
      <input type="number" class="form-control" id="commission_pct" placeholder="Enter commission_pct" name="commission_pct"  value="${empInfo.commission_pct}">
    </div>
    
    <div class="mb-3 mt-3">
      <label for="manager_id">manager_id:</label>
      <select name="manager_id">
      	<c:forEach items="${mlist}" var="manager">
 	  			<option value="${manager.employee_id}" ${empInfo.manager_id==manager.employee_id?"selected":"" }>${manager.employee_id} / ${manager.fullname}</option>
 	  		</c:forEach>
      </select>
    </div>
    
    <div class="mb-3 mt-3">
      <label for="department_id">department_id:</label>
 	  <select name = "department_id">
 	  		<c:forEach items="${deptlist}" var="dept">
 	  			<option value="${dept.department_id}" ${empInfo.department_id == dept.department_id?"selected":"" }>${dept.department_id} / ${dept.department_name}</option>
 	  		</c:forEach>
 	  </select>     
    </div>
    
    <input type="submit" class="btn btn-primary" value="수정하기">
  </form>
</div>
</body>
</html>