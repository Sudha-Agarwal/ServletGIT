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
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/simplilearn"  
     user="root"  password="root"/>  
     
     <sql:query dataSource="${db}" var="rs">  
SELECT * from Employee;  
</sql:query>  

<table border="2" width="100%">  
<tr>  
<th>Student ID</th>  
<th>First Name</th>  
<th>Last Name</th>  
 <th>Edit/Delete</th>
 <th>Edit/Delete</th>
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.id}"/></td>  
<td><c:out value="${table.first_name}"/></td>  
<td><c:out value="${table.last_name}"/></td>  
<td><a href="edit_JSTL_SQL.jsp?id=${table.id}">Edit</a></td>
<td><a href="delete_JSTL_SQL.jsp?id=${table.id}">Delete</a></td></tr>  
</tr>  
</c:forEach>  
</table>  




</div>
</body>
</html>