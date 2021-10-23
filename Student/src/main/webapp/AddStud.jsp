<%@page language="java" import="com.zensar.model.Student" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${student==null}">
<h1>Add Student</h1>
<form action="add">
</c:if> 

<c:if test="${student!=null}">
<h1>Edit Student</h1>
<form action="save">
</c:if>


Sid : <input type='text' name="sid" value="${student.getSid()}">
<br>
Name : <input type='text' name="snm" value="${student.getStudentname()}" >
<br>
Qualification : <input type='text' name="q" value="${student.getQualification()}" >
<br>
Placed : <input type='text' name="placed" value="${student.getPlaced()}">
<br>
<button type="submit">Save</button>
</form>


</body>
</html>