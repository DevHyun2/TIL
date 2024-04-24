<%@page import="java.util.List"%>
<%@page import="com.shinhan.day15.EmpDTO"%>
<%@page import="com.shinhan.day15.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- jsp의 실행결과가 HTML, TEXT, JSON, XML...
--%>

{
"emplist":[
	<%
	EmpService eservice = new EmpService();
	List<EmpDTO> emplist = eservice.selectAll();
	for(int i=0; i<emplist.size(); i++) {
	%>
	{"no":<%=emplist.get(i).getEmployee_id() %>,  
	"name" : "<%=emplist.get(i).getFirst_name() %>", 
	"capital" : "<%=emplist.get(i).getEmail() %>", 
	"region": <%=emplist.get(i).getSalary() %> 
	}
	
	<%
	 if(i < emplist.size()-1)
		  out.print(",");
	}  
	%>
	 
]
}