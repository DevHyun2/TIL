<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든직원조회</title>
<style>
table, tr, th, td{
	padding: 10px;
	border-collapse: collapse;
}
thead {
	color: white;
}
button {
	padding: 5px;
}
</style>
<script src="../static/js/jquery-3.7.1.min.js"></script>
<script>
var myname = "bb";
// 1)JavaScript의 백틱 문법: JSP 문법과 혼란...JSP에서 백틱은 \${}를 사용
var bb = `나의 이름은 \${myname}`;
console.log(bb);
// 2)jQuery
$(function(){
	$("tr th").css("backgroundColor", "navy");
});
// 3)JSP의 EL(Expression Language) 문법
var aa = "${emplist}";
<%-- 4)JSTL(JSp Tag Library) 문법 <c:forEach>...</c:forEach> --%>

function f_insert(){
	location.href="empInsert.do";
}
</script>
</head>
<body>
<%--include 지시자: JSP를 합쳐서 컴파일 --%>
<%--include 액션 태그: 각각 컴파일해서 합침 --%>
<%-- <%@ include file="../common/loginHeader.jsp" %> --%>
<jsp:include page="../common/loginHeader.jsp"></jsp:include>
<h2>접속인원:${total_user }</h2>
<ul>
  <c:forEach var="user" items="${user_list}">
    <li>${user}</li>
  </c:forEach>
</ul>
<%--<h1>세션에서 읽기 : ${memberId}</h1>
<h1>세션에서 읽기 : ${memberPass}</h1>
<h1>myinfo(다른 Servlet의 request 접근 불가): ${myinfo}</h1>
<h1>myinfo2(같은 브라우저로 접근하면 session 접근 가능): ${myinfo2}</h1>
<h1>myinfo3(ServletContext는 모든 Servlet에서 접근 가능, 모든 사용자가 공유): ${myinfo3}</h1>
<p>다음은 주소 창에 주소를 바꾸는 방법(재요청)</p>
<a href="empInsert.do">신규직원등록1</a>
<a href="javascript:location.href='empInsert.do'">신규직원등록2</a>
<button onclick="location.href='empInsert.do'">신규직원등록3</button>
<button onclick="f_insert()">신규직원등록4</button>--%>
<form action="empInsert.do">
	<input type="submit" value="신규직원등록5">
</form>
<a href="../index.html">홈으로 돌아가기</a>
<hr>
<h1>직원목록</h1>
<table border="1">
	<thead>
		<tr>
			<th>직원번호</th>
			<th>이름</th>
			<th>성</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>입사일</th>
			<th>직책</th>
			<th>급여</th>
			<th>커미션</th>
			<th>매니저</th>
			<th>부서번호</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${emplist}" var="emp">
			<tr>
				<td>
					<a href="empDetail.do?empid=${emp.employee_id}">
						${emp.employee_id}
					</a>
				</td>
				<td>${emp.first_name}</td>
				<td>${emp.last_name}</td>
				<td>${emp.email}</td>
				<td>${emp.phone_number}</td>
				<td><fmt:formatDate type="both" value="${emp.hire_date }" pattern="YYYY/MM/DD hh:mm:ss"/></td>
				<td>${emp.job_id}</td>
				<td><fmt:formatNumber value="${emp.salary }" groupingUsed="true" currencySymbol="￦"></fmt:formatNumber></td>
				<td>${emp.commission_pct}</td>
				<td>${emp.manager_id}</td>
				<td>${emp.department_id}</td>
				<td>
					<button onclick="location.href='empDelete.do?empid=${emp.employee_id}'">DELETE</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</html>