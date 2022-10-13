<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%  
int id=Integer.valueOf(request.getParameter("id"));  
%>  

<c:set var = "id" value = "${param.id}" />

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/simplilearn"  
     user="root"  password="root"/>  
     
     <sql:query dataSource="${db}" var="rs">  
select * from  Employee where id=? 
 <sql:param value="${id}" />  
</sql:query>  

<c:forEach var="table" items="${rs.rows}">    
<form action="update_JSTL_SQL.jsp">
<input type="text" name="id" value= <c:out value="${table.id}"/>>
<input type="text" name="first_name" value=<c:out value="${table.first_name}"/>>
<input type="text" name="last_name" value=<c:out value="${table.last_name}"/>>
<input type="submit" value="Change">
</form>
</c:forEach>  

</body>
</html>