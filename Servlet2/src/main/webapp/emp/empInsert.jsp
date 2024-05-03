<%@page import="com.shinhan.job.JobDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>직원 입력</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="/webshop12/static/js/jquery-3.7.1.min.js"></script>
  <script>
    $(function(){
    	$("form").on("submit", call);
    });
    
    function call(event){
    	var salary = $("#salary").val();
    	
    	if (salary == "" || salary <= 0){
    		alert("salary 값은 0보다 큰 값이어야 한다");
    		event.preventDefault(); // default 이벤트(서버전송) 취소
    		document.querySelector("#salary").focus();
    	}
    }
  </script>
</head>
<body>

<div class="container mt-3">
  <a href="emplist.do">직원목록보기</a>
  <h2>신규 직원 등록</h2>
  <form action="empInsert.do" method="post">
    <div class="mb-3 mt-3">
      <label for="employee_id">직원번호:</label>
      <input type="number" class="form-control" id="employee_id" placeholder="Enter employee id" name="employee_id" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="first_name">이름:</label>
      <input type="text" class="form-control" id="first_name" placeholder="Enter first name" name="first_name">
    </div>
    <div class="mb-3 mt-3">
      <label for="last_name">성:</label>
      <input type="text" class="form-control" id="last_name" placeholder="Enter last name" name="last_name" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="email">이메일:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="phone_number">전화번호:</label>
      <input type="text" class="form-control" id="phone_number" placeholder="Enter phone number" name="phone_number">
    </div>
    <div class="mb-3 mt-3">
      <label for="hire_date">입사일:</label>
      <input type="date" class="form-control" id="hire_date" name="hire_date" required>
    </div>
    <%-- ScriptLet 문법: 사용 지양, EL(${}, 반복문 없음), JSTL(<c:forEach>) 문법 사용 지향 --%>
    <div class="mb-3 mt-3">
      <label for="job_id">직책:</label>
      <select name="job_id" required>
	    <c:forEach items="${jlist}" var="job">
	      <option value="${job.job_id}">${job.job_title}</option>
	    </c:forEach>
      </select>
    </div>
    <div class="mb-3 mt-3">
      <label for="salary">급여:</label>
      <input type="number" class="form-control" id="salary" placeholder="Enter salary" name="salary">
    </div>
    <div class="mb-3 mt-3">
      <label for="commission_pct">커미션:</label>
      <input type="text" class="form-control" id="commission_pct" placeholder="Enter commission pct" name="commission_pct">
    </div>
    <div class="mb-3 mt-3">
      <label for="manager_id">매니저:</label>
      <select name="manager_id">
        <c:forEach items="${mlist}" var="manager">
          <option value="${manager.employee_id}">${manager.fullname}</option>
        </c:forEach>  
      </select>
    </div>
    <div class="mb-3 mt-3">
      <label for="department_id">부서번호:</label>
      <select name="department_id">
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
