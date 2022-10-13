<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.io.*,java.util.*,java.sql.*"%>  


    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- 
int id=Integer.valueOf(request.getParameter("id"));  
String first_name = request.getParameter("first_name");  
String last_name = request.getParameter("last_name");  
--%>

<c:set var = "id" value = "${param.id}" />
<c:set var = "first_name" value = "${param.first_name}" />
<c:set var = "last_name" value = "${param.last_name}" />



<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/simplilearn"  
     user="root"  password="root"/>  
     
   <sql:update dataSource="${db}" var="rs">  
update  employee set first_name=?, last_name=? where id=? 
  <sql:param value="${first_name}" />  
  <sql:param value="${last_name}" />  
 <sql:param value="${id}" />  


</sql:update> 
<%="Record updated successfully" %>
<jsp:include page="JSTL_SQL.jsp" />
</body>
</html>