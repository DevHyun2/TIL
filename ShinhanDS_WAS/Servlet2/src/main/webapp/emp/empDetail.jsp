<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원상세보기</title>
</head>
<body>
<div class="container mt-3">
<%@ include file="../common/loginHeader.jsp" %>
<!-- include 지시자는 파일을 합쳐서 컴파일 -->
	<h1>직원상세보기</h1>
	<form action="empDetail.do" method="post">
    <div class="mb-3 mt-3">
      <label for="employee_id">직원번호:</label>
      <input type="number" class="form-control" id="employee_id" placeholder="Enter employee id" name="employee_id" value="${empInfo.employee_id}">
    </div>
    <div class="mb-3 mt-3">
      <label for="first_name">이름:</label>
      <input type="text" class="form-control" id="first_name" placeholder="Enter first name" name="first_name" value="${empInfo.first_name}">
    </div>
    <div class="mb-3 mt-3">
      <label for="last_name">성:</label>
      <input type="text" class="form-control" id="last_name" placeholder="Enter last name" name="last_name" value="${empInfo.last_name}">
    </div>
    <div class="mb-3 mt-3">
      <label for="email">이메일:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${empInfo.email}">
    </div>
    <div class="mb-3 mt-3">
      <label for="phone_number">전화번호:</label>
      <input type="text" class="form-control" id="phone_number" placeholder="Enter phone number" name="phone_number" value="${empInfo.phone_number}">
    </div>
    <div class="mb-3 mt-3">
      <label for="hire_date">입사일:</label>
      <input type="date" class="form-control" id="hire_date" name="hire_date" value="${empInfo.hire_date}">
    </div>
    <%-- ScriptLet 문법: 사용 지양, EL(${}, 반복문 없음), JSTL(<c:forEach>) 문법 사용 지향 --%>
    <div class="mb-3 mt-3">
      <label for="job_id">직책:</label>
      <select name="job_id">
	    <c:forEach items="${jlist}" var="job">
	      <option value="${job.job_id}" ${empInfo.job_id == job.job_id?"selected":""}>
	      ${job.job_title}</option>
	    </c:forEach>
      </select>
    </div>
    <div class="mb-3 mt-3">
      <label for="salary">급여:</label>
      <input type="number" class="form-control" id="salary" placeholder="Enter salary" name="salary" value="${empInfo.salary}">
    </div>
    <div class="mb-3 mt-3">
      <label for="commission_pct">커미션:</label>
      <input type="text" class="form-control" id="commission_pct" placeholder="Enter commission pct" name="commission_pct" value="${empInfo.commission_pct}">
    </div>
    <div class="mb-3 mt-3">
      <label for="manager_id">매니저:</label>
      <select name="manager_id">
        <c:forEach items="${mlist}" var="manager">
          <option value="${manager.employee_id}" ${empInfo.manager_id == manager.employee_id?"selected":""}>
          ${manager.fullname}</option>
        </c:forEach>  
      </select>
    </div>
    <div class="mb-3 mt-3">
      <label for="department_id">부서:</label>
      <select name="department_id">
        <c:forEach items="${deptlist}" var="dept">
          <option value="${dept.department_id}" ${empInfo.department_id == dept.department_id?"selected":""}>
          ${dept.department_id} / ${dept.department_name}</option>
        </c:forEach>
      </select>
    </div>
    <input type="submit" class="btn btn-primary" value="Modify">
  </form>
 </div>
</body>
</html>