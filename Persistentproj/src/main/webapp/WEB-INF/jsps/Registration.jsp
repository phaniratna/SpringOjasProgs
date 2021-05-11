<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Home.jsp" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION PAGE</title>
</head>
<body>

<form:form action = "save" method="post" modelAttribute="employee">
<%-- <form:errors path="*"/> --%>
<center><table>
<tr>
<th>FIRST NAME:</th><td><form:input path="firstname" />
<form:errors path="firstname"/>
</td></tr>
<tr><th>LAST NAME:</th><td><form:input path="lastname"/></td></tr>
<tr><th>EMAIL:</th><td><form:input path="email" /></td><td><form:errors path="email" /></td></tr>
<tr><th>CONTACT NUMBER:</th><td><form:input path="contactNo"/></td></tr>
<tr><th>ADDRESS:</th><td><form:textarea path="address"/></td></tr>
<tr><th>PASSWORD:</th><td><form:password path="password"/></td><td><form:errors path="password" /></td></tr>
<tr><th>CONFIRM PASSWORD:</th><td><form:password path="confirmPassword"/></td><td><form:errors path="confirmPassword" /></td></tr>
<tr><td><input type= "submit" value = "register"/></td></tr>
</table></center>

</form:form>
</body>
</html>