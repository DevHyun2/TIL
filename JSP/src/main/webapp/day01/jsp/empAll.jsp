<%@page import="java.util.List"%>
<%@page import="com.shinhan.day15.EmpDTO"%>
<%@page import="com.shinhan.day15.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
#container{
	width: 1220px;
	border: 1px solid gray;
	margin: 0 auto;
}
h1{
	height: 100px;
	border: 1px solid gray;
	text-align: center;
	line-height: 100px;
	font-size: 50px;
	background-color: beige;
	color : orange;
}
a.decoNone{
	text-decoration: none;
	background-color: gray;
	color: white;
	padding: 10px;
	border-radius: 30px;
}
table, th, td {
	border-collapse: collapse;
}
th, td{
	padding: 10px;
	font-size: 15px;
	text-align: center;
}
th{
	background-color: lightgreen;
	color: navy;
}
/* 칸을 띄우면 자손을 의미 */
tbody tr:nth-child(2n){
	background-color: lightgray;
}
tbody tr:nth-child(2n+1){
	background-color: rgb(50,50,150,0.4);
}
#title{
	font-size: 30px;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="container">
	<h1>전직원목록</h1>
	<a class="decoNone" href="empInsert.jsp">신규직원 등록</a>
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
				<td><%=emp.getFirst_name() %></td>
				<td><%=emp.getLast_name() %></td>
				<td><%=emp.getEmail() %></td>
				<td><%=emp.getCommission_pct() %></td>
				<td><%=emp.getDepartment_id()%></td>
				<td><%=emp.getPhone_number()%></td>
				<td><%=emp.getSalary()%></td>
				<td><%=emp.getHire_date()%></td>
				<td><%=emp.getManager_id()%></td>
				<td><%=emp.getJob_id()%></</td>
			</tr>
			<%} %>
				
		</tbody>
	</table>
</div>
</body>
</html>