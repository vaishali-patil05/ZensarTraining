<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1>Student CRUD App</h1>
<h3><a href='AddStud.jsp'>Add Student</a></h3>
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Qualification</th>
			<th>Placed</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="sobj" items="${listStudent}">
			<tr>
				<td>${sobj.getSid()}</td>
				<td>${sobj.getStudentname()}</td>
				<td>${sobj.getQualification()}</td>
				<td>${sobj.getPlaced()}</td>
				<td>
				<a href="edit/${sobj.getSid()}">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="delete/${sobj.getSid()}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		

	</table>

</body>
</html>