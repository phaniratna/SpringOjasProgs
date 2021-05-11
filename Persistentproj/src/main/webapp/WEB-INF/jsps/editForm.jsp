<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="update" method="post" modelAttribute="emp">
<table>
<tr><td>EMP ID:</td><td><form:input path="empid" readonly="true"/></tr>
<tr><td>FIRSTNAME:</td><td><form:input path="firstname"/></tr>
<tr><td>LASTNAME:</td><td><form:input path="lastname"/></td></tr>
<tr><td>EMAIL:</td><td><form:textarea path="email"/></td></tr>
<tr><td>CONTACT NUMBER:</td><td><form:input path="contactNo"/></td></tr>
<tr><td>ADDRESS:</td><td><form:input path="address"/></td></tr>
<tr><td><input type= "submit" value = "edit"/></td></tr>
</table>

</form:form>
</body>
</html>