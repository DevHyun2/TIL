<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>
    $(function(){
       $("form").on("submit", call);
       $("#btnDupCheck").on("click", f_dupCheck);
    });
    function f_dupCheck(){
    	var empid = $("#employee_id").val();
    	if(empid=="") {
    		alert("직원번호를 입력하세요");
    		document.querySelector("#employee_id").focus();
    		return;
    	}
    	$.ajax({
    		url:"empIdCheck.do",
    		data:{"empid":empid},
    		type:"get",
    		success:function(responseData){
    			var message = "";
    			if(responseData=="0"){
    				message = "사용가능";
    			}else{
    				message = "사용불가능";
    				$("#employee_id").val("");
    				document.querySelector("#employee_id").focus();
    			}
    			$("#resultMessage").val(message);
    		},
    		error:function(data){
    			alert(data);
    		}
    	});
    }
    
    
    function call(event){
    	var salary = $("#salary").val();
    	if(salary=="" || salary <=0 ){
    		alert("salary값은 0보다 큰 값이어야한다. ");
    		event.preventDefault(); //default이벤트 취소 (서버전송 취소)
    		document.querySelector("#salary").focus();
    	}
    }
    
  </script>

</head>
<body>
<c:set var="path" value="${pageContext.servletContext.contextPath }"/>
<div class="container mt-3">
  <a href="${path}/emp/empAll.do">직원목록보기</a>
  <h2>신규직원등록</h2>
  <form action="${path}/emp/empInsert.do" method="post" >
    <div class="mb-3 mt-3">
      <label for="employee_id">직원번호:</label>
      <input type="number" class="form-control" id="employee_id" 
      placeholder="Enter employee_id" name="employee_id" required>
      <input type="button" value="중복체크" id="btnDupCheck">
      <input type="text" value="ID입력후 중복체크" id="resultMessage">
    </div>
     <div class="mb-3 mt-3">
      <label for="first_name">이름:</label>
      <input type="text" class="form-control" id="first_name" 
      placeholder="Enter first_name" name="first_name">
    </div>
    <div class="mb-3 mt-3">
      <label for="last_name">last_name:</label>
      <input type="text" class="form-control" id="last_name" 
      placeholder="Enter last_name" name="last_name" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="email">email:</label>
      <input type="email" class="form-control" id="email" 
      placeholder="Enter email" name="email" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="phone_number">phone_number:</label>
      <input type="text" class="form-control" id="phone_number" 
      placeholder="Enter phone_number" name="phone_number">
    </div>
    <%-- ScriptLet문법보다는 , EL(반복문없음):${}, JSTL문법:<c:forEach>을 사용하는 것이 좋다. 
      for(JobDTO job:joblist){}
    --%>
    <div class="mb-3 mt-3">
      <label for="job_id">job_id:</label>
      <select name="job_id">
        <c:forEach items="${joblist}" var="job">
          <option value="${job.job_id}">${job.job_title}</option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3 mt-3">
      <label for="hire_date">hire_date:</label>
      <input type="date" class="form-control" id="hire_date" 
      placeholder="Enter hire_date" name="hire_date" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="manager_id">manager_id:</label>
      <select name="manager_id">
        <c:forEach items="${mlist}" var="manager">
          <option value="${manager.employee_id }">${manager.fullname}</option>
        </c:forEach>
      </select>
    </div>
    
    
    <div class="mb-3 mt-3">
      <label for="department_id">department_id:</label>
      <select name="department_id">
        <c:forEach items="${deptlist}" var="dept">
          <option value="${dept.department_id}">${dept.department_name}</option>
        </c:forEach>
      </select> 
    </div>
    
    
    
    <div class="mb-3 mt-3">
      <label for="salary">salary:</label>
      <input type="number" class="form-control" id="salary" 
      placeholder="Enter salary" name="salary">
    </div>
    <div class="mb-3 mt-3">
      <label for="commission_pct">commission_pct:</label>
      <input type="text" class="form-control" id="commission_pct" 
      placeholder="Enter commission_pct" name="commission_pct">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>