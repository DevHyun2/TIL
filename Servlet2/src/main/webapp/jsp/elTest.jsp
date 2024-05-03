<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연습</title>
</head>
<body>
<h1>EL 연습</h1>
<%
Integer a = 100;
String b = String.valueOf(100);
request.setAttribute("score", 100);
int score2 = 300; // setAttribute가 아니라서 읽어오지 못함
request.setAttribute("greeting", "hello");
request.setAttribute("dept", new DeptDTO(10, "개발부", 100, 1700));

// 찾는 범위 순서: pageContext > request > session > application
pageContext.setAttribute("data1", 10);
request.setAttribute("data1", 20);
session.setAttribute("data1", 30);
application.setAttribute("data1", 40);

String p1 = request.getParameter("a");
String p2 = request.getParameter("b");

DeptService service = new DeptService();
List<DeptDTO> deptlist = service.selectAll();
request.setAttribute("deptlist", deptlist);

HashMap<String, Integer> cart = new HashMap<>();
cart.put("아메리카노",10);
cart.put("latte",20);
request.setAttribute("cart", cart);

HashMap<String, List<DeptDTO>> cart2 = new HashMap<>();
cart2.put("부서", deptlist);
request.setAttribute("cart2", cart2);
%>
<pre>
1.boolean : ${10>20}
2.string : ${"Hello"}${100}
<%-- 3.null : ${null+100} --%>
4.score : ${score+200} .... ${score2}
5.score2 : <%=score2 %>
6.나누기 : ${10/3}
<%-- 6.나누기 : ${10 div 3} --%>
6.나머지 : ${10 mod 3}
7.비교 : ${"hello"==greeting} ... ${greeting}
7.비교 : ${"hello" eq greeting}
8.논리(and) : ${score>=100 && greeting!="hello"}
8.논리(or) : ${score>=100 || greeting!="hello"}
9.dept toString() : ${dept}
9.dept getter : ${dept.department_name}
9.dept empty : ${empty dept}
9.dept not empty : ${not empty dept}
10.scope : ${data1}
10.pageScope : ${pageScope.data1}
10.requestScope : ${requestScope.data1}
10.sessionScope : ${sessionScope.data1}
10.applicationScope : ${applicationScope.data1}
11.param : ${param.a} ... <%=p1 %>
11.param : ${param.b} ... <%=p2 %>

EL문법은 반복문 사용이 불가능
12.Collection 읽기 : ${deptlist[0].department_name}
12.Collection 읽기 : ${deptlist[1].department_name}

반복문은 JSTL 문법으로 구현
</pre>
<ul>
	<c:forEach items="${deptlist}" var="dept">
		<li>${dept.department_name}</li>
	</c:forEach>
</ul>
<pre>
13.Map 읽기 : ${cart["아메리카노"]}
13.Map 읽기 : ${cart.latte}
</pre>
<ul>
	<c:forEach items="${cart}" var="mycart">
		<li>${mycart.key}.....${mycart.value}</li>
	</c:forEach>
</ul>
<pre>
14.Map 안의 리스트 접근 : ${cart2["부서"][0].department_name}
</pre>
</body>
</html>