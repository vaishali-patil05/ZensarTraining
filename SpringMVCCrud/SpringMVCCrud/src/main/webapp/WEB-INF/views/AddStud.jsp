<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty student}">
<h1>Add Student</h1>
<form action="add" method="post">
</c:if> 

<c:if test="${not empty student}">
<h1>Edit Student</h1>
<form action="save" method="post">
</c:if>


Sid : <input type='text' name="sid" value="${student.getSid()}">
<br>
Name : <input type='text' name="studentname" value="${student.getStudentname()}" >
<br>
Qualification : <input type='text' name="qualification" value="${student.getQualification()}" >
<br>
Placed : <input type='text' name="placed" value="${student.getPlaced()}">
<br>
<button type="submit">Save</button>
</form>


</body>
</html>