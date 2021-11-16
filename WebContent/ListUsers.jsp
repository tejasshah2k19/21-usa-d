<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
</head>
<body>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
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
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("userId")%></td>
			<td><%=rs.getString("firstName")%></td>
			<td><%=rs.getString("email")%></td>
			<td><%=rs.getString("password")%></td>
			<td><a href="DeleteUserServlet?userId=<%=rs.getInt("userId")%>">
					Delete </a> | <a
				href="EditUserServlet?userId=<%=rs.getInt("userId")%>"> Edit
			</a></td>
		</tr>
		<%
			}
		%>
	</table>





</body>
</html>






