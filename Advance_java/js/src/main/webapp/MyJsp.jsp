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
<%ArrayList<String> arr =(ArrayList<String>)session.getAttribute("arr");
Iterator itr=arr.iterator();
while(itr.hasNext()){
	out.println("<Strong><i>"+itr.next()+"</i></Strong><br>");
}
%>
</body>
</html>