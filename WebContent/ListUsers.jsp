<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
</head>
<body>
	<%-- 	<%
	%>

	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>

		<%
			for (UserBean user : users) {
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPassword()%></td>
			<td><a href="DeleteUserServlet?userId=<%=user.getUserId()%>">
					Delete </a> | <a href="EditUserServlet?userId=<%=user.getUserId()%>">
					Edit </a></td>
		</tr>
		<%
			}
		%>
	</table>
 --%>




	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>

		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userId }</td>
				<td>${user.firstName}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td><a href="DeleteUserServlet?userId=${user.userId}">
						Delete </a> | <a href="EditUserServlet?userId=${user.userId}">
						Edit </a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>






