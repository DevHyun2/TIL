<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/*  
inline : content만큼만 자리차지(width불가), label, input
block : 한라인 차지(width가능)
inline-block : 인라인요소가 block의 특징을 가질 수 있음
*/
h1{
	text-align: center;
	border-bottom: 3px solid;
	font-size: 50px;
	padding-bottom: 20px;
}
label{
	width: 150px;
	display: inline-block;
	margin: 3px;
	font-size: 20px;
}
legend{
	background-image: linear-gradient(to left,white,#bebebe);	
	font-size: 30px;
	border-radius: 30px;
}
.button{
	font-size: 20px;
	margin: 0 auto;
}
fieldset {
	border-radius: 30px;
	background-color: #bebebe;
	width: 40px;
	text-align: center;
	margin: 0 auto;
	border-width: 10px;
	padding: 20px;
}
/* input{
	background-color: #B9FFFF;
} */
.date{
	width: 162.667px;
}
.all{
	margin: 0 auto;
}
/* input요소의 value라는 속성이 존재하는가? */
input[value]{
	background-color: #B9FFFF
}
/* input요소의 type에 해당하는 속성만 */
input[type="submit"],input[type="reset"]{
	background-color: black;
	color: white;
}
/* class안에 바로 다음에 오는 label */
.first_field > label {
		background-color: skyblue;
}
/* 마우스 클릭시 반응 */
input:focus {
	background-color: beige;
}
label:hover {
	background-color: hotpink;
}
</style>
</head>
<body>
<h1>신규직원 등록</h1>
<%--
JSP주석 : JSP문서를 보는 사람을 위한 설명
--%>

<!-- 
HTML주석 : 개발자에게 코드를 설명하기 위함
이 주석은 개발자관리옵션에서 보임
method="post" : 브라우저에 주소 숨기기/ 파라메타 노출X, 요청문서의 body에 넘어간다
method="get" : 주소창에 서버에 전달되는 파마메타가 노출된다, 자동으로 인코딩 자릿수 제한이 있음(256 ~ 4096byte)
method 생략하면 get이 default
submit버튼을 누르면 자동으로 action으로 간다.(input들을 action에 전달한다)
주의점 -> input태그에 name(파라메타 이름)을 전달//없으면 전달하지 않음
-->

<!--  
name : 문서 내에서 같은 이름이 여러개 가능
id : 문서 내에서 유일한 이름
<input type="radio" value="M" name="gender"> 남자
<input type="radio" value="F" name="gender"> 여자
-->

<form action="empDBInsert.jsp" method="post">


<fieldset class="first_field">
	<legend>필수항목</legend>
	<label>직원번호</label>
	<input type="number" name="employee_id" id="employee_id"><br>
	<label>last_name</label>
	<input type="text" name="last_name"><br>
	<label>email</label>
	<input type="email" name="email"><br>
	<label>입사일</label>
	<input class="date" type="date" name="hire_date"><br>
	<label>job_id</label>
	<input type="text" name="job_id"><br>
</fieldset>
<fieldset>
	<legend>선택입력</legend>
	<label>first_name</label>
	<input type ="text" name="first_name"><br>
	<label>phone_number</label>
	<input type="text" name="phone_number"><br>
	<label>salary</label>
	<input type="number" name="salary" value=0><br>
	<label>manager_id</label>
	<input type="number" name="manager_id" value=100><br>
	<label>department_id</label>
	<input type="number" name="department_id" value=100><br>
	<label>Commission_pct</label>
	<input type="number" name="commission_pct"><br>
</fieldset>
<div class="all">
<input class="button" type="submit" value="DB입력">
<input class="button" type="reset" value="초기화">
</div>
</form>
</body>
</html>