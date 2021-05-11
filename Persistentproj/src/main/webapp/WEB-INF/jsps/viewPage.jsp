<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@include file="Home.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW PAGE</title>
</head>

<body>
	<center>
		<h3>EMPLOYEE DATAILS</h3>
		<table border="1" rules="all">
			<tr>
				<td>EMP ID</td>
				<td>FIRST NAME</td>
				<td>LAST NAME</td>
				<td>EMAIL</td>
				<td>CONTACT NUMBER</td>
				<td>ADDRESS</td>
				<td>EDIT</td>
				<td>DELETE</td>
			</tr>
			<c:forEach items="${list }" var="list">

				<tr>
					<td>${list.empid}</td>
					<td>${list.firstname }</td>
					<td>${list.lastname }</td>
					<td>${list.email }</td>
					<td>${list.contactNo }</td>
					<td>${list.address }</td>
					<td><a href="editform?empid=${list.empid }">EDIT</a></td>
					<td><a href="delete?empid=${list.empid }">DELETE</a></td>
				</tr>
			</c:forEach>

		</table>
		<br><br><br>
		<a href="registration">New Registration</a>

	</center>
</body>

</html>