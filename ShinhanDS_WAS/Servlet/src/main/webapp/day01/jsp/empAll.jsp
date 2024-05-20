<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style>
#container{
  width: 1000px;
  margin: 0 auto;
}
h1{
   height:100px;
  border: 1px solid gray;
  text-align: center;
  line-height:100px;
  background-color: beige;
  color: orange;
}
a.decoNone{
  text-decoration: none;
 /*  background-color: black;
  color: white; */
  padding: 10px;
  border-radius: 30px;
}
table, th, td {
	border-collapse: collapse;
}
th,td{
  padding: 5px;
  text-align: left; 
}
thead{
  background-color: lightgreen;
  color: hotpink;
}
/* 칸을 띄우면 자손을 의미  */
tbody tr:nth-child(2n){
  background-color: lightgray;
}
tbody tr:nth-child(2n+1){
  background-color: skyblue;
}
 
#header a {
  position: relative;
  top:-100px;
  left: 10px;
}

td[data-lname]{
  font-size: 20px;
}
td[data-lname^='B']{
  color: red;
}
td[data-job ~='IT_PROG']{
  color: purple;
}
td[data-hdate |='2005'],td[data-hdate $='07']{
  color: purple;
}
td[data-phone *='123']{
   color: red;
}
tr:has(td[data-phone *='423']){
   color: yellow;
} 
tr:has(td[data-phone *='423']) a{
   color: yellow;
} 

/*data중에 첫번째 tr의 border의 색깔 바꾸기  */
/*data중에 첫번째 tr의 background 색깔 바꾸기  */
tbody tr:nth-child(1){
    background-color: orange;
}
tbody tr:nth-of-type(1){
    border: 3px dotted blue;
}
/* td:nth-child(4){
    border: 3px dotted green;
} */
td:nth-child(3n){
    border: 5px dotted red;
}
tbody tr:last-child {
   background-color: orange; 	
}
.caption::after, .caption::before{
    content: "@@@@@@@";
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/webproject/js/jquery-3.7.1.min.js"></script>
<script>
  $(function(){
	  $("#btn1").on("click", function(){
		  $("tr td:nth-child(4)").css("color", "black");
		  $("tr td:nth-child(4)")
		  .filter(function(index,item){
			   return $(item).text().indexOf($("#email").val())>=0;  			   
		  })
		  .css("color", "red");
	  });
	  //급여찾기 : salary>=10000
	  $("#btn2").on("click", function(){
		  $("tr td:nth-child(7)").css("color", "black");
		  $("tr td:nth-child(7)").filter(function(index, item){			  
			  return Number($(item).text()) >= Number($("#salary").val()); 
		  }).css("color", "blue");
	  });
  });
</script>
</head>
<body>
<div id="container">
  <h1>전체 직원 정보</h1>
  <a class="decoNone btn btn-danger" href="empInsert.jsp">신규직원 등록</a>
  <a class="decoNone btn btn-danger" href="empAll.jsp">직원 조회</a>
  <button id="btn1">이메일찾기</button>
  <button id="btn2">급여찾기</button>
</div>
	<table border="1">
		<caption id="title">직원목록 전부조회</caption>
		<thead>
			<tr>
				<th>직원번호</th>
				<th>First_name</th>
				<th>Last_name</th>
				<th>Email</th>
				<th>Commission_pct</th>
				<th>Department_id</th>
				<th>Phone_number</th>
				<th>Salary</th>
				<th>Hire_date</th>
				<th>Manager_id</th>
				<th>Job_id</th>
			</tr>
		</thead>
		<tbody>
			<%
			EmpService eservice = new EmpService();
			List<EmpDTO> emplist = eservice.selectAll();
			%>
			<%for(EmpDTO emp:emplist) {%>
			<tr>
				<td>
				<a href="empDetail.jsp?empid=<%=emp.getEmployee_id()%>">
				<%=emp.getEmployee_id()%>
				</a>
				</td>
				<td data-fname="<%=emp.getFirst_name() %>"><%=emp.getFirst_name() %></td>
				<td><%=emp.getLast_name() %></td>
				<td><%=emp.getEmail() %></td>
				<td><%=emp.getCommission_pct() %></td>
				<td><%=emp.getDepartment_id()%></td>
				<td><%=emp.getPhone_number()%></td>
				<td><%=emp.getSalary()%></td>
				<td data-hdate="<%=emp.getHire_date()%>"><%=emp.getHire_date()%></td>
				<td><%=emp.getManager_id()%></td>
				<td><%=emp.getJob_id()%></td>
			</tr>
			<%} %>
				
		</tbody>
	</table>
</div>
</body>
</html>