<%@page import="java.util.List"%>
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
        List<mypack.login> mylist = (List<mypack.login>) request.getAttribute("list");
        if (mylist != null) {
            for (mypack.login login : mylist) {
                // Access login properties and display them as needed
                out.print(login.toString()+ "<br>");
            }
        }
    %>

</body>
</html>