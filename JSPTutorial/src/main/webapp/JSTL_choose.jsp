<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL IF-ELSE Statement</title>
</head>
<body>
<form action="#">
<p>Enter Name : 
<input type="text" name="name"/></p>
<p>Enter Password : 
<input type="password" name="password"/></p>
<p><input type="submit" value="submit"/></p>
</form>
<%
String name = request.getParameter("name");
String password = request.getParameter("password");
%>
<%
if(!(name == null || (name.equals(""))))
{
%>
<c:set var="nm" value="<%=name %>"/>
<c:set var="psw" value="<%=password %>"/>
<c:choose>
<c:when test="${(nm == 'Sudha') && (psw == '1234')}">
<p>Welcome, <c:out value="${nm }"/></p>
</c:when>
<c:otherwise>
<p>You Are Not A Person, Whom I Am Looking For</p>
</c:otherwise>
</c:choose>
<%
}
%>
</body>
</html>