<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set value = "Maven JSTL" var="pageTitle" />
<c:remove var="pageTitle" />
<c:out value = "${pageTitle}"/>

<c:set value="34" var="num"/>
<c:out value="${num % 2 eq 0 ? 'even': 'odd'}"/>

<c:forEach var = "j" begin = "1" end = "5">
<p>Value of j is: <c:out value="${j}" /></p>
</c:forEach>

<c:set var= "String1" value = "Welcome Page"/>

<c:if test = "${fn:containsIgnoreCase(String1, 'page')}" >
<p>Contains Page Substring</p>
</c:if>

<c:catch var ="catchtheException">  
   <% int x = 2/0;%>  
</c:catch>  
  
<c:if test = "${catchtheException != null}">  
   <p>The type of exception is : ${catchtheException} <br />  
   There is an exception: ${catchtheException.message}</p>  
</c:if>  
</body>
</html>