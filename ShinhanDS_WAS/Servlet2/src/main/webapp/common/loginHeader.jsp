<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>${loginEmp.first_name}님 환영합니다.</h1>

<a href="${pageContext.request.servletContext.contextPath}/auth/logout.do">로그아웃</a>
<hr>

<%
// 자바코드...service 메서드 안으로 들어감
%>
<%!
// 선언문(멤버변수, 멤버메서드)
%>