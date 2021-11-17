<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calc</title>
</head>
<body>
	<form action="FilterCalcServlet">
		No.1 : <input type="text" name="n1" /> ${n1Error } <br> No.2 : <input
			type="text" name="n2" /> ${n2Error } <br> <input type="submit"
			value="Add" />

	</form>
	<br>
	<br> ${ans }
</body>
</html>