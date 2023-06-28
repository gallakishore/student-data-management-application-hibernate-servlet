<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Status</title>
</head>
<body bgcolor="cyan">
	<br>
	<br>
	<br>
	<c:choose>
		<c:when test="${status  ne null}">
			<h1 style="color: green; text-align: center">Insertion
				Successful with id ${status}</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">Insertion Failed</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>