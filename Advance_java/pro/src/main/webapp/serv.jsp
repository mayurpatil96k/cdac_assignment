<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<String> dname=(ArrayList<String>)request.getAttribute("array");
Iterator itr=dname.iterator();
while(itr.hasNext()){
	out.println(itr.next());
	out.print("<br>");
}
%>
</body>
</html>