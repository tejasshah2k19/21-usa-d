<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


	<%
		int a = 90;
	%>
	<%=a%>

	<br>


	<c:set value="201" var="a"></c:set>
	<c:out value="${a}"></c:out>

	<c:if test="${a % 2 == 0  }">
		number is even
	</c:if>
	<c:if test="${a % 2 != 0  }">
		number is odd
	</c:if>
	<br>




	<c:forEach var="i" begin="1" end="5" step="1">
		<c:out value="${i}"></c:out>
		<br>

	</c:forEach>




	<c:set var="choice" value="1"></c:set>

	<c:choose>
		<c:when test="${choice == 1 }">
			choice 1
		</c:when>
		<c:when test="${choice == 2 }">
			choice 2
		</c:when>
		<c:when test="${choice == 3 }">
			choice 3 
		</c:when>
		<c:otherwise>
			Invalid choice
		</c:otherwise>
	</c:choose>

	<br>
	     
	<c:set var="str" value="mon,,tue,wen,thus,fri,sat,sun"></c:set>
	<c:forTokens items="${str}" delims="," var="i">
	    ${i}<br>
	</c:forTokens>











</body>
</html>