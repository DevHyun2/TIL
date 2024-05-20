<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}"/>
<div>
	로그인 사용자:
	<c:if test="${emp=null}">
	손님
	</c:if>
	<c:if test="${emp!=null}">
	${emp.first_name}님 환영합니다	
	</c:if> 
</div>