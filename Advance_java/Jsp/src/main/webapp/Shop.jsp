<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<String> arr=(ArrayList<String>)request.getAttribute("arr");
%>
 
<form action="secondserv" method="post">

        <c:forEach var="xy" items="${arr}">
            <input type="checkbox" name="ch" value="${xy}">${xy}<br>
        </c:forEach>

        <input type="submit" name="button" value="ADD TO CART">

    </form>
</body>
</html>