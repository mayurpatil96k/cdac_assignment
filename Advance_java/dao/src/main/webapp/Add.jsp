<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student Information Form</h2>

    <form action="AddServlet" method="post">
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName" required>

        <br>

        <label for="studentAddress">Student Address:</label>
        <textarea id="studentAddress" name="studentAddress" required></textarea>

        <br>

        <label for="persistenceStore">Select Persistence Store:</label>
        <select id="persistenceStore" name="persistenceStore" required>
            <option value="File">File</option>
            <option value="Database">Database</option>
        </select>

        <br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>