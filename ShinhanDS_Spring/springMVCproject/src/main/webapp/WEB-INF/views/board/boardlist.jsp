<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script>
setTimeout(()=?{
    var message = ${resultMessage};
    if(message!="") alert(message);
}, 500)
</script>
</head>
<body>
    <%@ include file="../common/header.jsp"%>
    <a href="${path}/board/boardinsert.do">게시판 등록</a>
    <h1>Board 목록</h1>
    <form action="${path}/board/selectDelete.do">
        <table border="1">
            <thead>
                <tr>
                    <th>선택</th>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>pic</th>
                    <th>작성일</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${blist}" var="board">
                    <tr>
                    <td><input type="checkbox" name="checkBno" value="${board.bno }"></td>
                        <td><a href="${path}/board/boardDetail.do?bno=${board.bno}">
                                ${board.bno} </a></td>
                        <td>${board.title}</td>
                        <td>${board.content}</td>
                        <td>${board.writer}</td>
                        <td><img src="${cpath}/upload/${board.pic}"
                            alt="${board.title}" width=50 height=50> <a
                            href="${cpath}/download.do?filename=${board.pic}">다운로드</a></td>
                        <td>${board.create_date}</td>
                        <td><input type="button" value="삭제하기"
                            onclick="location.href='${path}/board/boardDelete.do?bno=${board.bno}'"></td>
                        <!-- form tag내의 버튼은 submit을 수행한다. -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="선택삭제">
    </form>
</body>
</html>