<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll</title>
</head>
<body>
<c:set var="path" value="${pageContext.servletContext.contextPath}"/>
<%--<c:set var="path" value="${pageContext.request.servletContext.contextPath }/board"/>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath }"/> --%>
<a href="${path }/board/boardinsert.do">게시판등록</a>
<table border="1">
	<tr>
		<th>bno</th>
		<th>title</th>
		<th>content</th>
		<th>writer</th>
		<th>pic</th>
		<th>작성일</th>
		<th></th>
	</tr>
	<c:forEach var="board" items="${blist }">
	<tr>
		<td><a href="${path }/board/boardDetail.do?bno=${board.bno}">${board.bno }</a></td>
		<td>${board.title }</td>
		<td>${board.content }</td>
		<td>${board.writer }</td>
		<td>
		<img alt="${board.pic}" width="50" src="${cpath}/upload/${board.pic}">
		<a href="${cpath }/download.do?filename=${board.pic}">내려받기</a>
		</td>
		<td>${board.create_date }</td>
		<td><button onclick="location.href='${path}/board/boardDelete.do?bno=${board.bno }'">삭제</button></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>