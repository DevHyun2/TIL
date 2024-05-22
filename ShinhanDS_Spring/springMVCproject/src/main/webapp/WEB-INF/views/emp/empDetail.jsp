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
	<%@ include file="../common/header.jsp" %>
	<h1>직원상세보기(spring)</h1>
	<form action="${path}/emp/empDetail.do" method="post">
    <div class="mb-3 mt-3">
      <label for="employee_id">직원번호: </label>
      <input type="number" class="form-control" id="employee_id" 
      placeholder="Enter employee_id" name="employee_id" value="${empInfo.employee_id}">
    </div>
    <div class="mb-3 mt-3">
      <label for="first_name">firstname: </label>
      <input type="text" class="form-control" id="employee_id" 
      placeholder="Enter first_name" name="first_name" value="${empInfo.first_name}">
    </div>
    
    <div class="mb-3 mt-3">
      <label for="last_name">lastname: </label>
      <input type="text" class="form-control" id="last_name" 
      placeholder="Enter last_name" name="last_name"  value="${empInfo.last_name}">
    </div>
    <div class="mb-3 mt-3">
      <label for="email">email: </label>
      <input type="email" class="form-control" id="email" 
      placeholder="Enter email" name="email"  value="${empInfo.email}">
    </div>
    
    <div class="mb-3 mt-3">
      <label for="phone_number">phone number: </label>
      <input type="text" class="form-control" id="phone_number" 
      placeholder="Enter phone_number" name="phone_number"  value="${empInfo.phone_number}">
    </div>
    

     <div class="mb-3 mt-3">
      <label for="job_id">job_id: </label>
       <select name="job_id">
      		<c:forEach items="${joblist}" var="job">
      			<option value="${job.job_id}" ${empInfo.job_id==job.job_id?"selected":""}>
      				${job.job_title}
      			</option>
      		</c:forEach>
      </select>
    </div>
    
    
    <div class="mb-3 mt-3">
      <label for="manager_id">매니져 ID: </label>
      <select name="manager_id">
      	<option value="0">No매니저</option>
      	<c:forEach items="${mlist}" var="manager">
      			<option value="${manager.employee_id}" ${empInfo.manager_id==manager.employee_id?"selected" : ""}>
      			${manager.employee_id} / ${manager.fullname}</option>
      		</c:forEach>
      </select>
    </div>
    
    
    <div class="mb-3 mt-3">
      <label for="job_id">직업번호: </label>
      <input type="text" class="form-control" id="job_id"
      	 placeholder="Enter job_id" name="job_id"  value="${empInfo.job_id}">
    </div>
    
    <div class="mb-3 mt-3">
      <label for="department_id">department_id: </label>
      <select name="department_id">
    		<option value="0">No부서</option>  			
				<c:forEach items="${deptlist}" var="dept">
   				<option value="${dept.department_id}" ${empInfo.department_id==department_id?"selected":""}>
   			 	${dept.department_id} / ${dept.department_name}</option>
   			</c:forEach>
      </select>
    </div>
    
    <div class="mb-3 mt-3">
      <label for="salary">월급: </label>
      <input type="number" class="form-control" id="salary" 
      placeholder="Enter salary" name="salary" value="${empInfo.salary}">
    </div>
    <div class="mb-3 mt-3">
      <label for="commission_pct">보너스: </label>
      <input type="text" class="form-control" id="commission_pct" 
      placeholder="Enter commission_pct" name="commission_pct" value="${empInfo.commission_pct}">
    </div>
    <div class="mb-3 mt-3">
      <label for="hire_date">입사날짜: </label>
      <input type="date" class="form-control" id="hire_date" 
      placeholder="Enter hire_date" name="hire_date" value="${empInfo.hire_date}">
    </div>
    <input type="submit" class="btn btn-primary" value="수정하기">
  </form>
</body>
</html>