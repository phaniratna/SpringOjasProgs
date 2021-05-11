<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="Home.jsp" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form:form action="login" method="post" modelAttribute="login">
<table>
<tr><th>EMAIL:</th><td><form:input path="email"/></td></tr>
<tr><th>PASSWORD:</th><td><form:input path="password"/></td></tr>
<tr><td></td><td><input type = "submit" value = "login"></td></tr>
</table>
</form:form>
</center>
</body>
</html>